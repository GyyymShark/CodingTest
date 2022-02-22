#include <iostream>
#include <math.h>

using namespace std;

int GCD(int, int);

int main() {

	int n, d,temp,fgap,sgap=0;
	cin >> n >> d;

	for (int i = 0; i < n; i++) {
		cin >> temp;
		fgap = abs(temp - d);

		sgap=GCD(fgap, sgap);
	}
	cout << sgap;




	return 0;
}

int GCD(int a, int b) {
	if (b == 0)
		return a;
	else {
		return GCD(b, a % b);
	}
}