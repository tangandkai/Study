package com.tang.study.niukwwang.officer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class mergeInterval {

    public static void main(String[] args) {

        List<interval> intervals = new ArrayList<>();
        interval interval1 = new interval();
        interval1.start = 1;
        interval1.end = 8;
        intervals.add(interval1);

        interval interval2 = new interval();
        interval2.start = 2;
        interval2.end = 6;
        intervals.add(interval2);

        interval interval3 = new interval();
        interval3.start = 3;
        interval3.end = 7;
        intervals.add(interval3);

        interval interval4 = new interval();
        interval4.start = 9;
        interval4.end = 16;
        intervals.add(interval4);

        List<interval> res = new mergeInterval().merge(intervals);
        System.out.println(res);
    }

    public List<interval> merge(List<interval> intervals){

        Collections.sort(intervals, new Comparator<interval>() {
            @Override
            public int compare(interval o1, interval o2) {
                return o1.end - o2.end;
            }
        });
        int size = intervals.size();
        for (int i=size-1;i>0;i--){
            interval current = intervals.get(i);
            interval pre  = intervals.get(i-1);
            //形如【1，4】，【3，9】=》【1，9】
            if (pre.end>current.start){
                pre.start = Math.min(pre.start,current.start);
//                pre.end   = Math.max(pre.end,current.end);
                pre.end = current.end;
                intervals.remove(i);
            }
        }
        return intervals;
    }

    static class interval{
        public int start;
        public int end;

        public interval() {
            start = 0;
            end = 0;
        }

        public interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
