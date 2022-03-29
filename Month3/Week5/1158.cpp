#include <iostream>
#include <queue>

using namespace std;



int main() {
	queue<int> q;
	int n, k;
	cin >> n >> k;

	for (int i = 0; i < n; i++) {
		q.push(i + 1);
	}

	cout << "<";

	while (!q.empty()) {
		for (int i = 0; i < k - 1; i++) {
			int temp = q.front();
			q.pop();
			q.push(temp);
		}

		if (q.size() == 1) {
			cout << q.front();
		}
		else {
			cout << q.front() << ", ";
		}
		q.pop();
	}
	cout << ">";

	return 0;
}