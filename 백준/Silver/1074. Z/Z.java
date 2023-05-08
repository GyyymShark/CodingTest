import java.util.*;
import java.io.*;


class Main{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken()); //r행
        int c=Integer.parseInt(st.nextToken()); //c열  (c,r)

        System.out.println(func(n,r,c));
    }

    static int func(int n, int r, int c){
        if(n==0)
            return 0;
        int half=(1<<n-1);

        if(c<half && r<half) return func(n-1, r,c);
        if(c>=half && r<half) return half*half+func(n-1, r, c-half);
        if(c<half && r>=half) return 2*half*half+func(n-1,r-half,c);
        return 3*half*half+func(n-1,r-half,c-half);
    }

}