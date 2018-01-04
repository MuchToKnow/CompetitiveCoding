import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boolean {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String[] in = r.readLine().split(" ");
		if (in.length % 2 == 1) {
			System.out.println(in[in.length - 1]);
		} 
		  else {
			if (in[in.length - 1].equals("True")) {
				System.out.println("False");
			} else {
				System.out.println("True");
			}

		}
	}

}
