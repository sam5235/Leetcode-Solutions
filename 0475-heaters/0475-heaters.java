class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int result = 0, j = 0;
        for(int i = 0; i<houses.length; i++){
            while(j + 1 < heaters.length){
                if(Math.abs(houses[i] - heaters[j + 1]) <= Math.abs(houses[i] - heaters[j]))
                    j++;
                else break;
            }
            result = Math.max(result, Math.abs(houses[i] - heaters[j]));
        }
        return result;
    }
}
