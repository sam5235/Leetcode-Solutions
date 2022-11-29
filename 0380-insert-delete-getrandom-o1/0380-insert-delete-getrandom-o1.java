class RandomizedSet {
    HashMap<Integer, Integer> address;
    List<Integer> set;

    public RandomizedSet() {
        address = new HashMap<>();
        set = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!address.containsKey(val)){
            set.add(val);
            address.put(val, set.size() - 1);
            return true;
        }else return false;
    }
    
    public boolean remove(int val) {
        if(address.containsKey(val)){
            address.put(set.get(set.size() - 1), address.get(val));
            Collections.swap(set, address.get(val), set.size()- 1);
            set.remove(set.size() - 1);
            address.remove(val);
            return true;
        }else return false;
    }
    
    public int getRandom() {
        int rand = (int) (Math.random() * set.size());
        return set.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */