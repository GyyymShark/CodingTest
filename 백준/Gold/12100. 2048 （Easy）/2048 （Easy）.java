import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] board1=new int[21][21];
    static int[][] board2=new int[21][21];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board1[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int mx=0;
        for(int tmp=0; tmp<1024; tmp++){
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    board2[i][j]=board1[i][j];
            int brute=tmp;

            for(int i=0; i<5; i++){
                int dir=brute%4;
                brute/=4;
                tilt(dir);
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mx=Math.max(mx,board2[i][j]);
                }
            }
        }

        System.out.println(mx);

    }

    static void rotate(){   //board2를 시계방향으로 90도 회전하는 함수
        int[][] tmp=new int[21][21];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tmp[i][j]=board2[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board2[i][j]=tmp[n-1-j][i];
            }
        }


    }

    static void tilt(int dir){
        for(int i=dir; i>=0; i--) rotate();

        for(int i=0; i<n; i++){
            int[] tilted=new int[21]; //board2[i]를 왼족으로 기울인 결과를 저장할 변수
            int idx=0;  //tilted 배열에서 어디에 삽입해야 하는지 가리키는 변수

            for(int j=0; j<n; j++){
                if(board2[i][j]==0) continue;
                if(tilted[idx]==0)  //삽입할 위치가 비어있을때
                    tilted[idx]=board2[i][j];
                else if(tilted[idx]==board2[i][j])
                    tilted[idx++]*=2;
                else    //다른 값을 갖는 블록이 충돌
                    tilted[++idx]=board2[i][j];
            }
            for(int j=0; j<n; j++){
                board2[i][j]=tilted[j];
            }
        }
    }
}