#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



int main() {
	string input;
	string arr[1001];
	vector<string> s;
	int length;
	cin >> input;
	length = input.length();
	for (int i = 0; i < length; i++) {
		arr[i] = input.substr(i, length);
	}

	for (int i = 0; i < length; i++) {
		s.push_back(arr[i]);
	}

	sort(s.begin(), s.end());


	for (int i = 0; i < length; i++) {
		cout << s[i]<<"\n";
	}




	return 0;
}