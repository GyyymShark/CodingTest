#include <stdio.h>

//1592

int main() {
	int i = 1;
	int count = 0;
	int n, m, l;		//n�� �ڸ� m�������� �� l��°�ִ»��������
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



		if (array[i] % 2 != 0) {	//Ȧ���� �ð�������� lĭ�̵�
			i = i + l;
		}
		else if (array[i] % 2 == 0) {	//¦���� �ݽð�������� ��ĭ�̵�
			i = i - l;
		}


		if (i > n) {			//i�� �ð�����϶� 1���� �۾�����
			stair = l % n;  //������ġ���� ��ĭ �ð�� �̵�����
			i = i - l;		//����ġ ��Ŵ

			while (stair != 0) {
				i = i + 1;				//i�ð�� 1ĭ�̵�
				if (i > n)				//n���� �ð�������� ��ĭ�̵��ϸ� n+1�Ǵϱ�
					i = 1;				//�׶� i�� 1�� �̵�������
				stair--;				//��ĭ�پ����
			}
		}

		if (i < 1) {		//i�� �ݽð�����϶� 1���� �۾�����
			stair = l % n;	//������ġ���� ��ĭ �ݽð�� �̵�����
			i = i + l;		//����ġ ��Ŵ

			while (stair != 0) {
				i = i - 1;		//i�ݽð�� 1ĭ �̵�
				if (i < 1)		//1���� ��ĭ�ݽð���̵��ϸ� 0�̵Ǵϱ�
					i = n;		//�׶� n���� �̵�������

				stair--;		//��ĭ �پ����
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