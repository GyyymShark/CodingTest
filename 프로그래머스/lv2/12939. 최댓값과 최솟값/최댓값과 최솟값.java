import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st=new StringTokenizer(s);
        List<Integer> array=new ArrayList<>();
        
        while(st.hasMoreTokens()){
            array.add(Integer.parseInt(st.nextToken()));    
        }
        
        Collections.sort(array);
  
                      
        String answer = "";
        answer+=array.get(0)+" "+array.get(array.size()-1);
        return answer;
    }
}