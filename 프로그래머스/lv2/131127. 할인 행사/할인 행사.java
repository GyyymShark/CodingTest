class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //길이 14
        //0~13
        //0~9 1~10 2~11 3~12 4~13 
        
        for(int i=0; i<=discount.length-10; i++){
            boolean discountPossible=true;
            
            int[] numberCopy=new int[number.length];
            for(int l=0; l<number.length; l++){
                numberCopy[l]=number[l];
            }
            
            for(int j=i; j<i+10; j++){
                for(int k=0; k<want.length; k++){
                    if(want[k].equals(discount[j])){
                      numberCopy[k]--;
                      break;
                    } 
                }
            }
            
            
            for(int r=0; r<numberCopy.length; r++){
                if(numberCopy[r]>0) discountPossible=false;
            }
            if(discountPossible) answer++;
            
        }
        
        
        return answer;
    }
}