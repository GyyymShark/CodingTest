#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define MAX 1001
using namespace std;

bool visited[MAX];

void initialize(int n) {
	for (int i = 1; i <= n; i++) {
		visited[i] = false;
	}
}

void dfs(int current, vector<int> graph[]) {
	
	bool check = false;

	for (int i = 0; i < graph[current].size(); i++) {
		int next = graph[current][i];
		if (!visited[next]) {	//방문안했으면
			visited[next] = true;
			dfs(next, graph);
			check = true;
		}
	}
	if (!check)
		return;
}



int main() {

	int N, M,count=0;
	cin >> N >> M;

	vector<int>* graph = new vector<int>[N + 1];

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
	}
	for (int i = 1; i <= N; i++) {
		sort(graph[i].begin(), graph[i].end());
	}
	initialize(N);
	visited[1] = true;
	dfs(1, graph);
	
	for (int i = 1; i <= N; i++) {
		if (visited[i])
			count++;
	}
	cout << count-1;
	

	return 0;
}