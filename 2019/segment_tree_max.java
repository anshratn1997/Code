
import java.io.*;
import java.util.*;
import java.math.*;

// public 
class Main {
	// static variable
	static final int mod = (int) 1e9 + 7;
	static final double eps = 1e-6;
	static final double pi = Math.PI;
	static final long inf = Long.MAX_VALUE / 2;
	static final int max_size = (int)1e6 + 0;
	static int[][] tree = null;
	// static int[] arr = null;

	// .......static class
	static class Node {
		int key, value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		int f() {
			return key;
		}

		int s() {
			return value;
		}
	}

	// .............staic class end.

	BufferedReader br;
	PrintWriter out;

	public static void main(String[] args) {
		new Main().main1();

	}

	void main1() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			int t = 1;
			// t=ii();
			while (t-- > 0) {
				// .......solution start
				String nq[] = si().split(" ");
				int n = Integer.parseInt(nq[0]);
				int q = Integer.parseInt(nq[1]);
				tree = new int[4 * n][33];
				construct(1, 0, n - 1);
				for (int i = 0; i < q; i++) {
					String qq[] = si().split(" ");
					if (Integer.parseInt(qq[0]) == 1) {
						int idx = Integer.parseInt(qq[1]);
						int bit = Integer.parseInt(qq[2]);
						update(1, 0, n - 1, idx - 1, bit);
					} else {
						int idx = Integer.parseInt(qq[1]);
						int bit = Integer.parseInt(qq[2]);
						int res = query(1, 0, n - 1, 0, idx - 1, bit);
						out.println(res);
					}
				}
				// ..........solution end.
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ...............required method.

	void construct(int node, int start, int end) {
		if (start == end) {
			Arrays.fill(tree[node], 0);
		} else {
			int mid = (start + end) / 2;
			construct(2 * node, start, mid);
			construct(2 * node + 1, mid + 1, end);
			sumOfBits(node);
		}
	}

	void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node][value] = tree[node][value] == 1 ? 0 : 1;  
		} else {
			int mid = (start + end) / 2;
			if (start <= idx && idx <= mid) {
				update(2 * node, start, mid, idx, value);
			} else {
				update(2 * node + 1, mid + 1, end, idx, value);
			}
			sumOfBits(node);
		}
	}

	int query(int node, int start, int end, int l, int r, int bit) {

		if (r < start || end < l) {
			return 0;
		}
		if (l <= start && end <= r) {
			return tree[node][bit];
		}

		int mid = (start + end) / 2;
		int sum1 = query(2 * node, start, mid, l, r, bit);
		int sum2 = query(2 * node + 1, mid + 1, end, l, r, bit);
		return sum1 + sum2;
	}
	void sumOfBits(int node) {
		for (int i = 0; i < 33; i++ ) {
			tree[node][i] = tree[2 * node][i] + tree[2 * node + 1][i];
		}
	}

	// ................end.

	// ..............input method start.
	int getmax(int a[]) {
		int n = a.length;
		int max = a[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(a[i], max);
		}
		return max;
	}

	int getmin(int a[]) {
		int n = a.length;
		int min = a[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(a[i], min);
		}
		return min;
	}

	int[] iint() throws IOException {
		String line[] = br.readLine().split(" ");
		int[] a = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			a[i] = Integer.parseInt(line[i]);
		}
		return a;
	}

	long[] ilong() throws IOException {
		String line[] = br.readLine().split(" ");
		long[] a = new long[line.length];
		for (int i = 0; i < line.length; i++) {
			a[i] = Long.parseLong(line[i]);
		}
		return a;
	}

	double[] idouble() throws IOException {
		String line[] = br.readLine().split(" ");
		double[] a = new double[line.length];
		for (int i = 0; i < line.length; i++) {
			a[i] = Long.parseLong(line[i]);
		}
		return a;
	}

	long li() throws IOException {

		return Long.parseLong(br.readLine());
	}

	int ii() throws IOException {

		return Integer.parseInt(br.readLine());
	}

	double di() throws IOException {
		return Double.parseDouble(br.readLine());
	}

	char ci() throws IOException {
		return (char) br.read();
	}

	String si() throws IOException {
		return br.readLine();
	}

	String[] isa(int n) throws IOException {
		String at = si();
		return at.split(" ");
	}

	double[][] idm(int n, int m) throws IOException {
		double a[][] = new double[n][m];
		for (int i = 0; i < n; i++) {
			double[] temp = idouble();
			for (int j = 0; j < m; j++)
				a[i][j] = temp[j];
		}
		return a;
	}

	int[][] iim(int n, int m) throws IOException {
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			int[] temp = iint();
			for (int j = 0; j < m; j++)
				a[i][j] = temp[j];
		}
		return a;
	}

	long[][] ilm(int n, int m) throws IOException {
		long a[][] = new long[n][m];
		for (int i = 0; i < n; i++) {
			long[] temp = ilong();
			for (int j = 0; j < m; j++)
				a[i][j] = temp[j];
		}
		return a;
	}
	// ..............input methods end;

}

/*
input
5 5
1 1 2
1 2 2
2 2 2
2 5 2

output 
2
1
*/