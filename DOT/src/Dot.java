import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dot {
	public static void main(String[] args) {
		File file=new File("descript.dot");
		try {
			if(!file.exists()){
				file.createNewFile();
			}else{
				file.delete();
				file.createNewFile();
			}
			String s="digraph Beziehungen {nodesep=0.7\n"
					+"Jutta -> Franz [label=\"liebt\"]\n"
					+ "Bernd -> Franz [label=\"hasst\"]\n"
					+ "Franz -> Bernd [label=\"hasst\"]\n"
					+ "Franz -> Jutta [label=\"liebt\"]\n"
					+"Bernd -> Jutta [label=\"liebt\"]}";
			FileWriter fw=new FileWriter(file);
			fw.write(s);
			fw.close();
			Process pr=Runtime.getRuntime().exec("graphviz/bin/dot.exe -Tpng \"descript.dot\" -o \"image.png\"");
			while(pr.isAlive()){
				if((System.currentTimeMillis()%500)==0)
					System.out.println("dauert noch");
			}
			System.out.println("ende");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
