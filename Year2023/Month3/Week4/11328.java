
import java.util.*;


class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();

       char[] alp=new char[26];

       for(int i=0; i<n; i++){
           bool possible=true;
           String s1=sc.next();
           String s2=sc.next();

           for(char x : s1){
               alp[s1-'a']++;
           }
           for(char x : s2){
               alp[s2-'a']--;
           }

           for(int j=0; j<26; j++){
               if(alp[j]!=0){
                   System.out.println("Impossible");
                   possible=false;
                   break;
               }
           }
           if(possible)
               System.out.println("Possible");
       }

    }
}

