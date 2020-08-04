package com.twoc.depots.config;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * MD5工具类
 *
 * @author why
 */
public final class MD5Util {
    protected static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    public static void main(String[] args) {
       /* String hashAlgorithName = "MD5";
        String password = "123";//登录时输入的密码
        int hashIterations = 1024;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("123");//登录时输入的用户名
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj);
        logger.info("加密密码:"+obj);*/

        Object o = GetMD5Object("ceshi", "1");
        System.out.println(o.toString());
    }

    public static Object GetMD5Object(Object username, Object password) {
        String hashAlgorithName = "MD5";
        int hashIterations = 1024;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);//登录时输入的用户名
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        return obj;
    }

}
