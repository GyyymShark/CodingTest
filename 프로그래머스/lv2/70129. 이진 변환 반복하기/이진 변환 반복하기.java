class Solution {
    public int[] solution(String s) {
        int zeroCount=0, loopCount=0;
    
        while(!s.equals("1")){
            loopCount++;
            int temp=0;
            for(int i=0; i<s.length(); i++) if(s.charAt(i)=='0') temp++;
            
            s=Integer.toBinaryString(s.length()-temp);
            zeroCount+=temp;
        }
        return new int[] {loopCount,zeroCount};
        
    }
}