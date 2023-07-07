import java.util.*;
import java.io.*;

class Main {
    static int k;
    static int[] board;
    static int[] arr=new int[15];
    static boolean[] visited=new boolean[15];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            if(k==0)
                break;
            board=new int[k];
            for(int i=0; i<k; i++){
                board[i]=Integer.parseInt(st.nextToken());
            }
            func(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void func(int depth, int idx){
        if(depth==6){
            for(int i=0; i<6; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }


        for(int i=idx; i<k; i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=board[i];
                func(depth+1, i);
                visited[i]=false;
            }

        }

    }
}