class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> rept = new HashSet<>();
        int hash = 0;
        for(int i = 9; i < s.length() && i >= 0; i--){
           
            hash += val(s.charAt(i)) * (Math.pow(4, 9- i));
        }
        rept.add(hash);
        HashSet<String> ls = new HashSet<>();
        int i = 0;
        int j = 10;
        while(j < s.length()){
            hash -= val(s.charAt(i)) * Math.pow(4, 9);
            hash = (hash * 4) + val(s.charAt(j));
            if(rept.contains(hash))
                ls.add(s.substring(i + 1 ,j + 1));
            else rept.add(hash);
            i++;
            j++;
        }
        
        return new ArrayList<>(ls);
    }
    
    int val(char c){
        return c == 'A' ? 1 : c == 'C' ? 2 : c =='G' ? 3 : 4;
    }
   
   
}