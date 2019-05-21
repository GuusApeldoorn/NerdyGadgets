package projectkbsd;

import org.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import org.json.*;


public class connectjson {

    private static HttpURLConnection connection;

    public static String parse(String responseBody) {
        System.out.println();
        JSONArray mData = new JSONArray(responseBody);

        for (int i = 0; i < mData.length(); i++){
            JSONObject server = mData.getJSONObject(i);
            float uptime = server.getFloat("uptime");
            String name = server.getString("name");
            int timestamp = server.getInt("timestamp");
            int diskFree = server.getInt("disk_free");
            int diskUsed = server.getInt("disk_used");
            double cpu = server.getDouble("cpu");

            System.out.println("uptime:" + uptime + " nameserver:" + name + " timestamp:" + timestamp + " Diskfree:" + diskFree + " diskused:" + diskUsed + " CPU:" + cpu );

        }

        return null;


    }



    public static void main(String[] args){

        //methode 1: 145.44.235.233:443/data.json
        try {
            URL url = new URL("http://145.44.235.233:443/data.json");
            connection = (HttpURLConnection) url.openConnection();


            // Request setup
            connection.setRequestMethod("GET");
            //Als de connectie niet succesvol is na 5 seconden dan timed hij de connection out
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int statusconnection = connection.getResponseCode();
            System.out.println(statusconnection);

            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();


            if(statusconnection > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();

            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();


            }

            //System.out.println(responseContent);
            String responseContent1 = new String(responseContent);
            parse(responseContent1);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }






    }
}


