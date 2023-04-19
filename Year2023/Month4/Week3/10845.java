import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        Queue<Integer> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();

        int num=-1;

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            if(command.equals("push")){
                num=Integer.parseInt(st.nextToken());
                q.add(num);
            }
            else if(command.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1);
                    sb.append("\n");
                }
                else{
                    sb.append(q.remove());
                    sb.append("\n");
                }
            }
            else if(command.equals("size")){
                sb.append(q.size());
                sb.append("\n");
            }
            else if(command.equals("empty")){
                if(q.isEmpty()) {
                    sb.append(1);
                    sb.append("\n");
                }
                else {
                    sb.append(0);
                    sb.append("\n");
                }
            }
            else if(command.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1);
                    sb.append("\n");
                }
                else{
                    sb.append(q.peek());
                    sb.append("\n");
                }
            }
            else if(command.equals("back")){
                if(q.isEmpty()){
                    sb.append(-1);
                    sb.append("\n");
                }
                else{
                    sb.append(num);
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);

    }
}