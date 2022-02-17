#include <iostream>

using namespace std;


int main() {
	int n,count=0,divide=5,copydivide;
	cin >> n;
	
	while (n>=divide) {
		
		copydivide = divide;
		divide += 5;

		copydivide /= 5;
		count++;

		while (copydivide !=0) {
			if (copydivide % 5 == 0) {
				count++;
				copydivide /= 5;
			}
			else
				break;
		}
	}
	cout << count;

}