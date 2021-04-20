package com.sms.consumer.confg;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Md5PasswordEncoder implements PasswordEncoder {
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private String salt;

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private static Md5PasswordEncoder instance = new Md5PasswordEncoder();

    private Md5PasswordEncoder() {
    }
    //以单例模式构造
    public static Md5PasswordEncoder getInstance() {
        return instance;
    }


    private String mergePasswordAndSalt(CharSequence password) {
        if (password == null) {
            password = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return password.toString();
        } else {
            return password + "{" + salt + "}";
        }
    }

    private String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    private String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * MD5加密
     *
     * @param rawPassword 原始密码
     * @return 加密后的md5密文
     */
    @Override
    public String encode(CharSequence rawPassword) {
        String result = null;
        try {
            String algorithm = "MD5";
            MessageDigest md = MessageDigest.getInstance(algorithm);
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPassword).getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ignored) {
        }
        return result;
    }

    /**
     * 密码比较
     *
     * @param rawPassword     原始密码
     * @param encodedPassword 加密后的密码
     * @return boolean
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }
}
