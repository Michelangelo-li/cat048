package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_055_Mode_1CodeInOctalRepresentation {
    private int V;
    private int G;
    private int L;
    private String Mode1_Code;
    public static int length = 1;

    public I048_055_Mode_1CodeInOctalRepresentation(int[] data, int index) {
        int A;
        int B;
        // 111
        V = (data[index] >> 7) & 0x01;
        G = (data[index] >> 6) & 0x01;
        L = (data[index] >> 5) & 0x01;
        A = (data[index] >> 2) & 0x07;
        B = data[index] & 0x03;
        Mode1_Code = A+""+B;
    }

    @Override
    public String toString() {
        return V + "," + G + "," + L + "," + Mode1_Code;
    }
}
