class Solution {
    public int maximumSwap(int num) {
        
    
        int max_digit = -1;
        int max_digit_index = -1;
        int l_index = -1;
        int r_index = 1;
        
        String s = String.valueOf(num);
        if(s.length()==1) return num;
        for(int i= s.length()-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(max_digit < ch)
            {
                max_digit = ch;
                max_digit_index = i;
                continue;
            }
            
            if( max_digit > ch)
            {
                l_index = i;
                r_index = max_digit_index;
            }
        }
        if(l_index == -1) return num;
        
        s = swap(s, l_index, r_index);
        return Integer.parseInt(s);
    }
    
    private String swap(String s, int i,int j)
    {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return String.valueOf(arr);
    }
}