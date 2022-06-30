#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> v;
    while(n!=0){
        int temp=n%10;
        v.push_back(temp);
        n=n/10;
    }
    sort(v.begin(),v.end());
    for(int i=0; i<v.size(); i++){
        answer+=v[i]*(long long)pow(10,i);     
    }
    return answer;
}