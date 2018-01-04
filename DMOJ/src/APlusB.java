import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(r.readLine());
		for (int i = 0; i < n; i++){
			String[] tokens = r.readLine().split(" ");
			System.out.println(Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]));
		}
	}
}
