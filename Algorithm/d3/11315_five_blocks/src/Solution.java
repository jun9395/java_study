import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) {
        try {
            final int[][] movement = {
                    {-1, -1}, {0, -1}, {1, -1},
                    {-1, 0}, {1, 0},
                    {-1, 1}, {0, 1}, {1, 1}
            };

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine().trim());
                String[][] strings = new String[N][];
                for (int j = 0; j < N; j++)
                    strings[j] = br.readLine().trim().split("");

                FindBlocks findBlocks = new FindBlocks();
                boolean flag = findBlocks.findFiveBlocks(strings, N, movement);

                if (flag) bw.write("#" + t + " YES\n");
                else bw.write("#" + t + " NO\n");
                bw.flush();
            }

            bw.close();
            br.close();
        } catch (Exception e) {}
    }
}


class FindBlocks {
    public boolean findFiveBlocks(String[][] strings, int N, int[][] movement) {
//        for (int y = 0; y < N; y++) {
//            for (int x = 0; x < N; x++) {
//                if (strings[y][x].equals("o")) {
//                    for (int[] move : movement) {
//                        int count = 1;
//                        int nx = x + move[0], ny = y + move[1];
//                        if (-1 < nx && nx < N && -1 < ny && ny < N && strings[ny][nx].equals("o")) {
//                            count++;
//                            while (count < 5 && strings[ny][nx].equals("o")) {
//                                nx += move[0];
//                                ny += move[1];
//                                if (-1 < nx && nx < N && -1 < ny && ny < N)
//                                    count++;
//                                else
//                                    break;
//                            }
//                            if (count >= 5) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (strings[y][x].equals("o")) {
                    int count = 1;
                    for (int[] move : movement) {
                        int nx = x + move[0], ny = y + move[1];

                        if (-1 < nx && nx < N && -1 < ny && ny < N && strings[ny][nx].equals("o")) {
                            count++;
                            while (count < 5) {
                                nx += move[0];
                                ny += move[1];
                                if (-1 < nx && nx < N && -1 < ny && ny < N && strings[ny][nx].equals("o"))
                                    count++;
                                else
                                    break;
                            }

                            if (count >= 5) return true;
                            else count = 1;
                        }
                    }
                }
            }
        }

        return false;
    }
}