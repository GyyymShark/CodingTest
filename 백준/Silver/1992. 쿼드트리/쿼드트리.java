

import java.util.*;
import java.io.*;

class Main {
    static int board[][];
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        board=new int[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0; j<n; j++){
                board[i][j]=(int)str.charAt(j)-'0';
            }
        }
        
        solve(n, 0, 0);
        System.out.println(sb);
    }

    static void solve(int n, int x, int y) {

        if(check(n, x, y)){
            sb.append(board[x][y]);
            return;
        }


        for(int i=0; i<2; i++){
            if(i==0)
                sb.append("(");
            for(int j=0; j<2; j++){
                solve(n/2, x+(n/2)*i, y+(n/2)*j);
            }
        }


        sb.append(")");

    }

    static boolean check(int n, int x, int y){  //x행 y열
        int firstValue=board[x][y];

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(firstValue!=board[i][j])
                    return false;
            }
        }

        return true;
    }

    static void print(int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}