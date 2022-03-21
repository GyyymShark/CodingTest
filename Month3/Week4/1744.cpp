#include <iostream>
#include <vector>
#include <algorithm>


#define MAX(a,b) a>b ? a : b

using namespace std;

bool cmp(int a, int b) {
	return a > b;
}

int main() {
	int n;
	long long int count = 0;
	cin >> n;
	vector<int> plus;
	vector<int> zero;
	vector<int> minus;

	


	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		if (temp == 0) {
			zero.push_back(temp);
		}
		else if (temp > 0) {
			plus.push_back(temp);
		}
		else {
			minus.push_back(temp);
		}
	}

	
	sort(minus.begin(), minus.end());
	sort(plus.begin(), plus.end(),cmp);

	/*for (int i = 0; i < plus.size(); i++) {
		cout << "plus" << endl;
		cout << plus[i] << endl;
	}
	for (int i = 0; i < minus.size(); i++) {
		cout << "minus" << endl;
		cout << minus[i] << endl;
	}
	for (int i = 0; i < zero.size(); i++) {
		cout << "zero" << endl;
		cout << zero[i] << endl;
	}
	*/

	while (true) {
		if (plus.size() >= 2) {
			int prod, sum,max;
			sum = plus[0] + plus[1];
			prod = plus[0] * plus[1];
			max = MAX(sum, prod);
			count += max;
			plus.erase(plus.begin());
			plus.erase(plus.begin());
		}
		if (minus.size() >= 2) {
			int prod = minus[0] * minus[1];
			count += prod;
			minus.erase(minus.begin());
			minus.erase(minus.begin());
		}

		if (minus.empty() && plus.empty())
			break;
		
		if (plus.size() <= 1 && minus.size() <= 1) {
			bool plusfull = !plus.empty();
			bool minusfull = !minus.empty();
			bool zerofull = !zero.empty();

			//case1 plus o zero x minus x
			//case2 plus x zero x minus o	o가 하나인 경우
			//case3 plus x zero 0 minus x
			//case4 plus o zero o minus x   o가 두개인 경우
			//case5 plus o zero x minus o
			//caes6 plus x zero o minus o
			//case7 plus o zero o minus o	//o가 세개나 0개인경우
			//case8 plus x zero x minus x


			if (plusfull && !zerofull && !minusfull) {
				count += plus[0];
				plus.erase(plus.begin());
			}
			else if (!plusfull && !zerofull && minusfull) {
				count += minus[0];
				minus.erase(minus.begin());
			}
			else if (!plusfull && zerofull && !minusfull) {
				//
			}

			else if (plusfull && zerofull && !minusfull) {
				count += plus[0];
				plus.erase(plus.begin());
			}

			else if (plusfull && !zerofull && minusfull) {
				count += plus[0] + minus[0];
				plus.erase(plus.begin());
				minus.erase(minus.begin());
			}

			else if (!plusfull && zerofull && minusfull) {
				count += minus[0] * 0;
				minus.erase(minus.begin());
			}

			else if (plusfull && zerofull && minusfull) {
				count += (0 * minus[0]) + plus[0];
				plus.erase(plus.begin());
				minus.erase(minus.begin());
			}

			else if (!plusfull && !zerofull && !minusfull) {
				//
			}

		}

	}


	cout << count;

	return 0;
}