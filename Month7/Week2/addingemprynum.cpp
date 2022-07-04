#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    int list[10]={0};
    
    for(int i=0; i<numbers.size(); i++){
        list[numbers[i]]=1;
    }
    for(int j=0; j<10; j++){
        if(list[j]!=1){
            answer+=j;
        }
    }
    
    
    return answer;
}