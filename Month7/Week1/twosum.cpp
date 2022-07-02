#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> sum;
    vector<int> answer;
    for(int i=0; i<numbers.size()-1; i++){
        for(int j=i+1; j<numbers.size(); j++){
            sum.push_back(numbers[i]+numbers[j]);
        }
    } 
    sort(sum.begin(),sum.end());        //sum 오름차순 정렬
    
    
    int ansidx=0;
    answer.push_back(sum[0]);
    
    for(int i=1; i<sum.size(); i++){
        if(answer[ansidx]!=sum[i]){ //중복되는 값이 아니면
            answer.push_back(sum[i]); //값 삽입 후
            ansidx++;           //ansidx증가
        }
    }
    
    return answer;
}