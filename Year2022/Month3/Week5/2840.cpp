#include <iostream>
#include <deque>

using namespace std;


int main() {
	bool answer = true;
	int n, k;
	cin >> n >> k;

	deque<char> dq;

	for (int i = 0; i < n; i++) {
		dq.push_back('?');
	}






	for (int i = 0; i < k; i++) {
		int rotate;
		char c, temp;
		cin >> rotate >> c;


		for (int j = 0; j < rotate; j++) {
			temp = dq.front();
			dq.pop_front();
			dq.push_back(temp);
		}

		if (dq.front() != '?') {	//글자 삽입하려하는데 이미 입력이 되어있을때
			
			if (c != dq.front()) {		//그 입력된 수가 지금 입력하려는 수와 다르면
				answer = false;						//행운의바퀴가아니다
				break;
			}

		}

		else {
			dq[0] = c;
		}

	}

	if (answer) {

		for (int i = 0; i < n; i++) {		//중복 알파벳 유무 검사
			for (int j = i + 1; j < n; j++) {
				if (dq[i] == dq[j]) {	//같은게 있다
					if (dq[i] != '?')	//근데 그게 ?가 아니다?
					{
						cout << "!";		//그럼 그땐 내가 마 깡패가되는거야!
						return 0;
					}
				}
			}
		}





		while (true) {
			
			char temp;
			cout << dq.front();
			dq.pop_front();
			if (dq.empty())
				break;

			temp = dq.back();
			dq.pop_back();
			dq.push_front(temp);
		}
	}
	else {
		cout << "!";
	}



	return 0;
}