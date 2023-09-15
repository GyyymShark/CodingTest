import java.util.*;
import java.io.*;

class Main{
    static int n,m,max=0;
    static int[][] map;


    static int[] ter1x={0,0,0,0};
    static int[] ter1y={0,1,2,3};

    static int[] ter2x={0,0,1,1};
    static int[] ter2y={0,1,0,1};

    static int[] ter3x={0,1,2,2};
    static int[] ter3y={0,0,0,1};

    static int[] ter4x={0,1,1,2};
    static int[] ter4y={0,0,1,1};
    static int[] ter5x={0,0,0,1};
    static int[] ter5y={0,1,2,1};


    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }





        simulation(ter1x,ter1y);
        simulation(ter2x,ter2y);
        simulation(ter3x,ter3y);
        simulation(ter4x,ter4y);
        simulation(ter5x,ter5y);

        System.out.println(max);

    }

    static void simulation(int[] terX, int[] terY){


        for(int i=0; i<4; i++){
            bfs(terX, terY);  //search

            int[] tempX=new int[4];
            int[] tempY=new int[4];

            for(int j=0; j<4; j++){         //rotate
                tempX[j]=terY[j];
                tempY[j]=terX[j]*(-1);
            }
            for(int j=0; j<4; j++){
                terX[j]=tempX[j];
                terY[j]=tempY[j];
            }
        }


        for(int i=0; i<4; i++){  //대칭
            terY[i]*=-1;
        }

        for(int i=0; i<4; i++){

            bfs(terX, terY);  //search

            int[] tempX=new int[4];
            int[] tempY=new int[4];

            for(int j=0; j<4; j++){         //rotate
                tempX[j]=terY[j];
                tempY[j]=terX[j]*(-1);
            }
            for(int j=0; j<4; j++){
                terX[j]=tempX[j];
                terY[j]=tempY[j];
            }
        }


        //그대로 search
        // 회전 search(4방향)
        // 대칭 -> 회전 search(4방향)

    }


    static void bfs(int[] terX, int[] terY){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count=0;
                boolean possible=true;
                for(int dir=0; dir<4; dir++){

                    int x=i+terX[dir];
                    int y=j+terY[dir];


                    if(x<0 || x>=n || y<0 || y>=m){
                        possible=false;
                        break;
                    }
                    count+=map[x][y];
                }

                if(possible) max=Math.max(count,max);

            }
        }
    }
}