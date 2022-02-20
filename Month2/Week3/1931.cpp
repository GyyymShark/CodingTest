#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


bool cmp(pair<int, int> start ,pair<int,int> end);

int main() {
	vector<pair<int, int>> time;
	int n,start,end,count=0,room;
	cin>>n;

	for (int i = 0; i < n; i++) {
		cin >> start>>end;
		time.push_back(make_pair(start, end));
	}
	sort(time.begin(),time.end(),cmp);

	
	room = 0;
	count++;

	for (int i = 1; i < n; i++) {
		if (time[room].second <= time[i].first) {
			room = i;
			count++;
		}
	}
	
	cout << count;
	
}

bool cmp(pair<int, int> start, pair<int, int> end) {


	if (start.second == end.second) {
		return start.first < end.first;
	}
	else {
	return start.second < end.second;
	}
}