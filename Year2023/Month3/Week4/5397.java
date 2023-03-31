

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());

        LinkedList<Character> list=new LinkedList();
        ListIterator iter=list.listIterator();

        while(iter.hasNext()){
            iter.next();
        }

        for(int i=0; i<n; i++){
            while(iter.hasNext()){
                iter.next();
            }

            while(iter.hasPrevious()){
                iter.previous();
                iter.remove();
            }
            String str=br.readLine();


            for(char x : str.toCharArray()){
                switch(x){
                    case '-':{
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    }
                    case '<':{
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    }
                    case '>':{
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    }
                    default:{
                        iter.add(x);
                        break;
                    }
                }
            }

            for(char x : list){
                bw.write(String.valueOf(x));
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
