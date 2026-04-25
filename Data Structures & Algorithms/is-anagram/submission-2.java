class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occ = new HashMap<Character, Integer>();
        if(s.length()!= t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            int repeats = occ.getOrDefault(s.charAt(i), 0);
            occ.put(s.charAt(i), repeats+1);
        }

        for(int i = 0;i<t.length();i++){
            if(!occ.containsKey(t.charAt(i))){
                return false;
            }

            int left = occ.get(t.charAt(i));
            if(left == 0){
                return false;
            }

            occ.put(t.charAt(i), left - 1);
        }

        return true;
    }
}
