
import java.util.*;
import java.io.*;


class Main{
    static int[] cnt=new int[2];
    static int[][] board;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        board=new int[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        solve(n,0,0);
        System.out.print(cnt[0]+"\n"+cnt[1]);
    }

    static boolean check(int n, int x, int y){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(board[x][y]!=board[i][j])
                    return false;
            }
        }
        return true;

    }

    static void solve(int n, int x, int y){ //행 열
        int firstValue=board[x][y];

        if(check(n,x,y)){
            cnt[board[x][y]]++;
            return;
        }

        for(int i=0; i<2; i++)
            for(int j=0; j<2; j++)
                solve(n/2, x+(n/2)*i, y+(n/2)*j);

    }
}