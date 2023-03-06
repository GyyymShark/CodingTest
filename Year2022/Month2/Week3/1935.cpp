#include <stack>
#include <vector>
#include <iostream>
#include <string>

using namespace std; //

int main() {
	ios_base::sync_with_stdio(false);
	
	int alphabet[26] = { 0 };
	string str;
	int n,j=0,temp;
	cin >> n;
	cin >> str;
	stack<double> s;	//스택
	double result = 0.0;
	double a, b;
	
	for (int i=0; i<n; i++){
			//피연산자 입력
		cin >> temp;
		alphabet[i] = temp;
	}

	for (int i = 0; i < str.length(); i++) {
		if (0 <= str[i] - 'A' && str[i] - 'A' <= 25) {	//피연산자 일때
			s.push((double)alphabet[str[i]-'A']);
		}
		else {	//연산자 일때	pop두번
			b = s.top();
			s.pop();
			a = s.top();
			s.pop();
			
			switch (str[i]) {
			case '+': {
				result = a + b;
				break;
			}
			
			case '-': {
				result = a - b;
				break;
			}
			case '*': {
				result = a * b;
				break;
			}
			case '/': {
				result = a / b;
				break;
			}
					
			}
			
			s.push(result);
		}
	}
	

	result = s.top();
	cout << fixed;
	cout.precision(2);
	cout << result;


	return 0;
}