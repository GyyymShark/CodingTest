import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int x;
        int y;
        int k;
        int count;

        Point(int x, int y, int k, int count){
            this.x=x;
            this.y=y;
            this.k=k;
            this.count=count;
        }
    }
    static int k,n,m,min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visited;

    static Queue<Point> q =new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        visited=new boolean[n][m][k+1];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(value==1)
                    map[i][j]=-1;
            }
        }

        min=bfs();
        if(min==Integer.MAX_VALUE) System.out.println(-1);

        else System.out.println(min);


    }

    static int bfs(){
        int[] hdx={-1,-2,-2,-1,1,2,2,1};
        int[] hdy={-2,-1,1,2,-2,-1,1,2};
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        boolean horseSuccess=false;

        q.add(new Point(0,0,k,0));
        visited[0][0][k]=true;


        while(!q.isEmpty()){
            Point cur=q.remove();
            if(cur.x==n-1 && cur.y==m-1){
                return cur.count;
            }

            for(int dir=0; dir<4; dir++){
                int nx=cur.x+dx[dir];
                int ny=cur.y+dy[dir];
                int nk=cur.k;
                int ncount=cur.count;



                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                if(map[nx][ny]==-1 || visited[nx][ny][nk]) continue;

                q.add(new Point(nx,ny,nk,ncount+1));
                visited[nx][ny][nk]=true;
            }

            if (cur.k > 0) {
                for(int dir=0; dir<8; dir++){
                    int nx=cur.x+hdx[dir];
                    int ny=cur.y+hdy[dir];
                    int nk=cur.k;
                    int ncount=cur.count;


                    if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

                    if(map[nx][ny]==-1 || visited[nx][ny][nk-1]) continue;

                    q.add(new Point(nx,ny,nk-1,ncount+1));
                    visited[nx][ny][nk-1]=true;

                }
            }


        }



        return min;

    }



}