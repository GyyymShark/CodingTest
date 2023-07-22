import java.util.*;
import java.io.*;

class Main{





    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long max=0L;
        int maxCount=0;
        int n=Integer.parseInt(st.nextToken());
        HashMap<Long, Integer> card=new HashMap<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            long num=Long.parseLong(st.nextToken());

            if(card.containsKey(num)){
                int cardCount=card.get(num);
                cardCount++;

                if(maxCount==cardCount){
                    if(max>num)
                        max=num;
                }
                else if(maxCount<cardCount){
                    max=num;
                    maxCount=cardCount;
                }

                card.replace(num,cardCount);

            }
            else{
                if(maxCount==1){
                    if(max>num)
                        max=num;
                }
                else if(maxCount==0){
                    max=num;
                    maxCount=1;
                }
                card.put(num,1);
            }


        }

        System.out.println(max);

    }
}