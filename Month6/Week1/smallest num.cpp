#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int minidx=0;
    
    for(int i=1; i<arr.size(); i++){
    if(arr[i]<arr[minidx]){
        minidx=i;
        }
    }
    arr.erase(arr.begin()+minidx);
    
    for(int i=0; i<arr.size(); i++){
        answer.push_back(arr[i]);
    }
    if(answer.size()==0){
        answer.push_back(-1);
    }
    
    return answer;
}