#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    for(int i=0; i<s.length(); i++){
        if(i==0){
            if('a'<=s[i] && s[i]<='z'){
                s[i]=s[i]-('a'-'A');
            }
        }
        else if(s[i-1]==' '){
             if('a'<=s[i] && s[i]<='z'){
                s[i]=s[i]-('a'-'A');
            }
        }
        else{
            if('A'<=s[i]&& s[i]<='Z'){
                s[i]=s[i]+('a'-'A');
            }
        }
    }
    cout<<s<<endl;
    answer=s;
    return answer;
}