package com.wencheng.wencheng_web.pojo;

public class Wenzhang {
    private  int  id;
    private  String article;
    private  String articleSign;
    private  int status;
    private  String url;
    private  String username;
    /**********************************连接签名认证服务器必须信息**********************************/

    /**
     * 签名服务器ip地址.
     */
    private String hostip1;

    /**
     * 签名服务器端口.
     */
    private String port;

    /**
     * 容器名称.
     */
    private String strContainer;

    /********************************************************************************************/

    /**
     * 身份认证步骤(CLIENT-HELLO/CLIENT-AUTHCODE)
     */
    private String type;
    /**
     * 客户端的clientHello.
     */
    private String clientHello;

    /**
     * 客户端认证码.
     */
    private String clientAuth;

    /**
     * 随机数.
     */
    private String random;

    /**
     * 签名源数据.
     */
    private String sourceData;

    /**
     * 签名数据.(16进制)
     */
    private String signData;


    /**
     * 服务器类型
     */
    private String serverType;
    private  String strCert;

    boolean isShow;

    public Wenzhang(){

    }



    public Wenzhang(int id, String article,String articleSign, int status, String username) {
        this.id = id;
        this.article = article;
        this.articleSign = articleSign;
        this.status = status;
        this.username = username;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getStrCert() {
        return strCert;
    }

    public void setStrCert(String strCert) {
        this.strCert = strCert;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getArticleSign() {
        return articleSign;
    }

    public void setArticleSign(String articleSign) {
        this.articleSign = articleSign;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHostip1() {
        return hostip1;
    }

    public void setHostip1(String hostip1) {
        this.hostip1 = hostip1;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getStrContainer() {
        return strContainer;
    }

    public void setStrContainer(String strContainer) {
        this.strContainer = strContainer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClientHello() {
        return clientHello;
    }

    public void setClientHello(String clientHello) {
        this.clientHello = clientHello;
    }

    public String getClientAuth() {
        return clientAuth;
    }

    public void setClientAuth(String clientAuth) {
        this.clientAuth = clientAuth;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getSourceData() {
        return sourceData;
    }

    public void setSourceData(String sourceData) {
        this.sourceData = sourceData;
    }

    public String getSignData() {
        return signData;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    @Override
    public String toString() {
        return "Wenzhang{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", articleSign='" + articleSign + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
