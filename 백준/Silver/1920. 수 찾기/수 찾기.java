import java.util.*;
import java.io.*;

class Main{
    public static final int MAX=100001;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        HashSet<Integer> h=new HashSet<>();
        

        for(int i=0; i<n; i++){
            int value=Integer.parseInt(st.nextToken());
            h.add(value);
        }

        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int value=Integer.parseInt(st.nextToken());
            if(h.contains(value)) System.out.println(1);
            else System.out.println(0);
        }

    }
}