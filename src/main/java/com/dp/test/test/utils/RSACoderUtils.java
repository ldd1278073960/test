package com.dp.test.test.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ldp
 * @date 2021/4/27
 */
public class RSACoderUtils {

    public static final String logalrithm = "AES/CBC/PKCS5Padding";
    public static final String bm = "utf-8";
    private static byte[] keyValue = "`&^%T_&*o(+^p&@;".getBytes();
    private static byte[] iv = "`&^%T_&*o(+^p&@;".getBytes();
    private static Key keySpec;
    private static IvParameterSpec ivSpec;

    public RSACoderUtils() {
    }

    public static String encrypt(String msg) {
        byte[] encryptedData = null;

        try {
            Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(1, keySpec, ivSpec);
            encryptedData = ecipher.doFinal(msg.getBytes("utf-8"));
        } catch (BadPaddingException | IllegalBlockSizeException var3) {
            var3.printStackTrace();
        } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
        } catch (NoSuchPaddingException var5) {
            var5.printStackTrace();
        } catch (InvalidKeyException var6) {
            var6.printStackTrace();
        } catch (InvalidAlgorithmParameterException var7) {
            var7.printStackTrace();
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        return asHex(encryptedData);
    }

    public static String decrypt(String value) {
        try {
            if (StringUtils.isBlank(value)) {
                return value;
            }

            Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(2, keySpec, ivSpec);
            return new String(ecipher.doFinal(asBin(value)), "utf-8");
        } catch (BadPaddingException var2) {
            System.out.println("解密错误：" + value);
            var2.printStackTrace();
        } catch (IllegalBlockSizeException var3) {
            System.out.println("解密错误：" + value);
            var3.printStackTrace();
        } catch (NoSuchAlgorithmException var4) {
            var4.printStackTrace();
        } catch (NoSuchPaddingException var5) {
            var5.printStackTrace();
        } catch (InvalidKeyException var6) {
            var6.printStackTrace();
        } catch (InvalidAlgorithmParameterException var7) {
            var7.printStackTrace();
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        return "";
    }

    private static String asHex(byte[] buf) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);

        for(int i = 0; i < buf.length; ++i) {
            if ((buf[i] & 255) < 16) {
                strbuf.append("0");
            }

            strbuf.append(Long.toString((long)(buf[i] & 255), 16));
        }

        return strbuf.toString();
    }

    private static byte[] asBin(String src) {
        if (src.length() < 1) {
            return null;
        } else {
            byte[] encrypted = new byte[src.length() / 2];

            for(int i = 0; i < src.length() / 2; ++i) {
                int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);
                encrypted[i] = (byte)(high * 16 + low);
            }

            return encrypted;
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = null;
        xx(map);
        System.out.println(map);
    }

    private static void xx(Map<String,String> map){
        if (map == null){
            map = new HashMap<>();
            map.put("vdsav","dvds");
            map.put("vdsav1","dvds");
            map.put("vdsav2","dvds");
        }
    }



    static {
        keySpec = new SecretKeySpec(keyValue, "AES");
        ivSpec = new IvParameterSpec(iv);
    }
}
