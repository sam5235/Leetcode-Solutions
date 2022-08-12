class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if (x == 0) return true;
        List<Integer> num = new ArrayList<>();
        int bill = x / 1000000000; x %= 1000000000;
        int hunMil = x / 100000000; x %= 100000000;
        int tenMil = x / 10000000; x %= 10000000;
        int mill = x / 1000000; x %= 1000000;
        int hunTho = x / 100000; x %= 100000;
        int tenTho = x / 10000; x %= 10000;
        int tho = x / 1000; x %= 1000;
        int hun = x / 100; x %= 100;
        int ten = x / 10;
        int unit =  x %= 10;
        int[] digits = {bill, hunMil, tenMil, mill, hunTho, tenTho,tho,hun,ten,unit};
        for(int i = 0; i < digits.length; i++){
             num.add(digits[i]);
        }
               
         Collections.reverse(num);
        int i = num.size() - 1;
        while(num.get(i) == 0){
             num.remove(i);
            i--;
        }
         System.out.println(num);
        
        
        int k= 0;
        int j = num.size() - 1;
        while(k < j){
            if(num.get(k) != num.get(j)) return false;
            k++;
            j--;
        }
        return true;
    }
}