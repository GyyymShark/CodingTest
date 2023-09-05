import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int weight=0;
        int idx=0;
        boolean[] visited=new boolean[people.length];
        

        Arrays.sort(people);
        
        
        for(int i=people.length-1; i>=idx; i--){
            if(people[idx]+people[i]<=limit){
                answer++;
                idx++;
            }
            else{
                answer++;
            }
        }
        
     
        
        return answer;
    }
}