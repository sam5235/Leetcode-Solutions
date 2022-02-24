class MedianFinder {
        Queue<Integer> pq1;
        Queue<Integer> pq2;
    public MedianFinder() {
        pq1 = new PriorityQueue<>((a,b)-> b - a);
        pq2 = new PriorityQueue<>((a,b)-> a - b);
        
    }
    
    public void addNum(int num) {
       if(pq2.isEmpty() || num > pq2.peek()){
            pq2.add(num);
       } else pq1.add(num);
        if(pq2.size() > pq1.size() + 1){
            pq1.add(pq2.poll());
        } else if(pq1.size() > pq2.size() + 1){
            pq2.add(pq1.poll());
        }
        
    }
    
    public double findMedian() {
       
        if(pq1.size() == pq2.size()){
            return (pq1.peek() + pq2.peek())/2.0;
        } else if(pq1.size() > pq2.size()){
            return pq1.peek();
        }else return pq2.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//5: 09
// 5 : 49