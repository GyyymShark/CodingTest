#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1,sum = 0;
    for(int i=1; i<=(n+1)/2; i++){
        sum=i;
        for(int j=i+1; i<=(n+1)/2; j++){
            sum+=j;
            if(sum==n){
                answer++;
            }
            else if(sum>n){
                break;
            }
        }
    }
    return answer;
}