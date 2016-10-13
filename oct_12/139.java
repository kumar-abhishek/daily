/*
139. Word Break
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Show Company Tags

*/
public class Solution {
    Map<String, Boolean> map = new HashMap<String, Boolean>();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i=0; i<s.length(); i++) {
            if(wordBreak(s.substring(0,i), wordDict) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            } else {
                map.put(s, false);
            }
        }
        return false;
    }
}

