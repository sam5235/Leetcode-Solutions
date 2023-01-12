class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int freq = 0;
        for(int size = minSize; size <= Math.min(maxSize, s.length()); size++){
            HashMap<Character, Integer> letters = new HashMap<>();
            HashMap<String, Integer> occur = new HashMap<>();
            for(int i = 0; i < size; i++){
                int frequ = letters.getOrDefault(s.charAt(i), 0) + 1;
                letters.put(s.charAt(i), frequ);
            }
            int i = 0;
            int j = size;
            while(j < s.length()){
                if(letters.size() <= maxLetters){
                    String key = new String(s.substring(i, j));
                    int frequ = occur.getOrDefault(key, 0) + 1;
                    occur.put(key, frequ);
                    freq = Math.max(freq, frequ);
                }
                letters.put(s.charAt(i),letters.get(s.charAt(i)) - 1);
                if(letters.get(s.charAt(i)) == 0)
                    letters.remove(s.charAt(i));
                i++;
                int inc = letters.getOrDefault(s.charAt(j), 0) + 1;
                letters.put(s.charAt(j), inc);
                j++;
            }
            
            if(letters.size() <= maxLetters){
                String key = new String(s.substring(i, j));
                int frequ = occur.getOrDefault(key, 0) + 1;
                occur.put(key, frequ);
                freq = Math.max(freq, frequ);
            }
        }
        return freq;
    }
}