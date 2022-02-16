#include <iostream>
#include <stack>
#include <vector>
#define MAX 1000001
using namespace std;

int arr[MAX];

int main() {
	ios_base::sync_with_stdio(false);
	int n,temp,max=-9999;
	cin >> n;
	vector<int> list;
	vector<int> ans(n, -1);
	stack<pair<int, int>> s;	//첫번쨰원소 인덱스, 두번쨰원소 count

	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp > max)
			max = temp;
		arr[temp]++;
		list.push_back(temp);
	}

	
	
	for (int i = 0; i < n; i++) {

		while (!s.empty() && arr[s.top().second] < arr[list[i]]) {
			ans[s.top().first] = list[i];
			s.pop();
		}

		s.push({i,list[i]});
	}

	for (int i = 0; i < n; i++) {
		cout << ans[i] << " ";
	}
}