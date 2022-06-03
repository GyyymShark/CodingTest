#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, int n) {
    string answer = "";

    for(int i=0; i<s.size(); i++){
       for(int j=0; j<n; j++){
           if('A'<=s[i]&&s[i]<='z'){
            if(s[i]=='z'){
                s[i]='a'-1;
            }
           else if(s[i]=='Z'){
               s[i]='A'-1;
           }
               s[i]=s[i]+1;
           }
       }
        
    }   
    cout<<s;
    answer=s;
    return answer;
}