import java.io.*;
import java.util.*;
class Main{


    static class Node{
        int value;
        int count;

        Node(int value, int count){
            this.value=value;
            this.count=count;
        }
    }
    static int n,start,end;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Node> q=new LinkedList<>();
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];
        visited=new boolean[n+1];

        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());


        int m=Integer.parseInt(br.readLine());


        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());


            arr[a][b]=1;
            arr[b][a]=1;
        }

        bfs();
        System.out.println(count);

    }



    static void bfs() {
        q.offer(new Node(start,0));
        visited[start]=true;
        boolean possible=false;
        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.value==end){
                possible=true;
                count=cur.count;
                return;
            }

            for(int j=1; j<=n; j++){
                if(arr[cur.value][j]==1 && !visited[j]){  //간선이 있고, 방문하지 않았으면
                    q.add(new Node(j,cur.count+1));
                    visited[j]=true;
                }
            }

        }

        if(!possible) count=-1;
    }


    static void print(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}