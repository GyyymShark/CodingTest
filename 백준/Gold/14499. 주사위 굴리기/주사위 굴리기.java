import java.util.*;
import java.io.*;


class Main{
    static int n,m,x,y,k;
    static int[] dice=new int[6];       //동 서 북 남 아래 위

    static int[][] map;
    static int[]dx={0,0,0,-1,1}; //동 서 북 남
    static int[]dy={0,1,-1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map=new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int direction=Integer.parseInt(st.nextToken());
            simulation(direction);
        }




    }
    static void simulation(int dir){
        //direction 1=동쪽 2=서쪽 3=북쪽 4=남쪽
        //dice 0=아래 1=오른 2=위 3=왼 4=앞 5=뒤
        //n 행(y)  m 열(x)

        int nx=x+dx[dir];
        int ny=y+dy[dir];

        if(nx<0 || nx>=n || ny<0 || ny>=m) return;

        x=nx; y=ny;

        if(dir==1){
            int down=dice[0];
            for(int i=1; i<4; i++){
                dice[i-1]=dice[i];
            }
            dice[3]=down;
        }
        else if(dir==2){
            int left=dice[3];
            for(int i=2; i>=0; i--){
                dice[i+1]=dice[i];
            }
            dice[0]=left;
        }
        else if(dir==3){
            int down=dice[0]; int up=dice[2]; int front=dice[4]; int rear=dice[5];
            dice[4]= down; dice[5]=up; dice[2]=front; dice[0]=rear;
        }
        else if(dir==4){
            int down=dice[0]; int up=dice[2]; int front=dice[4]; int rear=dice[5];
            dice[0]=front; dice[2]=rear; dice[4]=up; dice[5]=down;
        }


        if(map[x][y]==0){
            map[x][y]=dice[0];
        }
        else{
            dice[0]=map[x][y];
            map[x][y]=0;
        }
        System.out.println(dice[2]);



    }
}