

import java.awt.*;
import java.util.*;
import java.io.*;

class Main{
    static int[][] board;
    static int[][] dist;
    static Queue<Point> q=new LinkedList<>();
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};




    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int row=Integer.parseInt(st.nextToken());
        int col=Integer.parseInt(st.nextToken());

        board=new int[row][col];
        dist=new int[row][col];

        for(int i=0; i<row; i++){
            String line=br.readLine();
            for(int j=0; j<col; j++){
                board[i][j]=line.charAt(j)-'0';
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dist[i][j]=-1;
            }
        }
        bfs(row, col);


        System.out.println(dist[row-1][col-1]);

    }

    static void bfs(int row, int col){
        q.add(new Point(0,0));
        dist[0][0]=1;


        while(!q.isEmpty()){
            Point p=q.poll();
            int curX=p.x;
            int curY=p.y;
            int value=board[curX][curY];
            int distValue=dist[curX][curY];

            for(int i=0; i<4; i++){
                int aroundX=curX+dx[i];
                int aroundY=curY+dy[i];

                if((0<=aroundX && aroundX<=row-1) && (0<=aroundY && aroundY<=col-1)){   //인덱스가 배열을 넘지 않고
                    if(dist[aroundX][aroundY] ==-1 && board[aroundX][aroundY]==1 ){ //방문하지 않았고 1일때만
                        dist[aroundX][aroundY]=distValue+1;
                        q.add(new Point(aroundX, aroundY));
                    }
                }
            }
        }
    }



}