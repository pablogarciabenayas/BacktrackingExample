package daa.ryp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BakeryTaskProcessor {

	private int[] order;
	private int[][] params;
	private int rows;
	private int columns;
	private int upperFlag = 0;
	private int[] bestResult;

	public BakeryTaskProcessor(int[] order, int[][] params, int rows,
			int columns) {
		this.order = order;
		this.params = Arrays.copyOf(params,params.length);
		this.rows = rows;
		this.columns = columns;
		this.bestResult = new int[order.length];
	}

	public void process() {

		for (int i = 1; i < rows+1; i++) {
			bestResult[i] = i;
			upperFlag = upperFlag + params[i][order[i]];
		}

		ArrayList<Node> nodesToExplore = new ArrayList<Node>();
		Node node = new Node(rows, columns, params, order);
		node.setFlag();
		nodesToExplore.add(node);

		while (!nodesToExplore.isEmpty()) {
			Node hopeNode = nodesToExplore.remove(0);
			ArrayList<Node> childs = getChilds(hopeNode, rows , columns);
			
			for (Node child : childs) {
				if(child.getLevel() == rows){
					if(child.getFlag() > upperFlag){

					copyResult(child.getResult(),bestResult);
					
					upperFlag = child.getFlag();
					}
					
				}else if(child.getFlag() > upperFlag){
					nodesToExplore.add(child);
				}
			}
			Collections.sort(nodesToExplore);
		}
		
	}

	private void copyResult(int[] o, int[] d) {
		for (int i = 0; i < o.length; i++) {
			d[i] = o[i];
		}
	}

		
	public String getFinalResult() {
		String res = "";
		res = res + "[";
		for (int i = 1; i < order.length; i++) {
			res = res + " "+bestResult[i]+" ";
			if(i<order.length-1){
				res = res + ",";
			}	
		}
		res = res + "]";
		return res;
		
	}
	
	public String getFinalProfit(){
		return Integer.toString(upperFlag);
		
	}
	

	private ArrayList<Node> getChilds(Node father, int r, int c) {
		
		int[][] fatherParams = father.getNodeMatrixParam();
		int[] fatherOrder = father.getOrder();
		
		ArrayList<Node> childs = new ArrayList<Node>();
		for (int i = 1; i <= r; i++) {
			int[][] currentParams = new int[r+1][c+1];
			int[] currentOrder = new int[r+1];
			
			for (int j = 1; j < r+1; j++) {
				for (int k = 1; k < c+1 ; k++) {
					currentParams[j][k] = fatherParams[j][k];
				}
			}
			
			for (int j = 0; j<r+1; j++) {
				currentOrder[j]=fatherOrder[j];
			}
			
			Node node = new Node(father.getRows(), father.getColumns(), currentParams, currentOrder);
			copyResult(father.getResult(), node.getResult());
			node.setLevel(father.getLevel()+1);
			
			if(isFeasible(node.getResult(),i,node.getLevel()-1)){
				int[] newNode = node.getResult();
				newNode[node.getLevel()]=i;
				node.setResult(newNode);
				node.setFlag();
				childs.add(node);
			}
		}
		return childs;
	}

	private boolean isFeasible(int[] result, int intento, int hasta) {
	
		for (int i = 1; i < result.length; i++) {
			if(result[i] == intento){
				return false;
			}
			
		}
		return true;
	}

}
