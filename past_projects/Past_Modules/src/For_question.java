/**
 * Name : Son, Junhee
 * Phone :
 * This project : for문 연습문제 - for문을 다음과 같이 고정한 후, 내부코드만 바꿔서 문제해결
 */
public class For_question {
    public static void main(String[] args) {
        int i, k;

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++) {
                System.out.print(3*i+k+1);
                System.out.printf(" ");
            }
            System.out.println();
        }
        System.out.println();

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++) {
                System.out.print(3*(i+1)-k);
                System.out.printf(" ");
            }
            System.out.println();
        }
        System.out.println();

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++) {
                System.out.print(i+1+3*k);
                System.out.printf(" ");
            }
            System.out.println();
        }
        System.out.println();

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++)
                if (k <= i)
                    System.out.printf("O ");
            System.out.println();
        }
        System.out.println();

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++)
                if (k < 2-i)
                    System.out.printf("  ");
                else
                    System.out.printf("O ");
            System.out.println();
        }
        System.out.println();

        for (i=0; i<3; i++) {
            for (k=0; k<3; k++)
                if ((3*i+k+1)%2 != 0)
                    System.out.printf("O ");
                else
                    System.out.printf("  ");
            System.out.println();
        }
        /* 또 다른 답
        for (i=0; i<3; i++) {
            for (k=0; k<3; k++)
                if (k%2 == i%2)
                    System.out.printf("O ");
                else
                    System.out.printf("  ");
            System.out.println();
         */
    }
}
