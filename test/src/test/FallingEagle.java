package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FallingEagle {

	private static long findEnergy(long[] arr){
		long sum = 0;
		for(int i = 0 ; i<arr.length-1 ;i++) {
			if(arr[i] > arr[i+1]) {
				sum += arr[i];
			}else {
				sum += arr[i+1];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		int n;

		for(int i=0;i<t;i++){
			n = Integer.parseInt(br.readLine());
			String s[]=br.readLine().split(" ");
			long[] cost = new long[n];
			for(int j=0;j<n;j++){
				cost[j]=(Long.parseLong(s[j]));
			}
			
			System.out.println(findEnergy(cost));
		}

		br.close();	
	}
}
