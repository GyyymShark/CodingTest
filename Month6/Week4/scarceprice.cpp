using namespace std;

long long solution(int price, int money, int count)
{
    long int answer = 0;
    long int sum=0;
    for(int i=count; i>=1; i--)
    {
        sum+=i*price;
    }
    
    if(sum>money){
        answer=sum-money;
    }
    
    return answer;
}