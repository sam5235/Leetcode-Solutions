class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       HashSet<Integer> set1 = new HashSet<>();
       for(int n1 : nums1) set1.add(n1);
       HashSet<Integer> set2 = new HashSet<>();
       for(int n2 : nums2) set2.add(n2);
       List<List<Integer>> ls = new ArrayList<>();
       List<Integer> ls1 = new ArrayList<>();
       for(int n : set1){
           if(!set2.contains(n)) ls1.add(n);
       } 
       ls.add(ls1);
       ls1 = new ArrayList<>();
       for(int n : set2){
           if(!set1.contains(n)) ls1.add(n);
       } 
       ls.add(ls1);
        return ls;
    }
}