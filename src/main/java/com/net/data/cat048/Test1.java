package com.net.data.cat048;


import com.alibaba.fastjson.JSONObject;
import com.net.data.cat048.bean.*;
import lombok.Data;
import org.junit.jupiter.api.Test;

import javax.tools.Diagnostic;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;

public class Test1 {


    @Test
    public void test1() {
        // 153 1001 1001  1001 1000
        int[] data = new int[]{31, 153, 62};
//        int[] data = new int[]{31,152};
        //FOE_FRI":0,"TST":1,"ERR":0,"ME":1,"XPP":0,"Mi":1}
        I048_020_TargetReportDescriptor i048_020_targetReportDescriptor = new I048_020_TargetReportDescriptor(data, 0);

        System.out.println(i048_020_targetReportDescriptor);
    }

    @Test
    public void test2() {
        int[] data = new int[]{31, 152};
        I048_030_WarningOrErrorConditions conditions = new I048_030_WarningOrErrorConditions(data, 0);
        System.out.println(conditions);
    }

    @Test
    public void test3() {
        int[] data = new int[]{31, 152, 24, 53};
        I048_040_MeasuredPositionInPolarCo_ordinates i048_040_measuredPositionInPolarCo_ordinates = new I048_040_MeasuredPositionInPolarCo_ordinates(data, 0);
        System.out.println(i048_040_measuredPositionInPolarCo_ordinates);
    }

    @Test
    public void test42() {
        int[] data = new int[]{31, 152, 24, 53};
        I048_042_CalculatedPositionInCartesianCo_ordinates i048_042_calculatedPositionInCartesianCo_ordinates = new I048_042_CalculatedPositionInCartesianCo_ordinates(data, 0);
        System.out.println(i048_042_calculatedPositionInCartesianCo_ordinates);
        System.out.println("lsb" + 360 / Math.pow(2, 14));
    }

    @Test
    public void test4() {
        //0111 1011
        //1001 1001
        int[] data = new int[]{123, 153};
        I048_050_Mode_2CodeInOctalRepresentation i048_050_mode_2CodeInOctalRepresentation = new I048_050_Mode_2CodeInOctalRepresentation(data, 0);
        System.out.println(i048_050_mode_2CodeInOctalRepresentation);
    }

    @Test
    public void test5() {
        int[] data = new int[]{122};
        I048_055_Mode_1CodeInOctalRepresentation i048_055_mode_1CodeInOctalRepresentation = new I048_055_Mode_1CodeInOctalRepresentation(data, 0);
        System.out.println(i048_055_mode_1CodeInOctalRepresentation.toString());
    }

    @Test
    public void test6() {
        int[] data = new int[]{122, 31};
        I048_060_Mode2CodeConfidenceIndicator i048_060_mode2CodeConfidenceIndicator = new I048_060_Mode2CodeConfidenceIndicator(data, 0);
        System.out.println(i048_060_mode2CodeConfidenceIndicator);
    }

    @Test
    public void test7() {
        int[] data = new int[]{27};
        I048_065_Mode1CodeConfidenceIndicator i048_065_mode1CodeConfidenceIndicator = new I048_065_Mode1CodeConfidenceIndicator(data, 0);
        System.out.println(i048_065_mode1CodeConfidenceIndicator);
    }

    @Test
    public void test8() {
        //10101 1011 1001 1100
        //1101 0100  0101 0111
        int[] data = new int[]{212, 87};
        I048_090_FlightLevelInBinaryRepresentation i048_090_flightLevelInBinaryRepresentation = new I048_090_FlightLevelInBinaryRepresentation(data, 0);
        System.out.println(i048_090_flightLevelInBinaryRepresentation);
    }

    @Test
    public void test9() {
        int[] data = new int[]{10, 3};
        I048_110_HeightMeasuredByA3DRadar i048_110_heightMeasuredByA3DRadar = new I048_110_HeightMeasuredByA3DRadar(data, 0);
        System.out.println(i048_110_heightMeasuredByA3DRadar);

    }

    @Test
    public void test10() {
        // 1000 0001
        //21: 0001 0101 61： 0011 1101
        int[] data = new int[]{193, 21, 61, 24, 53, 64, 24, 13, 24, 53};
        I048_120_RadialDopplerSpeed i048_120_radialDopplerSpeed = new I048_120_RadialDopplerSpeed(data, 0);
        System.out.println(i048_120_radialDopplerSpeed);
    }

    @Test
    public void test11() {
        System.out.println("2^14:" + Math.pow(2, 6));
        System.out.println(360 / Math.pow(2, 14));
    }

