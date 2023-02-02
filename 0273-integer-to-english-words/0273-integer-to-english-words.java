class Solution {
    public String numberToWords(int num) {
        if(num ==   0) return "Zero";
        String[] one = {" ","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] two = {" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] spec ={"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        List<String> ans = new ArrayList<>();
       
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Hundred");
        map.put(4, "Thousand");
        map.put(7, "Million");
        map.put(10, "Billion");
    
        String str = Integer.toString(num);
        int i = str.length() - 1;
        
        while(i >= 0){
            int j = str.length() - i;
            if(j == 2 || j == 5 || j == 8){
                
                ans.add(two[str.charAt(i) - '0']);
            }else{
                
                if(j % 3 == 0 && str.charAt(i) != '0') ans.add(map.get(3));
                 else if(j  == 4 && (str.charAt(i) != '0' || str.length() <= 6 ||(i > 1) && (str.charAt(i - 1) != '0' || str.charAt(i - 2) != '0') ) ) ans.add(map.get(4));
                 else if(j == 7  && (str.charAt(i) != '0' || str.length() <= 9 ||(i > 1) && (str.charAt(i - 1) != '0' || str.charAt(i - 2) != '0') ) )  ans.add(map.get(7));
                 else if(j  == 10) ans.add(map.get(10));
                if(i > 0 && str.charAt(i - 1) == '1' && !map.containsKey(str.length() - i + 1) ){
                    ans.add(spec[str.charAt(i) - '0']);
                    i--;
                } else  ans.add(one[str.charAt(i) - '0']);
                
                
            }
            i--;
            
        }
        StringBuilder sb = new StringBuilder();
        sb.append( ans.get(ans.size() - 1));
        for(int j = ans.size() - 2; j >= 0; j--){
            if(!ans.get(j).equals(" ")) sb.append( " " + ans.get(j));
        }
        
        return sb.toString();
    }
}