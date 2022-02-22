class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            int freq = map.getOrDefault(word, 0) +1;
            map.put(word, freq);
        }
        Queue<Word> q = new PriorityQueue<>((a,b) -> (a.freq == b.freq ? a.word.compareTo(b.word) : b.freq - a.freq ));
        for(Map.Entry<String , Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            Word word = new Word(val, key);
            q.add(word);
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
        ans.add(q.poll().word);
        }
        return ans;
        
    }
    class Word {
        int freq;
        String word;
        public Word(int freq, String word){
           this.freq  = freq;
            this.word = word;
        }
        
    }
}