package keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class Keys {
	private String[][] alphabet;
	
	public Keys(){
		this.alphabet=new String[3][75];
		try {
			InputStream input=getClass().getResourceAsStream("/keyboard/letters.txt");
			byte[] bytes=new byte[100];
			int i=0;
			while(input.read(bytes)>0){
				String value=new String(bytes,"UTF-8");
				StringTokenizer token=new StringTokenizer(value, "|");
					String[] values={token.nextToken(),token.nextToken(),token.nextToken()};
				System.out.println(values[0]+" "+values[1]+" "+values[2]);
				alphabet[0][i]=values[0];
				alphabet[1][i]=values[1];
				alphabet[2][i]=values[2];
				i++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public static void main(String[] args) {
		new Keys();
	}
}
