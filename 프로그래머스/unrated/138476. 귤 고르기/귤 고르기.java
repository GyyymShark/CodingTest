import java.util.*;


class Solution {
    
    static class Orange implements Comparable<Orange>{
        int num;
        int count;
        
        public Orange(int num, int count){
            this.num=num;
            this.count=count;
        }
        
        @Override
        public int compareTo(Orange o){
            return o.count-count;
        }
    }
    
    
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        int kind=1;
        List<Orange> orange=new ArrayList<>();
        Arrays.sort(tangerine);
        
        for(int i=1; i<tangerine.length; i++){
            if(tangerine[i]!=tangerine[i-1]) kind++;
        }
        int[] num=new int[kind];
        int[] count=new int[kind];
        
        num[0]=tangerine[0];
        count[0]++;
        
        int countIdx=0;
        
        for(int i=1; i<tangerine.length; i++){
            if(tangerine[i]!=tangerine[i-1]){   //앞과 뒤가 다르면 새로 추가
                countIdx++;
                num[countIdx]=tangerine[i];
                count[countIdx]++;
            }
            else{       //같으면 횟수 증가
                count[countIdx]++;
            }
        }
      
        
        for(int i=0; i<kind; i++){
            orange.add(new Orange(num[i],count[i]));
        }
        
        Collections.sort(orange);
        int orangeIdx=0;
        for(int i=k; i>0; i--){
            if(orange.get(orangeIdx).count==0){
                answer++;
                orangeIdx++;
            } 
            Orange temp=orange.get(orangeIdx);
            temp.count=temp.count-1;
            orange.set(orangeIdx,temp);
        }
        
        
        
      
      
       
        
        
        return answer;
    }
}