#include <iostream>

using namespace std;

int main() {

	int a, b,min,max;
	cin >> a >> b;
	if (a > b)
		min = b;
	else
		min = a;

	for (int i = 1; i <= min; i++) {
		if (a % i == 0 && b % i == 0) {
			max = i;
		}
	}
	cout << max << endl;
	cout << (a / max) * (b / max) * max;


	return 0;
}