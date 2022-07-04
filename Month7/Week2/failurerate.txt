#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


bool cmp(pair<int,double> & a, pair<int,double> &b){
    if(a.second==b.second){
        return a.first<b.first;
    }
    
    return a.second>b.second;
}

vector<int> solution(int N, vector<int> stages) {
    double failure;
    vector<int> answer;
    vector<pair<int,double>> result;
    

    
    for(int j=1; j<=N; j++){
        int challenging=0, clear=0;
        for(int i=0; i<stages.size(); i++){
            if(stages[i]>=j){
                if(stages[i]==j){
                    clear++;
                    challenging++;
                }
                else
                clear++;
            }
        }
        
        if(clear==0){
            failure=0.0;
        }
        else{
            failure=(double)challenging/clear;
        }
        result.push_back(make_pair(j,failure));
    }
    sort(result.begin(),result.end(),cmp);
    
    for(int i=0; i<result.size(); i++){
        cout<<result[i].first<<' '<<result[i].second<<endl;
        answer.push_back(result[i].first);
    }
    return answer;
}