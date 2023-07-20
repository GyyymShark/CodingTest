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

        @Override
        public String toString(){
            return x+" "+y;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        Point[] pointList=new Point[n];

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            pointList[i]=new Point(x,y);
        }

        Comparator<Point> comparator= new Comparator<Point>() {
            @Override
            public int compare(Point s1, Point s2){
                if(s1.y==s2.y){
                    return s1.x-s2.x;
                }
                return s1.y-s2.y;
            }
        };


        Arrays.sort(pointList, comparator);

        for(Point p : pointList){
            System.out.println(p);
        }

    }
}