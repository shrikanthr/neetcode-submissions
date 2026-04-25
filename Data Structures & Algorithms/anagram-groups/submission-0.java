class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sorts = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> anagrams = sorts.getOrDefault(sorted, new ArrayList<>());
            anagrams.add(s);
            sorts.put(sorted, anagrams);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry:sorts.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }
}
