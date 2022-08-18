class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            int j = n - i - 1;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        int end = n - 1;
        int c = 0 ;
        int j = 0;
        for(int i =  0; i < n; i++){
            j = Math.max(j, i + 1);
            if(i < n - 1 && chars[i] == chars[i + 1] && c < repeatLimit){
                c++;
            }
            else if( i < n - 1 && chars[i] == chars[i+1] && c == repeatLimit){
                while(j < n){
                    if(chars[i] != chars[j]){
                       char temp = chars[i];
                       chars[i] = chars[j];
                       chars[j] = temp; 
                       c = 0;
                        break;
                    }
                    j++;
                }
                if(j == n){
                    end = i - 1;

                    break;
                } 
             
            }
            else if(i < n - 1 && c >= repeatLimit && chars[i] != chars[i+1]){ 
                c = 0;
                char temp = chars[i];
               chars[i] = chars[i + 1];
               chars[i + 1] = temp; 
                
            }
            else if(c >= repeatLimit && i == n- 1){
                end = i - 1;
                
            
                break;
            } 
            else c = 0;
                
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= end; i++) sb.append(chars[i]);
        
        
        return sb.toString();
        
    }
}