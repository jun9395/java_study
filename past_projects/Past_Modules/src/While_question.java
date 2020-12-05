import javax.swing.*;

/**
 * Name : Son, Junhee
 * Phone :
 * This project :
 */
public class While_question {
    public static void main(String[] args) {
        int i=1, j=0;

        while (j<100) {
            if (i%2==0 || i%3==0 || i%5==0)
            {
                i++;
                continue;
            }
            System.out.printf(i++ + " ");
            j++;
        }
        System.out.println();
    }
}
