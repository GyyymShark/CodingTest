import java.util.*;

class Solution {
    static class Point{
        String value;
        int count;
        
        Point(String value, int count){
            this.value=value;
            this.count=count;
        }
    }
    static boolean[] visited;
    static int min=Integer.MAX_VALUE;
    static Queue<Point> q=new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        visited=new boolean[words.length];
        bfs(begin, target, words);
        if(min==Integer.MAX_VALUE) min=0;
        return min;
    }
    
    static boolean check(String str1, String str2){
        int count=0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)==str2.charAt(i)) count++;
        }
        if(str1.length()-1==count) return true;
        else return false;
    }
    
    static void bfs(String begin, String target, String[] words){
        q.offer(new Point(begin,0));
        while(!q.isEmpty()){
            Point cur=q.poll();
            if(cur.value.equals(target)){
                min=cur.count;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(cur.value,words[i])){
                    q.offer(new Point(words[i], cur.count+1));
                    visited[i]=true;
                }
            }
        }
    }
}