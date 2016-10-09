/*
49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

	Note: All inputs will be in lower-case.
*/


//accepted
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ll = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String s = String.valueOf(str);
            List<String> l;
            if(!map.containsKey(s)){
                l = new ArrayList<>();
                l.add(strs[i]);
            } else {
                l= map.get(s);
                l.add(strs[i]);
            }
            map.put(s, l);
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            ll.add(entry.getValue());
        }
        return ll;
    }
}


//cleaner accepted code:
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
