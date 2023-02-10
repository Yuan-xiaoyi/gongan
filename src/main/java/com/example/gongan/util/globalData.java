package com.example.gongan.util;

public class globalData {
    public String  url = "https://api.weixin.qq.com/sns/jscode2session";//微信服务器接口
    public String  appid = "wx43d4f67b2c2a36d0";
    public String  secret = "5e813f55de02c0600eb7e29851094350";
    public String  grant_type = "client_credential";
    public String  grant_type2 = "authorization_code";
    public String  refrenTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type={2}&appid={0}&secret={1}";

    public String  getPhoneNumberUrl = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token={0}";
}
