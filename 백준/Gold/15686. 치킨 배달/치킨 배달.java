import java.util.*;
import java.io.*;

class Main{
    static int n,m,min=Integer.MAX_VALUE;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static ArrayList<Point> houseList=new ArrayList<>();
    static ArrayList<Point> chickenList=new ArrayList<>();
    static ArrayList<Point> choiceList=new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int value=Integer.parseInt(st.nextToken());
                if(value==2)
                    chickenList.add(new Point(i,j));
                if(value==1)
                    houseList.add(new Point(i,j));
            }
        }
        visited=new boolean[chickenList.size()];

        func(0,0);
        System.out.println(min);

    }


    static void func(int depth, int start){
        if(depth==m){
            int val=getDistance();
            min=Math.min(val,min);
            return;
        }

        for(int i=start; i<chickenList.size(); i++){
            if(!visited[i]){
                visited[i]=true;
                choiceList.add(new Point(chickenList.get(i).x, chickenList.get(i).y));
                func(depth+1, i+1);
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
                int distance=Math.abs(chicken.x-house.x)+Math.abs(chicken.y-house.y);
                min=Math.min(distance,min);
            }
            sum+=min;
        }
        return sum;

    }
}