import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer=new int[2];
        
        int turn=0;
      
        for(int i=0; i<words.length; i++){
            if(i%n==0) turn++;
            if(i>0 && 
               (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))){
                answer[0]=(i%n)+1;
                answer[1]=turn;
                return answer;
            }
               
            for(int j=0; j<=i-1; j++){
                if(words[i].equals(words[j])){
                    answer[0]=(i%n)+1;
                    answer[1]=turn;
                    return answer;
                }
            }
               
        }

        return answer;
    }
}