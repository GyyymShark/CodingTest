#include <iostream>
#include <deque>

using namespace std;



int FindMin(deque<int>& dq, int temp) {
	int idx,value,count=0;


	if (dq.front() == temp) {
		dq.pop_front();
		return count;
	}

	else {

		for (int i = 0; i < dq.size(); i++) {
			if (dq[i] == temp)
			{
				idx = i;
				value = dq[idx];
				break;
			}
		}

		if (idx <= dq.size() / 2) {	//2번연산
			while (dq.front() != value) {
				int temp = dq.front();
				dq.pop_front();
				dq.push_back(temp);
				count++;
			}
		}
		else {	//3번연산
			while (dq.front() != value) {
				int temp = dq.back();
				dq.pop_back();
				dq.push_front(temp);
				count++;
			}

		}


		dq.pop_front();
		return count;
	}


}

int main() {
	int n, m,count=0;
	cin >> n >> m;
	deque<int> dq;

	for (int i = 0; i < n; i++) {
		dq.push_back(i + 1);
	}

	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;
		temp = FindMin(dq, temp);
		count += temp;
	}

	cout << count;

	return 0;
}