class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; 
        int r = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> freq = new HashMap<>(); 
        while(r<s.length()){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0)+1);
            if(isValid(freq, r-l+1, k)){
                max = Math.max(max, r-l+1);
            }
            while(!isValid(freq, r-l+1, k)){
                int f = freq.get(s.charAt(l));
                if(f == 0){
                    continue;
                }

                freq.put(s.charAt(l), f-1);
                l++;
            }

            r++;
        }

        return max;
    }

    private boolean isValid(Map<Character, Integer> freq, int length, int k){
        Map.Entry<Character, Integer> max = null;
        for(Map.Entry<Character, Integer> e:freq.entrySet()){
            if((max == null && e.getValue() !=null) || max.getValue() < e.getValue()){
                max = e;
            }
        }

        boolean isV = length - max.getValue() <= k;
        return length - max.getValue() <= k;
    }
}
