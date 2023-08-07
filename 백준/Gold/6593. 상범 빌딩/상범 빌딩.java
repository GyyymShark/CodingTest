import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int l;
        int r;
        int c;
        Point(int l, int r, int c){
            this.l=l;
            this.r=r;
            this.c=c;
        }
    }
    static int l,r,c;

    static int[][][] map;

    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dz={0,0,0,0,1,-1};
    static Queue<Point> q=new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        while(true){
            q.clear();
            StringTokenizer st=new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens())
                st=new StringTokenizer(br.readLine());
            l=Integer.parseInt(st.nextToken());
            r=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            if(l==0 && r==0 && c==0) break;

            map=new int[l][r][c];

            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    String str=br.readLine();
                    if(str.equals(""))
                        str=br.readLine();

                    for(int k=0; k<c; k++){
                        map[i][j][k]=0;

                        if(str.charAt(k)=='S'){
                            map[i][j][k]=1;
                            q.add(new Point(i,j,k));
                        }
                        else if(str.charAt(k)=='#')
                            map[i][j][k]=-1;
                        else if(str.charAt(k)=='E')
                            map[i][j][k]=-2;

                    }
                }
            }

            bfs();

        }


    }

    static void bfs(){

        while(!q.isEmpty()){
            Point cur=q.remove();

            for(int dir=0; dir<6; dir++){
                int x=cur.r+dx[dir];
                int y=cur.c+dy[dir];
                int z=cur.l+dz[dir];


                if(x<0 || x>=r || y<0 || y>=c || z<0 || z>=l) continue;

                if(map[z][x][y]==-2){
                    System.out.println("Escaped in "+map[cur.l][cur.r][cur.c]+" minute(s).");
                    return;
                }
                if(map[z][x][y]==-1 || map[z][x][y]>0) continue;
                map[z][x][y]=map[cur.l][cur.r][cur.c]+1;
                q.add(new Point(z,x,y));
            }
        }

        System.out.println("Trapped!");


    }

    static void print(){

        for(int i=0; i<l; i++){
            for(int j=0; j<r; j++){
                for(int k=0; k<c; k++){
                    System.out.print(map[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();

    }
}