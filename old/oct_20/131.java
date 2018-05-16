/*
131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

//accepted

public class Solution {
    public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    backtrack(s, list, new ArrayList<>(), 0);
    return list;
}

private void backtrack(String s, List<List<String>> list , List<String> tempList, int start) {
    if(start == s.length()) list.add(new ArrayList<>(tempList));
    for(int i = start; i < s.length(); i++) {
        if(!isPalindrome(s.substring(start, i+1))) continue;
        tempList.add(s.substring(start, i+1));
        backtrack(s, list, tempList, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}

private boolean isPalindrome(String t){
    int lo=0, hi = t.length()-1;
    while(lo<hi){
        if(t.charAt(lo) != t.charAt(hi)) return false;
        ++lo;
        --hi;
    }
    return true;
}
}
