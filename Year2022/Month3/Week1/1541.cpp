#include <iostream>
#include <queue>
//코드개같이못짰다진짜 누가짰냐
using namespace std;


int main() {

	queue<int> number;
	queue<char> expression;

	string input;
	cin >> input;
	
	int before = 0;
	int result;
	int first = 0;

	bool check = false;

	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '-' && check == false) {	//처음 '-'가 나왔을때
			check = true;
		}
		else if(check){	//앞에 -가 한번 나왔을때
			if (input[i] == '+') {	//+가 나오면 괄호쳐줌(괄호친다는건 결국 +가 -로바뀐다는것)
				input[i] = '-';
			}
			else if (input[i] == '-') {
				//check = false;
			}
		}
	}
	
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '+' || input[i]=='-') {
			expression.push(input[i]);
			int mola = 1;
			int num=0;
			if (first == 0) {
				for (int j = i - 1; j >= before; j--) {
					num += (input[j] - '0') * mola;
					mola *= 10;
				}
			}
			else {
				for (int j = i - 1; j > before; j--) {
					num += (input[j] - '0') * mola;
					mola *= 10;
				}
			}
			before = i;
			first++;
			//cout << num << endl;
			number.push(num);
		}
		if (i == input.length() - 1) {
			if (expression.empty()) {
				int mola = 1;
				int num = 0;
				for (int j = i; j >= before; j--) {
					num += (input[j] - '0') * mola;
					mola *= 10;
				}
				before = i;
				first++;
				number.push(num);
				break;
			}

			int mola = 1;
			int num = 0;
			for (int j = i; j > before; j--) {
				num += (input[j] - '0') * mola;
				mola *= 10;
			}
			before = i;
			first++;
			//cout << num << endl;
			number.push(num);
		}
		
	}
	//cout << input;

	result = number.front();
	number.pop();

	while (!number.empty()) {
		int a;
		char c;
		if (!expression.empty()) {
			c = expression.front();
			expression.pop();
		}
		if (c == '+') {
			a = number.front();
			number.pop();
			result += a;
		}
		else if (c == '-') {
			a = number.front();
			number.pop();
			result -= a;
		}
	}

	cout << result;

	return 0;
}