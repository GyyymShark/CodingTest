import java.nio.Buffer;
import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[][] map;
    static int[][][] check;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    static Queue<int[]> q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        check=new int[2][n][m];

        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<m; j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }
        
        if(n==1 && m==1) {
            System.out.println(1);
            return;
        }
        bfs();

    }
    static void bfs(){
        q.offer(new int[] {0,0,0});
        check[0][0][0]=1;

        while(!q.isEmpty()){
            int[] node=q.poll();
            int w=node[0];
            int x=node[1];
            int y=node[2];


            for(int dir=0; dir<4; dir++){
                int nx=x+dx[dir];
                int ny=y+dy[dir];

                if(nx<0 || nx>= n || ny<0 || ny>=m) continue;

                if(nx==n-1 && ny==m-1){
                    System.out.println(check[w][x][y]+1);
                    return;
                }

                if(map[nx][ny]==0){ //벽이 아닐때
                    if(check[w][nx][ny]==0){    //방문하지않았으면
                        q.offer(new int[] {w,nx,ny});
                        check[w][nx][ny]=check[w][x][y]+1;
                    }

                }
                else{   //벽일때
                    if(w==0){   //벽을 안부쉈으면
                        if(check[1][nx][ny]==0){
                            q.offer(new int[] {1,nx,ny});
                            check[1][nx][ny]=check[0][x][y]+1;

                        }
                    }

                }

            }
        }
        System.out.println(-1);
    }

    static void print(){
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    System.out.print(check[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}