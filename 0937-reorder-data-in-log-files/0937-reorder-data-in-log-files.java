class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) ->{
            int index1 = log1.indexOf(" ") + 1;
            int index2 = log2.indexOf(" ") + 1;
            
            if(Character.isLetter(log1.charAt(index1)) &&
               Character.isLetter(log2.charAt(index2))){
                   int cmp = log1.substring(index1).compareTo(log2.substring(index2));      
                   if(cmp != 0) return cmp;
                
                   return log1.compareTo(log2);
               }else if(Character.isLetter(log1.charAt(index1))) return -1; //log1(c) < log2(d)
                else if(Character.isLetter(log2.charAt(index2))) return 1;  //log1(d) > log2(c)
                else return 0; 
                              
        });
                        
        return logs;
    }
}