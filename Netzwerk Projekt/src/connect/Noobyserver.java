package connect;

import java.io.IOException;
import java.net.ServerSocket;

public class Noobyserver {
	ServerSocket serversocket;
	
	public Noobyserver(int port){
		try {
			this.serversocket=new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startServer(){
		while(true)
			try {
				new NoobyThread(this.serversocket.accept()).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		new Noobyserver(9000).startServer();;
	}
}

