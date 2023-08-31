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
    static int n=12, m=6,count=0;
    static int[][] map=new int[n][m];
    static boolean[][] visited=new boolean[n][m];
    static Queue<Point> q=new LinkedList<>();
    static Queue<Point> ex=new LinkedList<>();
    static boolean isPop=false;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        HashMap<String, Integer> colorMapping=new HashMap<>();
        colorMapping.put("R",1);
        colorMapping.put("G",2);
        colorMapping.put("B",3);
        colorMapping.put("P",4);
        colorMapping.put("Y",5);


        for(int i=0; i<n; i++){
            String str=br.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j)=='.') map[i][j]=0;
                else if(str.charAt(j)=='R') map[i][j]=colorMapping.get("R");
                else if(str.charAt(j)=='G') map[i][j]=colorMapping.get("G");
                else if(str.charAt(j)=='B') map[i][j]=colorMapping.get("B");
                else if(str.charAt(j)=='P') map[i][j]=colorMapping.get("P");
                else if(str.charAt(j)=='Y') map[i][j]=colorMapping.get("Y");
            }
        }
        simulation();


    }

    static void simulation(){
        while(true) {
            isPop=false;
            fallDown();
            explosion();

            if(isPop==false) break;

            count++;

        }
        System.out.println(count);
    }

    static void fallDown(){

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++){
                int first=i;
                int last=i;
                if(map[i][j]==0){

                    for(int k=i; k>=0; k--){    //처음 0이아닌 인덱스 찾기
                        if(map[k][j]!=0){
                            first=k;
                            break;
                        }
                    }

                    for(int k=i; k>=0; k--){    //마지막 0이아닌 인덱스 찾기
                        if(map[k][j]!=0){
                            last=k;
                        }
                    }

                    for(int k=first; k>=last; k--){    //내려주기
                        map[i+k-first][j]=map[k][j];
                        map[k][j]=0;
                    }

                }
            }
        }

    }
    static void explosion(){

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        visited=new boolean[n][m];


        for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++){

                if(!visited[i][j] && map[i][j]!=0){
                    q.add(new Point(i,j));
                    ex.add(new Point(i,j));
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        Point cur = q.remove();
                        int value=map[cur.x][cur.y];
                        for(int dir=0; dir<4; dir++){
                            int x=cur.x+dx[dir];
                            int y=cur.y+dy[dir];

                            if(x<0 || x>=n || y<0 || y>=m) continue;

                            if(map[x][y]!=value || visited[x][y]) continue;

                            q.add(new Point(x,y));
                            visited[x][y]=true;
                            ex.add(new Point(x,y));

                        }

                    }

                    if(ex.size()>=4){
                        while(!ex.isEmpty()){
                            Point remove = ex.remove();
                            map[remove.x][remove.y]=0;
                        }
                      isPop=true;

                    }

                    else{
                        ex.clear();
                    }


                }

            }
        }

    }

    static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}