import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class MovingAnt {
    public static void main(String[] args) {
        String[][] table = new String[10][];
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int x = 1, y = 1;
            for (int i = 0; i < 10; i++)
                table[i] = br.readLine().split(" ");
            if (table[x][y].equals("2"))
                table[x][y] = "9";
            else {
                table[x][y] = "9";
                boolean flag;
                while (true) {
                    flag = false;
                    while (table[x][y + 1].equals("0")) {
                        table[x][++y] = "9";
                    }
                    if (table[x][y + 1].equals("2")) {
                        table[x][++y] = "9";
                        break;
                    }
                    while (table[x + 1][y].equals("0")) {
                        table[++x][y] = "9";
                        if (table[x][y + 1].equals("0")) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) continue;
                    if (table[x + 1][y].equals("2")) {
                        table[++x][y] = "9";
                        break;
                    }
                    if (table[x][y + 1].equals("1"))
                        break;
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++)
                    bw.write(table[i][j] + " ");
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (Exception e) {}
    }
}