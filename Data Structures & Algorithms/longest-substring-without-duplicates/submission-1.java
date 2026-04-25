class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> occ = new HashMap<Character, Integer>();
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int length = 1;
        while(r<s.length()){
            if(occ.containsKey(s.charAt(r))){
                while(l < r && s.charAt(l)!=s.charAt(r)){
                    occ.remove(s.charAt(l));
                    l++;
                }                
                l++;
            }
            length = r-l+1;   
            maxLength = Math.max(length, maxLength);
            occ.put(s.charAt(r), r);
            r++;
        }

        return maxLength;
    }
}
