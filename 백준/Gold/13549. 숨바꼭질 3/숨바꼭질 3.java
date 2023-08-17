import java.util.*;
import java.io.*;

class Main{
    static int n,k;
    static int[] map=new int[100001];
    static boolean[] visited=new boolean[100001];

    static int[] dx={-1,1,2};
    static Queue<Integer> q=new LinkedList<>();
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        bfs();
        if(n==k) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }


    }

    static void bfs(){
        q.add(n);
        visited[n]=true;

        while(!q.isEmpty()){
            int cur = q.remove();


            for(int dir=2; dir<=2; dir++){
                int x=cur*dx[dir];

                if(x<0  || x>=100001) continue;
                if(visited[x]) continue;

                if(x==k){
                    min=Math.min(min,map[cur]);
                }

                q.add(x);
                visited[x]=true;
                map[x]=map[cur];
            }

            for(int dir=0; dir<2; dir++){

                int x=cur+dx[dir];

                if(x<0 || x>=100001) continue;
                if(visited[x]) continue;

                if(x==k){
                    min=Math.min(min,map[cur]+1);
                }

                q.add(x);
                visited[x]=true;
                map[x]=map[cur]+1;
            }




        }
    }
}