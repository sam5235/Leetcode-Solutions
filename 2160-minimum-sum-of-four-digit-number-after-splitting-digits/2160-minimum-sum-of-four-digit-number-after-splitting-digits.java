class Solution {
    public int minimumSum(int num) {
        int[] fourD = new int[4];
        int i = 0;
        while(num > 0){
            fourD[i] =  num%10;
            i++;
            num /= 10;
        }
        Arrays.sort(fourD);
        int minSum = Integer.parseInt(fourD[0] + "" + fourD[2]) +Integer.parseInt(fourD[1] + "" + fourD[3]);
        return minSum;
    }
}