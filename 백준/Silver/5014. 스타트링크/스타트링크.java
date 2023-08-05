import java.util.*;
import java.io.*;

class Main{

    static int f,s,g,u,d;
    static int[] floor;
    static Queue<Integer> q=new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        f=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(st.nextToken());
        u=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        floor=new int[f+1];
        bfs();
        
    }

    static void bfs(){

        if(s==g) {
            System.out.println(0);
            return;
        }

        q.add(s);
        floor[s]=1;
        while(!q.isEmpty()){
            int cur=q.remove();

            for(int dir=0; dir<2; dir++){
                int y=cur;

                if(dir==0)
                    y+=u;
                else if(dir==1)
                    y-=d;

                if(y==g){
                    System.out.println(floor[cur]);
                    return;
                }

                if(y<=0 || y>f) continue;   //0층이나 f층보다 높으면 안됨

                if(floor[y]>=1 && floor[cur]+1>=floor[y]) continue;      //이미 방문한 곳인데 최소갱신이 불가능 한경우

                floor[y]=floor[cur]+1;
                q.add(y);
            }
        }

        System.out.println("use the stairs");
    }
}