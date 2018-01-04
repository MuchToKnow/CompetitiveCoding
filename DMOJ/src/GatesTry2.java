import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeSet;


public class GatesTry2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		
		int gate = Integer.parseInt(b.readLine());
		int planes = Integer.parseInt(b.readLine());
		
		TreeSet<Integer> gates = new TreeSet<Integer>();
		for(int i = 1; i <= gate; i++){
			gates.add(i);
		}
		boolean flag = false;
		for(int i = 0; i < planes; i++){
			int request = Integer.parseInt(b.readLine());
			if(gates.floor(request) == null){
				p.print(i);
				flag = true;
				break;
			}
			else{
				gates.remove(gates.floor(request));
			}
		}
		if(!flag){
			p.print(planes);
		}
		p.close();
	}

}
