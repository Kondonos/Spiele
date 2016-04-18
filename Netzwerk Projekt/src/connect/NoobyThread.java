package connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NoobyThread extends Thread{
	Socket socket;
	
	public NoobyThread(Socket socket) {
		this.socket=socket;
	}
	public void run(){
		try {
			PrintWriter pw =new PrintWriter(socket.getOutputStream(),true);
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			BufferedReader bis=new BufferedReader(isr);
			int i=0;
			AES encrypter=new AES("testtesttest", "SHA-256", 16);
			String in=null;
			while(i<3){
				Thread.sleep(100);
				System.out.println(encrypter.encrypt("Username"));
				pw.println(encrypter.encrypt("Username"));
				System.err.println("1");
				in=bis.readLine();
				System.out.println(in);
				System.out.println(encrypter.decrypt(in));
				pw.println(encrypter.encrypt("Password"));
				in=bis.readLine();
				System.out.println(in);
				System.out.println(encrypter.decrypt(in));
				if(in!=null){
					pw.println(encrypter.encrypt("exit"));
					break;
				}	
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
