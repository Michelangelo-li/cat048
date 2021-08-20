/**
 * Data Fusion Platform
 *
 * @author Andy Zheng (shzheng@ronglian.com)
 * Project: interface-reader
 * File: KafkaProperties.java
 * Package: com.uec.dfp.sysmgmt
 * @version 1.1.0
 * @date 2020年9月16日
 */
package com.net.data.cat048.conf;


import lombok.ToString;

/**
 */
@ToString
public class KafkaProperties {
    /**
     * 通用属性部分
     */
    public String bootstrapServers;
    public String topic;
    public String clientId;                // clientId, client.id或group.id
    public String securityProtocol;
    public String saslMechanism;
    public String saslJaasModule;
    public String username;
    public String password;

    /**
     * Producer 属性部分
     */
    public String acks;
    public long bufferMemory;
    public int retries;
    public int batchSize;
    public long lingerMs;
    public int requestTimeoutMs;
    public int maxInFlightRequestPerConnection;
    public long retryBackoffMs;
    public boolean idempotence = false;

    /**
     * Consumer 属性部分
     */
    public String autoOffsetReset;
    public int sessionTimeout;
    public boolean enableAutoCommit;
    public int maxPollRecords;
    public int receiveBufferBytes;
    public int maxRequestSize;


    public String getFormatString(String indent) {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append(String.format("%sbootstrapServers:   [%s]\n", indent, bootstrapServers));
        strBuf.append(String.format("%stopic:              [%s]\n", indent, topic));
        strBuf.append(String.format("%sclientId:           [%s]\n", indent, clientId));
        strBuf.append(String.format("%ssecurityProtocol:   [%s]\n", indent, securityProtocol));
        strBuf.append(String.format("%ssaslMechanism:      [%s]\n", indent, saslMechanism));
        strBuf.append(String.format("%ssaslJaasModule:     [%s]\n", indent, saslJaasModule));
        strBuf.append(String.format("%susername:           [%s]\n", indent, username));
        strBuf.append(String.format("%spassword:           [%s]\n", indent, password));

        strBuf.append(String.format("%sacks:               [%s]\n", indent, acks));
        strBuf.append(String.format("%sbufferMemory:       [%d]\n", indent, bufferMemory));
        strBuf.append(String.format("%sretries:            [%d]\n", indent, retries));
        strBuf.append(String.format("%sbatchSize:          [%d]\n", indent, batchSize));
        strBuf.append(String.format("%slingerMs:           [%d]\n", indent, lingerMs));
        strBuf.append(String.format("%srequestTimeoutMS:   [%d]\n", indent, requestTimeoutMs));
        strBuf.append(String.format("%smaxInFlightRequestPerConnection: [%d]\n", indent, maxInFlightRequestPerConnection));
        strBuf.append(String.format("%sretryBackoffMs:     [%d]\n", indent, retryBackoffMs));
        strBuf.append(String.format("%sidempotence:        [%s]\n", indent, idempotence));

        strBuf.append(String.format("%sautoOffsetReset:    [%s]\n", indent, autoOffsetReset));
        strBuf.append(String.format("%ssessionTimeout:     [%d]\n", indent, sessionTimeout));
        strBuf.append(String.format("%senableAutoCommit:   [%s]\n", indent, enableAutoCommit));
        strBuf.append(String.format("%smaxPollRecords:     [%d]\n", indent, maxPollRecords));
        strBuf.append(String.format("%sreceiveBufferBytes: [%d]\n", indent, receiveBufferBytes));
        return strBuf.toString();
    }
}