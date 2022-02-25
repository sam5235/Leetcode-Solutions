class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        int n = citations.length;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(citations[mid] < n - mid){
                
                low = mid + 1;
            }else if(citations[mid] == n - mid){
                return n - mid;
            }
            else high = mid - 1;
        }
        return n - low;
    }
}