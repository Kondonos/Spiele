package ssl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.math.BigInteger;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import java.security.NoSuchAlgorithmException;

import java.util.Calendar;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v1CertificateBuilder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.util.encoders.Base64Encoder;

public class GenerateCSR {
	public static void main(String[] args) {
		try {
			KeyPairGenerator rsa;
		
			rsa = KeyPairGenerator.getInstance("RSA");
			rsa.initialize(4096);
			KeyPair kp = rsa.generateKeyPair();
		
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 1);

			byte[] pk = kp.getPublic().getEncoded();
			SubjectPublicKeyInfo bcPk = SubjectPublicKeyInfo.getInstance(pk);
			
			X509v1CertificateBuilder certGen = new X509v1CertificateBuilder(
					new X500Name("CN=CA Cert"),
					BigInteger.ONE,
					new Date(),
					cal.getTime(),
					new X500Name("CN=CA Cert"),
					bcPk
					);

			X509CertificateHolder certHolder = certGen
					.build(new JcaContentSignerBuilder("SHA1withRSA").build(kp.getPrivate()));

			Base64Encoder encoder = new Base64Encoder();

			System.out.println("CA CERT");
			System.out.println();
			File file=new File("test");
			file.createNewFile();
			encoder.encode(certHolder.getEncoded(), 0, certHolder.getEncoded().length, new FileOutputStream(file));
			System.out.println();
		} catch (NoSuchAlgorithmException | OperatorCreationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}
    
}
