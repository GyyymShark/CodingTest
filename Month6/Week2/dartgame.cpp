#include <string>
#include <iostream>
using namespace std;

int solution(string dartResult) {

    int answer = 0;
    int tempcnt=0;
    int temp[3];
    for(int i=0; i<dartResult.length(); i++){
        char cur=dartResult[i];
        if('0'<=cur && cur<='9'){
            int fake=cur-'0';
            if(cur=='0' && dartResult[i-1]=='1'){
                fake=10;
            }
            temp[tempcnt]=fake;
        }
        
        switch(cur){
            case 'S':{
                tempcnt++;
                break;
            }
            case 'D':{
                tempcnt++;
                temp[tempcnt-1]=temp[tempcnt-1]*temp[tempcnt-1]; 
                break;
            }
            case 'T':{
                tempcnt++;
                temp[tempcnt-1]=temp[tempcnt-1]*temp[tempcnt-1]*temp[tempcnt-1];
                break;
            }
            case '*':{
                if(tempcnt==1){
                    temp[0]*=2;
                }
                else{
                    temp[tempcnt-1]*=2;
                    temp[tempcnt-2]*=2;
                }
                break;
            }
            case '#':{
                temp[tempcnt-1]=temp[tempcnt-1]*(-1);
                break;
            }
        }
        
       
    }

     answer=temp[0]+temp[1]+temp[2];
    return answer;
}