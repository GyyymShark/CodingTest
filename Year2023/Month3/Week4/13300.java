

import java.util.*;


class Main {
    public static void main(String[] args) {
        int[][] student=new int[7][2];   //열 0 여학생 1 남학생
        Scanner sc=new Scanner(System.in);

        int n,k,result=0;
        n=sc.nextInt();
        k=sc.nextInt();

        for(int i=0; i<n; i++){
            int s,y;
            s=sc.nextInt();
            y=sc.nextInt();
            student[y][s]++;
        }
        for(int i=1; i<7; i++){
            for(int j=0; j<2; j++){
                result+=student[i][j]/k;
                student[i][j]%=k;
                if(student[i][j]!=0)
                    result++;
            }
        }

        System.out.println(result);

    }
}

