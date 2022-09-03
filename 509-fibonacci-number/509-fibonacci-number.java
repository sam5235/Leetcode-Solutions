class Solution {
    public int fib(int n) {
        
        return fibN(n, new HashMap<>());
    }
    int fibN(int n, HashMap<Integer,Integer> map){
        if(n == 1 || n == 0) return n;
        if(map.containsKey(n)) return map.get(n);
        int fn = fibN(n - 1, map) + fibN(n - 2, map);
        map.put(n, fn);
        return fn;
    }
}