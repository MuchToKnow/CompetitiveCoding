import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Hailstones {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		
		p.println(countHail(Integer.parseInt(b.readLine()), 0));
		p.close();
	}
	
	public static int countHail(int current, int counter){
		if(current == 1){
			return counter;
		}
		//if(Math.sqrt((double)current) == Math.floor(Math.sqrt((double)current))){
			//return (int) (counter + Math.sqrt(current));
		//}
		else{
			if(current % 2 == 0){
				return countHail(current/2, counter + 1);
			}
			else{
				return countHail(current*3 + 1, counter + 1);
			}
		}
	}

}
