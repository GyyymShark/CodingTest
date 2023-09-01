import java.util.*;
import java.io.*;

class Main{
    static Deque<Integer>[] dq=new Deque[4];
    static ArrayList<Integer>[] array=new ArrayList[4];
    static int k;

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            dq[i]=new LinkedList<>();
            array[i]=new ArrayList<>();
            String s = br.readLine();
            for(char x: s.toCharArray()){
                dq[i].addLast((int)x-'0');
            }
        }
        k=Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int gear=Integer.parseInt(st.nextToken());
            int direction=Integer.parseInt(st.nextToken());
            clearList();
            copyToList();
            HashMap<Integer, Integer> jobs = jobs(gear - 1, direction);
            rotate(jobs);
        }
        calculate();



    }

    static void clearList(){
        for(int i=0; i<4; i++){
            array[i].clear();
        }
    }

    static void printDeque(){
        for(int i=0; i<4; i++){
            System.out.println(dq[i]);
        }
        System.out.println();
    }

    static void calculate(){

        //n극 0, s극 1
        int score=0;
        for(int i=0; i<4; i++){
            int value=dq[i].removeFirst();
            if(value==1) score+=(int)Math.pow(2,i);
        }
        System.out.println(score);
    }

    static void copyToDeque(){

        for(int i=0; i<4; i++){
            dq[i].clear();
            for(int j=0; j<8; j++){
               dq[i].addLast(array[i].get(j));
            }
        }

    }

    static void copyToList(){
        for(int i=0; i<4; i++){
            for(int j=0; j<8; j++){
                int value=dq[i].removeFirst();
                array[i].add(value);
                dq[i].addLast(value);
            }
        }

    }
    static HashMap<Integer, Integer> jobs(int gear, int direction){



        HashMap<Integer, Integer> jobs=new HashMap<>();
        jobs.put(gear,direction);

        int gear3L = array[3].get(6);
        int gear2L= array[2].get(6); int gear2R=array[2].get(2);
        int gear1L= array[1].get(6); int gear1R=array[1].get(2);
        int gear0R=array[0].get(2);

        //0일때
        if(gear==0){
            if(gear0R==gear1L) return jobs;
            else{
                jobs.put(1, direction*(-1));
                if(gear1R==gear2L) return jobs;
                else{
                    jobs.put(2, direction);
                    if(gear2R==gear3L) return jobs;
                    else jobs.put(3,direction*(-1));
                }
            }


        }



        //3일때
        else if(gear==3){

            if(gear3L==gear2R) return jobs;

            else{
                jobs.put(2, direction*(-1));

                if(gear2L==gear1R) return jobs;

                else{
                    jobs.put(1,direction);

                    if(gear1L==gear0R) return jobs;
                    else jobs.put(0,direction*(-1));
                }
            }


        }


        else{       //1,2일때
            if(gear==1){
                if(gear1L!=gear0R) jobs.put(0,direction*(-1));
                if(gear1R==gear2L) return jobs;
                else{
                    jobs.put(2,direction*(-1));
                    if(gear2R==gear3L) return jobs;
                    else jobs.put(3,direction);
                }

            }
            else if(gear==2){
                if(gear2R!=gear3L) jobs.put(3,direction*(-1));
                if(gear2L==gear1R) return jobs;
                else{
                    jobs.put(1,direction*(-1));
                    if(gear1L==gear0R) return jobs;
                    else jobs.put(0,direction);
                }


            }

        }


        return jobs;
    }

    static void rotate(HashMap<Integer, Integer> jobs){


        for(int i=0; i<4; i++){
            if(jobs.containsKey(i)){
                int direction=jobs.get(i);
                if(direction==1){   //시계(맨 뒤 원소 맨 앞)
                    int value=dq[i].removeLast();
                    dq[i].addFirst(value);
                }
                else if(direction==-1){     //반시계(맨 앞 원소 맨 뒤)
                    int value=dq[i].removeFirst();
                    dq[i].addLast(value);
                }
            }
        }

    }
}