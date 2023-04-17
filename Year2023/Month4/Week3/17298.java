
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){

            while(!s.isEmpty()){
                if(arr[i]<=arr[s.peek()]){
                    s.push(i);
                    break;
                }
                else if(arr[i]>arr[s.peek()]){
                    arr[s.peek()]=arr[i];
                    s.pop();
                }
            }

            if(s.isEmpty()){
                s.push(i);
            }
        }

        while(!s.isEmpty()){
            arr[s.peek()]=-1;
            s.pop();
        }

        for(int i=0; i<n; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}