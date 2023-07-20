import java.util.*;
import java.io.*;

class Main{



    static int[] visited=new int[100001];
    static int subin, sister, min=Integer.MAX_VALUE;
    static Queue<Integer> q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        subin=Integer.parseInt(st.nextToken());
        sister=Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(visited[sister]);
    }
    static void bfs() {
       q.add(subin);


       while(!q.isEmpty()){
           int cur=q.remove();
           if(cur==sister) return;

           for(int dir=0; dir<3; dir++){
               int tmp=cur;

               if(dir==0)
               tmp-=1;
               else if(dir==1)
                   tmp+=1;
               else if(dir==2)
                   tmp*=2;

               if(tmp<0 || tmp>=100001) continue;


               if(visited[tmp]==0){     //아직 방문하지 않았을때
                   visited[tmp]=visited[cur]+1;
                   q.add(tmp);
               }

               else{        //방문 했을때
                   if(visited[cur]+1<visited[tmp]){
                       visited[tmp]=visited[cur]+1;
                       q.add(tmp);
                   }
               }



           }
       }


    }

}