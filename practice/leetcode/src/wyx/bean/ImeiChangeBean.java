/*
 * @Author: Tungbo
 * @Date: 2024-04-08 15:05:46
 * @LastEditTime: 2024-04-08 15:11:00
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package practice.leetcode.src.wyx.bean;

import java.util.List;

public class ImeiChangeBean {
    String uuid;
    String qcCode;
    List<ImeiChange> changeList;
    String ovs;
    String brand;
    String time;

    public ImeiChangeBean(String uuid, String qcCode, List<ImeiChange> changeList, String ovs, String brand, String time) {
        this.uuid = uuid;
        this.qcCode = qcCode;
        this.changeList = changeList;
        this.ovs = ovs;
        this.brand = brand;
        this.time = time;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getQcCode() {
        return qcCode;
    }
    public void setQcCode(String qcCode) {
        this.qcCode = qcCode;
    }
    public List<ImeiChange> getChangeList() {
        return changeList;
    }
    public void setChangeList(List<ImeiChange> changeList) {
        this.changeList = changeList;
    }
    public String getOvs() {
        return ovs;
    }
    public void setOvs(String ovs) {
        this.ovs = ovs;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
