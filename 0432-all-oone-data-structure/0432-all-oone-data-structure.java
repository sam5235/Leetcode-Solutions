class AllOne {
    
	// countMap: key is key, value is the count of the key
    private Map<String, Integer> countMap;
	// freqMap: key is count, value is keys with same count
    private TreeMap<Integer, HashSet<String>> freqMap;

    public AllOne() {
        countMap = new HashMap<>();
        freqMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int count = countMap.getOrDefault(key, 0);
        countMap.put(key, count + 1);
        if (count > 0) {
            freqMap.get(count).remove(key);
            if (freqMap.get(count).isEmpty()) {
                freqMap.remove(count);
            }
        }
        
        HashSet<String> set = freqMap.getOrDefault(count + 1, new HashSet<>());
        set.add(key);
        freqMap.put(count + 1, set);
    }
    
    public void dec(String key) {
        if (!countMap.containsKey(key)) {
            return;
        }
        
        int count = countMap.get(key);
        if (count == 1) {
            countMap.remove(key);
            freqMap.get(1).remove(key);
            if (freqMap.get(1).isEmpty()) {
                freqMap.remove(1);
            }
        } else {
            countMap.put(key, count - 1);
            freqMap.get(count).remove(key);
            if (freqMap.get(count).isEmpty()) {
                freqMap.remove(count);
            }
            
            HashSet<String> set = freqMap.getOrDefault(count - 1, new HashSet<>());
            set.add(key);
            freqMap.put(count - 1, set);
        }
    }
    
    public String getMaxKey() {
        if (freqMap.isEmpty()) {
            return "";
        }
        
        HashSet<String> maxSet = freqMap.lastEntry().getValue();
        return maxSet.iterator().next();
    }
    
    public String getMinKey() {
        if (freqMap.isEmpty()) {
            return "";
        }
        
        HashSet<String> minSet = freqMap.firstEntry().getValue();
        return minSet.iterator().next();
    }
}