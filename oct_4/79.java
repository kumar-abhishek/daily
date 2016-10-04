/*
79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

//accepted
public class Solution {
    public boolean dfs(char[][] board, int m, int n, int i, int j, int k, String word){
        if(k == word.length()) return true;
        if(i<0 || i>=m || j<0 || j>=n) return false;
        
        if(word.charAt(k) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            if(dfs(board, m, n, i+1, j, k+1, word) || 
            dfs(board, m, n, i, j+1, k+1, word) || 
            dfs(board, m, n, i, j-1, k+1, word) || 
            dfs(board, m, n, i-1, j, k+1, word))
                return true;
            board[i][j] = temp;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, m, n, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }
}
