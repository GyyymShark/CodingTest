#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAX 101
using namespace std;

int visited[MAX];
queue<int> q;

void initialize(int n) {
	for(int i = 1; i <= n; i++) {
		visited[i] = false;
	}
}

int bfs(vector<int> graph[], int start) {
	int count = 0;
	q.push(start);
	visited[start] = true;
	

	while (!q.empty()) {
		int current = q.front();
		q.pop();
		for (int i = 0; i < graph[current].size(); i++) {
			int next = graph[current][i];
			if (!visited[next]) {
				q.push(next);
				visited[next] = true;
				count++;
			}
		}
	}
	return count;
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
	initialize(n);
	count=bfs(graph, 1);
	

	cout << count;



	return 0;
}