#include <string>
#include <vector>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    bool check=false;
    long long i=2;
    while(true){
        if(i*i>n)
            break;
        if(i*i==n){
            check=true;
            answer=i;
            break;
        }
        i++;
    }
    if(!check){
        answer=-1;
             if(n==1){
        answer=4;
    }
    }
    else{
        answer=(i+1)*(i+1);
    }
    return answer;
}