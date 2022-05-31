#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string phone_number) {
    string answer = "";
    string star;
    string four;
    for(int i=0; i<phone_number.size()-4; i++){
        star+="*";
    }
    four=phone_number.substr(phone_number.size()-4,phone_number.size());
    answer+=star;
    answer+=four;
    return answer;
}