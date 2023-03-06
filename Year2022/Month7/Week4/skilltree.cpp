#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    for(int i=0; i<skill_trees.size(); i++){
        string temp=skill_trees[i]; //skill_trees 한 문자열씩 가능한지 체크하기위한 변수
        string check;
        bool realcheck=true;
        int comp=0;
        for(int k=0; k<temp.length(); k++){ //한 문자열을 한 문자씩 체크한다
             for(int j=0; j<skill.length(); j++){   //주어진 순서와 비교한다
            if(temp[k]==skill[j]){  //temp와 skill을 비교해 순서를
                check+=skill[j];    //check에 담는다
            }
        }
        }
        //check가 가능한 스킬트리인지 검증하는 단계
        cout<<check<<endl;
          
        for(int i=0; i<check.length(); i++){
            if(check[0]!=skill[0]){ //첫 스킬트리를 배우지 않았으면
                realcheck=false;
                break;
            }
            if(skill[i]==check[i]){
                realcheck=true;
            }
            else{
                realcheck=false;
                break;
            }
        }
       
       if(realcheck){
           answer++;
       }
    }
    return answer;
}