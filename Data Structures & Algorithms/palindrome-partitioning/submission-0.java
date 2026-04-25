class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partition(s, 0, new ArrayList<>());
        return result;
    }

    private void partition(String s, int start, List<String> curr){
        if(start >= s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }

        int end = start;
        while(end < s.length()){
            end++;
            String candidate = s.substring(start, end);
            if(!isPalindrome(candidate)){
                continue;
            }

            curr.add(candidate);
            partition(s, end, curr);
            curr.remove(curr.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(r>l){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
