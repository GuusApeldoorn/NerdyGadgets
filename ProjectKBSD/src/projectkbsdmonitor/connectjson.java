package projectkbsdmonitor;

import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class connectjson {
    
    private ArrayList<Node> testtest123;

    public connectjson(){
       testtest123 = new ArrayList<Node>();
   }

//    public ArrayList<Node> getNodes() {
//        return Nodes;
//    }

    public ArrayList<Node> getTesttest123() {
        return testtest123;
    }

    public void setTesttest123(ArrayList<Node> testtest123) {
        this.testtest123 = testtest123;
    }
    
    


//    public ArrayList<Float> Uptime = new ArrayList<Float>();
//    public ArrayList<Integer> TimeStamp = new ArrayList<Integer>();
//    public ArrayList<Integer> DiskFree = new ArrayList<Integer>();
//    public ArrayList<Integer> DiskUsed = new ArrayList<Integer>();
//    public ArrayList<Double> Cpu = new ArrayList<Double>();

    public static HttpURLConnection connection;
//
//
//
//    public Float getUptime(int index){
//        {
//            return Uptime.get(index);
//        }
//
//    }
//
//    public Integer getTimeStamp(int index){
//        {
//            return TimeStamp.get(index);
//        }
//    }
//
//    public Integer getDiskFree(int index){
//        {
//            return DiskFree.get(index);
//        }
//    }
//
//    public Integer getDiskUsed(int index){
//        {
//            return DiskUsed.get(index);
//        }
//    }
//    public Double getCpu(int index){
//        {
//            return Cpu.get(index);
//        }
//    }

    public ArrayList<Node> parse(String jsonString) {
        JSONArray server = new JSONArray(jsonString);
        ArrayList<Node> Nodes = new ArrayList<Node>();


        for (int i = 0; i < server.length(); i++) {
            JSONObject mData = server.getJSONObject(i);


            float uptime = mData.getFloat("uptime");
            String name = mData.getString("name");
            int timestamp = mData.getInt("timestamp");
            int diskFree = mData.getInt("disk_free");
            int diskUsed = mData.getInt("disk_used");
            double cpu = mData.getDouble("cpu");
            //System.out.println("uptime:" + uptime + " nameserver:" + name + " timestamp:" + timestamp + " Diskfree:" + diskFree + " diskused:" + diskUsed + " CPU:" + cpu);

            Node node = new Node(uptime,name,timestamp,diskFree,diskUsed,cpu);
            Nodes.add(node);

//            for(int a = 0; a < Nodes.size(); a++) {
//             System.out.print(Nodes.get(a)+", ");
//          }



            //Stopt de data in uit de JSONarray in de volgende arraylists.
//            Uptime.add(mData.getFloat("uptime"));
//            TimeStamp.add(mData.getInt("timestamp"));
//            DiskFree.add(mData.getInt("disk_free"));
//            DiskUsed.add(mData.getInt("disk_used"));
//            Cpu.add(mData.getDouble("cpu"));
        }

        return Nodes;

//        for(int a = 0; a < Nodes.size(); a++) {
//            System.out.println(Nodes.get(a)+", ");
//        }

        // checken of er data in de arraylists word gestopt.

//        for(int a = 0; a < Uptime.size(); a++) {
//            System.out.print(Uptime.get(a)+", ");
//        }
//        for(int a = 0; a < TimeStamp.size(); a++) {
//            System.out.print(TimeStamp.get(a)+", ");
//        }
//        for(int a = 0; a < DiskFree.size(); a++) {
//            System.out.print(DiskFree.get(a)+", ");
//        }
//        for(int a = 0; a < DiskUsed.size(); a++) {
//            System.out.print(DiskUsed.get(a)+", ");
//        }
//        for(int a = 0; a < Cpu.size(); a++) {
//            System.out.print(Cpu.get(a)+", ");
//        }



    }







        public  String getConnection() {


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
                //System.out.println(statusconnection);

                BufferedReader reader;
                String line;
                StringBuffer responseContent = new StringBuffer();


                if (statusconnection > 299) {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();

                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    reader.close();


                }

                //System.out.println(responseContent);
                //maakt van de stringbuffer(responseContent) een string
               String responseContent1 = new String(responseContent);
//                parse(responseContent1);

                return responseContent1;



            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                connection.disconnect();
            }




        }

        // methode die er voor zorgt dat er om de 2 seconden de data.json op nieuw wordt aangevraagd en verwerkt worden
        // zo dat de gegevens in de applicatie up to dat blijven.
        public void Loop() {
            Timer timer = new Timer();
            TimerTask myTask = new TimerTask() {
                @Override
                public void run() {
                    connectjson Connect = new connectjson();
                    String response = Connect.getConnection();
//                    Connect.Print(Connect.parse(response));
                    setTesttest123(Connect.parse(response));
                }

            };


            // hier de tijd aanpassen als het sneller of slomer moet. 2000 ms = 2 s
            timer.schedule(myTask, 2000, 2000);
        }


        public void Print(ArrayList<Node> arrayList){

        //arrayList.get(0).getUptime();
            for(int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }

        }

}


