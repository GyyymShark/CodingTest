import java.util.*;
import java.io.*;

class Main{


    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        Student(String name, int korean, int english, int math){
            this.name=name;
            this.korean=korean;
            this.english=english;
            this.math=math;
        }

        @Override
        public String toString(){
            return name;
        }


        @Override
        public int compareTo(Student s1){
            if(s1.korean==this.korean && s1.english==this.english && s1.math==this.math){
                return this.name.compareTo(s1.name);
            }

            else if(s1.korean==this.korean && s1.english==this.english) return s1.math-this.math;

            else if(s1.korean==this.korean) return this.english-s1.english;


            return s1.korean-this.korean;
        }


    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Student[] students=new Student[n];

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            int korean=Integer.parseInt(st.nextToken());
            int english=Integer.parseInt(st.nextToken());
            int math=Integer.parseInt(st.nextToken());

            students[i]=new Student(name,korean,english,math);
        }

        Arrays.sort(students);

        Arrays.stream(students).forEach(System.out::println);



    }
}