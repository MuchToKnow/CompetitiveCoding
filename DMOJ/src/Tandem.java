import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tandem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int type = Integer.parseInt(r.readLine());
		int n = Integer.parseInt(r.readLine());
		String[] d = r.readLine().split(" ");
		String[] p = r.readLine().split(" ");
		int[] dmoj = new int[n];
		int[] peg = new int[n];
		for (int i = 0; i < n; i++){
			dmoj[i] = Integer.parseInt(d[i]);
			peg[i] = Integer.parseInt(p[i]);
		}
		int total = 0;
		Arrays.sort(dmoj);
		Arrays.sort(peg);
		//min
		if (type == 1){
			for (int i = 0; i < n; i++){
				total = total + Integer.max(dmoj[i], peg[i]);
			}
			System.out.println(total);
		}
		//max
		else{
			for (int i = 0; i < n; i++){
				total = total + Integer.max(dmoj[i], peg[n-i-1]);
			}
			System.out.println(total);
		}
	}

}
