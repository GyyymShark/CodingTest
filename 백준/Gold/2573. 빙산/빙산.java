import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static Queue<Point> q =new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        visited=new boolean[n][m];
        
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        bfs();

    }

    static int[][] copy(){
        int[][] copymap=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copymap[i][j]=map[i][j];
            }
        }
        return copymap;
    }

    static void copyReverse(int[][] copymap){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j]=copymap[i][j];
            }
        }
    }

    static void bfs(){
        int year=0;

        while(true){


            int[][] copyMap=copy();
            visited=new boolean[n][m];
            int iceberg=0;
            boolean check=false;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){

                    if(map[i][j]>0){
                        check=true;
                        for(int dir=0; dir<4; dir++){
                            int x=i+dx[dir];
                            int y=j+dy[dir];

                            if(x<0 || x>=n || y<0 || y>=m) continue;

                            if(map[x][y]==0 && copyMap[i][j]>0) copyMap[i][j]--;
                        }
                    }

                }
            }
            copyReverse(copyMap);
            year++;


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j] && copyMap[i][j]>0){
                        q.add(new Point(i,j));
                        iceberg++;

                        while(!q.isEmpty()){
                            Point cur=q.remove();

                            for(int dir=0; dir<4; dir++){
                                int x=cur.x+dx[dir];
                                int y=cur.y+dy[dir];

                                if(x<0 || x>=n || y<0 || y>=m) continue;

                                if(copyMap[x][y]==0 || visited[x][y]) continue;

                                q.add(new Point(x,y));
                                visited[x][y]=true;
                            }
                        }
                    }
                }
            }



            if(iceberg>=2){
                System.out.println(year);
                return;
            }

            if(!check){
                System.out.println(0);
                return;
            }

        }

    }

}