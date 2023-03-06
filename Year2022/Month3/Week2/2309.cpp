#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool visited[9];

void initialize(int i, int j) {
	
		visited[i] = false;
		visited[j] = false; 
	
}

int SUM(vector<int> v, int a, int b) {
	int count = 0;

	for (int i = 0; i < v.size(); i++) {
		if (i == a || i == b)
			continue;
		count += v[i];
	}
	return count;
}

int main() {
	vector<int> v;
	int count;
	bool check = false;

	for (int i = 0; i < 9; i++) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	cout << v.size();

	for (int i = 0; i < v.size(); i++) {
		if (check)
			break;
		for (int j = i+1; j < v.size(); j++) {
			if (i == 4 && j == 8) {
				cout << "hey";
			}

			visited[i] = true;
			visited[j] = true;
			count=SUM(v, i, j);
			if (count == 100) {
				check = true;
				break;
			}
			initialize(i,j);
		}
	}


	cout << "check=" << check << endl;

	for (int i = 0; i < v.size(); i++) {
		if (!visited[i])
			cout << v[i] << "\n";
	}



	return 0;
}