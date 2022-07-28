#include <string>
#include <vector>
#include <iostream>

using namespace std;

string getbinary(int n){
    string temp="";
    while(n!=0){
        int remain;
        remain=n%2;
        n/=2;
        temp+=to_string(remain);
    }
    return temp;
    
}
int getcount(string temp){
    int count=0;
   for(int i=0; i<temp.length(); i++){
       if(temp[i]=='1')
           count++;
   }
    return count;
}

int solution(int n) {
    int answer = 0;
    string temp=getbinary(n);
    int ncount=getcount(temp);
    
    for(int i=n+1; ; i++){
        string binary=getbinary(i);
        int tempcount=getcount(binary);
        if(tempcount==ncount){
            answer=i;
            break;
        }
    }
    return answer;
}