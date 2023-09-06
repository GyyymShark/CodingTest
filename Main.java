import java.util.*;
import java.io.*;

class Main{

    static int n=5;
    static boolean[] visited=new boolean[n+1];
    static int[] dir=new int[n+1];  //dir{0=그대로 1=시계방향 회전x1 2=시계방향 회전x2 3=시계방향 회전x3}
    static int[][][] map;
    static int[][][] copyMap;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map=new int[n+1][n+1][n+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++){
                    int value=Integer.parseInt(st.nextToken());
                    if(value==1) value=-1;
                    map[i][j][k]=value;
                }
            }
        }



        simulation();

    }

    static void simulation(){
        rotateSearch(0);
    }

    static void rotateSearch(int cur){

        if(cur==n){
            copyMap=new int[n][n][n];
            for(int i=0; i<n; i++){
                rotate(i,dir[i]);
            }
            stack();
            return;

        }


        for(int i=0; i<n-1; i++){
            dir[cur]=i;
            visited[cur]=true;
            rotateSearch(cur+1);
            visited[cur]=false;
        }

    }

    static void rotate(int idx, int direction){

        int[][] copy=new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    copy[j][k]=map[i][j][k];
                }
            }
        }


        for(int i=0; i<direction; i++){

            int[][] temp=new int[n][n];

            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    temp[k][n-1-j]=copy[j][k];
                }
            }

            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    copy[j][k]=temp[j][k];
                }
            }

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copyMap[idx][i][j]=copy[i][j];
            }
        }





    }
    static void stack(){


        bfs();
    }
    static void bfs(){

    }



    static void print(){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    System.out.print(map[i][j][k]+" ");
                }
                System.out.println();
            }
        }

    }



}