package algorithm;

import java.util.Scanner;

public class fibonacciSequence {

	// 斐波那契数列
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Integer n = input.nextInt();

		Integer a = 1;
		Integer b = 1;
		Integer temp = 0;

		for (int i = 0; i < n; i++) {
			if (n == 1 || n == 2) {
				System.out.println("第" + n + "个数为：" + 1);
				return;
			}

			else {
				temp = a;
				a = b;
				b = temp + a;
				if (i + 1 == n) {
					System.out.println("第" + (i + 1) + "个数为：" + b);
				}
			}

		}

	}

}
