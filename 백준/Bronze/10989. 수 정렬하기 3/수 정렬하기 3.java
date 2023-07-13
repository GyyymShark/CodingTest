import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];
        ArrayList<Integer> arrList=new ArrayList<>();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=(Integer.parseInt(st.nextToken()));
        }
        //Collections.sort(arrList);
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
