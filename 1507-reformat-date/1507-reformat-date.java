class Solution {
    public String reformatDate(String date) {
        HashMap<String, Integer> month = new HashMap<>();
        month.put("Jan", 01);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
        month.put("May", 5);
        month.put("Jun", 6);
        month.put("Jul", 7);
        month.put("Aug", 8);
        month.put("Sep", 9);
        month.put("Oct", 10);
        month.put("Nov", 11);
        month.put("Dec", 12);
     

        StringBuilder ans = new StringBuilder();
        String[] form = date.split(" ");
        ans.append(form[2] + "-");
        ans.append(month.get(form[1]) < 10 ? 0 + "" + month.get(form[1]) + "-" : month.get(form[1]) + "-");
            ans.append(form[0].length() < 4 ? 0  + "" + form[0].charAt(0) : form[0].charAt(0)+ "" + form[0].charAt(1));
        
        return ans.toString();
    }
}