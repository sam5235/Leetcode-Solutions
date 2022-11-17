class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int area2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int inter = 0;
        if(isIntersect(ax1,  ay1, ax2, ay2,  bx1,  by1,  bx2, by2))
            inter = (Math.max(ax1, bx1) - Math.min(ax2, bx2)) * (Math.max(ay1, by1) - Math.min(ay2, by2)) ;
        return area1 + area2 - Math.abs(inter);
    }
    
    boolean isIntersect(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        return ((bx1 >= ax1 && bx1 <= ax2 )|| (ax1 >= bx1 && ax1 <= bx2)) &&  ((by1 >= ay1 && by1 <= ay2) || (ay1 >= by1 && ay1 <= by2));
    }
}