import java.io.*;

public class BubbleSort {
        private static BufferedReader b;
	    private static PrintWriter p;

	public static void main(String[] args) throws IOException {
		b = new BufferedReader(new InputStreamReader(System.in));
		p = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(b.readLine());
		int[] arr = new int[n];
		String sequence = b.readLine();
		String[] stringArr = sequence.split(" ");
		for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(stringArr[i]);
        }
        boolean flag = false;
        //print
        printSequence(arr);
        while(!flag){
            flag = true;
            for(int i = 0; i < n-1; i++){
                if(arr[i] > arr[i+1]){
                    int hold = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = hold;
                    printSequence(arr);
                    flag = false;
                }
            }
        }
		p.flush();
	}

	public static void printSequence(int[] arr){
	    for(int i = 0; i < arr.length; i++){
	        p.print(arr[i] + " ");
        }
        p.print("\n");
    }

}