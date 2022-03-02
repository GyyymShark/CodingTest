#include <iostream>
#include <queue>

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
		if (input[i] == '-' && check == false) {	//ó�� '-'�� ��������
			check = true;
		}
		else if(check){	//�տ� -�� �ѹ� ��������
			if (input[i] == '+') {	//+�� ������ ��ȣ����(��ȣģ�ٴ°� �ᱹ +�� -�ιٲ�ٴ°�)
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