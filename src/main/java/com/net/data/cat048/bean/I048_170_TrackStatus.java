package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_170_TrackStatus {
    private int CNF;
    private String RAD;
    private int DOU;
    private int MAH;
    private String CDM;
    private int TRE;
    private int GHO;
    private int SUP;
    private int TCC;

    public static int length = 0;

    public I048_170_TrackStatus(int[] data, int index) {
        CNF = (data[index] >> 7) & 0x01;
        RAD = ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01);
        DOU = (data[index] >> 4) & 0x01;
        MAH = (data[index] >> 3) & 0x01;
        CDM = ((data[index] >> 2) & 0x01) + "" + ((data[index] >> 1) & 0x01);
        length += 1;
        if ((data[index] & 0x01) == 1) {
            length += 1;
            TRE = (data[index + 1] >> 7) & 0x01;
            GHO = (data[index + 1] >> 5) & 0x01;
            SUP = (data[index + 1] >> 4) & 0x01;
            TCC = (data[index + 1] >> 3) & 0x01;
        }
    }

    @Override
    public String toString() {
        return CNF + "," + RAD + "," + DOU + "," + MAH + "," + CDM + "," + TRE + "," + GHO + "," + SUP + "," + TCC;
    }
}
