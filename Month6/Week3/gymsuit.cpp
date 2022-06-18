#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
   
    
    int* student =new int[n+1];
    for(int i=1; i<=n; i++){
        student[i]=1;
    }
    for(int i=0; i<reserve.size(); i++){
        int idx=reserve[i];
        student[idx]=2;
    }
    for(int i=0; i<lost.size(); i++){
        int idx=lost[i];
        if(student[idx]==2){
            student[idx]=1;
            continue;
        }
        student[idx]=0;
    }
    

    
    
    
    for(int i=1; i<=n; i++){
        if(student[i]==0){
            if(i==1){
                if(student[i+1]>=2){
                    student[i+1]--;
                    student[i]++;
                }
                continue;
            }
            else if(i==n){
                if(student[i-1]>=2){
                    student[i-1]--;
                    student[i]++;
                }
                continue;
            }
            
            
           
           if(student[i-1]>=2){
                    student[i-1]--;
                    student[i]++;
            }
           else if(student[i+1]>=2){
                    student[i+1]--;
                    student[i]++;
            }
        }
    }
    
    for(int i=1; i<=n; i++){
        if(student[i]>=1){
            answer++;
        }
    }
    
    return answer;
}