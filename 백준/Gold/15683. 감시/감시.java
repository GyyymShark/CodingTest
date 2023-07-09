import java.util.*;
import java.io.*;

class Main{
    static public class Point{
        int x;
        int y;
        int num;

        Point(int x, int y, int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }
    static int n,m;
    static int min=Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Point> cctvList=new ArrayList<Point>();

    static int[] dx={-1,0,1,0};  //상우하좌
    static int[] dy={0,1,0,-1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(1<=map[i][j] && map[i][j]<=5)
                    cctvList.add(new Point(i,j,map[i][j]));
            }
        }


        func(0, map);
        System.out.println(min);


    }

    static void func(int depth, int[][] map){
        if(depth==cctvList.size()){
            int zeroCount=countZero(map);
            min=Math.min(min,zeroCount);
            return;
        }


        int[][] copymap=new int[n][m];
        Point cctv=cctvList.get(depth);
        int num=cctv.num;

        for(int i=0; i<4; i++){
            copymap=copy(copymap,map);

            if(num==1){
                markArea(cctv.x, cctv.y, copymap,i);
            }
            else if(num==2){
                markArea(cctv.x, cctv.y, copymap,i);
                markArea(cctv.x, cctv.y, copymap,(i+2)%4);
            }
            else if(num==3){
                markArea(cctv.x, cctv.y, copymap,i);
                markArea(cctv.x, cctv.y, copymap,(i+1)%4);
            }
            else if(num==4){
                markArea(cctv.x, cctv.y, copymap,i);
                markArea(cctv.x, cctv.y, copymap,(i+1)%4);
                markArea(cctv.x, cctv.y, copymap,(i+3)%4);
            }
            else if(num==5){
                markArea(cctv.x, cctv.y, copymap,i);
                markArea(cctv.x, cctv.y, copymap,(i+1)%4);
                markArea(cctv.x, cctv.y, copymap,(i+2)%4);
                markArea(cctv.x, cctv.y, copymap,(i+3)%4);
            }
            func(depth+1, copymap);

        }

    }


    static void markArea(int x, int y, int[][] map, int dir){
        dir%=4;

        while(true){
            x+=dx[dir];
            y+=dy[dir];

            if(x<0 || x>=n || y<0 || y>=m || map[x][y]==6) break;

            if(map[x][y]!=0){
                continue;
            }
            map[x][y]=-1;
        }
    }

    static int[][] copy(int[][] copyMap, int[][] map){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMap[i][j]=map[i][j];
            }
        }
        return copyMap;
    }


    static int countZero(int[][] map){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0)
                    count++;
            }
        }
        return count;
    }

}