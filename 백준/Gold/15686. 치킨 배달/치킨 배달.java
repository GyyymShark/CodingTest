import java.util.*;
import java.io.*;

class Main{
    static int n,m,min=9999;
    static int[][] map1;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static ArrayList<Point> chickenList=new ArrayList<>();
    static ArrayList<Point> houseList=new ArrayList<>();
    static ArrayList<Point> choiceList=new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map1=new int[n][n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map1[i][j]=Integer.parseInt(st.nextToken());
                if(map1[i][j]==1)
                    houseList.add(new Point(i,j));
                if(map1[i][j]==2)
                    chickenList.add(new Point(i,j));
            }
        }
        visited=new boolean[chickenList.size()];

        func(0,0);
        System.out.println(min);

    }
    static void func(int depth, int start){
        if(depth==m){
            int value=getDistance();
            min=Math.min(min,value);
            return;
        }

        for(int i=start; i<chickenList.size(); i++){
            if(!visited[i]){
                visited[i]=true;
                choiceList.add(new Point(chickenList.get(i).x, chickenList.get(i).y));
                func(depth+1,i+1);
                choiceList.remove(choiceList.size()-1);
                visited[i]=false;
            }

        }


    }


    static int getDistance(){
        int sum=0;
        for(Point house : houseList){
            int min=Integer.MAX_VALUE;
            for(Point chicken : choiceList){
                int value=Math.abs(chicken.x-house.x)+Math.abs(chicken.y-house.y);
                if(value<min)
                    min=value;
            }
            sum+=min;
        }

        return sum;

    }

}