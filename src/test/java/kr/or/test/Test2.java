package kr.or.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("a값?");
			int a = sc.nextInt();
			System.out.println("b값?");
			int b = sc.nextInt();
			System.out.println(a + b);
		}

	}

}
