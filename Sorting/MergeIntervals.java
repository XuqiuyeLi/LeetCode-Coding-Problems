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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        if(intervals.size() == 1){
            return intervals;
        }
        // need to sort it first, otherwise not work
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }        
        });
        
        // always compare the current intervals with the one in the result already
        // the last entry in the result serve as a stack top
        int last = 0;
        result.add(intervals.get(0));
        // i points to the last Interval in the result
        for(int i = 0; i < intervals.size() - 1; i++){
            if(result.get(last).end >= intervals.get(i + 1).start){
                int newStart = Math.min(result.get(last).start, intervals.get(i + 1).start);
                int newEnd = Math.max(result.get(last).end, intervals.get(i + 1).end);
                result.set(last, new Interval(newStart, newEnd));
            }
            //not overlap
            else{
                result.add(intervals.get(i + 1));
                last++;
            }
        }
        return result;
        
    }
}