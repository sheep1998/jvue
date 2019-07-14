package com.jvue.backend.util;


import java.util.ArrayList;
import java.util.Date;

public class Atimer {
    private ArrayList<String> timeList = new ArrayList<>();

    public void catchTime(){
        this.timeList.add(String.valueOf(new Date().getTime()));
    }

    public long getMaxInterval(){
        if(this.timeList.size()<=1){
            System.out.println("WARNING: timeList length <=1");
            return 0;
        }
        long interval = Long.valueOf(this.timeList.get(this.timeList.size()-1)) - Long.valueOf(this.timeList.get(0));
        System.out.println("time maxInterval:");
        System.out.println(interval);
        return interval;
    }

    public ArrayList<Long> getIntervals(){
        ArrayList<Long> intervals = new ArrayList<>();
        System.out.println("time intervals:");
        for (int i=1; i<this.timeList.size(); i++){
            Long interval = Long.valueOf(this.timeList.get(i)) - Long.valueOf(this.timeList.get(i-1));
            intervals.add(interval);
            System.out.println(String.valueOf(i-1)+" "+String.valueOf(i)+": "+String.valueOf(interval));
        }
        return intervals;
    }

    public int ran(int max,int min){
        return (int)(Math.random()*(max-min)+min);
    }





}
