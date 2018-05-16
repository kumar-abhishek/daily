/*
264. Ugly Number II  QuestionEditorial Solution
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
*/
//accepted solution
 public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue();
        pq.offer(1l);
        int count = 1;
        while(count < n){
            long top = pq.poll();
            ++count;
            if(top%2==0){
                pq.offer(top*2);
            } else if(top %3==0){
                pq.offer(top*2);
                pq.offer(top*3);
            } else{
                pq.offer(top*2);
                pq.offer(top*3);
                pq.offer(top*5);
            }
        }
        return pq.poll().intValue();
    }
}

