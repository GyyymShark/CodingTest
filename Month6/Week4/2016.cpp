#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(int a, int b) {
    string answer = "";
    string dow[]={"FRI","SAT","SUN","MON","TUE","WED","THU"};
    int day[]={31,29,31,30,31,30,31,31,30,31,30};
    
    int total=0;
    
    for(int i=0; i<a-1; i++){
        total+=day[i];
    }
    total=total+b-1;
    cout<<total<<endl;
    total=total%7;
    answer=dow[total];
 
    return answer;
}