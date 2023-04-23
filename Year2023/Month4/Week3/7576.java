
import java.util.*;
import java.io.*;
import java.awt.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Queue<Point> q =new LinkedList<>();
        int minDay=0, tomato=0;
        int[][] board;
        int[] dx={0,0,-1,1};
        int[] dy={1,-1,0,0};

        int col=Integer.parseInt(st.nextToken());
        int row=Integer.parseInt(st.nextToken());
        board=new int[row][col];

        for(int i=0; i<row; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //print board
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]==1){
                    tomato++;
                    q.add(new Point(i,j));
                }
            }
        }

        if(tomato==0){
            System.out.println(-1);
            return;
        }

        else{
            while(!q.isEmpty()){
                Point p=q.poll();
                for(int i=0; i<4; i++){
                    int aroundx=p.x+dx[i];
                    int aroundy=p.y+dy[i];

                    if((0<=aroundx && aroundx<=row-1) && (0<=aroundy && aroundy<=col-1)){
                        if(board[aroundx][aroundy]==0){ //방문하지 않았으면
                            board[aroundx][aroundy]=board[p.x][p.y]+1;
                            q.add(new Point(aroundx, aroundy));
                        }
                    }



                }
            }
        }


        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]==0){
                    minDay=0;
                    System.out.println(-1);
                    return;
                }

                if(board[i][j]>minDay){
                    minDay=board[i][j];
                }
            }
        }



        System.out.println(minDay-1);

    }
}