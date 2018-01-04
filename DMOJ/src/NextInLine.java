import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextInLine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int y = Integer.parseInt(r.readLine());
		int o = Integer.parseInt(r.readLine());
		System.out.println(o - y + o);
	}

}
