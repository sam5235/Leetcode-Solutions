class Solution {
    public int longestStrChain(String[] words) {
        int longest = 1;
        HashMap<String, Integer> word_max = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        for(int i = 0;i < words.length;++i) {
            String word = words[i];
            int longer = 1;
            for(int j = 0;j < word.length();++j) {
                String last = new StringBuilder(word).deleteCharAt(j).toString();
                longer = Math.max(longer, word_max.getOrDefault(last, 0) + 1);
            }
            word_max.put(word, longer);
            longest = Math.max(longest, longer);
        }
        return longest;
    }
}