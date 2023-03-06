#include <iostream>

using namespace std;


int main() {

	int t;
	cin >> t;
	int a, b,min,max;
	for (int i = 0; i < t; i++) {
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
		cout << (a / max) * (b / max) * max<<endl;
	}

	




}