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
    static int n,area=0;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> q =new LinkedList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        map=new char[n][n];
        visited=new boolean[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0; j<n; j++){
                map[i][j]=str.charAt(j);
            }
        }
        normal();
        System.out.print(area+" ");
        weakness();
        System.out.println(area);
    }

    static void normal(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(map[i][j]=='R' && !visited[i][j]){
                    area++;
                    q.add(new Point(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point cur=q.remove();

                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(visited[nx][ny] || map[nx][ny]=='B' || map[nx][ny]=='G') continue;

                            q.add(new Point(nx,ny));
                            visited[nx][ny]=true;
                        }

                    }
                }

                else if(map[i][j]=='B' && !visited[i][j]){
                    area++;
                    q.add(new Point(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point cur=q.remove();

                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(visited[nx][ny] || map[nx][ny]=='R' || map[nx][ny]=='G') continue;

                            q.add(new Point(nx,ny));
                            visited[nx][ny]=true;
                        }

                    }
                }


                if(map[i][j]=='G' && !visited[i][j]){
                    area++;
                    q.add(new Point(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point cur=q.remove();

                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(visited[nx][ny] || map[nx][ny]=='B' || map[nx][ny]=='R') continue;

                            q.add(new Point(nx,ny));
                            visited[nx][ny]=true;
                        }

                    }
                }

            }
        }
    }
    static void weakness(){
        area=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j]=false;
                if(map[i][j]=='G')
                    map[i][j]='R';
            }
        }



        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(map[i][j]=='R' && !visited[i][j]){
                    area++;
                    q.add(new Point(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point cur=q.remove();

                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(visited[nx][ny] || map[nx][ny]=='B' || map[nx][ny]=='G') continue;

                            q.add(new Point(nx,ny));
                            visited[nx][ny]=true;
                        }

                    }
                }

                else if(map[i][j]=='B' && !visited[i][j]){
                    area++;
                    q.add(new Point(i,j));
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        Point cur=q.remove();

                        for(int dir=0; dir<4; dir++){
                            int nx=cur.x+dx[dir];
                            int ny=cur.y+dy[dir];

                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            if(visited[nx][ny] || map[nx][ny]=='R' || map[nx][ny]=='G') continue;

                            q.add(new Point(nx,ny));
                            visited[nx][ny]=true;
                        }

                    }
                }

            }
        }





    }

}