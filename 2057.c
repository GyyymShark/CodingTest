#include <stdio.h>

//2057

unsigned long long factorial(int i);

int main() {
	unsigned long long factn = 0;			//���丮�� ������ ���� ��
	int fact_arr_check[21] = { 0 };
	unsigned long long n;				//�Է¹��� ��
	int i = 21;
	int result = 0;		//result=0�̸� yes result=1�̸� no
	unsigned long long fact_arr[21];	//0~20���丮�� �� �����س��� �迭
	int escape = 0;		//escape 1�̸� Ż�� 0�̸� Ż�� ����
	scanf("%lld", &n);

	if (n == 0)		//�Է¹����� 0�̸� result=1	
		result = 1;

	for (int i = 0; i < 21; i++) {		//���丮�� �� �Է�
		fact_arr[i] = factorial(i);
	}
	factn = n;		//n�� factn�� ����

	while (1) {	//n�� factn�� ������ Ż��
		if (factn == 0)
			break;




		for (int j = 0; j <= i; j++)
		{
			if (factn < fact_arr[j]) {	//factn�� ���尡��� ���丮�� ���� ����
				i = j - 1;
				factn = factn - fact_arr[j - 1];
				break;
			}

			else if (factn == fact_arr[j]) {	//factn�� ���� ���丮�� ���� �־ ����
				i = j - 1;
				factn = factn - fact_arr[j];
				break;
			}




			if (factn > fact_arr[20]) {			//�������� �־������� 20!�� �ѱ����� ������ Ȥ�ó��ؼ� �־��
				factn = factn - fact_arr[20];
			}


			if (factn > fact_arr[i - 1])// 5������������ ���� ���� 
									 //	������ ���丮�� �� 2������ factn=3�̵Ǵµ� �̶��� factn�� 0! 1!���� ũ�Ƿ�
			{
				unsigned long long sum = 0;
				for (j; j < i; j++) {
					sum += fact_arr[j];	//0!�� 1!�� �����ش�.
				}

				if (sum >= factn) {			//���� factn�� 4���������� factn=2�ϰ��̰� sum=2�̹Ƿ� ���丮���� ������ ��Ÿ�� �� �ִ�.
					factn = 0;
					break;
				}

				else                       //factn�� 3�ε� sum�� 2�̹Ƿ�  ��� ���丮���� ������ ���� �� ���� �� �̴�.
					escape = 1;

			}
		}



		if (escape == 1)
			break;
		if (factn == 0)
			break;

	}

	if (factn == 0) {
		if (result == 1) {	//0�̵�������
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