class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        int idx = 0;
        for(int i = 0; i < nums1.length; i++){
            all[idx] = nums1[i];
            idx++;
        }
        for(int i = 0; i < nums2.length; i++){
            all[idx] = nums2[i];
            idx++;
        }
        Arrays.sort(all);
        if(all.length % 2 == 0)
            return (all[all.length/2 -1 ] + all[all.length/2])/2.0;
        else return all[all.length/2]/1.0;
    }
}