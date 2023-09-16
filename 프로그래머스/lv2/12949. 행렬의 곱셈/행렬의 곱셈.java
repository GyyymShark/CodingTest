class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

  
        int[][] answer=new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<arr1.length; i++){   
            int answerCol=0;
            for(int j=0; j<arr2[0].length; j++){   
                int value=0;
                for(int k=0; k<arr2.length; k++){  
                    value+=arr1[i][k]*arr2[k][j];
                }
                answer[i][answerCol]=value;
                answerCol++;
                
            }
        }
        
        return answer;
    }
}