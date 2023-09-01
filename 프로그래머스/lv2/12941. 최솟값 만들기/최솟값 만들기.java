import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        //가장 큰 수 * 가장 작은 수
        Arrays.sort(A);
        Integer[] b=Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(b,Comparator.reverseOrder());
        int result=0;
        for(int i=0; i<A.length; i++){
            result+=A[i]*b[i];
        }
       
        return result;
    }
}