class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++){
           if((i == 0 || flowerbed[i - 1] != 1) && (i == flowerbed.length - 1 || flowerbed[i + 1] != 1) && flowerbed[i] == 0){
               flowerbed[i] = 1; 
               n--;
           }   
        }
        return n <= 0;
    }
}