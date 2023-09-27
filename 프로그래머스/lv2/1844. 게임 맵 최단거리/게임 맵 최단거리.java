import java.util.*;
class Solution {
    static class Point{
        int x;
        int y;
        int count;
        Point(int x, int y, int count){
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    
    static Queue<Point> q=new LinkedList<>();
    static int min=Integer.MAX_VALUE;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        visited=new boolean[maps.length][maps[0].length];
        bfs(maps);
        if(min==Integer.MAX_VALUE) min=-1;
        return min;
    }
    
    static void bfs(int[][] maps){
        int n=maps.length;
        int m=maps[0].length;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        q.offer(new Point(0,0,1));
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            Point cur=q.poll();
            
            for(int dir=0; dir<4; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];
                
                if(x<0 || x>=n || y<0 || y>=m) continue;
                
                
                if(x==n-1 && y==m-1){
                    min=Math.min(cur.count+1, min);
                    return;
                }
                
                if(maps[x][y]==0 || visited[x][y]) continue;

        
                q.offer(new Point(x,y,cur.count+1));
                visited[x][y]=true;
            }
        }
        
    }
}