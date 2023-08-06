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
    static int n;
    static int[][] map1;
    static int[][] map2;
    static int count=Integer.MIN_VALUE;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};


    static HashSet<Integer> set=new HashSet<>();
    static Queue<Point> q=new LinkedList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());

        map1=new int[n][n];
        map2=new int[n][n];



        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map1[i][j]=Integer.parseInt(st.nextToken());
                set.add(map1[i][j]);
            }
        }

        bfs();

    }

    static void bfs(){
        int end=0;
        while(end<=100){
            int area=0;
            int height=end;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map2[i][j]=0;
                    if(map1[i][j]<=height)
                        map2[i][j]=1;
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map2[i][j]==0){
                        area++;
                        q.add(new Point(i,j));
                        map2[i][j]=1;

                        while(!q.isEmpty()){
                            Point cur=q.remove();
                            for(int dir=0; dir<4; dir++){
                                int x=cur.x+dx[dir];
                                int y=cur.y+dy[dir];

                                if(x<0 || x>=n || y<0 || y>=n) continue;

                                if(map2[x][y]==1) continue;

                                q.add(new Point(x,y));
                                map2[x][y]=1;
                            }
                        }
                    }
                }
            }

            count=Math.max(count,area);
            end++;

        }

        System.out.println(count);
    }
}