class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry > 0){
                int t = carry + val(a, i) + val(b, j);
                sb.append( t % 2);
                carry = t >> 1;
                i--;
                j--;
        }
        return sb.reverse().toString();
    }
    int val(String s, int i){
        if(i >= 0 && i < s.length()) return s.charAt(i) - '0';
        else return 0;
    }
}