package com.jvue.backend.util;

import java.io.*;
import java.util.ArrayList;

public class CsvUtil {
    public ArrayList<String[]> readCsv(String filename) throws IOException {
        ArrayList<String[]> content = new ArrayList<>();
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\csv\\" + filename;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        while((line=reader.readLine())!=null){
            String[] item = line.split(",");
            //System.out.println(String.join("-",item));
            content.add(item);
        }
        System.out.println(content.size());
        return content;
    }

    public void writeCsv(String filename,ArrayList<String[]> content) throws IOException {
        String path = "C:\\Users\\1535725170\\Documents\\GitHub\\jvue\\csv\\" + filename;
        File csv = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(csv,true));
        for(int i=0;i<content.size();i++){
            writer.write(String.join(",",content.get(i)));
            writer.newLine();
        }
        writer.close();
    }
}
