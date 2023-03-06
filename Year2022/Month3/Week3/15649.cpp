#include <iostream>
#define MAX 10
bool visited[MAX];
int arr[MAX];
int store[MAX];
using namespace std;


void dfs(int cur, int n,int m) {
	if (cur == m) {
		for (int i = 1; i <= m; i++) {
			cout << store[i] << " ";
		}
		cout << "\n";
		return;
	}
	else {
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				store[cur + 1] = arr[i];
				dfs(cur + 1, n, m);
				visited[i] = false;
			}
		}
	}


}
int main() {

	int n, m;
	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		arr[i] = i;
	}

	dfs(0,n,m);

	return 0;
}