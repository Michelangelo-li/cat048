package com.net.data.cat048.bean;


import com.net.data.cat048.decoder.CommonUtil;
import lombok.Data;

@Data
public class I048_240_AircraftIdentification {
    private String AircraftIdentification;
//    private String AircraftIdentification2;
    public static int length = 6;

    public I048_240_AircraftIdentification(int[] data, int index) {
//        int character1 = (data[index] >> 2) & 0x3f;
//        int character2 = ((data[index] & 0x03) << 4) | ((data[index + 1] & 0xf0) >> 4);
//        int character3 = ((data[index + 1] & 0x0f) << 2) | ((data[index + 2] & 0xc0) >> 6);
//        int character4 = data[index + 2] & 0x3f;
//        int character5 = data[index + 3] & 0xfc;
//        int character6 = (data[index + 3] & 0x03) << 4 | (data[index + 4] & 0xf0) >> 4;
//        int character7 = (data[index + 4] & 0x0f) << 2 | ((data[index + 5] & 0xc0) >> 6);
//        int character8 = data[index + 5] & 0x3f;
//        AircraftIdentification1 = character1 + " " + character2 + " " + character3 + " " + character4 + " " + character5 + " " + character6 + " " + character7 + " " + character8;
        AircraftIdentification = CommonUtil.bytesToCallsign(
                new int[]{data[index], data[index + 1], data[index + 2], data[index + 3], data[index + 4], data[index + 5]}
        );
    }

    @Override
    public String toString() {
        return AircraftIdentification;

    }
}
