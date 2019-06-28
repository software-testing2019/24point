package src.version2;

import java.util.ArrayList;

public class Experssion {
	private ArrayList<Integer> num = new ArrayList<Integer>();
	private ArrayList<String> sign = new ArrayList<String>();

	public void add(int n) {
		num.add(n);
	}

	public void add(String s) {
		sign.add(s);
	}

	private int getPriority(String s) {
		if (sign.equals("+"))
			return 1;
		if (sign.equals("-"))
			return 1;
		if (sign.equals("*"))
			return 2;
		if (sign.equals("/"))
			return 2;
		return -1;
	}

	private String toString(int la) {
		if (la == 0) {
			return num.get(0) + sign.get(0) + num.get(1);
		} else {
			String result = this.toString(la - 1);
			if (getPriority(sign.get(la)) >= getPriority(sign.get(la - 1)))
				result = "(" + result + ")";
			result += sign.get(la) + num.get(la + 1);
			return result;
		}
	}

	public String toString() {
		return toString(2);
	}

	public void clear() {
		num.clear();
		sign.clear();
	}
	}