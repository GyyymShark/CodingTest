import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache=new LinkedList<>();
        
        for(String s: cities){
            String city=s.toLowerCase();
            
            if(cacheSize==0){
                answer+=5;
                continue;
            }
            
            if(cache.contains(city) && !cache.isEmpty()){
                cache.remove(cache.indexOf(city));
                answer+=1;
            }
            else{
                if(cache.size()>=cacheSize){
                    cache.remove(cache.size()-1);
                }
                answer+=5;
            }
            cache.add(0,city);
        }
        
        
        
        return answer;
    }
}