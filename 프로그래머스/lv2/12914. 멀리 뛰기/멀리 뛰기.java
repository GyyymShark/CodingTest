class Solution {
    public long solution(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        
        long answer = 0;
        long[] d=new long[n+1];
        d[1]=1;
        d[2]=2;
        
      
        
        for(int i=3; i<=n; i++){
            d[i]=(d[i-1]+d[i-2])%1234567;
        }
        
        answer=d[n];
        
        return answer;
    }
}