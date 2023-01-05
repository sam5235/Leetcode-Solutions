class Allocator {
    int[] memory;
    public Allocator(int n) {
        memory = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int i = 0;
        int j = 0;
        int n  = memory.length;
        while( i < n){
            if(memory[i] == 0){
                j = i;
                while(j < n && memory[j] == 0){
                    if(size == (j - i + 1)){
                        for(int m = i; m <= j; m++)
                            memory[m] = mID;
                        return i;
                    }
                    j++;
                }
            }
            j++;
            i = j;
            
        }
        return -1;
    }
    
    public int free(int mID) {
        int freed = 0;
        for(int i = 0; i < memory.length; i++){
            if(memory[i] == mID){
                memory[i] = 0;
                freed++;
            }
                
        }
        return freed;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */