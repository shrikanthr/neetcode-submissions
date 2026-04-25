class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for(int i=0;i<t.length();i++){
            int f = freq.getOrDefault(t.charAt(i), 0);
            freq.put(t.charAt(i), f+1);
        }

        int l=0;
        int found = 0;
        int need = freq.size();
        int min = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        Map<Character, Integer> window = new HashMap<>();
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(freq.containsKey(c) && freq.get(c).equals(window.get(c))){
                found++;
            }

            while(found == need){
                int length = r-l+1;
                if(length < min){
                    min = length;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(freq.containsKey(leftChar) && freq.get(leftChar) > window.get(leftChar)){
                    found--;
                }

                l++;
            }            
        }

        return min == Integer.MAX_VALUE? "":s.substring(res[0], res[1]+1);
    }
}
