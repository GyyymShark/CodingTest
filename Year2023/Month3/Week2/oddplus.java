import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int answer[]=new int[T];

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int arr[]=new int[10];
            for(int j=0; j<10; j++){
                arr[j]=sc.nextInt();
            }

            for(int k=0; k<10; k++){
                if(arr[k]%2!=0){
                    answer[test_case-1]+=arr[k];
                }
            }

        }
        for(int i=1; i<=T; i++){
            System.out.println("#"+i+" "+answer[i-1]);
        }
    }
}