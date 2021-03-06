package boj2869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stz;
		
		stz = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(stz.nextToken());
		int B = Integer.parseInt(stz.nextToken());
		int V = Integer.parseInt(stz.nextToken());
		
		int days = ( V - B ) / ( A - B );
		
		if( ( V - B )% (A - B) != 0) {
			days++;
		}
	
		bw.write(days+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
