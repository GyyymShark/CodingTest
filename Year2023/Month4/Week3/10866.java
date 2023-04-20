
import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb=new StringBuilder();
        Deque<Integer> dq=new LinkedList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push_front":{
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "push_back":{
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop_front":{
                    if(dq.isEmpty()){
                        sb.append(-1);
                        sb.append("\n");
                    }
                    else{
                        sb.append(dq.removeFirst());
                        sb.append("\n");
                    }
                    break;
                }
                case "pop_back":{
                    if(dq.isEmpty()){
                        sb.append(-1);
                        sb.append("\n");
                    }
                    else{
                        sb.append(dq.removeLast());
                        sb.append("\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(dq.size());
                    sb.append("\n");
                    break;
                }
                case "empty":{
                    if(dq.isEmpty()){
                        sb.append(1);
                        sb.append("\n");
                    }
                    else{
                        sb.append(0);
                        sb.append("\n");
                    }
                    break;
                }
                case "front":{
                    if(dq.isEmpty()){
                        sb.append(-1);
                        sb.append("\n");
                    }
                    else{
                        sb.append(dq.peekFirst());
                        sb.append("\n");
                    }
                    break;
                }
                case "back":{
                    if(dq.isEmpty()){
                        sb.append(-1);
                        sb.append("\n");
                    }
                    else{
                        sb.append(dq.peekLast());
                        sb.append("\n");
                    }
                    break;
                }
            }
        }
        System.out.println(sb);

    }
}