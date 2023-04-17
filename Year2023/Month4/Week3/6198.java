
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s =new Stack<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long sum=0;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int height=Integer.parseInt(st.nextToken());

            while(!s.isEmpty()){
                if(s.peek()>height){
                    sum+=s.size();
                    s.push(height);
                    break;
                }
                else{
                    s.pop();
                }
            }

            if(s.empty()){
                s.push(height);
            }

        }

        System.out.println(sum);
    }
}