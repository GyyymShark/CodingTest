import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map=new HashMap<>();
        
        for(Integer a : tangerine){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        
        List<Integer> key=new ArrayList<>(map.keySet());
        Collections.sort(key, new Comparator<>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return map.get(i2)-map.get(i1);
          }
        });
        
        
        for(Integer value : key){
            k-=map.get(value);
            
            answer++;
            
            if(k<=0) break;
        }
        
            
        
        
        return answer;
    }
}