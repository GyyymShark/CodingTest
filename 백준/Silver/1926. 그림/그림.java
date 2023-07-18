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
   static int n,m, count=0, max=0;
   static int[][] board;
   static boolean[][] visited;
   static Queue<Point> q=new LinkedList<>();
   static int[] dx={-1,1,0,0};     //상하좌우
   static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        travel();
        System.out.println(count);
        System.out.println(max);
    }


    static void travel(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int size=0;
                if(!visited[i][j] && board[i][j]==1){
                    visited[i][j]=true;
                    q.add(new Point(i,j));
                    count++;

                    while(!q.isEmpty()){
                        Point cur=q.remove();
                        size++;
                        for(int dir=0; dir<4; dir++){
                            int x=cur.x+dx[dir];
                            int y=cur.y+dy[dir];

                            if(x<0 || x>=n || y<0 || y>=m) continue;

                            if(!visited[x][y] && board[x][y]==1){
                                visited[x][y]=true;
                                q.add(new Point(x,y));

                            }
                        }

                    }

                    max=Math.max(max,size);

                }
            }
        }


    }
}