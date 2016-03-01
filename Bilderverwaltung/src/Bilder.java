import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Bilder {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\Manga\\RAW\\Bakuman\\Bakuman v01-05\\[小畑健×大場つぐみ] バクマン。 第01巻");
		ArrayList<String> txt=new ArrayList<>();
		getfile(file,txt);
		File out=new File("./out.txt");
		out.createNewFile();
		BufferedWriter bw=new BufferedWriter(new FileWriter(out));
		bw.write(txt.get(0).toString());
		bw.flush();
		bw.close();
	}
	public static void getfile(File file,ArrayList<String> txt) throws IOException{
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				System.out.println(f.toString());
				getfile(f,txt);
			}
		}else{
			BufferedReader br=new BufferedReader(new FileReader(file));
			String s="",t="";			
			while((s=br.readLine())!=null){
				t+=s;
			}
			txt.add(t);
		}
	}
}
