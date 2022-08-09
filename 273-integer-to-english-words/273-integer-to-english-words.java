	  class Solution {
    String[] units = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tenPlus = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        int billions = num/1000000000; num%=1000000000; 
        int millions = num/1000000; num%=1000000;
        int thousand = num/1000; num%=1000;
        int hundred = num/100; num%=100;
        int ten = num/10;
        int unit = num%10;
        StringBuffer sb = new StringBuffer();
        if(billions != 0) {
            sb.append(numberToWords(billions));
            sb.append(" Billion");
        }
        if(millions != 0) {
            if(sb.length() != 0) sb.append(' ');
            sb.append(numberToWords(millions));
            sb.append(" Million");
        }
        if(thousand != 0) {
            if(sb.length() != 0) sb.append(' ');
            sb.append(numberToWords(thousand));
            sb.append(" Thousand");
        }
        if(hundred != 0) {
            if(sb.length() != 0) sb.append(' ');
            sb.append(units[hundred - 1]);
            sb.append(" Hundred");
        }
        if(ten == 1 && unit != 0) {
            if(sb.length() != 0) sb.append(' ');
            sb.append(tenPlus[unit - 1]);
        } else {
            if(ten != 0) {
                if(sb.length() != 0) sb.append(' ');
                sb.append(tens[ten - 1]);
            }
            if(unit!=0) {
                if(sb.length() != 0) sb.append(' ');
                sb.append(units[unit -1]);
            }
            else if(sb.length() == 0) sb.append("Zero");
        }
        return sb.toString();
    }
}