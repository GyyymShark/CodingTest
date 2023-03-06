#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int gcd(int a, int b) {
    if (b==0)
    	return a;
    else
    	return gcd(b, a%b);
}
int lcm(int a, int b){
    return a * b / gcd(a,b);
}

int solution(vector<int> arr) {
    int answer = 1;
    
    for(int i=0; i<arr.size(); i++){
        int LCM=lcm(answer,arr[i]);
        answer=LCM;
    }

    
    
    
    return answer;
}


