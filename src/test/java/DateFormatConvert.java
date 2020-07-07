import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConvert {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy년 MM월 dd일 E요일 HH시 mm분 ss초");
		System.out.println("현재 날짜와 시간은" + sdf.format(now) + " 입니다.");

	}

}
