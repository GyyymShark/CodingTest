

import java.util.*;
import java.io.*;

class Main{
    static int n,s,cnt=0;
    static int[] board=new int[30];

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            board[i]=Integer.parseInt(st.nextToken());
        }
        func(0,0);
        if(s==0) cnt--;
        System.out.println(cnt);
    }

    static void func(int cur, int tot){
        if(cur==n){
            if(tot==s)cnt++;
            return;
        }
        func(cur+1, tot);
        func(cur+1, tot+board[cur]);
    }
}