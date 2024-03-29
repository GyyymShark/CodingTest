import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main{
    static int[][] arr=new int[41][2];
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        arr[0][0]=1; arr[0][1]=0;
        arr[1][0]=0; arr[1][1]=1;
        arr[2][0]=1; arr[2][1]=1;

        for(int i=3; i<=40; i++){
            arr[i][0]=arr[i-1][1];
            arr[i][1]=arr[i-1][0]+arr[i-1][1];
        }

        for(int i=0; i<t; i++){
            int n=Integer.parseInt(br.readLine());
            System.out.println(arr[n][0]+" "+arr[n][1]);
        }
    }
}