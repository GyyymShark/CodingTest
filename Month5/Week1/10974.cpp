#include <iostream>
#include <vector>
#define MAX 10
using namespace std;

bool visited[MAX];
int printstack[MAX];
int printidx = 0;

void Print(int n) {
	for (int i = 1; i <= n; i++) {
		cout << printstack[i] << " ";
	}
	cout << "\n";
	printidx = 0;
}

void dfs(vector<int> v, int n,int cur) {
	if (n==cur) {
		Print(n);
		return;
	}

	bool visitcheck = false;
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			printstack[cur+1] = i;
			dfs(v, n,cur+1);
			visited[i] = false;
		}
		
	}

	

	

}

int main() {
	int n;
	cin >> n;
	vector<int> v;

	for (int i = 0; i < n; i++) {
		v.push_back(i + 1);
	}

	

	dfs(v, n,0);



	return 0;
}