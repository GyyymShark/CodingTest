import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        long a,b;
        Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        //  a=Integer.parseInt(br.readLine());
        //b=Integer.parseInt(br.readLine());

        a=sc.nextLong();
        b=sc.nextLong();
        // sc.nextLine();
        bw.flush();

        if(a>b){
            System.out.println(a-b-1);
            //bw.write(a-b-1);
            for(long i=b+1; i<a; i++)
                //bw.write(i+" ");
                System.out.print(i+" ");
        }
        else if(a<b){
            System.out.println(b-a-1);
            //bw.write(b-a-1);
            for(long j=a+1; j<b; j++) {
                System.out.print(j + " ");
                //bw.write(j+" ");
            }
        }
        else{
            System.out.println(0);
            //bw.write(0);
        }
        //bw.flush();
        //bw.close();

    }
}
