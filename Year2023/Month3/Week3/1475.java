import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] num=new int[10];
        int max=0;

        int n=sc.nextInt();

        while(n!=0){
            num[n%10]++;
            n/=10;
        }
        if((num[6]+num[9])%2!=0){   //홀수일때
            max=(num[6]+num[9])/2+1;
            num[6]=max;
            num[9]=max;
        }
        else{
            max=(num[6]+num[9])/2;
            num[6]=max;
            num[9]=max;
        }

        for(int i=0; i<=9; i++){
            if(max<num[i])
                max=num[i];
        }
        System.out.println(max);

    }
}
