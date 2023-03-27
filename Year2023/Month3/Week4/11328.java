
import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        sc.nextLine();11328 java


        for(int i=0; i<n; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            char[] charS1 = s1.toCharArray();
            char[] charS2 = s2.toCharArray();
            Arrays.sort(charS2);
            Arrays.sort(charS1);

            s1 = new String(charS1);
            s2 = new String(charS2);
            if(s1.equals(s2))
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }

    }
}

