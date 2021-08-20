package com.net.data.cat048.conf;

import java.text.SimpleDateFormat;

public class Constant {

    public static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final long TIME_SLOT_MINUTE = 60L;
    public static final long TIME_SLOT_HOUR = 3600L;
    public static final long TIME_SLOT_DAY = 24 * 3600L;

    public static final String SIGNAL_HUP = "HUP";
    public static final String SIGNAL_INT = "INT";
    public static final String SIGNAL_TERM = "TERM";

    /**
     * 应用ID，用于校验脚本与配置的一致性
     */
    public static final String SYSPROP_APP_ID = "cat062Parse.id";


    /**
     * 启动脚本中指定的配置文件路径的属性名
     */
    public static final String SYSPROP_CONFIG_FILE = "cat062Parse.configurationFile";

    public static final String READER_UDP = "udp";
    public static final String READER_KAFKA = "kafka";
    public static final String READER_ORACLE = "oracle";
    public static final String READER_FILE = "file";
    public static final String READER_FTP = "ftp";
    public static final int MAX_SEQ_NO = 10000;
    public static final int NO_DATA_CYCLE = 5;

    public static final String MH4041_HEAD_STR = "ZCZC";
    public static final String MH4041_TAIL_STR = "NNNN";
    // MH4041的两个报文之间通常是12个字节的0x1f填充
    public static final byte[] MH4041_GAP =
            {0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f, 0x1f};
    public static final int SN_ROOLLING = 1000000000;
}
