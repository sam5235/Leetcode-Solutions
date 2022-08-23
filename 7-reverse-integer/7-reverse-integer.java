class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;
        String s = "";
        s = x +"";
        s = (x > 0)? s: s.substring(1, s.length());
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        long inval = Long.parseLong(sb.toString());
        if(x > 0 && inval < Integer.MAX_VALUE) return Integer.parseInt( sb.toString());
        else if(x < 0 && -inval > Integer.MIN_VALUE) return -Integer.parseInt( sb.toString());
         return 0;
    }
}