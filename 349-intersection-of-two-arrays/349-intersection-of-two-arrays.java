class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int t : nums1) set.add(t);
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]))set2.add(nums2[i]);
        }
        System.out.println(set);
        System.out.println(set2);

        int[] ans = new int[set2.size()];
        Iterator<Integer> value = set2.iterator();
        int i = 0;
        while (value.hasNext()) {
            ans[i] = value.next();
            i++;
        }
        return ans;
    }
}