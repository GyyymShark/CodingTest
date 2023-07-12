import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        for(int i=0; i<n; i++){
            sb.append(arr.get(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}