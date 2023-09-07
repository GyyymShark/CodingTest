import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Integer> stack=new Stack<>();
        
        
        for(int i=0; i<s.length(); i++){
            
            if(!stack.isEmpty()){
                if(stack.peek()==s.charAt(i)-'a'){
                    stack.pop();
                    continue;
                }
                else{
                    stack.add(s.charAt(i)-'a');
                }
            }
            
            else stack.add(s.charAt(i)-'a');
            
        }
        
        if(stack.isEmpty()) answer++;
        
        System.out.println(stack);
        

        return answer;
    }
}