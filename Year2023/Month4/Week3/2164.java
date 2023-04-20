
import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());


        for(int i=1; i<=n; i++){
            q.add(i);
        }


        while(q.size()!=1){
            q.poll();
            int num=q.poll();
            q.add(num);
        }

        sb.append(q.remove());
        System.out.println(sb);


    }
}