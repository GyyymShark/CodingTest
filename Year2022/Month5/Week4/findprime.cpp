#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    bool* arr=new bool[n+1];
    for(int i=0; i<n+1; i++){
        arr[i]=true;       //소수면 true 소수아니면 false
    }
    int answer = 0;

        for(int j=2; j*j<n; j++){
            if(arr[j]==true){
                for(int k=j*2; k<=n; k=k+j){
                    arr[k]=false;
                }
            }
        }
  
    for(int i=2; i<=n; i++){
        if(arr[i]==true){
            answer++;
        }
    }
return answer;
}

