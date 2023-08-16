import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static Queue<Point> q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map=new int[n][n];
        visited=new boolean[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0) continue;
                visitBfs(i,j);
                bfs(i,j);
            }
        }
        System.out.println(min);


    }

    static int[][] copy(){
        int[][] copymap=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copymap[i][j]=map[i][j];
            }
        }
        return copymap;
    }


    static void bfs(int x, int y){
        q.add(new Point(x,y));
        int[][] copy = copy();

        while(!q.isEmpty()){
            Point cur=q.remove();
            for(int dir=0; dir<4; dir++){
                int nx=cur.x+dx[dir];
                int ny=cur.y+dy[dir];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(visited[nx][ny]) continue;

                if(copy[nx][ny]==1){ //다른 섬에 도달했을때
                    int bridge=copy[cur.x][cur.y]-1;
                    min=Math.min(bridge, min);
                    continue;
                }

                q.add(new Point(nx,ny));
                visited[nx][ny]=true;
                copy[nx][ny]=copy[cur.x][cur.y]+1;
            }
        }
    }

    static void visitBfs(int x, int y){
        visited=new boolean[n][n];
        q.add(new Point(x,y));
        visited[x][y]=true;

        while(!q.isEmpty()){
            Point cur=q.remove();

            for(int dir=0; dir<4; dir++){
                int nx=cur.x+dx[dir];
                int ny=cur.y+dy[dir];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;


                if(!visited[nx][ny] && map[nx][ny]==1){
                    q.add(new Point(nx,ny));
                    visited[nx][ny]=true;
                }


            }
        }


    }
}