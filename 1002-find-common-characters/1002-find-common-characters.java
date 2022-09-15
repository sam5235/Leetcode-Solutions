class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] arr = new int[n][26];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < words[i].length(); j++){
                arr[i][words[i].charAt(j) - 'a']++;
            }
        }
        int[] ans = arr[0];
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < 26; j++){
                ans[j] = Math.min(ans[j], arr[i + 1][j]);
            }
        }

        List<String> ls = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(ans[i] > 0){
                char c = (char) (i + 97);
                ls.add(c + "");
                ans[i]--;
            }
        }
        return ls;
    }
}