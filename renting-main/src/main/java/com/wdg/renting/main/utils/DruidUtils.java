package com.wdg.renting.main.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.utils
 * @Author: 吴第广
 * @CreateTime: 2023-04-24  11:21
 * @Description: TODO
 * @Version: 1.0
 */


public class DruidUtils {
    /**
     * 该方法实现对数据库用户名的加密
     * @param s
     * @return
     * @throws Exception
     */
    public static String username(String s) throws Exception {

        System.out.println("明文密码: " + s);
        String[] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        s = ConfigTools.encrypt(privateKey, s);

        System.out.println("privateKey:" + privateKey);
        System.out.println("publicKey:" + publicKey);

        System.out.println("password:" + s);

        String decryptPassword = ConfigTools.decrypt(publicKey, s);
        return decryptPassword;
    }

    /**
     * 改方法实现对数据库密码的加密
     * @param s
     * @return
     * @throws Exception
     */
    public static String password(String s) throws Exception {

        System.out.println("明文密码: " + s);
        String[] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        s = ConfigTools.encrypt(privateKey, s);

        System.out.println("privateKey:" + privateKey);
        System.out.println("publicKey:" + publicKey);

        System.out.println("s:" + s);

        String decryptPassword = ConfigTools.decrypt(publicKey, s);
        return decryptPassword;
    }

    public static void main(String[] args) throws Exception {
        password("5555");
    }
}

