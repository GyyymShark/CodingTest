#include <iostream>
#include <queue>

using namespace std;
int main(void)
{

    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0); 
	priority_queue<int> myp_q;

	int n;
	int num;

	cin >> n;

	int i;
	for (i = 0; i < n; i++)
	{
		cin >> num;
		if (num == 0)
		{
			if (myp_q.empty() == true)
			{
				cout << "0" << "\n";
			}
			else
			{
				cout << myp_q.top() << "\n";
				myp_q.pop();
			}
		}
		else
		{
			myp_q.push(num);
		}
	}
	return 0;
}
