#include <string>
#include <vector>
#include <math.h>
#include <iostream>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    int** matrix=new int*[n];
    for(int i=0; i<n; i++){
        matrix[i]=new int[n];
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            matrix[i][j]=0;
        }
    }
    
    for(int j=0; j<n; j++){
        int temp=arr1[j];
        int count1=0;
        for(int i=(int)pow(2,n-1); i>=1; i=i/2){
            if(temp/i>=1){
                matrix[j][count1]=1;
                temp=temp%i;
            }
            count1++;
        }
    }
    
     for(int j=0; j<n; j++){
        int temp=arr2[j];
        int count2=0;
        for(int i=(int)pow(2,n-1); i>=1; i=i/2){
            if(temp/i>=1){
                matrix[j][count2]=1;
                temp=temp%i;
            }
            count2++;
        }
    }
    
    for(int i=0; i<n; i++){
        string temp;
        for(int j=0; j<n; j++){
            if(matrix[i][j]==1){
                temp+='#';
            }
            else{
                temp+=' ';
            }
        }
        answer.push_back(temp);
    }
    
    
    return answer;
}