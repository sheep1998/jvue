package com.jvue.backend.controller;

import com.jvue.backend.dto.DemoDto;
import com.jvue.backend.service.UserService;
import com.jvue.backend.util.*;
import com.jvue.backend.util.BinaryTree.BinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class DemoController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/demo")
    @ResponseBody
    public DemoDto demo() throws InterruptedException, IOException, ParseException {
        //pyDemo();

        return dtoDemo();
    }

    public void translatorDemo() throws ParseException {
        Translator translator = new Translator();
        int i = translator.string2int("123");
        System.out.println(i);
        long now=System.currentTimeMillis();
        Date date = new Date(now);
        String format = "yyyy年MM月dd日";
        String s = translator.date2string(date,format);
        System.out.println(s);
        Date d = translator.string2date(s,format);
        System.out.println(d);
    }

    public void pyDemo(){
        PythonWorker pythonWorker = new PythonWorker();
        String param1 = String.valueOf(1);
        String param2 = String.valueOf(2);
        String[] params = {param1,param2};

        pythonWorker.activate("demo.py",params);
    }

    public void txtDemo() throws IOException {
        TxtUtil util = new TxtUtil();
        util.writeTxt("1.txt");
        util.readTxt("1.txt");
    }

    public void csvDemo() throws IOException {
        CsvUtil util = new CsvUtil();
        ArrayList<String[]> content = new ArrayList<>();
        String[] n1 = {"1","2","3"};
        String[] n2 = {"4","5","6"};
        String[] n3 = {"q","w","e"};
        String[] n4 = {"a","s","d"};
        content.add(n1);
        content.add(n2);
        content.add(n3);
        content.add(n4);
        util.writeCsv("11.csv",content);
        util.readCsv("11.csv");
    }

    public void mysqlDemo(){
        System.out.println(userService.getNameById(2));
        userService.changeNameByName("Li Hu","Boy Friend");
        userService.save("Tiger Oil");
    }

    public void btreeDemo(){
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.delete(80);
        bt.infixOrder(bt.getRoot());
    }

    public void xlsxDemo() throws IOException {
        XlsxUtil util = new XlsxUtil();
        ArrayList<String[]> content = new ArrayList<>();
        String[] n1 = {"1","2","3"};
        String[] n2 = {"4","5","6"};
        String[] n3 = {"q","w","e"};
        String[] n4 = {"a","s","d"};
        content.add(n1);
        content.add(n2);
        content.add(n3);
        content.add(n4);
        String[] title = {"一","二","三","四"};
        util.writeXlsx("data2.xlsx",title,content);
        util.readXlsx("data2.xlsx","Sheet0");
    }

    public DemoDto dtoDemo(){
        DemoDto ety = new DemoDto();
        ety.setMessgae("1");
        return ety;
    }

    public void timeDemo() throws InterruptedException {
        Atimer atimer = new Atimer();
        atimer.catchTime();
        Thread.sleep(1000);
        atimer.catchTime();
        Thread.sleep(2000);
        atimer.catchTime();
        Thread.sleep((3000));
        atimer.catchTime();
        System.out.println(atimer.getMaxInterval());
        ArrayList<Long> intervals = atimer.getIntervals();
        for(int i=0;i<intervals.size();i++){
            System.out.println(intervals.get(i));
        }
    }
}
