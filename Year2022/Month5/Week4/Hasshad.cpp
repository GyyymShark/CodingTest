#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int a,b,c,d,e;
    e=x%10;
    d=(x%100)/10;
    c=(x%1000)/100;
    b=(x%10000)/1000;
    a=x/10000;
    bool answer = true;
    if(x%(a+b+c+d+e)!=0){
        answer=false;
    }
    
    return answer;
}