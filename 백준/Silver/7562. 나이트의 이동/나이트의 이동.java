import java.util.*;
import java.io.*;


class Main{
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int I;
    static Queue<Point> q=new LinkedList<>();
    static boolean visited[][];
    static int board[][];

    static int[] dx={1,1,2,2,-1,-1,-2,-2};
    static int[] dy={-2,2,-1,1,-2,2,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            I=Integer.parseInt(st.nextToken());
            visited=new boolean[I][I];
            board=new int[I][I];
            int x,y;
            Point start,goal;
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            start=new Point(x,y);
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            goal=new Point(x,y);
            bfs(start,goal);
            System.out.println(board[goal.x][goal.y]);
        }
    }

    static void bfs(Point start, Point goal){
        q.add(start);
        visited[start.x][start.y]=true;


        while(!q.isEmpty()){
            Point cur=q.remove();
            for(int dir=0; dir<8; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];

                if(x<0 || x>=I || y<0 || y>=I) continue;

                if(!visited[x][y]){
                    visited[x][y]=true;
                    board[x][y]=board[cur.x][cur.y]+1;
                    q.add(new Point(x,y));
                    if(x==goal.x && y==goal.y) break;
                }
            }
        }

    }
}