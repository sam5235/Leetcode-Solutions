class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String , Integer> pali = new HashMap<>();
        for(String w : words){
            int freq = pali.getOrDefault(w, 0)+ 1;
            pali.put(w, freq);
        }
        int ans = 0;
        boolean on = false;
        for(int i = 0; i < words.length; i++){
            String curr = words[i];
            if(pali.containsKey(curr) && curr.charAt(0) == curr.charAt(1)){
                if(pali.get(curr) % 2 == 0){
                    ans += pali.get(curr);
                }else{
                    if(!on){
                       ans += pali.get(curr);
                        on = true;
                    }
                    else ans += pali.get(curr) - 1;
                }
                pali.remove(curr);
            }
            else{
                String rev = curr.charAt(1) + "" + curr.charAt(0);
                if(pali.containsKey(curr) && pali.containsKey(rev)){
                    pali.put(curr, pali.get(curr) - 1);
                    if(pali.get(curr) == 0)
                        pali.remove(curr);
                    pali.put(rev, pali.get(rev) - 1);
                    if(pali.get(rev)== 0)
                        pali.remove(rev);
                    ans += 2;
                }
            }
        }
        return ans * 2;
    }
}