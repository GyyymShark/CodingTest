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
    static int m,n;
    static int[][] fire;
    static int[][] sang;
    static int[][] map;
    static Queue<Point> fq=new LinkedList<>();
    static Queue<Point> sq=new LinkedList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());



        for(int k=0; k<t; k++){

            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            fire=new int[m][n];
            sang=new int[m][n];
            map=new int[m][n];      //wall=-1, empty=0, fire=1, sang=2
            fq.clear();
            sq.clear();

            for(int i=0; i<m; i++){
                st=new StringTokenizer(br.readLine());
                String str=st.nextToken();
                for(int j=0; j<n; j++){
                    fire[i][j]=-1;
                    sang[i][j]=-1;
                    map[i][j]=-1;
                    if(str.charAt(j)=='*'){
                        fq.add(new Point(i,j));
                        fire[i][j]=0;
                        map[i][j]=1;
                    }
                    else if(str.charAt(j)=='.'){
                        map[i][j]=0;
                    }
                    else if(str.charAt(j)=='@'){
                        sq.add(new Point(i,j));
                        sang[i][j]=0;
                        map[i][j]=2;
                    }
                }
            }
            firebfs();
            sangbfs();

        }



    }


    static void firebfs(){

        while(!fq.isEmpty()){
            Point cur=fq.remove();

            for(int dir=0; dir<4; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];

                if(x<0 || x>=m || y<0 || y>=n) continue;

                if(map[x][y]==-1 || fire[x][y]>=0) continue;

                fq.add(new Point(x,y));
                fire[x][y]=fire[cur.x][cur.y]+1;
            }

        }

    }

    static void sangbfs(){

        while(!sq.isEmpty()){
            Point cur=sq.remove();

            for(int dir=0; dir<4; dir++){
                int x=cur.x+dx[dir];
                int y=cur.y+dy[dir];

                if(x<0 || x>=m || y<0 || y>=n) {
                    System.out.println(sang[cur.x][cur.y]+1);
                    return;
                }

                if(sang[x][y]>=0 || map[x][y]==-1) continue;

                //통과 조건: 불방문 but 더 작음 or 불 =-1
                //불통 조건: 불방문 and 더 큼

                if(fire[x][y]!=-1 && fire[x][y]<=sang[cur.x][cur.y]+1) continue;

                sq.add(new Point(x,y));
                sang[x][y]=sang[cur.x][cur.y]+1;
            }
        }
        System.out.println("IMPOSSIBLE");

    }

    static void print(){
        System.out.println("----------------map--------------------");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("----------------fire--------------------");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(fire[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("----------------sang--------------------");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(sang[i][j]);
            }
            System.out.println();
        }
        System.out.println();


    }
}