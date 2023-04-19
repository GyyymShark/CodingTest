
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

            switch(command){
                case "push": {
                    num=Integer.parseInt(st.nextToken());
                    q.add(num);
                    break;
                }
                case "pop": {
                    if(!q.isEmpty()) {
                        sb.append(q.peek());
                        sb.append("\n");
                        q.remove();
                    }
                    else{
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;
                }
                case "size": {
                    if(!q.isEmpty()) {
                        sb.append(q.size());
                        sb.append("\n");
                    }
                    else{
                        sb.append(0);
                        sb.append("\n");
                    }
                    break;
                }
                case "empty": {
                    if(!q.isEmpty()) {
                        sb.append(0);
                        sb.append("\n");
                    }
                    else{
                        sb.append(1);
                        sb.append("\n");
                    }
                    break;
                }
                case "front": {
                    if(!q.isEmpty()) {
                        sb.append(q.peek());
                        sb.append("\n");
                    }
                    else{
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;
                }
                case "back": {
                    if(!q.isEmpty()) {
                        sb.append(num);
                        sb.append("\n");
                    }
                    else{
                        sb.append(-1);
                        sb.append("\n");
                    }
                    break;
                }
            }

        }

        System.out.println(sb);

    }
}