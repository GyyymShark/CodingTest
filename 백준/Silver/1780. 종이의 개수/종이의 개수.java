


import java.util.*;
import java.io.*;

class Main {

    static int[][] board;
    static int zero=0, one=0, minusOne=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(n,0,0);       //x행 y열
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    static void count(int value) {
        if(value==0){
            zero++;
        }
        else if(value==1){
            one++;
        }
        else if(value==-1){
            minusOne++;
        }
    }

    static void count(int size, int x, int y){
        for(int i=0; i<size; i++){      //행
            for(int j=0; j<size; j++){      //열
                int xCoord=x+i;
                int yCoord=y+j;
                if(board[xCoord][yCoord]==0){
                    zero++;
                }
                else if(board[xCoord][yCoord]==1){
                    one++;
                }
                else if(board[xCoord][yCoord]==-1){
                    minusOne++;
                }
            }
        }
    }



    static void paper(int size, int x, int y){
        int firstValue=board[x][y];     //행열
        boolean equal=true;

        if(size==1){    //개수 카운트
            count(board[x][y]);
            return;
        }


        Loop1 :
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(firstValue!=board[i][j]){
                    equal=false;
                    break Loop1;
                }
            }
        }
        if(!equal){
            //00 03 06 30 33 36 60 63 66 <- 9일떄
            //00 01 02 10 11 12
            for(int i=0; i<3; i++){     //행
                for(int j=0; j<3; j++){ //열
                    //paper(size/3,  i*(size/3), j*(size/3));
                    paper(size/3,  x+i*(size/3), y+j*(size/3));
                }
            }
        }

        else{
            if(firstValue==0){
                zero++;
            }
            else if(firstValue==-1){
                minusOne++;
            }
            else if(firstValue==1){
                one++;
            }
           // System.out.println("minusOne:"+minusOne+" "+"zero:"+zero+" "+"one:"+one);
        }

    }
}