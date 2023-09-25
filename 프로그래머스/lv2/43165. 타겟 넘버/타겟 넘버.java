import java.util.*;
class Solution {
    static class Point{
        int idx;
        int sum;
        Point(int idx, int sum){
            this.idx=idx;
            this.sum=sum;
        }
    }
    static Queue<Point> q=new LinkedList<>();
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
    
        q.offer(new Point(0,0));
        
        while(!q.isEmpty()){
            Point cur=q.poll();
            if(cur.idx==numbers.length){
                if(cur.sum==target) answer++;
            }
            
            else{
                q.offer(new Point(cur.idx+1, cur.sum+numbers[cur.idx]));
                q.offer(new Point(cur.idx+1, cur.sum-numbers[cur.idx]));
            }
        }
        
        
        return answer;
    }
}