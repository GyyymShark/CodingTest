import java.util.*;
import java.io.*;

class Main{
    static int n,w,l;
    static int time=0, sum=0;
    static Queue<Integer> trucks=new LinkedList<>();
    static Queue<Integer> bridge=new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trucks.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<w; i++){
            bridge.add(0);
        }



        simulation();


    }

    static void simulation(){
        while(!bridge.isEmpty()){
            sum-=bridge.remove();


            if(!trucks.isEmpty()) {
                if (sum + trucks.peek() <= l) {
                    int truck = trucks.remove();
                    bridge.add(truck);
                    sum += truck;
                } else {
                    bridge.add(0);
                }
            }



            time++;

        }

        System.out.println(time);
    }
}