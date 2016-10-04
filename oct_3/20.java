/*
20. Valid ParenthesesGiven a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
//accepted
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch=='[') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                char chTop = stack.pop();
                if(ch == ')') {
                    if(chTop != '(') return false;
                } else if(ch == '}'){
                    if(chTop != '{') return false;
                }else if(ch == ']'){
                    if(chTop != '[') return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}
