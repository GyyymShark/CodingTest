import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack=new Stack<>();
       
        for(char x : s.toCharArray()){
            if(x=='(') stack.push(1);
            else{
                if(!stack.empty())
                    stack.pop();
                else{
                    stack.push(1); 
                    break;
                }
                
            }
        }
        
        if(stack.empty()) return true;
        else return false;
        
    
    }
}