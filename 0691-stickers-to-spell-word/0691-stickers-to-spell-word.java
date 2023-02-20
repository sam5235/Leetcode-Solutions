class Solution {
    public int minStickers(String[] stickers, String target) {
        int n=stickers.length;
        int[][] chs = new int[n][26];
        
        for(int i=0; i<n; i++) { 
            String sticker=stickers[i];
            for(char ch:sticker.toCharArray()) {
                chs[i][ch - 'a']++;
            }
        }
        int ret=minStickersHelper(chs,target, new HashMap<>());
        return ret == Integer.MAX_VALUE-1 ? -1 : ret;
    }
    
    private int minStickersHelper(int[][] chArr, String target, Map<String,Integer> memo) {
        if(target.length() <= 0)
            return 0;
        if(memo.containsKey(target))
            return memo.get(target);
        
        int min=Integer.MAX_VALUE-1;
        for(int[] chs:chArr) {
            int len=target.length();
            String rem=getRemainingStr(chs.clone(),target);
            if(rem.length() == len) 
                continue;
            min=Math.min(min,1+minStickersHelper(chArr,rem,memo));
        }
        memo.put(target,min);
        return min;
    }
    
    private String getRemainingStr(int[] chs, String target) { 
        StringBuilder sb = new StringBuilder();
        if(chs[target.charAt(0) - 'a'] == 0) 
            return target;
        for(char ch:target.toCharArray()) {
            if(chs[ch - 'a'] > 0)
                chs[ch - 'a']--;
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}