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
    
    public OurLoginService() {
    	writeToDatabase("olero", "valid_password");
    	writeToDatabase("dendu", "password");
    }
    
 void writeToDatabase(String userName, String pwd, boolean... args) {
        JSONObject obj = new JSONObject();
        obj.put("id", (int)(Math.random() * 10000));
        obj.put("username", userName);
        obj.put("password", pwd);
        
        // Add session if we logged in
        if(args.length > 0 && args[0]) {
        	obj.put("session", userName + "933");
        }

    try {
        bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(obj.toJSONString());
        bw.newLine();
        bw.flush();
        bw.close();
	    } catch (IOException e) {
	        System.out.println(e);
	    }
    }

    @Override
    public boolean login(String userName, String pwd) {
    	
        try {
            br = new BufferedReader(new FileReader(file));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                JSONObject obj = (JSONObject) parser.parse(line);
                
                if (obj.get("username").equals(userName) && obj.get("password").equals(pwd)) {
                	// Add session string
                    writeToDatabase(userName, pwd, true);
                    return true;
                }
                
            }
        } catch (Exception e) {
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

                if (obj.get("username").equals(userName) && obj.containsKey("session")) {
                    return obj.get("session").toString();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return "NO";
    }

    public void clearData() {
        file.delete();
    }
}
