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
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            str=sc.nextLine();
            int xCount=0;
            for(int i=0; i<str.length(); i++){
                if(str.length()<=7){
                    System.out.println("#"+test_case+" YES");
                    break;
                }
                else{
                    if(str.charAt(i)=='x'){
                        xCount++;
                    }
                }
            }
            if(xCount>0){
                if(xCount>=8){
                    System.out.println("#"+test_case+" NO");
                }
                else{
                    System.out.println("#"+test_case+" YES");
                }
            }

        }
    }
}