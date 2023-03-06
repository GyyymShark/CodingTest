#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> nums) {
    int answer = 0;
    

    for(int i=0; i<nums.size()-2; i++){
        for(int k=i+1; k<nums.size()-1; k++){
            for(int j=k+1; j<nums.size(); j++){
                int temp=nums[i]+nums[k]+nums[j];
                int count=0;
                for(int l=2; l<temp; l++){
                    if(temp%l==0)
                    {
                        count++;
                        break;
                    }
                }
                if(count==0){
                    answer++;
                }
            }
        }
    }
  
    return answer;
}