#include <string>
#include <vector>
#include <iostream>

using namespace std;
int solution(int n) {
    vector<int> v;
    v.push_back(0);
    v.push_back(1);
    int answer = 0;
    for(int i=2; i<=n; i++){
        v.push_back((v[i-2]+v[i-1])%1234567);
    }
    answer=v[n];
    return answer;
}

