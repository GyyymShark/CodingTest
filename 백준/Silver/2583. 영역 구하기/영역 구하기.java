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

    static Queue<Point> q=new LinkedList<>();

    static int m,n,k;
    static int[][] board;
    static int leftx,lefty,rightx,righty;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static ArrayList<Integer> count2=new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());


        board=new int[m][n];

        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            leftx=Integer.parseInt(st.nextToken());
            lefty=Integer.parseInt(st.nextToken());
            rightx=Integer.parseInt(st.nextToken());
            righty=Integer.parseInt(st.nextToken());
            markArea();
        }
        bfs();
        Collections.sort(count2);

        for(int value : count2){
            System.out.print(value+" ");
        }

    }


    static void bfs(){
        int area=0,count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==0){
                    q.add(new Point(i,j));
                    area++;
                    board[i][j]=1;

                    while(!q.isEmpty()){
                        Point cur=q.remove();
                        count++;
                        for(int dir=0; dir<4; dir++){
                            int x=cur.x+dx[dir];
                            int y=cur.y+dy[dir];

                            if(x<0 || x>=m || y<0 || y>=n) continue;

                            if(board[x][y]==1) continue;

                            q.add(new Point(x,y));
                            board[x][y]=1;
                        }
                    }
                    count2.add(count);
                    count=0;
                }
            }
        }
        System.out.println(area);

    }

    static void print(){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    static void markArea(){

        for(int i=m-righty; i<=m-lefty-1; i++){
            for(int j=leftx; j<=rightx-1; j++){
                board[i][j]=1;
            }
        }

    }
}