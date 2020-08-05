package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayForce {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(t);
		while(t-- > 0){
			int a = sc.nextInt();
			System.out.println(a);
			int b = sc.nextInt();
			System.out.println(b);
			int n = sc.nextInt();
			System.out.println(n);
			int mod = sc.nextInt();
			System.out.println(mod);
			int[] arr = new int[n];
			arr[0] = a;
			arr[1] = b;
			Map<Integer,Integer> map = new HashMap<>();
			
			for(int i = 2 ; i< n ; i++) {
				arr[i] = (arr[i-1] + arr[i-2] ) % mod;
			}

			for(int i = 0 ; i < n ; i++) {
				if(map.containsKey(arr[i])) {
					map.put(arr[i], (int)map.get(arr[i]) + 1);
				}else {
					map.put(arr[i], 1);
				}
			}
			long sum = 0;
			for(Object i : map.keySet()) {
				sum += Math.pow((int)map.get(i),2);
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
