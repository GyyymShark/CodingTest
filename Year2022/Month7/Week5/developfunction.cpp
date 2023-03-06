#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> day;
    for(int i=0; i<progresses.size(); i++){
        int comp=(100-progresses[i])/speeds[i];
        int remain=(100-progresses[i])%speeds[i];
        
        if(remain==0){  //나머지가 0이면 comp가 day
            day.push(comp);
        }
        else{   //나머지가 존재하면 comp+1이 day
            day.push(comp+1);
        }
    }
    
    while(!day.empty()){
        int count=0;
        int today=day.front();      //day에서 하나를 뽑고
        day.pop();
        count++;
        int daysize=day.size(); //pop하면 size가 바뀌기때문에 변수로 지정해준다
        for(int j=0; j<daysize; j++){
           if(today>=day.front()){   //비교해가며 작으면 배포가능하므로
               day.pop();   //pop해주고
               count++;     //count세준다
           }
       }
       answer.push_back(count);
    }
   
  /*
    for(int i=0; i<day.size(); i++){   //day.size()까지해야지 마지막을 돈다
        int count=0;
        int today=day.front();      //day에서 하나를 뽑고
        day.pop();
        count++;
       for(int j=0; j<day.size(); j++){
           if(today>=day.front()){   //비교해가며 작으면 배포가능하므로
               day.pop();   //pop해주고
               count++;     //count세준다
           }
       }
       answer.push_back(count);
        }*/

    return answer;
}