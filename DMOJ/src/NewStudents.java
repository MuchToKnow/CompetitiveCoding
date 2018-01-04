import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;


public class NewStudents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		int s1 = Integer.parseInt(b.readLine());
		double tGrade = 0;
		for (int i = 0; i < s1; i++){
			tGrade += Integer.parseInt(b.readLine());
		}
		int s2 = Integer.parseInt(b.readLine());
		for(int i = 0; i < s2; i++){
			s1++;
			tGrade += Integer.parseInt(b.readLine());
			p.println(Math.round((tGrade/s1) * 1000d) / 1000d);
		}
		p.close();
	}

}
