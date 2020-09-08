package kr.or.test;

public class FindAndReplace {

	public static void main(String[] args) {
		String str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		int index = str.indexOf("자바");
		if (index == -1) {
			System.out.println("자바 문자열이 포함되어 있지 않습니다.");
		} else {
			System.out.println("자바 문자열이 포함되어 있씁니다.");
			System.out.println("index값은: " + index + "입니다.");
			str = str.replace("자바", "java");
			System.out.println("-->" + str);
		}
	}

}
