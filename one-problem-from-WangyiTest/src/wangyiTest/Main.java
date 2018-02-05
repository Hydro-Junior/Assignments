package wangyiTest;

/**
 * ���ױ��Ե��е��⣬ȫ�������жϣ������뷨�������������������
 */
import java.util.Scanner;

public class Main {
	static int[] book = new int[100000];
	static int sum = 0;
	static int[] b = new int[100000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int[][] arrays = new int[nums][];
		for (int i = 0; i < nums; i++) {
			int n = sc.nextInt();
			arrays[i] = new int[n];
			for (int j = 0; j < n; j++) {
				arrays[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < arrays.length; i++) {
			sum = 0;
			dfs(0, arrays[i].length, arrays[i]);
			if(sum > 0) {System.out.println("Yes");}
			else {
				System.out.println("No");
			}
		}

	}

	public static void dfs(int step, int n, int[] a) {

		boolean flag = true;
		
		if (step == n) {
			for (int j = 0; j < a.length - 1; j++) {
				if (((b[j] * b[j + 1]) % 4) != 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				sum ++;
				return;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (book[i] == 0) {
				b[step] = a[i];
				book[i] = 1;
				dfs(step + 1, n, a);
				book[i] = 0;
			}
		}
		return;
	}

}