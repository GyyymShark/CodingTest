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
    static int r,c;

    static int[][] board;
    static int[][] fmap;
    static int[][] jmap;
    static Queue<Point> fq=new LinkedList<>();
    static Queue<Point> jq=new LinkedList<>();

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        board=new int[r][c];
        fmap=new int[r][c];
        jmap=new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                fmap[i][j]=-1;
                jmap[i][j]=-1;
            }
        }

        for(int i=0; i<r; i++){
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0; j<c; j++){
                if(str.charAt(j)=='#'){
                    board[i][j]=-1;
                }
                else if(str.charAt(j)=='J'){
                    jmap[i][j]=0;
                    jq.add(new Point(i,j));
                }
                else if(str.charAt(j)=='F'){
                    fmap[i][j]=0;
                    fq.add(new Point(i,j));
                }
            }
        }




        bfs();

    }


    static void bfs(){
        while(!fq.isEmpty()){
            Point fire=fq.remove();

            for(int dir=0; dir<4; dir++){
                int nx=fire.x+dx[dir];
                int ny=fire.y+dy[dir];

                if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                if(fmap[nx][ny]>=0 || board[nx][ny]==-1) continue;
                fmap[nx][ny]=fmap[fire.x][fire.y]+1;
                fq.add(new Point(nx,ny));
            }
        }


        while(!jq.isEmpty()){
            Point jihun=jq.remove();

            for(int dir=0; dir<4; dir++){
                int nx=jihun.x+dx[dir];
                int ny=jihun.y+dy[dir];

                if(nx<0 || nx>=r || ny<0 || ny>=c){
                    System.out.println(jmap[jihun.x][jihun.y]+1);
                    return;
                }

                if(jmap[nx][ny]>=0 || board[nx][ny]==-1) continue;
                if(fmap[nx][ny]!=-1 && jmap[jihun.x][jihun.y]+1>=fmap[nx][ny]) continue;
                jmap[nx][ny]=jmap[jihun.x][jihun.y]+1;
                jq.add(new Point(nx,ny));

            }
        }
        System.out.println("IMPOSSIBLE");



    }
}