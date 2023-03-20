import java.util.*;

public class Main {
    public static void main(String[] args){
        Integer[] arr=new Integer[4];
        Scanner sc=new Scanner(System.in);

        for(int t=0; t<3; t++){
            int cnt=0;

            for(int i=0; i<4; i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0; i<4; i++) {
                if(arr[i]==1)
                    cnt++;
            }
            switch(cnt){
                case 4:{
                    System.out.println("E");
                    break;
                }
                case 3:{
                    System.out.println("A");
                    break;
                }
                case 2:{
                    System.out.println("B");
                    break;
                }
                case 1:{
                    System.out.println("C");
                    break;
                }
                case 0:{
                    System.out.println("D");
                    break;
                }
            }

            //도 0-1개 1-3개
            //개 0-2개 1-2개
            //걸 0-3개 1-1개
            //윷 0-4개 1-0개
            //모 0-0개 1-4개
        }

    }

}