/*
This is a dedicated to the two days of time and resourse putted by the two enemies (Samiya & Feysel)
TOGETHER WE CAN!!! YEAAAAHH!!! ZIMBEY ERE ZIMBEL
*/

class Solution {
    public int countSpecialNumbers(int n) {
        int[] basics = new int[11];
        basics[1] = 9;
        int mul = 9;
        for(int i = 2; i < 11; i++){
            basics[i] = mul * basics[i - 1];
            mul--;
        }
        int uniq = 0, first = 1, pow = 0;
        for(int i = 1; i < 11; i++){
            if(n < Math.pow(10, i)){
                first = (int)Math.pow(10, i - 1); 
                pow = i;
                break;
            }
           uniq += basics[i];
        }
        int start = first;
        
        for(int i = pow - 1; i >= 0; i--){
            int end = ((n / first) * first) - 1;
            
            if(end < start){
                first /= 10;
                continue;
            }
            
            uniq += helper(start, end);
            first /= 10;
            start = end + 1;
        }
        return uniq + helper(start, n);
    }
    
    int helper(int start, int end){
        boolean[] seen = new boolean[10];
        String s = start + "";
        String e = end + "";
        int res = 1;
        
        for(int i = 0; i < s.length(); i++){
            int high = e.charAt(i) - '0';
            int low = s.charAt(i) -  '0';
            int used = 0;
            for(int digit = low; digit <= high; digit++){
                if(seen[digit]) used++;
            } 
            seen[high] = true;
            int opt = high - low - used +  1;
            if(high == 9 && low == 0){
                while(i < s.length()){
                    opt = high - low - i +  1;
                    res *= opt;
                    i++;
                }
                return res;
            }
            res*= opt;
            
        }
        return res;
    }
}