package com.jvue.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Translator {
    public int string2int(String s){
        return Integer.parseInt(s);
    }

    public Date string2date(String s,String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = simpleDateFormat.parse(s);
        return date;
    }

    public String date2string(Date date,String format){
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        String str = sformat.format(date);
        return str;
    }
}
