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

    public static String parse(String jsonString) {

        JSONArray server = new JSONArray(jsonString);

        for (int i = 1; i < server.length(); i++){
            JSONObject mData = server.getJSONObject(i);
            float uptime = mData.getFloat("uptime");
            String name = mData.getString("name");
            int timestamp = mData.getInt("timestamp");
            int diskFree = mData.getInt("disk_free");
            int diskUsed = mData.getInt("disk_used");
            double cpu = mData.getDouble("cpu");

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

            //maakt van de stringbuffer(responseContent) een string
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


