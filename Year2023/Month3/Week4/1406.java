
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int m,idx;
        StringTokenizer st=new StringTokenizer(br.readLine());

        LinkedList<Character> list=new LinkedList();

        m=Integer.parseInt(br.readLine());
        String str=st.nextToken();

        for(int i=0; i<str.length(); i++){
            list.add(str.charAt(i));
        }

        idx=list.size();

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()){
            iter.next();
        }



        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());

            String strCommand=st.nextToken();
            char command=strCommand.charAt(0);
            if(command=='P'){
                char command2=st.nextToken().charAt(0);
                iter.add(command2);
            }
            else if(command=='L'){
                if(iter.hasPrevious())
                    iter.previous();
            }
            else if(command=='B'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }
            else if(command=='D'){
                if(iter.hasNext())
                    iter.next();
            }
        }

        for(Character chr : list){
            bw.write(chr);
        }

        bw.flush();
        bw.close();

    }
}
