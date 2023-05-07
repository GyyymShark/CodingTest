

import java.util.*;
import java.io.*;


class Main{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());

        sb.append((1<<n)-1);
        sb.append("\n");
        func(1,3,n);
        System.out.println(sb);

    }

    static void func(int start, int end, int n){
        if(n==1) {
            sb.append(start + " " + end);
            sb.append("\n");
            return;
        }

        func(start, 6-start-end, n-1);
        sb.append(start+" "+end);
        sb.append("\n");
        func(6-start-end, end, n-1);


    }
}