import java.util.*;
import java.io.*;

class Main{
    static int[] d;
    static int[][] gear=new int[5][8];
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1; i<=4; i++){
            String s=br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j]=s.charAt(j)-'0';
            }
        }

        int k=Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            d=new int[5];
            st=new StringTokenizer(br.readLine());
            int gear=Integer.parseInt(st.nextToken());
            int dir=Integer.parseInt(st.nextToken());
            simulation(gear, dir);
        }
        int count=0;
        if(gear[1][0]==1) count+=1;
        if(gear[2][0]==1) count+=2;
        if(gear[3][0]==1) count+=4;
        if(gear[4][0]==1) count+=8;

        System.out.println(count);


    }

    static void simulation(int gear, int dir){
        checkDir(gear, dir);
        rotate();
    }
    static void rotate(){

        for(int i=1; i<=4; i++){
            if(d[i]==1){    //시계 방향
                int lastValue=gear[i][7];
                for(int j=6; j>=0; j--){
                    gear[i][j+1]=gear[i][j];
                }
                gear[i][0]=lastValue;
            }
            else if(d[i]==-1){  //반시계 방향
                int firstValue=gear[i][0];
                for(int j=1; j<=7; j++){
                    gear[i][j-1]=gear[i][j];
                }
                gear[i][7]=firstValue;
            }
        }

    }

    static void checkDir(int no, int dir){

        d[no]=dir;
        //왼쪽 회전 검사
        for(int i=no; i>1; i--){
            if(gear[i][6]==gear[i-1][2]) break;  //회전 불가능
            d[i-1]=d[i]*(-1);
        }

        //오른쪽 회전 검사
        for(int i=no; i<4; i++){
            if(gear[i][2]==gear[i+1][6]) break;  //회전 불가능
            d[i+1]=d[i]*(-1);
        }

    }

    static void print(){
        for(int i=1; i<=4; i++){
            for(int j=0; j<8; j++) {
                System.out.print(gear[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}