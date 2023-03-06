#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#define MAX 1001

using namespace std;

stack<int> s;
queue<int> q;
bool visited[MAX];


void initialize(int N) {
	for (int i = 0; i <= N; i++) {
		visited[i] = false;
	}
}

void dfs(vector<int> graph[], int start) {
	visited[start] = true;
	s.push(start);
	cout << start << " ";
	int current, next;

	while (!s.empty()) {
		bool visitcheck = false;
		current = s.top();

		for (int i = 0; i < graph[current].size(); i++) {
			next = graph[current][i];

			if (!visited[next]) {	//방문안했을 노드에 대해서
				visitcheck = true;
				s.push(next);
				visited[next] = true;
				cout << next << " ";
				break;
			}
		}
		if (!visitcheck) {	//방문하지 않은 next가 없으면
			s.pop();
		}
	}
	cout << "\n";
}

void bfs(vector<int> graph[], int start) {
	visited[start] = true;
	q.push(start);
	int current, next;
	while (!q.empty()) {
		current = q.front();
		q.pop();
		cout << current << " ";

		for (int i = 0; i < graph[current].size(); i++) {
			next = graph[current][i];
			if (!visited[next]) {
				q.push(next);
				visited[next] = true;
			}
		}
		
	}

	cout << "\n";
}

int main() {
	int N, M, V;

	cin >> N >> M >> V;

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
	dfs(graph, V);


	initialize(N);
	bfs(graph, V);

	return 0;
}
