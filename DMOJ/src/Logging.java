import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Logging {
	
	static BufferedReader b;
	static PrintWriter o;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		b = new BufferedReader(new InputStreamReader(System.in));
		o = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(b.readLine());
		int[] addedMasses = new int[n+1];
		addedMasses[0] = 0;
		int total = 0;
		for (int i = 1; i < n+1; i++){
			total += readInt();
			addedMasses[i] = total;
		}
		
		int q = Integer.parseInt(b.readLine());
		for(int i = 0; i < q; i++){
			int a = readInt();
			int b = readInt();
			if(a == 0){
				o.println(addedMasses[b+1]);
			}
			else{
			o.println(addedMasses[b+1] - addedMasses[a]);
			}
		}
		o.close();
	}
	
	static String next() throws IOException{
		while(st == null || !st.hasMoreTokens()){
			st = new StringTokenizer(b.readLine().trim());
		}
		return st.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException{
		return Integer.parseInt(next());
	}

}
