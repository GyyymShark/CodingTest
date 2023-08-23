import java.util.*;
import java.io.*;

class Main{
    static final int MAX=20001;
    static Integer[] a; static Integer[] b;
    static int alength,blength;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            alength=Integer.parseInt(st.nextToken());
            blength=Integer.parseInt(st.nextToken());

            a=new Integer[alength]; b=new Integer[blength];
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<alength; j++){
                a[j]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<blength; j++){
                b[j]=Integer.parseInt(st.nextToken());
            }
            print();
        }
    }


    static void print(){
        Arrays.sort(a,Collections.reverseOrder());
        Arrays.sort(b,Collections.reverseOrder());
        int count=0;

        for(int i=0; i<alength; i++){
            for(int j=0; j<blength; j++){
                if(a[i]>b[j]){
                    count+=blength-j;
                    break;
                }
            }
        }
        System.out.println(count);


    }
}