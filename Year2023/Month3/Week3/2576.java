import java.util.*;

public class Main {
    public static void main(String[] args){
        Integer[] arr=new Integer[7];
        Scanner sc=new Scanner(System.in);
        int min=101;
        int sum=0;

        for(int i=0; i<7; i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0; i<7; i++){
            if(arr[i]%2!=0){
                sum+=arr[i];
                if(min>arr[i]) {
                    min = arr[i];
                }
            }
        }

        if(min==101)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }



    }
}
