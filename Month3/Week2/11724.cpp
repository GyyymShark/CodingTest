#include <iostream>
#include <vector>
#include <algorithm>
#define MAX 1001
using namespace std;
bool component = false;

int visited[MAX];
int count = 0;

void initialize(int n) {
	for(int i = 1; i <= n; i++) {
		visited[i] = false;
	}
}


void dfs(vector<int> graph[], int start) {
	bool check = false;
	

	if (!visited[start]) {
		visited[start] = true;
		component = true;
	}
	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];

		if (!visited[next]) {
			check = true;
			component = true;
			visited[next] = true;
			dfs(graph, next);
		}
	}

	if (!check) {
		return;
	}

}

int main() {
	int n, m,count=0;
	
	cin >> n >> m;
	vector<int>* graph = new vector<int>[n+1];

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	initialize(n);

	for (int i = 1; i <= n; i++) {
		component = false;
		dfs(graph, i);
		if (component)
			count++;
	}
	

	cout << count;



	return 0;
}