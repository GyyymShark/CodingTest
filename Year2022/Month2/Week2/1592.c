#include <stdio.h>

//1592

int main() {
	int i = 1;
	int count = 0;
	int n, m, l;		//n은 자리 m번받으면 끝 l번째있는사람에게줌
	scanf("%d %d %d", &n, &m, &l);
	int* array = (int*)malloc(sizeof(int) * (n + 1));

	for (int j = 0; j <= n; j++) {
		array[j] = 0;
	}




	while (1) {
		int stair;

		array[i]++;

		if (array[i] == m)
			break;



		if (array[i] % 2 != 0) {	//홀수면 시계방향으로 l칸이동
			i = i + l;
		}
		else if (array[i] % 2 == 0) {	//짝수면 반시계방향으로 ㅣ칸이동
			i = i - l;
		}


		if (i > n) {			//i가 시계방향일때 1보다 작아지면
			stair = l % n;  //현재위치에서 몇칸 시계로 이동할지
			i = i - l;		//원위치 시킴

			while (stair != 0) {
				i = i + 1;				//i시계로 1칸이동
				if (i > n)				//n에서 시계방향으로 한칸이동하면 n+1되니까
					i = 1;				//그때 i는 1로 이동시켜줌
				stair--;				//한칸줄어들음
			}
		}

		if (i < 1) {		//i가 반시계방향일때 1보다 작아지면
			stair = l % n;	//현재위치에서 몇칸 반시계로 이동할지
			i = i + l;		//원위치 시킴

			while (stair != 0) {
				i = i - 1;		//i반시계로 1칸 이동
				if (i < 1)		//1에서 한칸반시계로이동하면 0이되니까
					i = n;		//그때 n으로 이동시켜줌

				stair--;		//한칸 줄어들음
			}
		}





	}


	for (int j = 0; j <= n; j++) {
		count += array[j];
	}
	printf("%d", --count);

	free(array);
	return 0;
}