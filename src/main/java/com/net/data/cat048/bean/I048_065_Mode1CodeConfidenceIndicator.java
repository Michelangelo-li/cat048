package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_065_Mode1CodeConfidenceIndicator {
    private String Confidence_Indicator;

    public static int length = 1;

    public I048_065_Mode1CodeConfidenceIndicator(int[] data, int index) {
        int QA4;
        int QA2;
        int QA1;
        int QB2;
        int QB1;
        QA4 = (data[index] >> 4) & 0x01;
        QA2 = (data[index] >> 3) & 0x01;
        QA1 = (data[index] >> 2) & 0x01;
        QB2 = (data[index] >> 1) & 0x01;
        QB1 = data[index] & 0x01;
        Confidence_Indicator = QA4 + "" + QA2 + "" + QA1 + "" + QB2 + "" + QB1;
    }

    @Override
    public String toString() {
        return Confidence_Indicator;
    }
}
