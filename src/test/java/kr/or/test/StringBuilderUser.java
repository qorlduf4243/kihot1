package kr.or.test;

import java.io.PrintStream;

public class StringBuilderUser {
 
 public static void main(String[] args) {
  String str = "";
  for(int cnt=1;cnt<=100;cnt++) {
   //str += cnt;
   str = str + cnt;
   //문자열과 숫자를 더하면 문자열
  }
  System.out.println(str);
  
  StringBuilder sb = new StringBuilder();
  for(int cnt=1;cnt<=100;cnt++) {
   sb.append(cnt);
  }
  str = sb.toString();
  System.out.println(str);
 }

}