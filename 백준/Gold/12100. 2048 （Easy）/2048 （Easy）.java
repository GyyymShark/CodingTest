import java.util.*;
import java.io.*;


class Main{
    static int n,max=0;
    static int[][] board1=new int[21][21];
    static int[][] board2=new int[21][21];
    //기울이기와
    //방향별 브루투포스
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                board1[i][j]=Integer.parseInt(st.nextToken());
        }


        for(int tmp=0; tmp<1024; tmp++){
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    board2[i][j]=board1[i][j];

            int brute=tmp;
            for(int i=0; i<5; i++){
                int dir=brute%4;
                brute/=4;
                if(dir==0){     //상
                    up();
                }
                else if(dir==1){    //우
                    right();
                }
                else if(dir==2){    //하
                    down();
                }
                else if(dir==3){    //좌
                    left();
                }


            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(board2[i][j]>max)
                        max=board2[i][j];
                }
            }

        }


        System.out.println(max);

    }


    static void right(){
        for(int i=0; i<n; i++){ //행

            int[] tmp=new int[n];
            int tmpidx=0;

            for(int j=n-1; j>=0; j--){
                if(board2[i][j]==0) continue;

                if(tmp[tmpidx]==0) tmp[tmpidx]=board2[i][j];

                else if(tmp[tmpidx]==board2[i][j]) tmp[tmpidx++]*=2;

                else tmp[++tmpidx]=board2[i][j];
            }

            for(int j=0; j<n; j++){
                board2[i][n-1-j]=tmp[j];
            }
        }
    }

    static void left(){
        for(int i=0; i<n; i++){ //행

            int[] tmp=new int[n];
            int tmpidx=0;

            for(int j=0; j<n; j++){
                if(board2[i][j]==0) continue;

                if(tmp[tmpidx]==0) tmp[tmpidx]=board2[i][j];

                else if(tmp[tmpidx]==board2[i][j]) tmp[tmpidx++]*=2;

                else tmp[++tmpidx]=board2[i][j];
            }

            for(int j=0; j<n; j++){
                board2[i][j]=tmp[j];
            }
        }
    }

    static void down(){
        for(int j=0; j<n; j++){ //열

            int[] tmp=new int[n];
            int tmpidx=0;

            for(int i=n-1; i>=0; i--){
                if(board2[i][j]==0) continue;

                if(tmp[tmpidx]==0) tmp[tmpidx]=board2[i][j];

                else if(tmp[tmpidx]==board2[i][j]) tmp[tmpidx++]*=2;

                else tmp[++tmpidx]=board2[i][j];
            }

            for(int i=0; i<n; i++){
                board2[n-1-i][j]=tmp[i];
            }
        }
    }

    static void up(){
        for(int j=0; j<n; j++){ //열

            int[] tmp=new int[n];
            int tmpidx=0;

            for(int i=0; i<n; i++){
                if(board2[i][j]==0) continue;

                if(tmp[tmpidx]==0) tmp[tmpidx]=board2[i][j];

                else if(tmp[tmpidx]==board2[i][j]) tmp[tmpidx++]*=2;

                else tmp[++tmpidx]=board2[i][j];
            }

            for(int i=0; i<n; i++){
                board2[i][j]=tmp[i];
            }
        }
    }

    static void printBoard2(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}