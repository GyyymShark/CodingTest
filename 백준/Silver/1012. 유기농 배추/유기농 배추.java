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
    static int n,m,k,worm=0;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q =new LinkedList<>();

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            worm=0;
            map=new int[n][m];
            visited=new boolean[n][m];
            for(int j=0; j<k; j++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                map[x][y]=1;
            }
            bfs();
            System.out.println(worm);
        }



    }
    static void bfs(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j]=true;
                    worm++;

                    while(!q.isEmpty()){
                        Point cur=q.remove();
                        visited[cur.x][cur.y]=true;
                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                            if(!visited[nx][ny] && map[nx][ny]==1) {
                                q.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }

            }
        }

    }
}