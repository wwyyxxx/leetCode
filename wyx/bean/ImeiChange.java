/*
 * @Author: Tungbo
 * @Date: 2024-04-08 15:07:27
 * @LastEditTime: 2024-04-08 17:14:15
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.bean;

public class ImeiChange {
    String imei;
    String type;
    Boolean validate;
    public String getImei() {
        return imei;
    }
    public void setImei(String imei) {
        this.imei = imei;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Boolean getValidate() {
        return validate;
    }
    public void setValidate(Boolean validate) {
        this.validate = validate;
    }
    @Override
    public String toString() {
        return "ImeiChange [imei=" + imei + ", type=" + type + ", validate=" + validate + "]";
    }
    
}
