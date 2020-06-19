package kr.or.member;

//MemberVO 클래스 생성(정의)
public class MemberVO {
	//name, age, phoneNum 값을 각각 문자열, 숫자열, 문자열 형태로 쓰겠다.
	private String name;
	private int age;
	private String phoneNum;
	
	//set 으로 변수값을 지정해주고, get으로 값을 불러옴, 아래 값은 getter setter 제네레이트로 일괄적용
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
