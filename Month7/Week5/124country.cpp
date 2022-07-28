#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(int n) {
    int arr[3]={1,2,4};
    string answer = "";
    string fakeanswer="";
    while(n!=0){
        int div,rem;
        n-=1;
        div=n/3;
        rem=n%3;
        n/=3;
        fakeanswer+=to_string(arr[rem]);
        }
    for(int i=fakeanswer.length()-1; i>=0; i--){
        answer+=fakeanswer[i];
    }
    return answer;
}