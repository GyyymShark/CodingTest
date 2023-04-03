
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int k=Integer.parseInt(br.readLine());
        int sum=0;

        Stack<Integer> stack=new Stack<>();

        for(int i=0; i<k; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());

            if(num==0){
                stack.pop();
            }
            else{
                stack.push(num);
            }
        }

        while(!stack.isEmpty()){
            int n=stack.peek();
            sum+=n;
            stack.pop();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
