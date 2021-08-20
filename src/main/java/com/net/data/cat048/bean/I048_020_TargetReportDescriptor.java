package com.net.data.cat048.bean;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;

@Data
public class I048_020_TargetReportDescriptor {
    private String TYP;
    private int SIM;
    private int RDP;
    private int SPI;
    private int RAB;
    private int TST;
    private int ERR;
    private int XPP;
    private int ME;
    private int Mi;
    private String FOE_FRI;

    public static int length;

    //    public ArrayList<JSONObject> jsonObjects;
    public I048_020_TargetReportDescriptor(int[] data, int index) {
        TYP = ((data[index] >> 7) & 0x01) + "" + ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01);
        SIM = (data[index] >> 4) & 0x01;
        RDP = (data[index] >> 3) & 0x01;
        SPI = (data[index] >> 2) & 0x01;
        RAB = (data[index] >> 1) & 0x01;
        length += 1;
        if ((data[index] & 0x01) == 1) {
            length += 1;
            TST = (data[index + 1] >> 7) & 0x01;
            ERR = (data[index + 1] >> 6) & 0x01;
            XPP = (data[index + 1] >> 5) & 0x01;
            ME = (data[index + 1] >> 4) & 0x01;
            Mi = (data[index + 1] >> 3) & 0x01;
            FOE_FRI = ((data[index + 1] >> 2) & 0x01) + "" + ((data[index + 1] >> 1) & 0x01);
        }
    }

    //    public I048_020_TargetReportDescriptor(int[] data, int index) {
//        jsonObjects = new ArrayList<>();
//
//        int currentIndex = index;
//        int oByte = 0;
//
//        TYP = ((data[index] >> 7) & 0x01) + "" + ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01);
//        SIM = (data[index] >> 4) & 0x01;
//        RDP = (data[index] >> 3) & 0x01;
//        SPI = (data[index] >> 2) & 0x01;
//        RAB = (data[index] >> 1) & 0x01;
//
//        // 1 2 3
//        do {
//            //1 2
//            length += 1;
//            //currentIndex = 0 1
//            oByte = data[currentIndex];
//
//            if ((oByte & 0x01) == 1) {
//                int TST;
//                int ERR;
//                int XPP;
//                int ME;
//                int Mi;
//                String FOE_FRI;
//                JSONObject jsonObject = new JSONObject();
//                //currentIndex = 1 2
//                //1001 1000
//                oByte = data[currentIndex + 1];
//
//
//                TST = (oByte >> 7) & 0x01;
//                jsonObject.put("TST", TST);
//
//
//                ERR = (oByte >> 6) & 0x01;
//                jsonObject.put("ERR", ERR);
//
//
//                XPP = (oByte >> 5) & 0x01;
//                jsonObject.put("XPP", XPP);
//
//
//                ME = (oByte >> 4) & 0x01;
//                jsonObject.put("ME", ME);
//
//                Mi = (oByte >> 3) & 0x01;
//                jsonObject.put("Mi", Mi);
//
//                FOE_FRI = ((oByte >> 2) & 0x01) +""+((oByte >> 1) & 0x01);
//                jsonObject.put("FOE_FRI", FOE_FRI);
//
//                currentIndex += 1;
//
//                jsonObjects.add(jsonObject);
//            }
//        } while ((oByte & 0x01) == 0x01);
//
//    }
//private String TYP;
//    private int SIM;
//    private int RDP;
//    private int SPI;
//    private int RAB;
//    private int TST;
//    private int ERR;
//    private int XPP;
//    private int ME;
//    private int Mi;
//    private String FOE_FRI;
    @Override
    public String toString() {
        return TYP + "," +SIM+ "," +RDP+ "," +SPI+ "," +RAB+ "," +TST+ "," +ERR+ "," +XPP+ "," +ME+ "," +Mi+ "," +FOE_FRI;
    }
}
