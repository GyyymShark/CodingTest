import java.util.*;

public class Main {
    public static void main(String[] args){
        Integer[] arr=new Integer[3];
        Scanner sc=new Scanner(System.in);

        for(int i=0; i<3; i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr,Collections.reverseOrder());

        if(arr[0]==arr[1] && arr[1]==arr[2]){
            System.out.println(10000+arr[0]*1000);
        }
        else if(arr[0]==arr[1]){
            System.out.println(1000+arr[0]*100);
        }
        else if(arr[1]==arr[2]){
            System.out.println(1000+arr[1]*100);
        }
        else{
            System.out.println(arr[0]*100);
        }




    }
}