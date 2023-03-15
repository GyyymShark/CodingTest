import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        System.out.println(T);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            boolean check=false;
            int test_case_copy=test_case;
            //System.out.println(test_case);
            while(test_case_copy!=0){
                int remain=test_case_copy%10;
                if(remain== 3 || remain== 6 || remain==9){
                    check=true;
                    System.out.print("-");
                }
                test_case_copy/=10;
            }
            if(!check){
                System.out.print(test_case);
            }
            System.out.print(" ");
        }
    }
}