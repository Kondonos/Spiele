package ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocket;

public class ServerThread extends Thread{
	Socket ssls;
	public ServerThread(Socket socket) {
		this.ssls=socket;
	}
	public void run(){
		try {
			PrintWriter pw=new PrintWriter(ssls.getOutputStream(),true);
			InputStreamReader isr=new InputStreamReader(ssls.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			System.out.println("user "+ br.readLine() +" is now connecte to the server...");
			while(true){
				pw.println(br.readLine()+" echo");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
