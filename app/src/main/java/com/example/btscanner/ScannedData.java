package com.example.btscanner;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class ScannedData {
    /*掃描到的所有資訊*/
    private String deviceName; /*設備名稱*/
    private String rssi; /*訊號強度*/
    private String deviceByteInfo;
    private String address; /*位址*/

    public ScannedData(String deviceName, String rssi, String deviceByteInfo, String address) {
        this.deviceName = deviceName;
        this.rssi = rssi;
        this.deviceByteInfo = deviceByteInfo;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public String getRssi() {
        return rssi;
    }
    public String getDeviceByteInfo() {
        return deviceByteInfo;
    }
    public String getDeviceName() {
        return deviceName;
    }

}
