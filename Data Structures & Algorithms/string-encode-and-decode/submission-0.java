class Solution {
    
    private static final Character delimiter = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append(delimiter);
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<String>();
                System.out.println(str);

        int currLength = -1;
        boolean readingString = false;
        boolean readingLength = true;
        StringBuilder s = new StringBuilder();
        for(int i=0;i<str.length();i++){            
            if(readingLength && str.charAt(i) == delimiter){
                int length = Integer.parseInt(s.toString());
                s = new StringBuilder();                
                currLength = i+length;
                if(length == 0){
                    strs.add(s.toString());
                    continue;
                }
                readingString = true;
                readingLength = false;
                continue;
            }

            if(readingString && i == currLength)
            {
                s.append(str.charAt(i));
                strs.add(s.toString());
                s = new StringBuilder();
                readingString=false;
                readingLength=true;
                continue;
            }

            s.append(str.charAt(i));
        }
        
        return strs;
    }
}
