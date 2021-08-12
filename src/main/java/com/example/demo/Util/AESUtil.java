package com.example.demo.Util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.example.demo.Util.AESUtil.class);

    // 默认算法
    private static final String ALGORITHM_STR = "AES/CBC/PKCS5Padding";

    /* *
     * @Description  加密 aes cbc模式
     * @Param [content]
     * @Return java.lang.String
     */
    public static String aesEncode(String content, String encryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");

            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(encryptKey.getBytes()));
            //获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteEncode = content.getBytes(StandardCharsets.UTF_8);
            //根据密码器的初始化方式--加密：将数据加密
            byte[] byteAES = cipher.doFinal(byteEncode);
            //将加密后的byte[]数据转换为Base64字符串
            return new String(Base64.encodeBase64(byteAES));
            //将字符串返回
        } catch (Exception e) {
            LOGGER.error("密文加密失败"+e.getMessage(),e);
            throw new RuntimeException("密文加密失败");
        }

    }

    /* *
     * @Description 解密
     * @Param [cotent]
     * @Return java.lang.String
     */
    public static String aesDecode(String content, String decryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(decryptKey.getBytes(StandardCharsets.UTF_8), "AES");

            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(decryptKey.getBytes(StandardCharsets.UTF_8)));
            //8.将加密并编码base64后的字符串内容base64解码成字节数组
            byte[] bytesContent = Base64.decodeBase64(content);
            /*
             * 解密
             */
            byte[] byteDecode = cipher.doFinal(bytesContent);
            return new String(byteDecode, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("没有指定的加密算法::"+e.getMessage(),e);
        } catch (IllegalBlockSizeException e) {
            LOGGER.error("非法的块大小"+"::"+e.getMessage(),e);
            throw new RuntimeException("密文解密失败");
            //e.printStackTrace();
        } catch (NullPointerException e) {
            LOGGER.error("秘钥解析空指针异常"+"::"+e.getMessage(),e);
            throw new RuntimeException("秘钥解析空指针异常");
        } catch (Exception e) {
            LOGGER.error("秘钥AES解析出现未知错误"+"::"+e.getMessage(),e);
            throw new RuntimeException("密文解密失败");
        }
        //如果有错就返null
        return null;

    }

    public static void main(String[] args) {
//        String[] keys = {
//                "", "88DE8D485E6DF32B", "word"
//        };
//        System.out.println("key | AESEncode | AESDecode");
//        for (String key : keys) {
//            System.out.print(key + " | ");
//            String encryptString = aesEncode(key, key);
//            System.out.print(encryptString + " | ");
//            String decryptString = aesDecode(encryptString, key);
//            System.out.println(decryptString);
//        }
        String encryptString = aesEncode("{\n" +
                "    \"msg\": \"请求成功!\",\n" +
                "    \"msgCode\": \"000000\",\n" +
                "    \"result\": {\"id\":\"1\",\"test\":\"2\"}\n" +
                "}", "tyrlur5o8t3i9iae");
        System.out.println("加密：" + encryptString);
        String s = aesDecode(encryptString, "tyrlur5o8t3i9iae");
        System.out.println("解密：" + s);

        /*String ee = "pP/lDSwgiJzAmH3HGyuyPEzTSGtLmdawMxLUax4yU6k0QcIoFx2Spr2sh" +
                "/kD5uDiFIMj0ODlLwMyRycxfJIi3a7PXcvqmXUHmJ" +
                "+y0NUk" +
                "/AHlPLNeIlIoBYNdMVRZuhejEbHICY1YOT0l5g31MyF75tndfYB5wi29QDYWIgp6QytmykFMO3TimN2P2TTQCoCgUydd6t6jmxKm0hYC7e0dIr52lRosFqpE7RJ9bBQ3PbFwS9xqK4UP+FepbdVHAHarGj4GYAqprdX6sCau52bJE2vQXl7MrFYypnf3eHhYniGXqX9B9Kh59zw9Vizt8j8s3JB/jfbx6QEOZjb7iuxF/p7pXPS1acrleWZimCItUWUlYccOkOuSrzGvbGoWktYl8oSawjMkVhy6iCQ7efbGJJiORIkYYYO7AKvtSOlBsYh1smbp1gkzMhS+v4gweBgTCg9EM1Lrh2t6bl6ScLlIGf/rmAFie1WXhwQRsdePyjaIIbrgqrZN6mhcsJgut+lHluYyhoFQj3I7X3nvTi90IO45pL3/YGM3Fg6ZxkYMRe00TDXZujqgXUaXGxnQ0jbfO7UBtl/7lIUVJO5XKQRWtlsMd2TOp3AMhYWzTXY4ZDOnLzPUoGn5fx+2unUH1CzA+3WQE761EhV0CATSt1v1vrY+jMsfYGAx8q64tIY84EdBz2by7+vBWS2u5sZlr2tofe6Y65ARns9V+/z6AE5cibRPpgKZbKMitf2Z8D1o1LqLOCSWAzIafJhuqesPQ4xDgv4aRjoJ3j6HGKw05O7DU5WmMisLpTWPgN2JejJL1uEDaTh99+xeiAcb3m4XNzKoV1nsAnO/Qbk4n7lyETtkqA==";
        String bb = aesDecode(ee, "oba0ay6yni9uclvn");
        System.out.println(bb);*/

    }

}
