#include <iostream>

using namespace std;


void Plus(int n, int dp[]);

int main() {
	int dp[12];
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	Plus(4, dp);

	int t;
	cin >> t;
	
	for (int i = 0; i < t; i++) {
		int n;
		cin >> n;
		cout << dp[n]<<endl;
	}
	
	


	return 0;
}

void Plus(int n, int dp[]) {
	if (n == 12) {
		return;
	}
	else {
		dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
		Plus(n + 1, dp);
	}
}