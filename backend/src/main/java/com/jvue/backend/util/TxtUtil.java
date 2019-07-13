package com.jvue.backend.util;

import java.io.*;

public class TxtUtil {
    public void writeTxt(String filename) throws IOException {
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\txt\\" + filename;
        File file = new File(path);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(writer);
        out.write("123\r\n");
        out.write("\r\n");
        out.newLine();
        out.write("234\r\n");
        out.flush();
        out.close();
    }

    public void readTxt(String filename) throws IOException {
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\txt\\" + filename;
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }


}
