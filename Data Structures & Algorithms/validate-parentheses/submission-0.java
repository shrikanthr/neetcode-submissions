class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<Character, Character>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Map<Character, Character> open = new HashMap<Character, Character>();
        open.put('(', '(');
        open.put('{', '{');
        open.put('[', '[');

        Stack<Character> valid = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(open.containsKey(s.charAt(i))){
                valid.push(s.charAt(i));
                continue;
            }

            if(brackets.containsKey(s.charAt(i))){
                if(valid.isEmpty()){
                    return false;
                }
                Character o = valid.pop();
                if(o != brackets.get(s.charAt(i))){
                    return false;
                }
            }
        }

        return valid.isEmpty();
    }
}
