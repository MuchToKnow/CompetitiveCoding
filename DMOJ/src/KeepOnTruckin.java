import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeepOnTruckin {
    private static BufferedReader b;
	private static PrintWriter p;
    private static int[] solved;
	public static void main(String[] args) throws IOException {
		b = new BufferedReader(new InputStreamReader(System.in));
		p = new PrintWriter(new OutputStreamWriter(System.out));
        int min = Integer.parseInt(b.readLine());
        int max = Integer.parseInt(b.readLine());
        int n = Integer.parseInt(b.readLine());
        int[] motelArr = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
        ArrayList<Integer> motels = new ArrayList<>();
        for(int i = 0; i < motelArr.length; i++){
            motels.add(motelArr[i]);
        }
        for(int i = 0; i < n; i++){
            motels.add(Integer.parseInt(b.readLine()));
        }
        Collections.sort(motels);
        solved = new int[motels.size()];
        for(int i = 0; i < solved.length; i++){
            solved[i] = -1;
        }
        p.print(numberPaths(0,min, max, motels));
        p.flush();
	}

	public static int numberPaths(int index, int min, int max, List<Integer> motels){
	    int loc = motels.get(index);

	    if(index == motels.size()-1) {
	        //At destination (successful path)
            return 1;
        }

	    if(solved[index] != -1){
	        return solved[index];
        }

        else {
	        int pathsFrom = 0;
            for (int i = index + 1; i < motels.size(); i++) {
                int dist = motels.get(i) - loc;
                if(dist > max){
                    break;
                }
                if(dist >= min && dist <= max){
                    pathsFrom = pathsFrom + numberPaths(i, min, max, motels);
                }
            }
            solved[index] = pathsFrom;
            return solved[index];
        }
    }

}
