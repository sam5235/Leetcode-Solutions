class Solution {
    public String smallestNumber(String pattern) {
        for(int i = 1; i <= 9; i++){
            StringBuilder sb = new StringBuilder();
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            sb.append(i);
            if(helper(pattern, 0, sb, set)){
                return sb.toString();
            } 
            
        }
        return "";
    }
    
    boolean helper(String p, int idx, StringBuilder sb, HashSet<Integer> set){
        if(idx == p.length()){
            return true;
        }
        char c = p.charAt(idx);
        int num = sb.charAt(sb.length() - 1) - '0';
        int dir = c == 'D'? -1: 1;
            for(int i = num; i >= 1 && i <= 9; i+=dir){
                if(!set.contains(i)){
                    sb.append(i);
                    set.add(i);
                    if(helper(p, idx + 1, sb, set))
                         return true;
                    sb.deleteCharAt(sb.length() - 1);
                    set.remove(i);

                }
            }
            return false;
           
        }
    }
