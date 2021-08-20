package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_250_ModeSMBData {
    private int REP;
    private String MB_DATA;


    private int BDS1;
    private int BDS2;
    public static int length = 9;

    public I048_250_ModeSMBData(int[] data, int index) {
        REP = data[index];
        MB_DATA = data[index + 1] + "" + data[index + 2] + "" + data[index + 3] + "" + data[index + 4] + "" + data[index + 5] + "" + data[index + 6] + "" + data[index + 7];
        BDS1 = data[index + 8] & 0xf0;
        BDS2 = data[index + 8] & 0x0f;
    }
    @Override
    public String toString(){
        return REP+","+MB_DATA+","+BDS1+","+BDS2;
    }
}
