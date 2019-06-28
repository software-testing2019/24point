package src.version2;

import java.util.ArrayList;

public class Thinker {
	private Experssion  exp;
	StringBuffer s  = new StringBuffer();
	

	public Thinker(Experssion  expp) {
		exp = expp;
	}

	public boolean count(ArrayList<Integer> array, int num, int target) {
		if (num == 1) {
			if (array.get(0) + array.get(1) == target) {
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("+");
				return true;
			}

			if (array.get(0) - array.get(1) == target) {
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("-");
				return true;
			}

			if (array.get(1) - array.get(0) == target) {
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("-");
				return true;
			}

			if (array.get(0) * array.get(1) == target) {
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("*");
				return true;
			}

			if (array.get(0) * target == array.get(1)) {
				exp.add(array.get(0));
				exp.add(array.get(1));
				exp.add("/");
				return true;
			}

			if (array.get(1) * target == array.get(0)) {
				exp.add(array.get(1));
				exp.add(array.get(0));
				exp.add("/");
				return true;
			}

			return false;

		} else {
			for (int current = 0; current < array.size(); current++) {
				ArrayList<Integer> array1 = new ArrayList<Integer>();
				int currentNum = array.get(current);

				for (int i = 0; i < array.size(); i++) {
					if (i != current) {
						array1.add(array.get(i));
					}
				}

				if (count(array1, num - 1, target - currentNum)) {
					exp.add("+");
					exp.add(currentNum);
					if (num == 3) {										
						System.out.println(exp.toString());
						s.append(exp.toString());
						s.append("  ");
						exp.clear();
					}
					if (num != 3)
						return true;
				}
				if (count(array1, num - 1, target + currentNum)) {
					exp.add("-");
					exp.add(currentNum);
					if (num == 3) {
					
						s.append(exp.toString());
						s.append("  ");
						exp.clear();
					}
					if (num != 3)
						return true;
				}

				if (count(array1, num - 1, target * currentNum)) {
					exp.add("/");
					exp.add(currentNum);
					if (num == 3) {
						
						s.append(exp.toString());
						s.append("  ");
						exp.clear();
					}
					if (num != 3)
						return true;
				}

				if (target % currentNum == 0) {
					if (count(array1, num - 1, (int) (target / currentNum))) {
						exp.add("*");
						exp.add(currentNum);
						if (num == 3) {
							
							s.append(exp.toString());
							s.append("  ");
							exp.clear();
						}
						if (num != 3)
							return true;
					}

				}
			}
			return false;
		}
	}
}