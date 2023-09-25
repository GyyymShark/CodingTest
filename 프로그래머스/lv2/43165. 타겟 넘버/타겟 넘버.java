class Solution {
    static int[] sign=new int[20];
    static int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers.length,numbers,target);
        return answer;
    }
    
    static void dfs(int cur, int depth, int[] numbers, int target){
        
        if(cur==depth){
            int count=0;
            for(int i=0; i<depth; i++){
                count+=numbers[i]*sign[i];
            }
            if(count==target) answer++;
            
            return;
        }
        
        
        sign[cur]=1;
        dfs(cur+1, depth, numbers, target);
        sign[cur]=-1;
        dfs(cur+1, depth, numbers, target);
    }
}