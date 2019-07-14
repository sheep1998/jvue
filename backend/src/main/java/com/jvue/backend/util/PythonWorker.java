package com.jvue.backend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PythonWorker {

    public List<String> activate(String filename,String[] params){
        try{
            String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pyend\\"+filename;
            String[] args1 = new String[]{"python",path,String.join("-",params)};
            Process process = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    process.getInputStream()
            ));
            String line;
            List<String> result = new LinkedList<>();
            while ((line = in.readLine()) !=null){
                System.out.println(line);
                result.add(line);
            }
            in.close();
            process.waitFor();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
