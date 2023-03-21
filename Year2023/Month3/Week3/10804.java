
import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};


        for(int i=0; i<10; i++){
            int start,end;
            start=sc.nextInt();
            end=sc.nextInt();

            start-=1; //4
            end-=1;  //9
            int tempEnd=end;
            for(int j=start; j<=(start+end)/2; j++){
                int gap=tempEnd-j;
                int temp=arr[j];
                arr[j]=arr[j+gap];
                arr[j+gap]=temp;
                tempEnd--;
            }


        }

        for(int k=0; k<20; k++){
            System.out.print(arr[k]+" ");
        }

    }
}
