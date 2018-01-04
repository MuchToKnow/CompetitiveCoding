import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ListMinimum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(b.readLine());
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(b.readLine());
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++){
			p.println(arr[i]);
		}
		p.close();
	}
}
