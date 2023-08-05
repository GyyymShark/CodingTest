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
    static Queue<Point> q=new LinkedList<>();

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,count=0;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Integer> array=new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        board=new int[n][n];
        visited=new boolean[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0; j<n; j++){
               board[i][j]=str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(count);
        Collections.sort(array);
        for(int a : array){
            System.out.println(a);
        }

    }

    static void bfs(){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1 && !visited[i][j]){
                    int num=0;
                    q.add(new Point(i,j));
                    count++;

                    while(!q.isEmpty()){
                        Point cur=q.remove();
                        visited[cur.x][cur.y]=true;
                        num++;

                        for(int dir=0; dir<4; dir++){
                            int x=cur.x+dx[dir];
                            int y=cur.y+dy[dir];

                            if(x<0 || x>=n || y<0 || y>=n) continue;

                            if(visited[x][y] || board[x][y]==0) continue;

                            q.add(new Point(x,y));
                            visited[x][y]=true;
                        }
                    }
                    array.add(num);
                }
            }
        }

    }
}