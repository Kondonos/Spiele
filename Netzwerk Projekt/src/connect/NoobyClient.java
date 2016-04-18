package connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NoobyClient {
	Socket socket;
	
	public NoobyClient(String host, int port) {
		try {
			socket=new Socket(host, port);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			InputStreamReader cmd=new InputStreamReader(System.in);
			BufferedReader cmdbr=new BufferedReader(cmd);
			AES crypter=new AES("testtesttest", "SHA-256", 16);
			String in=null;
			String com=null;
			while(true){
				System.out.println(1);
				in=crypter.decrypt(br.readLine());
				System.out.println(in);
				if(in.equals("Username")|| in.equals("Password")){
					System.out.print(in+": ");
					com=cmdbr.readLine();
					pw.println(crypter.encrypt(com));
				}
				if(in.equals("exit"))
					break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new NoobyClient("localhost", 9000);
	}
}
