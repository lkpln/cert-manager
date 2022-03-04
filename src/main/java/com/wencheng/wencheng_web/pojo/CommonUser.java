package com.wencheng.wencheng_web.pojo;


public class CommonUser extends xtqm.code.server.vo.CommonUser {
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
    public  CommonUser(){}
    public CommonUser(String username, String loginId, String unitCode, String unitName, String mobilePhoneNumber, String email, String identifyCard, String appId, String signal, String confirmSignal, String createTime, String userType, String businessType, String code, String status, String priSignKey, String pubSignKey, String udid, String taxServiceName, String taxServiceCode, String taxpayerCode, String taxCode) {
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
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "CommonUser{" +
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
                '}';
    }
}
