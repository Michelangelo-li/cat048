package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_260_ACASResolutionAdvisoryReport {
    private String MB_DATA;
    public static int length = 7;

    public I048_260_ACASResolutionAdvisoryReport(int[] data, int index) {
        MB_DATA =data[0]+""+data[1]+""+data[2]+""+data[3]+""+data[4]+""+data[5]+""+data[6];
    }

    @Override
    public String toString() {
        return MB_DATA + "";
    }
}
