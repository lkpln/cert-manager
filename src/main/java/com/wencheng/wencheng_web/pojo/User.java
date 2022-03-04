package com.wencheng.wencheng_web.pojo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {
    @NotBlank(message="用户名不能为空")
    private String username;

    private String loginId;
    private String unitCode;
    private String unitName;
    private String mobilePhoneNumber;
    private String email;
    private String identifyCard;
    private String appId;
    private String signal;
    private String confirmSignal;
    private String createTime;
    private String userType;
    private String businessType;
    private String code;
    private String status;
    private String priSignKey;
    private String pubSignKey;
    private String udid;
    private String taxServiceName;
    private String taxServiceCode;
    private String taxpayerCode;
    private String taxCode;
    private  String password;
    private int signType; //业务类型：0、身份认证  1、签名
    private String filePath; //源文件
    private  String key;
    String strSrcData;
    String  flag;
    String  tagCode;
    String strData;
    int id;
    private  String token;
    public  User(){

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String unitCode, String unitName, String mobilePhoneNumber, String email, String identifyCard, String userType, String businessType, String taxServiceName, String taxServiceCode) {
        this.username = username;
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
        this.identifyCard = identifyCard;
        this.userType = userType;
        this.businessType = businessType;
        this.taxServiceName = taxServiceName;
        this.taxServiceCode = taxServiceCode;
    }

    public User(String username, String loginId, String unitCode, String unitName, String mobilePhoneNumber, String email, String identifyCard, String appId, String signal, String confirmSignal, String createTime, String userType, String businessType, String code, String status, String priSignKey, String pubSignKey, String udid, String taxServiceName, String taxServiceCode, String taxpayerCode, String taxCode, String password, int signType, String filePath, String key, String strSrcData, String flag, String tagCode, String strData, String token) {
        this.username = username;
        this.loginId = loginId;
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.email = email;
        this.identifyCard = identifyCard;
        this.appId = appId;
        this.signal = signal;
        this.confirmSignal = confirmSignal;
        this.createTime = createTime;
        this.userType = userType;
        this.businessType = businessType;
        this.code = code;
        this.status = status;
        this.priSignKey = priSignKey;
        this.pubSignKey = pubSignKey;
        this.udid = udid;
        this.taxServiceName = taxServiceName;
        this.taxServiceCode = taxServiceCode;
        this.taxpayerCode = taxpayerCode;
        this.taxCode = taxCode;
        this.password = password;
        this.signType = signType;
        this.filePath = filePath;
        this.key = key;
        this.strSrcData = strSrcData;
        this.flag = flag;
        this.tagCode = tagCode;
        this.strData = strData;
        this.token = token;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStrSrcData() {
        return strSrcData;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getStrData() {
        return strData;
    }

    public void setStrData(String strData) {
        this.strData = strData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStrSrcData(String strSrcData) {
        this.strSrcData = strSrcData;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public String getConfirmSignal() {
        return confirmSignal;
    }

    public void setConfirmSignal(String confirmSignal) {
        this.confirmSignal = confirmSignal;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriSignKey() {
        return priSignKey;
    }

    public void setPriSignKey(String priSignKey) {
        this.priSignKey = priSignKey;
    }

    public String getPubSignKey() {
        return pubSignKey;
    }

    public void setPubSignKey(String pubSignKey) {
        this.pubSignKey = pubSignKey;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getTaxServiceName() {
        return taxServiceName;
    }

    public void setTaxServiceName(String taxServiceName) {
        this.taxServiceName = taxServiceName;
    }

    public String getTaxServiceCode() {
        return taxServiceCode;
    }

    public void setTaxServiceCode(String taxServiceCode) {
        this.taxServiceCode = taxServiceCode;
    }

    public String getTaxpayerCode() {
        return taxpayerCode;
    }

    public void setTaxpayerCode(String taxpayerCode) {
        this.taxpayerCode = taxpayerCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", loginId='" + loginId + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitName='" + unitName + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", identifyCard='" + identifyCard + '\'' +
                ", appId='" + appId + '\'' +
                ", signal='" + signal + '\'' +
                ", confirmSignal='" + confirmSignal + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userType='" + userType + '\'' +
                ", businessType='" + businessType + '\'' +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", priSignKey='" + priSignKey + '\'' +
                ", pubSignKey='" + pubSignKey + '\'' +
                ", udid='" + udid + '\'' +
                ", taxServiceName='" + taxServiceName + '\'' +
                ", taxServiceCode='" + taxServiceCode + '\'' +
                ", taxpayerCode='" + taxpayerCode + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
