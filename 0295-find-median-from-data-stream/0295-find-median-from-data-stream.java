class MedianFinder {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<>((a,b)-> a - b);
        maxH = new PriorityQueue<>((a,b)-> b - a);
    }
    
    public void addNum(int num) {
        if(maxH.isEmpty() || num < maxH.peek())
            maxH.add(num);
        else minH.add(num);
        if(maxH.size() > minH.size() + 1)
            minH.add(maxH.poll());
        else if(maxH.size() + 1 < minH.size())
            maxH.add(minH.poll());
        
    }
    
    public double findMedian() {
        if(minH.size() == maxH.size())
            return (minH.peek() + maxH.peek()) / 2.0;
        else if(minH.size() > maxH.size())
            return minH.peek();
        else return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */