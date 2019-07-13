package com.jvue.backend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonWorker {

    public void activate(String filename,String[] params){
        try{
            String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\pyend\\"+filename;
            String[] args1 = new String[]{"python",path,String.join("-",params)};
            Process process = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    process.getInputStream()
            ));
            String line;
            while ((line = in.readLine()) !=null){
                System.out.println(line);
            }
            in.close();
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
