

import java.util.*;
import java.io.*;
import java.awt.Point;

class Main{
    static int arr[][];
    static int visited[][];
    static StringBuilder sb=new StringBuilder();
    static Queue<Point> q=new LinkedList<>();
    static int[] dx={0,0,-1,1}; //상하좌우
    static int[] dy={1,-1,0,0};  //상하좌우

    static int count=0; //그림 개수
    static int maxArea=0;  //최대 그림 넓이

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int col,row;
        StringTokenizer st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());


        arr=new int[row][col];
        visited=new int[row][col];

        for(int i=0; i<row; i++){
            StringTokenizer str=new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                int value=Integer.parseInt(str.nextToken());
                arr[i][j]=value;
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                bfs(i,j, row, col);
            }
        }

        sb.append(count+"\n"+maxArea);
        System.out.println(sb);

    }

    static void bfs(int row, int col, int rowSize, int colSize){
        boolean exist=false;
        if(visited[row][col]!=1)
            q.add(new Point(row, col));
        visited[row][col]=1;
        int area=0;

        while(!q.isEmpty()){
            Point p=q.poll();
            int curX=(int)p.getX();
            int curY=(int)p.getY();


            if(arr[curX][curY]==1){   //그림이 있으면
                area++;     //그림 넓이 증가
                exist=true;

                for(int i=0; i<4; i++){
                    int aroundX=dx[i]+curX;
                    int aroundY=dy[i]+curY;

                    if((0<=aroundX && aroundX<=rowSize-1) && (0<=aroundY && aroundY<=colSize-1)){
                        if(visited[aroundX][aroundY]!=1 && arr[aroundX][aroundY]==1){
                            q.add(new Point(aroundX,aroundY));
                            visited[aroundX][aroundY]=1;
                        }
                    }



                }
            }

        }


        if(area>maxArea)
            maxArea=area;

        if(exist)
            count++;
    }

}
