#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;     //정답
    for(int i=0; i<id_list.size(); i++){
        answer.push_back(0);
    }
    vector<int> count;  //신고당한 횟수
    vector<pair<string,string>> reportlist; //공백기준으로 신고한사람,신고당한사람 자른 문자열
    int** reportarr=new int*[id_list.size()];   //중복 신고를 확인하기 위한 이차원배열
    for(int i=0; i<id_list.size(); i++){
        reportarr[i]=new int[id_list.size()];
    }
    for(int i=0; i<id_list.size(); i++){
        for(int j=0; j<id_list.size(); j++){
        reportarr[i][j]=0;      //이차원배열할당및 초기화
        }
    }


    
    for(int i=0; i<report.size(); i++){
        string reporter;    //신고한 사람
        string reported;    //신고당한 사람
        bool blankcheck=false;       //공백까지왔는지 체크
      for(int j=0; j<report[i].size(); j++){    //한 string당 공백 찾기
          if(report[i][j]==' '){
                blankcheck=true;
                continue;
            }
          
          if(!blankcheck){
              reporter+=report[i][j];
          }
          else{
              reported+=report[i][j];
          }
      }
        reportlist.push_back(make_pair(reporter,reported)); //신고한사람, 신고당한사람 저장
    }
    
    for(int i=0; i<reportlist.size(); i++){
        int reporteridx,reportedidx;        //reportlist를 이용해 이차원배열에 신고 당한 사람 count세주기
        for(int j=0; j<id_list.size(); j++){
            if(id_list[j]==reportlist[i].first){
                reporteridx=j;
            }
            if(id_list[j]==reportlist[i].second){
                reportedidx=j;
            }
            
        }
        reportarr[reporteridx][reportedidx]++;
    }
    
    for(int i=0; i<id_list.size(); i++){
        int cnt=0;
        for(int j=0; j<id_list.size(); j++){
            if(reportarr[j][i]>0)
                cnt++;                  //반복문 돌며 해당인원 신고당한 횟수 저장
        }
        count.push_back(cnt);
    }
    for(int i=0; i<count.size(); i++){
        cout<<count[i]<<endl;
    }
   
    for(int i=0; i<id_list.size(); i++){       
        for(int j=0; j<id_list.size(); j++){
           int idx=reportarr[i][j];
           if(idx>0){
               if(count[j]>=k){
                   answer[i]++;
               }
           }
        }
    }
    

    
    return answer;
}