#include <iostream>
#define MAX 1000000
using namespace std;

bool arr[MAX + 1];

void Eratos(int n);
void Goldbach(int n);

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int input = 1;
	Eratos(MAX);
	while (true) {
		cin >> input;
		if (input == 0)
			break;
		Goldbach(input);
	}



	return 0;
}

void Eratos(int n) {


	for (int i = 0; i <= n; i++) {		//ó���� �� �Ҽ���
		arr[i] = true;
	}
	arr[0] = false;
	arr[1] = false;


	for (int i = 2; i * i <= n; i++) {
		if (arr[i]) {	//�Ҽ��̸�
			for (int j = i * i; j <= n; j += i) {
				arr[j] = false;
			}
		}
	}



}

void Goldbach(int n) {
	int max_a = 0, max_b = -1;
	int a, b;


	for (int i = n-3; i >= 2; i--) {

		if (n % 2 != 0)
			break;


		if (arr[i] && i % 2 != 0) {	//�Ҽ��̰� Ȧ���� ���߿�
			b = i;
			a = n - b;	//max_b�� n-max_a�� ����

			if (arr[a] && a % 2 != 0) { //max_b�� �Ҽ��� Ȧ���̸�

				if (b - a > max_b - max_a) { //�����ִ񰪵Ǵ� ���� ����
					max_a = a;
					max_b = b;
				}
				break;
			}
			else {		//a�� Ȧ��&�Ҽ��� ���Ծȵ�
				a = 0;
				b = 0;
			}
		}


	}

	if (max_b - max_a == -1) {
		cout << "Goldbach's conjecture is wrong." << "\n";
	}
	else {
		cout << n << " = " << max_a << " + " << max_b << "\n";
	}
}