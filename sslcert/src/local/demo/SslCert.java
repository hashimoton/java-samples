package local.demo;

import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;

public class SslCert {

  public static void main(String[] args)
  {
    try {
      URL url = new URL(args[0]);
      HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
      conn.connect();
      System.out.println("Connected");

      Certificate[] certs = conn.getServerCertificates();
      for (int i = 0; i < certs.length; i++) {
        Certificate cert = certs[i];
        System.out.println("*** Certificate " + i + "***");
        System.out.println(cert);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
