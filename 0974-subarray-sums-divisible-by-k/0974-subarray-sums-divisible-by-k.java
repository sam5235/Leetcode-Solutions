class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> subArr = new HashMap<>();
        int n = nums.length;
        int[] mod = new int[n];
        int sum = nums[0];
        for(int i = 0; i < n; i++){
            if(i > 0)
              sum += nums[i];
            mod[i] = (sum % k);
        }
        subArr.put(0, 1);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(subArr.containsKey(mod[i]) ){
                cnt += subArr.get(mod[i]);
                subArr.put(mod[i], (subArr.get(mod[i]) + 1));
            }else{
                subArr.put(mod[i], 1);
            }
            
            cnt += subArr.getOrDefault((mod[i] - k), 0);
            cnt += subArr.getOrDefault((mod[i] + k), 0);
            
            
        }
        return cnt;
    }
}
// [0, 2, 0, -1, 0, -1, -5, 2, -6, -6]

// 7 : [0,0]
// 7 : [0,2]
// -7 : [0,4]
// 0 : [1,2]
// -14 : [1,4]
// -7 : [2,6]
// 0 : [2,7]
// -14 : [3,4]
// 0 : [4,5]
// 7 : [7,7]
// -7 : [9,9]


     
     
