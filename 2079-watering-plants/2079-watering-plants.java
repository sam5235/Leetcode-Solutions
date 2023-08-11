class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int cap = capacity;
        int steps = 0;
        for(int i = 0; i<plants.length; i++){
            if(cap - plants[i] < 0){
                steps += (i * 2) + 1;
                cap = capacity - plants[i];
            }else{
                cap -= plants[i];
                steps++;
            }
        }
        return steps;
    }
}