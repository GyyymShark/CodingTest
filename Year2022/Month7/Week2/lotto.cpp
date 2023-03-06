#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int list[]={6,6,5,4,3,2,1};
    sort(lottos.begin(),lottos.end());
    sort(win_nums.begin(),win_nums.end());
    int zerocount=0,samecount=0;
    for(int i=0; i<lottos.size(); i++){
        if(lottos[i]==0){
            zerocount++;
        }
        else{
            for(int j=0; j<win_nums.size(); j++){
                if(lottos[i]==win_nums[j])
                    samecount++;
            }
        }
    }

    answer.push_back(list[zerocount+samecount]);
    answer.push_back(list[samecount]);
    
    return answer;
}