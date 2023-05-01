

import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.valueOf(Integer.parseInt(st.nextToken()));
        long b=Long.valueOf(Integer.parseInt(st.nextToken()));
        long c=Long.valueOf(Integer.parseInt(st.nextToken()));
        long result=bfs(a,b,c);
        System.out.println(result);
    }

    static long bfs(long a, long b, long c) {
        if(b==1) return a%c;
        long value=bfs(a, b/2, c);
        value=(value*value)%c;  //2k승
        if(b%2==0) return value;
        else return (a*value)%c;
    }
}