class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            int num = (int) c;
            if(num >= 65){
                str.append(c);

            }
        }

        possibleStrings(str.toString(), 0, new StringBuilder(), ans);
        List<String> newA = new ArrayList<>();
        for(int i = 0; i < ans.size(); i++){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            int k = 0;
            while( j < s.length()){
                int num = s.charAt(j) - '0';
                while(num >= 0 && num <= 9){
                    sb.append(num + "");
                    j++;
                    if(j >= s.length())
                        break;
                    num = s.charAt(j) - '0';
                }
                    if(k < ans.get(i).length())
                        sb.append(ans.get(i).charAt(k));
                    k++;
                    j++;
                
            }
            newA.add(sb.toString());
        }
        return newA;
    }
        
    void possibleStrings(String s, int idx, StringBuilder sb, List<String> ls){
        if(idx >= s.length()){
            ls.add(sb.toString());
            return;
        }
        char curr =  (int)s.charAt(idx) - '0' < 97 ? (char)(s.charAt(idx) ^ 0x20) : (char) (s.charAt(idx) & 95);
        sb.append(curr);
        possibleStrings(s, idx + 1, sb, ls);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(s.charAt(idx));
        possibleStrings(s, idx + 1, sb, ls);
        sb.deleteCharAt(sb.length() - 1);
    }
    
}