    @Test
    public void test12() {
        int[] data = new int[]{254, 34, 123, 234, 12, 42, 512, 254};
        I048_130_RadarPlotCharacteristics i048_130_radarPlotCharacteristics = new I048_130_RadarPlotCharacteristics(data, 0);
        System.out.println(i048_130_radarPlotCharacteristics);
    }

    @Test
    public void test13() {
        int[] data = new int[]{1, 2, 4};
        I048_140_TimeOfDay i048_140_timeOfDay = new I048_140_TimeOfDay(data, 0);
        System.out.println(i048_140_timeOfDay);

    }

    @Test
    public void test161() {
        int[] data = new int[]{15, 255};
        I048_161_TrackNumber i048_161_trackNumber = new I048_161_TrackNumber(data, 0);
        System.out.println(i048_161_trackNumber);
    }

    @Test
    public void test14() {
        int[] data = new int[]{43, 182};
        I048_170_TrackStatus i048_170_trackStatus = new I048_170_TrackStatus(data, 0);
        System.out.println(i048_170_trackStatus);
    }

    @Test
    public void test15() {
        int[] data = new int[]{43, 182, 2, 5};
        I048_210_TrackQuality i048_210_trackQuality = new I048_210_TrackQuality(data, 0);
        System.out.println(i048_210_trackQuality);
    }

    @Test
    public void test16() {
        int[] data = new int[]{43, 12, 3};
        I048_220_AircraftAddress i048_220_aircraftAddress = new I048_220_AircraftAddress(data, 0);
        System.out.println(i048_220_aircraftAddress);
    }

    @Test
    public void test17() {
        int[] data = new int[]{123, 241};
        I048_230_CommunicationsACASCapabilityAndFlightStatus i048_230_communicationsACASCapabilityAndFlightStatus = new I048_230_CommunicationsACASCapabilityAndFlightStatus(data, 0);
        System.out.println(i048_230_communicationsACASCapabilityAndFlightStatus);
    }

    @Test
    public void test18() {
        int[] data = new int[]{1, 2, 3};
        System.out.println(data[0] + data[1]);
        System.out.println(data[0] << 8 | data[1]);
    }

    @Test
    public void test19() {
        int[] data = new int[]{1, 2, 3};
        //0010 0000  0000 0010
        System.out.println((data[0] << 7) | data[1] >> 6);
    }

    @Test
    public void test20() {
        int[] data = new int[]{123, 153};
        int index = 0;
        int a2 = ((data[index] & 0x01) << 2) | ((data[index + 1] & 0xc0) >> 6);
        System.out.println((data[index] & 0x01) << 3);
        System.out.println(a2);
    }

    @Test
    public void test240() {
        //1010 1100
        //0101 0101
        int[] data = new int[]{172, 85, 87, 25, 32, 35};
        I048_240_AircraftIdentification i048_240_aircraftIdentification = new I048_240_AircraftIdentification(data, 0);
        System.out.println(i048_240_aircraftIdentification);
    }

    @Test
    public void test100() {
        int[] data = {140, 3};
        I048_100_ModeCCodeAndCodeConfidenceIndicator i048_100_modeCCodeAndCodeConfidenceIndicator = new I048_100_ModeCCodeAndCodeConfidenceIndicator(data, 0);
        System.out.println(i048_100_modeCCodeAndCodeConfidenceIndicator);
    }

    @Test
    //异或 不同为1 相同为0
    public void test101() {
        char[] oldChars = {'0', '1'};
        char[] newChars = new char[oldChars.length];
        newChars[0] = oldChars[0];
        for (int i = 0; i < oldChars.length - 1; i++) {
//            System.out.println("newChars[i]"+newChars[i]);
//            System.out.println("oldChars[i + 1]"+oldChars[i + 1]);

            newChars[i + 1] = Character.forDigit((newChars[i] ^ oldChars[i + 1]),10);
        }

        for (char c : newChars) {
            System.out.print(c + " ");
        }
//        System.out.println((char) 0);

    }


    // 十六进制字符串转化成 字节数组
    public static byte[] hexString2Bytes(String hex) {

        if ((hex == null) || (hex.equals(""))) {
            return null;
        } else if (hex.length() % 2 != 0) {
            return null;
        } else {
            hex = hex.toUpperCase();
            int len = hex.length() / 2;
            byte[] b = new byte[len];
            char[] hc = hex.toCharArray();
            for (int i = 0; i < len; i++) {
                int p = 2 * i;
                b[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p + 1]));
            }
            return b;
        }

    }

    //    字符转换为字节
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}