#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> temp;
    vector<int> answer;
    
    for(int i=0; i<commands.size(); i++){ 
        int I=commands[i][0];
        int J=commands[i][1];
        int K=commands[i][2];
        
        for(int j=I-1; j<J; j++){ 
        temp.push_back(array[j]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[K-1]);
        temp.clear();
    }
    
    
    return answer;
}