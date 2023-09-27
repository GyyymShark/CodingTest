import java.util.*;

class Solution {
    static Queue<Integer> q =new LinkedList<>();
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int cur, int n, int[][] computers){
        q.offer(cur);
        visited[cur]=true;
        
        while(!q.isEmpty()){
            int value=q.poll();
            for(int i=0; i<n; i++){
                if(visited[i]==false && computers[value][i]==1){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
}