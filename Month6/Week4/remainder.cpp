#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int min=n;
    for(int i=n; i>=2; i--){
        if(n%i==1 && i<min){
            min=i;
        }
    }
    answer=min;
    return answer;
}