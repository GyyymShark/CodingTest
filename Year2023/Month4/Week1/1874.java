package com.example.demo.Week1;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();

        int k=Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack();
        int[] arr=new int[k+1];
        Boolean possible=true;
        int max=1;


        for(int i=1; i<=k; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=k; i++){

            if(stack.isEmpty()){
                while(max<=arr[i]){
                    stack.push(max);
                    max++;
                    sb.append("+").append("\n");
                    //bw.write("+");
                    //bw.newLine();
                }
                //bw.write("-");
                //bw.newLine();
                sb.append("-").append("\n");
                stack.pop();
            }

            else{
                if(stack.peek()==arr[i]){
                    // bw.write("-");
                    // bw.newLine();
                    sb.append("-").append("\n");
                    stack.pop();
                }
                else{
                    if(stack.peek()>arr[i]){
                        possible=false;
                        break;
                    }
                    else{
                        while(max<=arr[i]){
                            stack.push(max);
                            max++;
                            //bw.write("+");
                            //bw.newLine();
                            sb.append("+").append("\n");
                        }
                        //bw.write("-");
                        //bw.newLine();
                        sb.append("-").append("\n");
                        stack.pop();
                    }
                }
            }


            // System.out.println(stack);

        }

        if(possible){
            //bw.flush();
            System.out.println(sb);
        }
        else{
            System.out.println("NO");
        }

        // bw.close();


    }

}

