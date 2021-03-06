package boj2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main4 {
	
	private static int[] arr;
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException { // 퀵정렬 이용
		makeArr();
		initializeArr();
		quickSortStack(0,arr.length-1);
		printArr();
	}
	
	public static void makeArr() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		arr = new int[size];
	}
	
	public static void initializeArr() throws NumberFormatException, IOException {
		for(int i=0; i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		suffle();
	}
	
	public static void quickSortStack(int left, int right) {
		Stack<Integer> leftStack = new Stack<Integer>();
		Stack<Integer> rightStack = new Stack<Integer>();
		
		leftStack.push(left);
		rightStack.push(right);
		
		while(!leftStack.isEmpty()) {
			int pLeft = left = leftStack.pop();
			int pRight = right = rightStack.pop();
			int pivot = arr[(left+right)/2];
			
			do {
				while(arr[pLeft] < pivot ) pLeft++;
				while(arr[pRight] > pivot ) pRight--;
				
				if(pLeft <= pRight) {
					swap(pLeft++,pRight--);
				}
			}while(pLeft <= pRight);
		
			if(left < pRight) {
				leftStack.push(left);
				rightStack.push(pRight);
			}
			if(pLeft < right ) {
				leftStack.push(pLeft);
				rightStack.push(right);
			}
		}	
	}
	
	public static void suffle() {
		for(int i=0; i<5;i++) {
			int value1 = (int)(Math.random()*arr.length);
			int value2 = (int)(Math.random()*arr.length);
			swap(value1,value2);
		}
	}
	public static void swap(int pLeft, int pRight) {
		int tmp = arr[pLeft];
		arr[pLeft] = arr[pRight];
		arr[pRight] = tmp;
	}
	
	public static void printArr() throws IOException {
		for(int value : arr) {
			sb.append(value).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
