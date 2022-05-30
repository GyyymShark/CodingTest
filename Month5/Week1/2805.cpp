#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	vector<int> tree;
	int n, m;
	long long int treelen = 0;
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		int temp; cin >> temp;
		tree.push_back(temp);
	}
	sort(tree.begin(), tree.end());

	int left = 0;
	int right = tree[tree.size() - 1];
	int result = 0;

	while (left <= right) {
		int middle = (left + right) / 2;
		treelen = 0;

		for (int i = 0; i < tree.size(); i++) {
			if (tree[i] > middle) {
				treelen += tree[i] - middle;
			}
		}

		if (treelen < m) {	//treelen을 증가시켜야한다
							//middle이 작아져야한다
			right = middle - 1;
		}
		else {		//middle이 커져야한다
			result = middle;
			left = middle + 1;
		}
	}

	cout << result;
}