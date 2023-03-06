#include <iostream>
#include <deque>
#define MAX 1001

using namespace std;

int arr[MAX];		//1~n

int main() {
	int n;
	cin >> n;

	deque<int> dq;

	for (int i = 0; i < n; i++) {
		dq.push_back(i + 1);
	}

	for (int i = 1; i <= n; i++) {
		int temp;
		cin >> temp;
		arr[i] = temp;
	}

	int temp,idx;
	temp = dq.front();
	dq.pop_front();
	idx = arr[temp];
	cout << temp<<" ";

	while (!dq.empty()) {
		if (idx > 0) {	//양수면  pop front, push back
			for (int i = 0; i < idx-1; i++) {
				temp = dq.front();
				dq.pop_front();
				dq.push_back(temp);
			}

			temp = dq.front();
			idx = arr[temp];
			dq.pop_front();
			cout << temp<<" ";

		}
		else {	//음수면 pop back, push front

			for (int i = idx; i < 0; i++) {
				temp = dq.back();
				dq.pop_back();
				dq.push_front(temp);
			}

			temp = dq.front();
			idx = arr[temp];
			dq.pop_front();
			cout << temp<<" ";
		}

		//if(dq.size()>=1)
		//idx = arr[dq.front()];
	}
	







	return 0;
}