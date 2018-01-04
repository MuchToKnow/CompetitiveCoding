import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusBHard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(r.readLine());
		String[] tokens = null;
		String[] int1 = null;
		String[] int2 = null;
		boolean int1Negative = false;
		boolean int2Negative = false;
		for (int i = 0; i < n; i++){
			tokens = r.readLine().split(" ");
			int1 = tokens[0].split("");
			int2 = tokens[1].split("");
			if (int1[0].equals("-")){
				int1Negative = true;
			}
			if (int2[0].equals("-")){
				int2Negative = true;
			}
			for(int o = 0; o < Integer.min(int1.length, int2.length); o++){
			//Add manually accounting for negative cases
			}
		}
		
	}

}
