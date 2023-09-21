import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> closet=new HashMap<>();
        List<String> kind;
        int kindSize,count=0;
        for(int i=0; i<clothes.length; i++){
            String cloth=clothes[i][1];
            closet.put(cloth,closet.getOrDefault(cloth,0)+1);
        }
        
        kind=new ArrayList<>(closet.keySet());
        kindSize=kind.size();
        for(String key: kind){
            answer*=closet.get(key)+1;
        }
        
        
        return answer-1;
    }
}