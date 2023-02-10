//package com.example.gongan.util.yzcode;
//
//import com.alibaba.fastjson.JSONObject;
//import com.aliyun.credentials.models.Config;
//import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
//import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
//import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
//import com.example.gongan.util.yzcode.SendSms;
//import org.springframework.stereotype.Service;
//
//@Service
//class SendSmsImpl implements SendSms {
//    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
//        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
//                // 您的 AccessKey ID
//                .setAccessKeyId(accessKeyId)
//                // 您的 AccessKey Secret
//                .setAccessKeySecret(accessKeySecret);
//        // 访问的域名
//        config.endpoint = "dysmsapi.aliyuncs.com";
//        return new com.aliyun.dysmsapi20170525.Client(config);
//    }
//
//    public boolean send(String phoneNum, String templateCode, java.util.Map<String, Object> code) throws Exception{
//        //下面将你获得的AccessKey ID和AccessKey Secret填入
//        com.aliyun.dysmsapi20170525.Client client = SendSmsImpl.createClient
//        ("LTAI5tDDuxbcniifi55PgR5U", "iZGpXKou2iTmDfEdQ8rrBnyZCNBIRd"); // 袁
////        ("LTAI5tHwXPBEu5fgL61e3AtR", "a4EVB31FvvBXL2AMaXREy0vHnkRG3j"); // 余
//        SendSmsRequest sendSmsRequest = new SendSmsRequest()
//                .setPhoneNumbers(phoneNum)
//                .setSignName("汐一通讯商机管理系统")
//                .setTemplateCode(templateCode)
//                .setTemplateParam(JSONObject.toJSONString(code));
//        //接收发送结果
//        SendSmsResponse response = client.sendSms(sendSmsRequest);
//        SendSmsResponseBody sendSmsResponseBody = response.getBody();
//        System.out.println("发送请求码："+sendSmsResponseBody.code+"\t发送情况："+sendSmsResponseBody.message+"发送的手机号码："+phoneNum);
//        //如果发送成功返回true,否则false
//        if(sendSmsResponseBody.code.equals("OK")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//
//    public boolean send(String phoneNum, String templateCode) throws Exception{
////        //下面将你获得的AccessKey ID和AccessKey Secret填入
////        System.out.println("成功发送的通知短信");
////        return true;
//       com.aliyun.dysmsapi20170525.Client client = SendSmsImpl.createClient("LTAI5tDDuxbcniifi55PgR5U", "iZGpXKou2iTmDfEdQ8rrBnyZCNBIRd"); // 我
////               ("LTAI5tHwXPBEu5fgL61e3AtR", "a4EVB31FvvBXL2AMaXREy0vHnkRG3j"); // 余
//        SendSmsRequest sendSmsRequest = new SendSmsRequest()
//                .setPhoneNumbers(phoneNum)
//                .setSignName("汐一通讯商机管理系统")
//                .setTemplateCode(templateCode);
//        //接收发送结果
//        SendSmsResponse response = client.sendSms(sendSmsRequest);
//        SendSmsResponseBody sendSmsResponseBody = response.getBody();
//        System.out.println("发送请求码："+sendSmsResponseBody.code+"\t发送情况："+sendSmsResponseBody.message+"发送的手机号码："+phoneNum);
//        //如果发送成功返回true,否则false
//        if(sendSmsResponseBody.code.equals("OK")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//}
