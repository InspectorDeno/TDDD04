package se.liu.ida;

import java.io.*;
import java.util.UUID;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;


public class OurLoginService implements LoginService {

    BufferedWriter bw = null;
    BufferedReader br = null;
    JSONParser parser = new JSONParser();
    File file = new File("database.txt");

    @Override
    public boolean login(String userName, String pwd) {

        JSONObject obj = new JSONObject();
            obj.put("id", (int)(Math.random() * 10000));
            obj.put("username", userName);
            obj.put("password", pwd);
            obj.put("session", UUID.randomUUID().toString());

        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(obj.toJSONString());
            bw.flush();
            bw.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
            return false;
    }

    @Override
    public int getId(String userName) {

        try {
            br = new BufferedReader(new FileReader(file));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                JSONObject obj = (JSONObject) parser.parse(line);
                if (obj.get("username").equals(userName)) {
                    return Integer.parseInt(obj.get("id").toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public String getSession(String userName) {
        try {
            br = new BufferedReader(new FileReader(file));
            for (String line = br.readLine(); line != null; line = br.readLine()) {

                JSONObject obj = (JSONObject) parser.parse(line);

                if (obj.get("username").equals(userName)) {
                    return obj.get("session").toString();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void clearData() {
        file.delete();
    }
}
