import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class GatesTry1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		
		int gates = Integer.parseInt(b.readLine());
		int planes = Integer.parseInt(b.readLine());
		
		int[] planesUnder = new int[gates+1];
		int highest = 1;
		boolean flag = true;
		for (int i = 0; i < planes; i++){
			int gateReq = Integer.parseInt(b.readLine());
			if (gateReq > highest){
				planesUnder = fillHighest(planesUnder, highest, gateReq, i);
				highest = gateReq;
			}
			else{
				planesUnder = addUnder(planesUnder, gateReq, highest);
				if(planesUnder[0] == 1){
					p.print(i);
					flag = false;
					break;
				}
			}
		}
		if(flag == true){
			p.print(planes);
		}
		p.close();
	}
	//increment everything from x to max
	public static int[] addUnder (int[] arr, int x, int max){
		for(int i = x; i <= max; i++){
			arr[i]++;
			if(arr[i] > i){
				arr[0] = 1;
				return arr;
			}
		}
		return arr;
	}
	//Set all of the new highs
	public static int[] fillHighest (int[] arr, int prev, int high, int seen){
		for(int i = prev; i <= high; i++){
			arr[i] = seen;
		}
		arr[high]++;
		return arr;
	}

}
