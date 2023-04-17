

import java.util.*;
import java.io.*;


class Top{
    int index;
    int height;
    Top(int index, int height){
        this.index=index;
        this.height=height;
    }
}

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        Stack<Top> s=new Stack<>();
        int n=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            int height=Integer.parseInt(st.nextToken());

            while(!s.isEmpty()){
                Top top=s.peek();
                if(top.height<height){
                    s.pop();
                }
                else{
                    s.push(new Top(i, height));
                    sb.append(top.index+" ");
                    break;
                }
            }


            if(s.isEmpty()){
                s.push(new Top(i,height));
                sb.append(0+" ");
            }
        }

        System.out.println(sb);
    }
}