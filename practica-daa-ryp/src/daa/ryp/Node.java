package daa.ryp;

import java.util.Arrays;

public class Node implements Comparable {

	private int[] result;
	private int flag;
	private int level;
	private int rows;
	private int columns;
	private int[][] nodeMatrixParam;
	private int[] order;

	public Node(int r, int c, int[][] params, int[] o) {
		this.rows = r;
		this.columns = c;
		this.nodeMatrixParam = Arrays.copyOf(params, params.length);
		this.order = Arrays.copyOf(o, o.length);
		this.result = new int[r + 1];

	}

	public void setFlag() {

		int profit = 0;

		for (int i = 1; i <= level; i++) {
			profit = profit + nodeMatrixParam[result[i]][order[i]];
		}

		for (int i = level + 1; i <= rows; i++) {
			int bestBaker = getBestBaker(rows, order[i], nodeMatrixParam);
			profit = profit + nodeMatrixParam[bestBaker][order[i]];
		}
		this.flag = profit;

	}

	private int getBestBaker(int r, int type, int[][] params) {

		int best = 1;

		for (int i = 1; i <= r; i++) {
			if (params[i][type] > params[best][type]) {
				best = i;
			}
		}

		return best;
	}

	public int getLevel() {
		return level;
	}

	public void setResult(int[] result) {
		this.result = result;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setNodeMatrixParam(int[][] nodeMatrixParam) {
		this.nodeMatrixParam = nodeMatrixParam;
	}

	public void setOrder(int[] order) {
		this.order = order;
	}

	public int[] getResult() {
		return result;
	}

	public int getFlag() {
		return flag;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int[][] getNodeMatrixParam() {
		return nodeMatrixParam;
	}

	public int[] getOrder() {
		return order;
	}

	@Override
	public int compareTo(Object o) {

		Node obj = (Node) o;

		if (this.flag < obj.flag) {
			return -1;
		} else if (this.flag > obj.flag) {
			return 1;
		} else {
			return 0;
		}

	}

}
