#include <stdio.h>

//2057

unsigned long long factorial(int i);

int main() {
	unsigned long long factn = 0;			//팩토리얼 합으로 구한 값
	int fact_arr_check[21] = { 0 };
	unsigned long long n;				//입력받을 수
	int i = 21;
	int result = 0;		//result=0이면 yes result=1이면 no
	unsigned long long fact_arr[21];	//0~20팩토리얼 값 저장해놓을 배열
	int escape = 0;		//escape 1이면 탈출 0이면 탈출 못함
	scanf("%lld", &n);

	if (n == 0)		//입력받은게 0이면 result=1	
		result = 1;

	for (int i = 0; i < 21; i++) {		//팩토리얼 값 입력
		fact_arr[i] = factorial(i);
	}
	factn = n;		//n값 factn에 대입

	while (1) {	//n과 factn이 같으면 탈출
		if (factn == 0)
			break;




		for (int j = 0; j <= i; j++)
		{
			if (factn < fact_arr[j]) {	//factn에 가장가까운 팩토리얼 수를 빼줌
				i = j - 1;
				factn = factn - fact_arr[j - 1];
				break;
			}

			else if (factn == fact_arr[j]) {	//factn과 같은 팩토리얼 수가 있어도 빼줌
				i = j - 1;
				factn = factn - fact_arr[j];
				break;
			}




			if (factn > fact_arr[20]) {			//문제에서 주어진수는 20!를 넘길일은 없지만 혹시나해서 넣어둠
				factn = factn - fact_arr[20];
			}


			if (factn > fact_arr[i - 1])// 5가들어왔을떄를 예로 들자 
									 //	근접한 팩토리얼 수 2를뺴면 factn=3이되는데 이때는 factn이 0! 1!보다 크므로
			{
				unsigned long long sum = 0;
				for (j; j < i; j++) {
					sum += fact_arr[j];	//0!과 1!을 더해준다.
				}

				if (sum >= factn) {			//만약 factn이 4가들어왔으면 factn=2일것이고 sum=2이므로 팩토리얼의 합으로 나타낼 수 있다.
					factn = 0;
					break;
				}

				else                       //factn이 3인데 sum이 2이므로  얘는 팩토리얼의 합으로 구할 수 없는 수 이다.
					escape = 1;

			}
		}



		if (escape == 1)
			break;
		if (factn == 0)
			break;

	}

	if (factn == 0) {
		if (result == 1) {	//0이들어왔을때
			printf("NO");
		}

		else {
			printf("YES");
		}
	}

	else
	{
		if (escape == 1)
		{
			printf("NO");
		}
	}


	return 0;
}


unsigned long long factorial(int i) {


	if (i == 0)
		return 1;

	else
		return i * factorial(i - 1);






}