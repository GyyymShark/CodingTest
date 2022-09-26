#include <iostream>

using namespace std;

int main(){
int round=2;
int C[4][7]={{1,1,0,1,0,0,0},
    {1,1,1,1,1,1,0},
    {0,0,1,0,0,0,1},
    {0,0,1,0,1,0,0}
    };

    int D[4][7]={{0,0,1,0,0,0,1},
    {0,0,0,1,0,0,1},
    {1,1,1,1,0,1,0},
    {0,1,0,1,1,0,0}
    };

 while(round<=16){
    cout<<"round: "<<round<<"  ";

     int rotate;
    cout<<"rotate:";
    cin>>rotate;



    int C00=C[0][0];
    int C01=C[0][1];
    int D00=D[0][0];
    int D01=D[0][1];

if(rotate==1){          //1만큼 회전
//rotate는 1일때
    for(int i=0; i<4; i++){
        for(int j=0; j<=6; j++){
            if(j==6){       //마지막 열 값 저장
                if(i==3){   //마지막행일때는
                C[i][j]=C00;
                D[i][j]=D00;
                continue;
                }
                C[i][j]=C[i+1][0];
                D[i][j]=D[i+1][0];
                continue;
            }
            C[i][j]=C[i][j+rotate];
            D[i][j]=D[i][j+rotate];
        }
    }
}

else if(rotate==2){     //2만큼회전
//rotate는 1일때
    for(int i=0; i<4; i++){
        for(int j=0; j<=6; j++){
           if(j==5){
             if(i==3){
                C[i][j]=C00;
                D[i][j]=D00;
                continue;
             }
                C[i][j]=C[i+1][0];
                D[i][j]=D[i+1][0];
                continue;
           }
           else if(j==6){
            if(i==3){
                C[i][j]=C01;
                D[i][j]=D01;
                continue;
            }
                C[i][j]=C[i+1][1];
                D[i][j]=D[i+1][1];
                continue;
           }
            C[i][j]=C[i][j+rotate];
            D[i][j]=D[i][j+rotate];
        }
    }
}
  
 for(int i=0; i<4; i++){        //Ci Di 출력
        for(int j=0; j<7; j++){
            cout<<"C["<<i<<"]["<<j<<"]: "<<C[i][j]<<" ";
        }
        cout<<endl;
    }
        cout<<endl;
     for(int i=0; i<4; i++){
        for(int j=0; j<7; j++){
            cout<<"D["<<i<<"]["<<j<<"]: "<<D[i][j]<<" ";
        }
        cout<<endl;
    }

    int PC2[6][8];          //여기서부터 rotate시켜준 C와 D로 PC-2과정 해준다

    PC2[0][0]=C[1][6];
    PC2[0][1]=C[2][2];
    PC2[0][2]=C[1][3];
    PC2[0][3]=C[3][2];
    PC2[0][4]=C[0][0];
    PC2[0][5]=C[0][4];
    PC2[0][6]=C[0][2];
    PC2[0][7]=C[3][6];

    PC2[1][0]=C[2][0];
    PC2[1][1]=C[0][5];
    PC2[1][2]=C[2][6];
    PC2[1][3]=C[1][2];
    PC2[1][4]=C[3][1];
    PC2[1][5]=C[2][4];
    PC2[1][6]=C[1][4];
    PC2[1][7]=C[0][3];

    PC2[2][0]=C[3][4];
    PC2[2][1]=C[1][0];
    PC2[2][2]=C[2][1];
    PC2[2][3]=C[0][6];
    PC2[2][4]=C[3][5];
    PC2[2][5]=C[2][5];
    PC2[2][6]=C[1][5];
    PC2[2][7]=C[0][1];
     
    PC2[3][0]=D[1][5];
    PC2[3][1]=D[3][2];
    PC2[3][2]=D[0][2];
    PC2[3][3]=D[1][1];
    PC2[3][4]=D[2][4];
    PC2[3][5]=D[3][5];
    PC2[3][6]=D[0][1];
    PC2[3][7]=D[1][4];

    PC2[4][0]=D[3][1];
    PC2[4][1]=D[2][2];
    PC2[4][2]=D[0][4];
    PC2[4][3]=D[2][5];
    PC2[4][4]=D[2][1];
    PC2[4][5]=D[2][6];
    PC2[4][6]=D[1][3];
    PC2[4][7]=D[3][6];

    PC2[5][0]=D[0][5];
    PC2[5][1]=D[3][3];
    PC2[5][2]=D[2][3];
    PC2[5][3]=D[1][6];
    PC2[5][4]=D[3][1];
    PC2[5][5]=D[1][0];
    PC2[5][6]=D[0][0];
    PC2[5][7]=D[0][3];

    cout<<endl;

    for(int i=0; i<6; i++){     //PC2출력
        for(int j=0; j<8; j++){
            cout<<"PC2["<<i<<"]["<<j<<"]: "<<PC2[i][j]<<" ";
        }
        cout<<endl;
    }

    round++;
 }


    return 0;
}