#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool solution(string s) {
    int arr[8];
    bool answer = true;
    if(s.length()==4 || s.length()==6){
    }
    else{
        answer=false;
    }
    
    for(int i=0; i<s.length(); i++){
        arr[i]=s[i];
    }
    for(int i=0; i<s.length(); i++){
        if(48<=s[i] && s[i]<=57)
        {

        }
        else{
            answer=false;
        }
    }
    return answer;
}