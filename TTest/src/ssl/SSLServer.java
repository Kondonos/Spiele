package ssl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class SSLServer {
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
			SSLServerSocketFactory sslssf=ctx.getServerSocketFactory();
			SSLServerSocket sslss=(SSLServerSocket)sslssf.createServerSocket(9999);
			sslss.setEnabledCipherSuites(sslss.getSupportedCipherSuites());
			sslss.setEnabledProtocols( new String[]{"TLSv1","TLSv1.1","TLSv1.2"});
			System.out.println("Server up & ready for connections...");
			while(true){
				new ServerThread(sslss.accept()).start();
			}
			
		} catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException | KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

