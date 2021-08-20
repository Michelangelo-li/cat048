package com.net.data.cat048.bean;

import lombok.Data;

/**
 * 雷达识别码
 * （SAC）系统区域代码	SAC的最新列表已发布在Eurocontrol网站上
 * （SIC）系统识别代码
 */
@Data
public class I048_010_DataSourceIdentifier {
    private int sAC;

    private int sIC;

    public static final int length = 2;
    //{"sAC":22,"sIC":101}

    public I048_010_DataSourceIdentifier(int[] data, int index) {
        sAC = data[index];
        sIC = data[index + 1];
    }

    @Override
    public String toString() {
        return sAC + "," + sIC;
    }
}
