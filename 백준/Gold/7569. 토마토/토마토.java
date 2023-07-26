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
    static int m,n,h,min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx={-1,1,0,0};    //상하좌우
    static int[] dy={0,0,-1,1};

    static Queue<Point> q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());


        map=new int[m*h][n];
        visited=new boolean[m*h][n];

        for(int i=0; i<m*h; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int value=Integer.parseInt(st.nextToken());
                map[i][j]=value;
                if(map[i][j]==1)
                    q.add(new Point(i,j));
            }
        }

        if(ripeCheck()){
            System.out.println(0);
            return;
        }

        bfs();
        if(ripeCheck(min))
        System.out.println(min);
        else
            System.out.println(-1);

       // printMap();

    }

    static void bfs(){


        while(!q.isEmpty()){
            Point cur=q.remove();
            visited[cur.x][cur.y]=true;

            for(int dir=0; dir<4; dir++){       //상하좌우
                int nx=cur.x+dx[dir];
                int ny=cur.y+dy[dir];

                if(nx<(cur.x/m)*m || nx>=(cur.x/m+1)*m || ny<0 || ny>=n) continue;
                //if(nx<0 || nx>=m*h || ny<0 || ny>=n) continue;
                if(!visited[nx][ny] && map[nx][ny]==0){
                    q.add(new Point(nx,ny));
                    visited[nx][ny]=true;
                    map[nx][ny]=map[cur.x][cur.y]+1;
                }
            }


                for(int dir=0; dir<2; dir++){
                    int nx=cur.x,ny=cur.y;
                    if(dir==0)
                        nx=cur.x+(-1*m);
                    else if(dir==1)
                        nx=cur.x+(1*m);


                    if(nx<0 || nx>=m*h || ny<0 || ny>=n) continue;
                  //  if(nx<(nx/m)*m || nx>=(nx/m+1)*m || ny<0 || ny>=n) continue;

                    if(!visited[nx][ny] && map[nx][ny]==0){
                        q.add(new Point(nx,ny));
                        visited[nx][ny]=true;
                        map[nx][ny]=map[cur.x][cur.y]+1;
                    }
                }
           // printMap();
        }

    }


    static boolean ripeCheck(){
        int count=0;
        for(int i=0; i<m*h; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0)
                    count++;
            }
        }
        if(count==0) return true;
        return false;
    }

    static boolean ripeCheck(int value){
        int max=0;
        for(int i=0; i<m*h; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0)
                    return false;
                if(map[i][j]>max)
                    max=map[i][j];
            }
        }
        min=max-1;
        return true;
    }

    static void printMap(){
        for(int i=0; i<m*h; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}