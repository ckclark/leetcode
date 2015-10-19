package leetcode.find_median_from_data_stream;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> lowerheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> upperheap = new PriorityQueue<Integer>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        upperheap.add(num);
        lowerheap.add(-upperheap.remove());
        if(lowerheap.size() > upperheap.size()){
            upperheap.add(-lowerheap.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(upperheap.size() > lowerheap.size()){
            return upperheap.peek();
        }else if(upperheap.size() < lowerheap.size()){
            return -lowerheap.peek();
        }else{
            return .5 * (upperheap.peek() - lowerheap.peek());
        }
    }
}