class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        //번호 0~n-1
        
        //0 1 -> 0
        //2 3 -> 1
        //4 5 -> 2
        //6 7 -> 3
    
        a--; b--;
        
        while((a/2)!= (b/2)){
            a/=2;
            b/=2;
            answer++;
        }
        
        
        
       
        
        return answer;
    }
}