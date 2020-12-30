import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println("현재 시간: " + d1); // UTC + 9

        // 시간값을 직접 지정
        // 연 월 일 시 분 초
        Date d2 = new Date(1125034805687L);
        System.out.println("지정한 시간: " +d2);

        Date d3 = new Date(0L);
        System.out.println("0L: " + d3);

        Date d4 = new Date(System.currentTimeMillis()); // 현재 시간을 long으로
        System.out.println("현재 시간: " + d4);


        // 시간값 추출
        int year = d1.getYear() + 1900;    // 더 이상 사용하지 않는 메서드
        int month = d1.getMonth() + 1;
        int day = d1.getDate();
        int hour = d1.getHours();
        int minute = d1.getMinutes();
        int second = d1.getSeconds();
        System.out.println(year + "년 " + month + "월 " + day + "일 " + hour + "시"
        + minute + "분" + second + "초");



    }
}
