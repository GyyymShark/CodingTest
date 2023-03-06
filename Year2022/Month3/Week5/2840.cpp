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

		if (dq.front() != '?') {	//���� �����Ϸ��ϴµ� �̹� �Է��� �Ǿ�������
			
			if (c != dq.front()) {		//�� �Էµ� ���� ���� �Է��Ϸ��� ���� �ٸ���
				answer = false;						//����ǹ������ƴϴ�
				break;
			}

		}

		else {
			dq[0] = c;
		}

	}

	if (answer) {

		for (int i = 0; i < n; i++) {		//�ߺ� ���ĺ� ���� �˻�
			for (int j = i + 1; j < n; j++) {
				if (dq[i] == dq[j]) {	//������ �ִ�
					if (dq[i] != '?')	//�ٵ� �װ� ?�� �ƴϴ�?
					{
						cout << "!";		//�׷� �׶� ���� �� ���а��Ǵ°ž�!
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