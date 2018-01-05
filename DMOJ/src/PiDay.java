import java.io.*;

public class PiDay {
    private static BufferedReader b;
    private static PrintWriter p;
    private static long[][] solved;

    public static void main(String[] args) throws NumberFormatException, IOException {
        b = new BufferedReader(new InputStreamReader(System.in));
        p = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(b.readLine());
        int k = Integer.parseInt(b.readLine());
        solved = new long[251][251];
        for(int i = 0; i < solved.length; i++) {
            for(int o = 0; o < solved[i].length; o++) {
                solved[i][o] = -1;
            }
        }
        p.print(solve(n,k));
        p.flush();
    }

    public static long solve(int n, int k) {
        if(n < k) {
            return 0;
        }
        if(n == k || k == 1) {
            return 1;
        }
        else if(solved[n][k] != -1){
            return solved[n][k];
        }
        else {
            solved[n][k] = solve(n-k, k) + solve(n-1, k-1);
        }
        return solved[n][k];
    }

}
