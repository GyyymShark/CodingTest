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
    static int r,c,d;       // d는 0 북쪽 1 동쪽 2 남쪽 3 서쪽
    static int[][] map;
    static Queue<Point> q =new LinkedList<>();

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int count=0;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];

        st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                int value=Integer.parseInt(st.nextToken());
                if(value==1) value=-1;
                map[i][j]=value;
            }
        }



        simulation();




    }


    static void simulation(){
        q.add(new Point(r,c));
        map[r][c]=1;


        while(!q.isEmpty()){
            Point cur=q.remove();

            if(map[cur.x][cur.y]==0) map[cur.x][cur.y]=1;
            boolean emptyCheck=false;
            for(int dir=0; dir<4; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];


                if(x<0 || x>=n || y<0 || y>=m) continue;

                if(map[x][y]==-1 || map[x][y]==1) continue;     //벽이거나 청소된거는 패스
                emptyCheck=true;
                break;
            }



            if(!emptyCheck){    //주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 (d=북동남서)
                if(d==0){   //북
                    int x=cur.x+1;
                    int y=cur.y;

                    if(x<0 || x>=n) break;

                    if(map[x][y]!=-1) q.add(new Point(x,y));
                }

                else if(d==1){  //동
                    int x=cur.x;
                    int y=cur.y-1;

                    if(y<0 || y>=m) break;

                    if(map[x][y]!=-1) q.add(new Point(x,y));
                }
                else if(d==2){  //남
                    int x=cur.x-1;
                    int y=cur.y;

                    if(x<0 || x>=n) break;

                    if(map[x][y]!=-1) q.add(new Point(x,y));
                }
                else if(d==3){  //서
                    int x=cur.x;
                    int y=cur.y+1;

                    if(y<0 || y>=m) break;

                    if(map[x][y]!=-1) q.add(new Point(x,y));
                }

            }


            else{   //현재 주변 4칸 중 청소되지 않은 빈칸이 있는 경우

                d--;    //반시계방향 90도 회전
                if(d==-1) d=3;

                if(d==0){
                    int x=cur.x-1;
                    int y=cur.y;

                    if(map[x][y]==0) q.add(new Point(x,y));
                    else q.add(new Point(cur.x, cur.y));
                }
                else if(d==1){
                    int x=cur.x;
                    int y=cur.y+1;

                    if(map[x][y]==0) q.add(new Point(x,y));
                    else q.add(new Point(cur.x, cur.y));
                }
                else if(d==2){
                    int x=cur.x+1;
                    int y=cur.y;

                    if(map[x][y]==0) q.add(new Point(x,y));
                    else q.add(new Point(cur.x, cur.y));
                }
                else if(d==3){
                    int x=cur.x;
                    int y=cur.y-1;

                    if(map[x][y]==0) q.add(new Point(x,y));
                    else q.add(new Point(cur.x, cur.y));
                }


            }

        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1) count++;
            }
        }

        System.out.println(count);



    }

}