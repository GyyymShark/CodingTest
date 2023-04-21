
import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        Deque<Integer> dq=new LinkedList<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0; i<t; i++){
            boolean status=true;    //true면 뒤집기 안함, false면 뒤집기 함
            boolean error=false;
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            StringTokenizer st2=new StringTokenizer(br.readLine());

            int[] arr;
            int len=Integer.parseInt(st2.nextToken());
            arr=new int[len];

            StringTokenizer str=new StringTokenizer(br.readLine(), "[],");
            int idx=0;
            while(str.hasMoreTokens()){
                dq.addLast(Integer.parseInt(str.nextToken()));
                idx++;
            }

            for(char x : command.toCharArray()){

                if(x=='R'){
                    status=!status;
                }
                else if(x=='D'){

                    if(dq.size()==0){
                        error=true;
                        break;
                    }

                    if(status){ //뒤집기 안했을때
                        dq.removeFirst();
                    }
                    else{   //뒤집기 했을때
                        dq.removeLast();
                    }

                }
            }

            if(!error){
                if(status){
                    boolean check=false;
                    sb.append("[");
                    while(!dq.isEmpty()){
                        check=true;
                        sb.append(dq.removeFirst()+",");
                    }
                    if(check)
                        sb.deleteCharAt(sb.length()-1);
                    sb.append("]");
                    sb.append("\n");
                }
                else{
                    boolean check=false;
                    sb.append("[");
                    while(!dq.isEmpty()){
                        check=true;
                        sb.append(dq.removeLast()+",");
                    }
                    if(check)
                        sb.deleteCharAt(sb.length()-1);
                    sb.append("]");
                    sb.append("\n");
                }
            }
            else {
                sb.append("error");
                sb.append("\n");
            }


        }

        System.out.println(sb);
    }
}