import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());


        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> order=new ArrayList<>();
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            int val=Integer.parseInt(st.nextToken());

            hm.put(val, hm.getOrDefault(val, 0)+1);

            if(!order.contains(val)){
                order.add(val);
            }
        }

        ArrayList<Integer> key=new ArrayList<>(hm.keySet());


        key.sort((o1,o2) ->{
            if(hm.get(o1)==hm.get(o2)){
                return order.indexOf(o1)-order.indexOf(o2);
            }
            return hm.get(o2)-hm.get(o1);
        });



        Iterator<Integer> it=key.iterator();


        while(it.hasNext()){
            Integer num=it.next();
            int count=hm.get(num);

            for(int i=0; i<count; i++){
                System.out.print(num+" ");
            }
        }


    }
}