#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> priorities, int location) {
  
    int answer = 0;
    bool print=true;
    
 
    
    while(true){
       print=true;
        
        for(int i=1; i<priorities.size(); i++){
            if(priorities[0]<priorities[i]){    //J보다 중요도가 높은 문서가 있으면 출력안함
                print=false;
                break;
            }
        }
  
        
        if(print==false){
             int temp=priorities[0];
                priorities.erase(priorities.begin());   //맨앞 대기목록에서 꺼내고
                priorities.push_back(temp);     //맨뒤로 넣음
                
                if(location>0)
                location--;     //대기순서 하나감소
                
                else if(location==0)    //location이 0이면
                    location=priorities.size()-1; //맨뒤로 
        }
        else if(print==true){   //출력이 된다면
            if(location>0){
             priorities.erase(priorities.begin());   //맨앞 대기목록에서 꺼내고
             answer++;      //출력횟수 증가
            location--;
            }
            else if(location==0){   //location이 0이라는건 종료조건임
                priorities.erase(priorities.begin());   //맨앞 대기목록에서 꺼내고
                answer++;
                break;
            }
        }
    }
    return answer;
    }