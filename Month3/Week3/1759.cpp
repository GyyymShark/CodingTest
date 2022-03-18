#include <iostream>
#include <algorithm>

#define MAX 20

using namespace std;
int Count = 0;
char arr[MAX];
bool visited[MAX];

void password(int cur, int L, int C, string str,int prev) {
	if (cur == L) {
		int vowel=0;		//모음
		int consonant=0;	//자음
		for (int i = 0; i < L; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vowel++;
			}
			else {
				consonant++;
			}

			
		}
		if (vowel >= 1 && consonant >= 2) {
			for (int i = 0; i < L; i++) {
				cout << arr[i];
			}
		}
		else {
			return;
		}
		cout << "\n";
		
		return;
	}


	else {

		for (int i = 0; i < C; i++) {

			if (!visited[i] && prev<i) {
				arr[cur] = str[i];
				visited[i] = true;
				password(cur + 1, L, C, str, i);
				visited[i] = false;
			}
		}
	}
}


int main() {

	string str;
	int L, C;

	cin >> L >> C;

	for (int i = 0; i < C; i++) {
		char c;
		cin >> c;
		str += c;
	}
	
	sort(str.begin(), str.end());
	//cout << str<<endl;
	
		password(0, L, C, str,-1);
	

	return 0;
}