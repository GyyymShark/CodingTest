import java.util.*;
import java.io.*;
public class Main {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static Queue<Point> fq=new LinkedList<>();
    static Queue<Point> jq=new LinkedList<>();
    static int r,c;
    static int[][] map;
    static int[][] fire;
    static int[][] jihun;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        map=new int[r][c];
        fire=new int[r][c];
        jihun=new int[r][c];


        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0; j<c; j++){
                fire[i][j]=-1;
                jihun[i][j]=-1;

                if(str.charAt(j)=='#'){
                    map[i][j]=-1;
                }
                else if(str.charAt(j)=='J'){
                    jihun[i][j]=0;
                    jq.add(new Point(i,j));
                }
                else if(str.charAt(j)=='F'){
                    fire[i][j]=0;
                    fq.add(new Point(i,j));
                }
            }
        }

        fireBfs();
        jihunBfs();



    }

    static void fireBfs(){

        while(!fq.isEmpty()){
          Point cur=fq.remove();

          for(int dir=0; dir<4; dir++){
              int x=cur.x+dx[dir];
              int y=cur.y+dy[dir];

              if(x<0 || x>=r || y<0 || y>=c) continue;

              if(map[x][y]==-1 || fire[x][y]>=0) continue;

              fq.add(new Point(x,y));
              fire[x][y]=fire[cur.x][cur.y]+1;

          }
        }

    }

    static void jihunBfs(){

        while(!jq.isEmpty()){
            Point cur=jq.remove();

            for(int dir=0; dir<4; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];

                if(x<0 || x>=r || y<0 || y>=c) {
                    System.out.println(jihun[cur.x][cur.y]+1);
                    return;
                }

                if(map[x][y]==-1 || jihun[x][y]>=0) continue;

                if(fire[x][y]==-1){
                    jq.add(new Point(x,y));
                    jihun[x][y]=jihun[cur.x][cur.y]+1;
                }
                else{
                    if(fire[x][y]>jihun[cur.x][cur.y]+1){
                        jq.add(new Point(x,y));
                        jihun[x][y]=jihun[cur.x][cur.y]+1;
                    }
                }



            }
        }

        System.out.println("IMPOSSIBLE");

    }



    static void print(){
        System.out.println("map");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("fire");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(fire[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("jihun");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(jihun[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
