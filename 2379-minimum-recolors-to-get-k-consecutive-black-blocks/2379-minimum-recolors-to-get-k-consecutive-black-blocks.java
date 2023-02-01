class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        
        int start = 0;
        int minchange = blocks.length();
        int change = 0;
        for( int right = 0; right < blocks.length(); right ++){
            
            
            if( blocks.charAt(right) == 'W'){
                change++;
            }
            
            if( right - start + 1 == k){
                minchange = Math.min(change, minchange);
                
                if(blocks.charAt(start) =='W'){
                    change--;
                }
                start++;
            }
        }
        
        return minchange;
    }
}