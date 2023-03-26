package com.example.demo.Week1;

import java.util.*;


class Main {
    public static void main(String[] args) {
        int n, x,count=0;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[] arr = new int[2000001];
        Integer[] input=new Integer[n];


        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        x=sc.nextInt();




        for(int i=0; i<n; i++){
            int value=input[i];
            arr[value]=1;
            if(value*2!=x && value<x){
                if(arr[x-value]==1)
                    count++;
            }
        }

        System.out.println(count);


    }
}

