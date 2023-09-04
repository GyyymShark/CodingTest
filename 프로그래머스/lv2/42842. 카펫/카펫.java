class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int count=brown+yellow;
        
        for(int yWidth=yellow; yWidth>=1; yWidth--){
            if(yellow%yWidth!=0) continue;
            int yHeight=yellow/yWidth;
            int width=yWidth+2;
            if(count%width!=0) continue;
            int height=count/width;
            answer[0]=width;
            answer[1]=height;
            break;
        }
        
        return answer;
    }
}