
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long n=Integer.parseInt(st.nextToken());
        long result=dfs(n);
        System.out.println(result);
    }

    static long dfs(long n){
        if(n==0)
            return 1;

        return n*dfs(n-1);
    }
}