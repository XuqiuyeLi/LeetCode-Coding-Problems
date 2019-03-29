/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRoomsMyFirstSolution(Interval[] intervals) {
        // solution: sort first
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int count = 1;
        if(intervals.length <= 1){
            return intervals.length;
        }
        // always compare with the last one
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end){
                // we need a separate one for the last one
                count++;
            }
        }
        return count;  
    }
    public int minMeetingRooms(Interval[] intervals) {
        // solution: sort first
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        //Initialize a new min-heap and add the first meeting's ending time to the heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int maxRooms = 0;
        for(int i = 0; i < intervals.length; i++){
            // allocate a room
            if(minHeap.isEmpty() || intervals[i].start < minHeap.peek()){  
                maxRooms++;
            }
            // free the room
            else{
                minHeap.poll();
            }
            minHeap.offer(intervals[i].end);            
        }
        return maxRooms;
    }
}