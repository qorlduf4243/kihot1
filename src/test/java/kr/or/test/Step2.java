package kr.or.test;

//ValueObject클래스형 자료형
class MemberVO {
	private String name;
	private int age;
	private String phoneNum;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class MemberService {
	//액션-서비스 클래스 - 출력용 메서드 작성
	//매개변수로 클래스배열을 받아서 출력하는 형태로 작성
	public void printMembers(MemberVO[] members) {
		//향상된 for(loop)문 사용
		for(MemberVO m :members) {
			System.out.println(" 이름은: " + m.getName() + " | 나이는: " + m.getAge() + " | 전화번호는: " + m.getPhoneNum());
		}
	}
}

public class Step2 {

	public static void main(String[] args) {
		System.out.println("클래스형 변수-사용자 정의 자료형");
		// MemberVO 클래스를 실행하기 위해 new 연산자를
		MemberVO m1 = new MemberVO();
		// setter 메소드를 이용해 해당 인스턴스 변수에 값을 넣는다.
		m1.setName("홍길동");
		m1.setAge(45);
		m1.setPhoneNum("000-0000-0000");
		// 마찬가지로 다른 MemberVO객체(instance)를 생성해서 값을 넣는다.
		MemberVO m2 = new MemberVO();
		MemberVO m3 = new MemberVO();
		m2.setName("성춘향");
		m2.setAge(100);
		m2.setPhoneNum("111-1111-1111");
		m3.setName("각시탈");
		m3.setAge(3);
		m3.setPhoneNum("222-2222-2222");

		// 크기가 3인 MemberVO클래스ㅡㄹ 배열객체로 선언
		MemberVO[] members = new MemberVO[3];
		//MemberVO[]배열클래스 참조index에 m1,m2,m3를 넣는다
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		//출력: MemberService 클래스를 사용
		MemberService ms = new MemberService();
		ms.printMembers(members);
	}

}
