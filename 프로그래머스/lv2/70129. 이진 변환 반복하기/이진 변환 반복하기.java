class Solution {
    public int[] solution(String s) {
        int zeroCount=0;
        int loop=0;
        while(!s.equals("1")){
            String str="";
            for(char x : s.toCharArray()){
                if(x=='0') zeroCount++;
                else str+=x;
            }
            loop++;
            
            int length=str.length();
            s="";
            String temp="";
            while(length!=0){
                int value=length%2;
                length=length/2;
                temp+=value;
            }
            for(int i=temp.length()-1; i>=0; i--){
                s+=temp.charAt(i);
            }
        }
        int[] arr= {loop,zeroCount};
        return arr;
    }
}