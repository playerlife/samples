import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.io.OutputStream;

 import java.net.HttpURLConnection;
import java.net.MalformedURLException;

 import java.net.URL;
 import org.json.JSONObject;
import org.json.JSONArray; 
 
public class AppAddTest {
 
    public static final String ADD_URL = "http://192.168.4.68:35357/v2.0/users";
 //   public static final String ADD_URL = "http://192.168.4.97:35357/v2.0/tokens";
    public static void appadd() throws IOException {
    	HttpURLConnection connection=null;
        try {
             //��������
             URL url = new URL(ADD_URL);
             connection = (HttpURLConnection) url.openConnection();
             

             //����http��������
             
             connection.setDoOutput(true);
             connection.setDoInput(true);
             connection.setRequestMethod("POST"); // ���Ը�����Ҫ �ύ GET��POST��DELETE��INPUT��http�ṩ�Ĺ���
             connection.setUseCaches(false);
             connection.setInstanceFollowRedirects(true);
             
             //����httpͷ ��Ϣ
             connection.setRequestProperty("Content-Type","application/json");  //�趨 �����ʽ json��Ҳ�����趨xml��ʽ��
             //connection.setRequestProperty("Content-Type", "text/xml");   //�趨 �����ʽ xml��
             connection.setRequestProperty("Accept","application/json");//�趨��Ӧ����Ϣ�ĸ�ʽΪ json��Ҳ�����趨xml��ʽ��
//             connection.setRequestProperty("X-Auth-Token","xx");  //�ض�http��������Ҫ����Ϣ�����ݷ���������Ҫ�����
             connection.connect();
 
             //��� ��������
             
            JSONObject user = new JSONObject();  
            user.put("name", "alice4");
            user.put("roles", "admin");
            user.put("enabled", "true");
            user.put("tenantId", "998abe42845e4f258da7e96b0d8335ec");
            user.put("password", "mypassword123");

            //����Ƕ�׵� json����
            
            JSONObject obj = new JSONObject();
             obj.put("user",user);
             OutputStream out = connection.getOutputStream();                        
             out.write(obj.toString().getBytes());
             out.flush();
             out.close();
 
//            ��ȡ��Ӧ
             BufferedReader reader = new BufferedReader(new InputStreamReader(
                     connection.getInputStream()));
             String lines;
             StringBuffer sb = new StringBuffer("");
             while ((lines = reader.readLine()) != null) {
                 lines = new String(lines.getBytes(), "utf-8");
                 sb.append(lines);
             }
             System.out.println(sb);
             reader.close();
////              �Ͽ�����
             connection.disconnect();
         } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
 
    }

 
    public static void main(String[] args) throws IOException {
         appadd();
     }
 
}