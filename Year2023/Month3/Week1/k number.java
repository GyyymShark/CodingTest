import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int l=0; l<commands.length; l++){
            int i=commands[l][0];
            int j=commands[l][1];
            int k=commands[l][2];
            
            int[] arr=new int[j-i+1];
            for(int b=0; b<arr.length; b++){
                arr[b]=array[(i-1)+b];
            }
             Arrays.sort(arr);
         for(int b=0; b<arr.length; b++){
            }
            answer[l]=arr[k-1];
        }
       
        
        
        return answer;
    }
}