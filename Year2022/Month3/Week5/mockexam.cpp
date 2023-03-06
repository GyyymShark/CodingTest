#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


vector<int> solution(vector<int> answers) {
      
    int first[5]={1,2,3,4,5};
    int second[8]={2,1,2,3,2,4,2,5};
    int third[10]={3,3,1,1,2,2,4,4,5,5};
    
     vector<int> answer;
    int maxscore=0;
    int score[3]={0,0,0};
  
    for(int i=0; i<answers.size(); i++){ 
    if(answers[i]==first[i%5]) score[0]++;
        if(answers[i]==second[i%8]) score[1]++;
        if(answers[i]==third[i%10]) score[2]++;
    }
   
    maxscore=max(max(score[0],score[1]),score[2]);
    
    
    for(int i=0; i<3; i++){
        if(maxscore==score[i])
            answer.push_back(i+1);
    }
    
   
   
    
    return answer;
}