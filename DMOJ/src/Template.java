import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Template {
	
	private static BufferedReader b;
	private static PrintWriter p;

	public static void main(String[] args) {
		b = new BufferedReader(new InputStreamReader(System.in));
		p = new PrintWriter(new OutputStreamWriter(System.out));
		
		p.flush();
	}

}
