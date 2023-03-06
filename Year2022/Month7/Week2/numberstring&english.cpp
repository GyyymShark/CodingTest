#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    string list[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    string answer;
    int result;
    string temp;
    for(int i=0; i<s.length(); i++){
        if(s[i]>59){    //문자면
            temp+=s[i];     //temp에 값을 차곡차곡 쌓음
            for(int j=0; j<=9; j++){    //그리고 항상 검사를 해줌
                if(list[j]==temp){  //만약 같은 문자를 찾았으면
                    answer+=j+48;  //answer에 숫자 추가
                    temp="";    //temp 널로 초기화
                }
            }
            
        }
        else{       //숫자면
            answer+=s[i];       //그대로 answer에 추가
        }
    }
    result= stoi(answer);
    return result;
}