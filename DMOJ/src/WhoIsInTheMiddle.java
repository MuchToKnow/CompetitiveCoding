import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhoIsInTheMiddle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int first = Integer.parseInt(r.readLine());
		int second = Integer.parseInt(r.readLine());
		int third = Integer.parseInt(r.readLine());
		int mx = Integer.max(Integer.max(first, second), third);
		if(first == mx){
			System.out.println(Integer.max(second, third));
		}
		else if (second == mx){
			System.out.println(Integer.max(first, third));
		}
		else{
			System.out.println(Integer.max(first, second));
		}
	}
}
