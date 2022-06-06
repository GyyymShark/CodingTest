#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    answer.push_back(arr[0]);
    int anscnt=0;
    
    for(int i=0; i<arr.size(); i++){
    if(answer[anscnt]!=arr[i]){
        answer.push_back(arr[i]);
        anscnt++;
    }
       
    }

    return answer;
}