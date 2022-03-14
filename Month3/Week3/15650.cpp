#include <iostream>
#define MAX 22
using namespace std;

int arr[MAX];
int store[MAX];
bool visited[MAX];

int Count = 0;


void dfs(int cur,int len, int n,int curidx) {
	if (cur == len) {
		int sum = 0;
		for (int i = 0; i < len; i++) {
			cout << store[i] << " ";
			
		}
		cout << "\n";
		return;
	}

	else {
		for (int i = 0; i < n; i++) {
			if (!visited[i] && i>=curidx) {
				visited[i] = true;
				store[cur] = arr[i];
				dfs(cur+1, len, n,i);
				visited[i] = false;
			}
		}
	}
}

void initialize(int n) {
	for (int i = 0; i < n; i++) {
		visited[i] = false;
	}
}

int main() {
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		arr[i] = i + 1;
	}
	
		initialize(n);
		dfs(0, m, n,0);
	


	return 0;
}