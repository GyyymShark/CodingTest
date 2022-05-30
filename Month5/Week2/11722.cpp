#include <iostream>
#define MAX 1001
using namespace std;

int arr[MAX];
int count[MAX];
int previdx[MAX];

int main(){

    int maxindex,maxval=0,result=0;
    int n;
    cin>>n;
    for(int i=0; i<n; i++){ //수열 입력받기
        cin>>arr[i];
    }

  

  
    

    for(int i=0; i<n; i++){      
        for(int j=i+1; j<n; j++){
          
                if(arr[i]>arr[j]){  //만약 현재보다 작은 값을 발견했을때
                    if(count[i]+1>count[j]){        // 더 길어질수 있으면
                        count[j]=count[i]+1;    //count[j]값을 count[i]+1로 해주고
                        previdx[j]=i;           //previdx[j]를 i값으로 해준다
                    }
                }
            

                
            
        }
    }

    for(int i=0; i<n; i++){
       if(result<count[i]){
           result=count[i];
       }
    }

    cout<<result+1;

    return 0;
}