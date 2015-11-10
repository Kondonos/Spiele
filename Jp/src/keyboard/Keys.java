package keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Keys {
	private String[][] alphabet;
	
	public Keys(String path){
		this.alphabet=new String[3][46];
		File file=new File(path);
		if(!(file.exists()||file.isFile())){
			System.err.println("File doesn't exisist or isn't file!");
			return;
		}else{
			try {
				BufferedReader br=new BufferedReader(new FileReader(file));
				File test=new File("test.txt");
				test.createNewFile();
				FileWriter fos=new FileWriter(test);
				
				String tmp="";
				int i=1;
				while((tmp=br.readLine())!=null){
					tmp.trim();
					System.out.println(tmp);
					fos.write(tmp);
					fos.flush();
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	public static void main(String[] args) {
		new Keys("letters.txt");
	}
}
