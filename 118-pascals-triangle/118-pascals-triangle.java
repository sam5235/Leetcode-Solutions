class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>(Arrays.asList(1)));
        int i = 0;
        while(i < numRows -1){
            int j = 0;
            List<Integer> temp = new ArrayList<>();
            temp.add(ans.get(i).get(j));
            while(j < ans.get(i).size() - 1){
                    temp.add(ans.get(i).get(j) + ans.get(i).get(j + 1));
                j++;
            }
            temp.add(ans.get(i).get(j));
            ans.add(temp);
            i++;
        }
                return ans;
    }
}