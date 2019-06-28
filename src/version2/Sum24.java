package src.version2;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Experssion exp = new Experssion();
		Thinker ti = new Thinker(exp);
		ArrayList<Integer> card = new ArrayList<Integer>();
		int sum = 24;
		Scanner sc = new Scanner(System.in);
		int t;

		for (int i = 0; i < 4; i++) {
			t = sc.nextInt();
			card.add(t);
		}
		
		ti.count(card, card.size() - 1, sum);
		
		if(ti.s.toString().equals(" ")||ti.s.toString().equals(null)||ti.s.toString().hashCode() == 0) {
		System.out.println("no solution");
		}
		else {
			System.out.println(ti.s.toString());
			}
		

	}

}







