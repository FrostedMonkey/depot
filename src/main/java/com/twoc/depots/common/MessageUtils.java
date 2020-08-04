package com.twoc.depots.common;

import io.goeasy.GoEasy;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class MessageUtils {
    /**
     * 2019/5/5 11:24:10
     * TP1905012
     * 【天画通】#name#，您有一条新的消息需要处理。
     * TP1905013
     * 【天画通】#name#，您的申请已经审核，审核#message#。
     * TP1905014
     * 【天画通】#name#的存储量不足，请您及时增加库存。
     */
    /**
     * 提交申请
     *
     * @param EmployeeName
     * @param phone
     * @param type
     */
    public static void returnMessageTP12(String EmployeeName, String phone, String type) {
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "59480b29e53040b3a9cba826adc18184";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "name:" + EmployeeName);
        querys.put("tpl_id", type);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通知审核结果
     *
     * @param EmployeeName
     * @param message
     * @param phone
     * @param type
     */
    public static void returnMessageTP13(String EmployeeName, String message, String phone, String type) {
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "59480b29e53040b3a9cba826adc18184";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "name:" + EmployeeName + ",message:" + message);
        querys.put("tpl_id", type);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void returnMessageTP14(String EmployeeName, String phone, String type) {
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "59480b29e53040b3a9cba826adc18184";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "name:" + EmployeeName);
        querys.put("tpl_id", type);
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pushGoEasy(String type, String message) {
        GoEasy goEasy = new GoEasy("rest-hangzhou.goeasy.io", "BC-362e5ffae184440b9043fa653d633f62");
        goEasy.publish(type, message);
    }
}
