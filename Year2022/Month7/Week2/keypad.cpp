#include <string>
#include <vector>
#include <math.h>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
    int row[]={3,0,0,0,1,1,1,2,2,2};
    int col[]={1,0,1,2,0,1,2,0,1,2};
    string answer = "";
    int leftrow=3,leftcol=0,rightrow=3,rightcol=2;
    for(int i=0; i<numbers.size(); i++){
        int goalrow=row[numbers[i]];
        int goalcol=col[numbers[i]];
        int leftdis=abs(goalrow-leftrow)+abs(goalcol-leftcol);
        int rightdis=abs(goalrow-rightrow)+abs(goalcol-rightcol);
        cout<<"leftdis"<<leftdis<<' '<<"rightdis"<<rightdis<<endl;
        switch(numbers[i]){
            case 1:{
                leftrow=0, leftcol=0;
                answer+='L';
                break;
            }
            case 2:{
                if(leftdis<rightdis){   //왼손이 움직일때
                    leftrow=0,leftcol=1;
                    answer+='L';
                }
                else if(leftdis==rightdis){     //값이 같을때
                    if(hand=="left"){
                        leftrow=0,leftcol=1;
                        answer+='L';
                    }
                    else{
                        rightrow=0,rightcol=1;
                        answer+='R';
                    }
                }
                else{   //오른손이 움직일때
                    rightrow=0,rightcol=1;
                    answer+='R';
                }
                break;
            }
            case 3:{
                rightrow=0, rightcol=2;
                answer+='R';
                break;
            }
            case 4:{
                leftrow=1, leftcol=0;
                answer+='L';
                break;
            }
            case 5:{
                if(leftdis<rightdis){   //왼손이 움직일때
                    leftrow=1,leftcol=1;
                    answer+='L';
                }
                else if(leftdis==rightdis){     //값이 같을때
                    if(hand=="left"){
                        leftrow=1,leftcol=1;
                        answer+='L';
                    }
                    else{
                        rightrow=1,rightcol=1;
                        answer+='R';
                    }
                }
                else{   //오른손이 움직일때
                    rightrow=1,rightcol=1;
                    answer+='R';
                }
                break;
            }
            case 6:{
                rightrow=1, rightcol=2;
                answer+='R';
                break;
            }
            case 7:{
                leftrow=2, leftcol=0;
                answer+='L';
                break;
            }
            case 8:{
                if(leftdis<rightdis){   //왼손이 움직일때
                    leftrow=2,leftcol=1;
                    answer+='L';
                }
                else if(leftdis==rightdis){     //값이 같을때
                    if(hand=="left"){
                        leftrow=2,leftcol=1;
                        answer+='L';
                    }
                    else{
                        rightrow=2,rightcol=1;
                        answer+='R';
                    }
                }
                else{   //오른손이 움직일때
                    rightrow=2,rightcol=1;
                    answer+='R';
                }
                break;
            }
            case 9:{
                rightrow=2, rightcol=2;
                answer+='R';
                break;
            }
            case 0:{
                if(leftdis<rightdis){   //왼손이 움직일때
                    leftrow=3,leftcol=1;
                    answer+='L';
                }
                else if(leftdis==rightdis){     //값이 같을때
                    if(hand=="left"){
                        leftrow=3,leftcol=1;
                        answer+='L';
                    }
                    else{
                        rightrow=3,rightcol=1;
                        answer+='R';
                    }
                }
                else{   //오른손이 움직일때
                    rightrow=3,rightcol=1;
                    answer+='R';
                }
                break;
            }
            
        }
    }
    return answer;
}