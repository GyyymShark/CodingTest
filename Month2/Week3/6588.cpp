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


	for (int i = 0; i <= n; i++) {		//처음엔 다 소수로
		arr[i] = true;
	}
	arr[0] = false;
	arr[1] = false;


	for (int i = 2; i * i <= n; i++) {
		if (arr[i]) {	//소수이면
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


		if (arr[i] && i % 2 != 0) {	//소수이고 홀수인 수중에
			b = i;
			a = n - b;	//max_b는 n-max_a로 가정

			if (arr[a] && a % 2 != 0) { //max_b도 소수고 홀수이면

				if (b - a > max_b - max_a) { //차가최댓값되는 값만 저장
					max_a = a;
					max_b = b;
				}
				break;
			}
			else {		//a만 홀수&소수면 포함안됨
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