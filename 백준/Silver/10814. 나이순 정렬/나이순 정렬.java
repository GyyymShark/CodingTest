import java.util.*;
import java.io.*;

class Main{
    static class User{
        private int age;
        private String name;

        User(int age, String name){
            this.age=age;
            this.name=name;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        User[] users=new User[n];
        StringBuilder sb=new StringBuilder();

        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int age=Integer.parseInt(st.nextToken());
            String name=st.nextToken();
            users[i]=new User(age,name);
        }

        Arrays.sort(users, new Comparator<User>(){
            @Override
            public int compare(User s1, User s2){
                return s1.age-s2.age;
            }
        });

        for(User user : users){
            sb.append(user.age+" "+user.name+"\n");
        }
        System.out.println(sb);

    }
}