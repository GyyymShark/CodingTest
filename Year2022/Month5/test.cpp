#include <iostream>

using namespace std;

int main(){
    int t;
    cin>>t;
    for(int i=1; i<=t; i++){
        //string stime,etime;     //00:59:58 01:20:34
        //cin>>stime>>etime;
        int count=0;
        int stime,etime;
        cin>>stime>>etime;

        while(true){
            if(stime==etime){
                break;
            }
            stime=(stime+1)%60;
            if(stime)//5958  %6
        230000

        }
        
    }



    return 0;
}