package com.net.data.cat048.decoder;

import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat048.bean.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CAT048Track {

//    I048_0_MessageType i048_0_messageType;
    I048_010_DataSourceIdentifier i048_010_dataSourceIdentifier;
    I048_020_TargetReportDescriptor i048_020_targetReportDescriptor;
    I048_030_WarningOrErrorConditions i048_030_warningOrErrorConditions;
    I048_040_MeasuredPositionInPolarCo_ordinates i048_040_measuredPositionInPolarCo_ordinates;
    I048_042_CalculatedPositionInCartesianCo_ordinates i048_042_calculatedPositionInCartesianCo_ordinates;
    I048_050_Mode_2CodeInOctalRepresentation i048_050_mode_2CodeInOctalRepresentation;
    I048_055_Mode_1CodeInOctalRepresentation i048_055_mode_1CodeInOctalRepresentation;
    I048_060_Mode2CodeConfidenceIndicator i048_060_mode2CodeConfidenceIndicator;
    I048_065_Mode1CodeConfidenceIndicator i048_065_mode1CodeConfidenceIndicator;
    I048_070_Mode3ACodeInOctalRepresentation i048_070_mode3ACodeInOctalRepresentation;
    I048_080_Mode3ACodeConfidenceIndicator i048_080_mode3ACodeConfidenceIndicator;
    I048_090_FlightLevelInBinaryRepresentation i048_090_flightLevelInBinaryRepresentation;
    I048_100_ModeCCodeAndCodeConfidenceIndicator i048_100_modeCCodeAndCodeConfidenceIndicator;
    I048_110_HeightMeasuredByA3DRadar i048_110_heightMeasuredByA3DRadar;
    I048_120_RadialDopplerSpeed i048_120_radialDopplerSpeed;
    I048_130_RadarPlotCharacteristics i048_130_radarPlotCharacteristics;
    I048_140_TimeOfDay i048_140_timeOfDay;
    I048_161_TrackNumber i048_161_trackNumber;
    I048_170_TrackStatus i048_170_trackStatus;
    I048_200_CalculatedTrackVelocityInPolarCoOrdinates i048_200_calculatedTrackVelocityInPolarCoOrdinates;
    I048_210_TrackQuality i048_210_trackQuality;
    I048_220_AircraftAddress i048_220_aircraftAddress;
    I048_230_CommunicationsACASCapabilityAndFlightStatus i048_230_communicationsACASCapabilityAndFlightStatus;
    I048_240_AircraftIdentification i048_240_aircraftIdentification;
    I048_250_ModeSMBData i048_250_modeSMBData;
    I048_260_ACASResolutionAdvisoryReport i048_260_acasResolutionAdvisoryReport;


    // 指定字段不序列化
    @JSONField(serialize = false)
    private List<Integer> existedItems = new ArrayList<>();

    @JSONField(serialize = false)
    public static int length;

    //index=3,currentIndex += CAT062Track.length,currentIndex += CAT062Track.length;
    //34 0 16 246 22 101 2 42 52 32 224 136 64 64 128 0
    // index = 3
    public CAT048Track(int[] data, int index) {

        // currentIndex = 3  254
        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 0;

        //data[currentIndex] = f6 = 1111 0110
        do {
            // obyte = 254 1111 1110
            oByte = data[currentIndex];
            //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；00000001=0x01
            for (int i = 7; i >= 1; i--) {
                //其中对应的位为1
                // oByte >> 7 = 1
                if (((oByte >> i) & 0x01) == 0x01) {
                    //existedItems add 10
                    existedItems.add(CAT048UAP.UAP[itemIndex]);
                }
                itemIndex += 1;
            }
            // currentIndex = 4
            currentIndex += 1;
        } while ((oByte & 0x01) == 0x01);


        System.out.print("existedItems:");
        for (Integer b :
                existedItems) {
            System.out.print(b + " ");
        }
        //oByte的最后一位为1 说明obyte还是fspec
        ////00000001=0x01 只要oByte的最后一位为1就==，就继续


        //UAP = new int[]{10, 140, 20, 40, 70, 90, 130, 220, 240, 250, 161, 42, 200,
        // 170, 210, 30, 80, 100, 110, 120, 230, 260, 55, 50, 65, 60, -1, -1};
        for (int item : existedItems) {
            switch (item) {
                case 10:
                    // currentIndex = 4
                    System.out.println("10 data[cur]"+currentIndex);
                    i048_010_dataSourceIdentifier = new I048_010_DataSourceIdentifier(data, currentIndex);
                    System.out.println("创建10成功");
                    currentIndex += I048_010_DataSourceIdentifier.length;
                    break;
                case 140:
                    System.out.println("140 data[cur]"+currentIndex);
                    i048_140_timeOfDay = new I048_140_TimeOfDay(data, currentIndex);
                    System.out.println("创建140成功");
                    currentIndex += I048_140_TimeOfDay.length;
                    break;
                case 20:
                    System.out.println("20 data[cur]"+currentIndex);
                    i048_020_targetReportDescriptor = new I048_020_TargetReportDescriptor(data, currentIndex);
                    System.out.println("创建20成功");
                    currentIndex += I048_020_TargetReportDescriptor.length;
                    break;
                case 40:
                    System.out.println("40 data[cur]"+currentIndex);
                    i048_040_measuredPositionInPolarCo_ordinates = new I048_040_MeasuredPositionInPolarCo_ordinates(data, currentIndex);
                    System.out.println("创建40成功");
                    currentIndex += I048_040_MeasuredPositionInPolarCo_ordinates.length;
                    break;
                case 70:
                   System.out.println("70 data[cur]"+currentIndex);
                    i048_070_mode3ACodeInOctalRepresentation = new I048_070_Mode3ACodeInOctalRepresentation(data, currentIndex);
                    System.out.println("创建70成功");
                    currentIndex += I048_070_Mode3ACodeInOctalRepresentation.length;
                    break;
                case 90:
                   System.out.println("90 data[cur]"+currentIndex);
                    i048_090_flightLevelInBinaryRepresentation = new I048_090_FlightLevelInBinaryRepresentation(data, currentIndex);
                   System.out.println("创建90成功");
                    currentIndex += I048_090_FlightLevelInBinaryRepresentation.length;
                    break;
                case 130:
                    System.out.println("130 data[cur]"+currentIndex);
                    i048_130_radarPlotCharacteristics = new I048_130_RadarPlotCharacteristics(data, currentIndex);
                    System.out.println("创建130成功");
                    currentIndex += I048_130_RadarPlotCharacteristics.length;
                    break;
                case 220:
                    System.out.println("220 data[cur]"+currentIndex);
                    i048_220_aircraftAddress = new I048_220_AircraftAddress(data, currentIndex);
                    currentIndex += I048_220_AircraftAddress.length;
                    break;
                case 240:
                    System.out.println("240 data[cur]"+currentIndex);
                    i048_240_aircraftIdentification = new I048_240_AircraftIdentification(data, currentIndex);
                    currentIndex += I048_240_AircraftIdentification.length;
                    break;
                case 250:
                    System.out.println("250 data[cur]"+currentIndex);
                    i048_250_modeSMBData = new I048_250_ModeSMBData(data, currentIndex);
                    currentIndex += I048_250_ModeSMBData.length;
                    break;
                case 161:
                    i048_161_trackNumber = new I048_161_TrackNumber(data, currentIndex);
                    currentIndex += I048_161_TrackNumber.length;
                    break;
                case 42:
                    i048_042_calculatedPositionInCartesianCo_ordinates = new I048_042_CalculatedPositionInCartesianCo_ordinates(data, currentIndex);
                    currentIndex += I048_042_CalculatedPositionInCartesianCo_ordinates.length;
                    break;
                case 200:
                    i048_200_calculatedTrackVelocityInPolarCoOrdinates = new I048_200_CalculatedTrackVelocityInPolarCoOrdinates(data, currentIndex);
                    currentIndex += I048_200_CalculatedTrackVelocityInPolarCoOrdinates.length;
                    break;
                case 170:
                    i048_170_trackStatus = new I048_170_TrackStatus(data, currentIndex);
                    currentIndex += I048_170_TrackStatus.length;
                    break;
                case 210:
                    i048_210_trackQuality = new I048_210_TrackQuality(data, currentIndex);
                    currentIndex += I048_210_TrackQuality.length;
                    break;
                case 30:
                    i048_030_warningOrErrorConditions = new I048_030_WarningOrErrorConditions(data, currentIndex);
                    currentIndex += I048_030_WarningOrErrorConditions.length;
                    break;
                case 80:
                    i048_080_mode3ACodeConfidenceIndicator = new I048_080_Mode3ACodeConfidenceIndicator(data, currentIndex);
                    currentIndex += I048_080_Mode3ACodeConfidenceIndicator.length;
                    break;
                case 100:
//                    i048_100_modeCCodeAndCodeConfidenceIndicator = new I048_100_ModeCCodeAndCodeConfidenceIndicator(data, currentIndex);
                    currentIndex += I048_100_ModeCCodeAndCodeConfidenceIndicator.length;
                    break;
                case 110:
                    i048_110_heightMeasuredByA3DRadar = new I048_110_HeightMeasuredByA3DRadar(data, currentIndex);
                    currentIndex += I048_110_HeightMeasuredByA3DRadar.length;
                    break;
                case 120:
                    i048_120_radialDopplerSpeed = new I048_120_RadialDopplerSpeed(data, currentIndex);
                    currentIndex += I048_120_RadialDopplerSpeed.length;
                    break;
                case 230:
                    System.out.println("130 data[cur]"+currentIndex);
                    i048_230_communicationsACASCapabilityAndFlightStatus = new I048_230_CommunicationsACASCapabilityAndFlightStatus(data, currentIndex);
                    currentIndex += I048_230_CommunicationsACASCapabilityAndFlightStatus.length;
                    break;
                case 260:
//                    i048_260_acasResolutionAdvisoryReport = new I048_260_ACASResolutionAdvisoryReport(data, currentIndex);
                    currentIndex += I048_260_ACASResolutionAdvisoryReport.length;
                    break;
                case 55:
                    i048_055_mode_1CodeInOctalRepresentation = new I048_055_Mode_1CodeInOctalRepresentation(data, currentIndex);
                    currentIndex += I048_055_Mode_1CodeInOctalRepresentation.length;
                    break;
                case 50:
                    i048_050_mode_2CodeInOctalRepresentation = new I048_050_Mode_2CodeInOctalRepresentation(data, currentIndex);
                    currentIndex += I048_050_Mode_2CodeInOctalRepresentation.length;

                case 65:
                    i048_065_mode1CodeConfidenceIndicator = new I048_065_Mode1CodeConfidenceIndicator(data, currentIndex);
                    currentIndex += I048_065_Mode1CodeConfidenceIndicator.length;
                case 60:
                    i048_060_mode2CodeConfidenceIndicator = new I048_060_Mode2CodeConfidenceIndicator(data, currentIndex);
                    currentIndex += I048_060_Mode2CodeConfidenceIndicator.length;

                case -1:
                    currentIndex += data[currentIndex];
                    break;
                case -2:
                    while ((data[currentIndex] & 0x01) == 0x01) {
                        currentIndex += 1;
                    }
                    currentIndex += 1;
                    break;
                default:
                    // 10 20
                    if (item <= -3 && item >= -100) {
                        currentIndex += (data[currentIndex] * (-2 - item) + 1);
                    } else if (item < -100) {
                        currentIndex += (-100 - item);
                    }
                    break;
            }
        }
        length = currentIndex - index;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(2048);

        return stringBuilder.append(i048_010_dataSourceIdentifier)
                .append(",").append(i048_140_timeOfDay)
                .append(",").append(i048_020_targetReportDescriptor)
                .append(",").append(i048_040_measuredPositionInPolarCo_ordinates)
                .append(",").append(i048_070_mode3ACodeInOctalRepresentation)
                .append(",").append(i048_090_flightLevelInBinaryRepresentation)
                .append(",").append(i048_130_radarPlotCharacteristics)
                .append(",").append(i048_220_aircraftAddress)
                .append(",").append(i048_240_aircraftIdentification)
                .append(",").append(i048_250_modeSMBData)
                .append(",").append(i048_161_trackNumber)
                .append(",").append(i048_042_calculatedPositionInCartesianCo_ordinates)
                .append(",").append(i048_200_calculatedTrackVelocityInPolarCoOrdinates)
                .append(",").append(i048_170_trackStatus)
                .append(",").append(i048_210_trackQuality)
                .append(",").append(i048_030_warningOrErrorConditions)
                .append(",").append(i048_080_mode3ACodeConfidenceIndicator)
                .append(",").append(i048_100_modeCCodeAndCodeConfidenceIndicator)
                .append(",").append(i048_110_heightMeasuredByA3DRadar)
                .append(",").append(i048_120_radialDopplerSpeed)
                .append(",").append(i048_230_communicationsACASCapabilityAndFlightStatus)
                .append(",").append(i048_260_acasResolutionAdvisoryReport)
                .append(",").append(i048_055_mode_1CodeInOctalRepresentation)
                .append(",").append(i048_050_mode_2CodeInOctalRepresentation)
                .append(",").append(i048_065_mode1CodeConfidenceIndicator)
                .append(",").append(i048_060_mode2CodeConfidenceIndicator)
                .toString();
    }

}
