package ssl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;


public class SSLClient {
	public static void main(String[] args) {
		try {
			KeyStore ks=KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(new FileInputStream("my.store"), "projekte".toCharArray());
			TrustManagerFactory tmf=TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			tmf.init(ks);
			SSLContext ctx=SSLContext.getInstance("SSL");
			KeyManagerFactory kmf=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(ks, "projekte".toCharArray());
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
			SSLSocketFactory sslsf=ctx.getSocketFactory();
			SSLSocket ssls=(SSLSocket)sslsf.createSocket("localhost", 9999);
			InputStreamReader isr =new InputStreamReader(ssls.getInputStream());
			BufferedReader sbr=new BufferedReader(isr);
			PrintWriter pw=new PrintWriter(ssls.getOutputStream(),true);
			InputStreamReader cmd=new InputStreamReader(System.in);
			BufferedReader cbr=new BufferedReader(cmd);
			System.out.println("please enter a username: ");
			pw.println(cbr.readLine());
			String message=null;
			while(true){
				System.out.println( "please enter a message to sen to server: ");
				message=cbr.readLine();
				if(message.equals("exit")){
					pw.println(message);
					ssls.close();
					break;
				}
				pw.println(message);
				System.out.print("message reply from server: ");
				System.out.println(sbr.readLine());
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ConnectException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
