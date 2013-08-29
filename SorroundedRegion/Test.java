package SorroundedRegion;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = new char[2][];
		test[0] = new char[2];
		test[1] = new char[2];
		test[0][0] = 'O';
		test[0][1] = 'O';
		test[1][1] = 'O';
		test[1][0] = 'O';
		Solution s = new Solution();
		s.solve(test);
	}

}
