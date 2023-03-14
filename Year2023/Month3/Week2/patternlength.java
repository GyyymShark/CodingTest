import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String str;
        str=sc.nextLine();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean check=false;
            int result=0;

            str=sc.nextLine();
            for(int j=1; j<str.length(); j++){
                if(str.charAt(j)==str.charAt(0)){
                    for(int k=0; k<j; k++){
                        if(str.charAt(k)==str.charAt(k+j)){
                            result=j;
                            check=true;
                        }
                        else{
                            check=false;
                            break;
                        }
                    }
                }
                if(check){
                    System.out.println("#"+test_case+" "+result);
                    break;
                }
            }



        }
    }
}