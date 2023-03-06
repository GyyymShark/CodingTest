#include <iostream>
#include <stack>

using namespace std;

int main() {
	int n,input,sum=0;
	cin >> n;
	stack<int> s;
	for (int i = 0; i < n; i++) {
		cin >> input;
		if (input == 0)
			s.pop();
		else
			s.push(input);
	}
	while (!s.empty()) {
		sum += s.top();
		s.pop();
	}
	cout << sum;
}