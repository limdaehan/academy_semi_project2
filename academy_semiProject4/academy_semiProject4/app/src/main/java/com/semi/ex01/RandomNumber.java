package com.semi.ex01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomNumber {
    static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    static int seq = 0;

    public static String makeId() {
        Date date = new Date();
        String dateStr = format.format(date);

        String id = "U" + dateStr + getSeq();

        return id;
    }

    public static String getSeq() {
        seq += 1;
        if(seq == 999) {
            seq = 1;
        }
        String seqStr = String.valueOf(seq);
        if(seqStr.length() == 1){
            seqStr = "00" + seqStr;

        } else if (seqStr.length() == 2) {
            seqStr = "0" + seqStr;
        }
        return seqStr;
    }
}
