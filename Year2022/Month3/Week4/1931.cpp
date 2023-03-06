#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


bool cmp(pair<int,int>& a, pair<int,int>& b) {

	if (a.second == b.second) {
		return a.first < b.first;
	}

	return a.second < b.second;
}

int main() {
	int n;
	cin >> n;
	vector<pair<int,int>> v;

	for (int i = 0; i < n; i++) {
		int start, end;
		cin >> start >> end;
		v.push_back({ start,end });
	}

	/*
	vector<int> v;
	sort(v.begin(), v.end(),cmp)
	bool cmp(int a,int b){ 
	return a<b;
	}

	*/

	sort(v.begin(), v.end(), cmp);
	int start = v[0].first;
	int end = v[0].second;
	int count = 0;
	count++;
	for (int i = 1; i < n; i++) {
		if (end < v[i].first) {
			start = v[i].first;
			end = v[i].second;
			count++;
			}
	}
	cout << count;


	return 0;
}