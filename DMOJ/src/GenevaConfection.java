import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;

public class GenevaConfection {
	private static BufferedReader b;
	private static PrintWriter p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		b = new BufferedReader(new InputStreamReader(System.in));
		p = new PrintWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(b.readLine());
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(b.readLine());
			Stack<Integer> top = new Stack();
			for(int o = 0; o < n; o++){
				top.push(Integer.parseInt(b.readLine()));
			}
			int next = 1;
			Stack<Integer> branch = new Stack();
			while(true){
				if(!top.empty() && top.peek() == next){
					top.pop();
					next++;
				}
				else if(!branch.empty() && branch.peek() == next){
					branch.pop();
					next++;
				}
				else if (top.size() == 0){
					if(branch.size() == 0){
						p.print("Y\n");
						break;
					}
					else{
						p.print("N\n");
						break;
					}
				}
				else{
					branch.push(top.pop());
				}
			}
		}
		p.flush();
	}

}
