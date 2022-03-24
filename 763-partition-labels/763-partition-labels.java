class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] c = s.toCharArray();
        List<Integer> ans = new ArrayList<>();
        List<Integer> labels = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < c.length; i++){
            int j = i;
            while(j  < c.length){
                if(c[i] == c[j] && j > idx){
                        idx = j;
                } 
                        j++;
            }
            if(i == idx){
                ans.add(idx);
            }
        }
       
            labels.add(ans.get(0) + 1 );
            for(int i = 1; i < ans.size(); i++){
                labels.add(ans.get(i) - ans.get(i - 1) );
            }
            
        
        return labels;
    }
}