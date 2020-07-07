package kr.or.test;

public class Step1 {

   public static void main(String[] args) {
      System.out.println("클래스를 사용하지 않는 내장변수 자료형 소스");
       //필드=변수표기
      String name; int age; String phoneNum;
      
      name = "홍길동"; age = 45; phoneNum="000-0000-0000";
      //메서드의 매개변수-인자-파라미터 로 값 전달
        printMember(name, age, phoneNum); 
        name = "성춘향"; age = 70; phoneNum="111-1111-1111";
      //메서드의 매개변수-인자-파라미터 로 값 전달
        printMember(name, age, phoneNum); 
        name = "각시탈"; age = 30; phoneNum="222-2222-2222";
      //메서드의 매개변수-인자-파라미터 로 값 전달
        printMember(name, age, phoneNum); 
        
        System.out.println("내장변수 배열자료형 소스");
        String[] names = {"홍길동","성춘향","각시탈"};
        int[] ages = {45,100,3};
        String[] phoneNums = {"000-0000-0000","111-1111-1111","222-2222-2222"};
        printMember(names,ages,phoneNums);
   }
    //오버 로딩-같은 이름의 매개변수가 틀린 같은이름 메서드
   private static void printMember(String[] names, int[] ages, String[] phoneNums){
      int cntLength = names.length;
      System.out.println("매개변수 이름의 갯수는 " + cntLength + "입니다.");
      //배열은 값을 참조할때 주소-index를 사용하는데 0번 주소부터 시작
      for(int cnt=0;cnt<cntLength;cnt++) {
        System.out.println("이름은:" +names[cnt] + "| 나이는:" + ages[cnt]+  "|전화번호는:"+ phoneNums[cnt]);
      }
      
   }

   private static void printMember(String name, int age, String phoneNum) {
      System.out.println("이름은:" +name + "| 나이는:" +age+  "|전화번호는:"+ phoneNum);
      
   }

}