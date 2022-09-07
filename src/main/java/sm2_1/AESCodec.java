package sm2_1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;
import java.util.UUID;

public class AESCodec {

    // 密钥算法
    private static final String KEY_ALGORITHM = "AES";

    // 加解密算法/工作模式/填充方式
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    private static final String AES_ECB_PKCS5Padding_ALGORITHM = "AES/ECB/PKCS5Padding";

    // 密钥大小
    private static final int KEY_SIZE = 128;

    private static final String VI_STR = "6DA0557C5119454A";

    /**
     * 生成密钥
     */
    public static byte[] initKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 加密数据
     */
    public static byte[] aesEcbPkcs5PaddingAlg(byte[] data, byte[] aesKey,boolean isEncrypt) throws Exception {
        Key key = new SecretKeySpec(aesKey, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ECB_PKCS5Padding_ALGORITHM);

        if(isEncrypt) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
        }else
        {
            cipher.init(Cipher.DECRYPT_MODE, key);
        }

        return cipher.doFinal(data);
    }

    /**
     * 中行demo加密数据
     * @param content
     * @return
     * @throws Exception
     */
    public static String encryptNew(String content, String aesKey) throws Exception {
        String charset = "utf-8";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec sks = new SecretKeySpec(aesKey.getBytes(charset), KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,
                    sks,
                    createIVSpec(VI_STR));
            byte[] encrypt = cipher.doFinal(content.getBytes(charset));
            encrypt = Base64.getEncoder().encode(encrypt);
            return new String(encrypt, charset);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 解密数据
     */
    public static String decrypt(String data, String aesKey) throws Exception {
//        Key key = new SecretKeySpec(Base64.getDecoder().decode(aesKey), KEY_ALGORITHM);
        Key key = new SecretKeySpec(aesKey.getBytes(), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec iv = createIVSpec(VI_STR);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }


    public static String decryptNew(String content, String key) throws Exception {
        String charset = "utf-8";
        byte[] data = null;
        try {
            content = replaceBaseStr(content);
            byte[] conByte = content.getBytes();
            data = Base64.getDecoder().decode(conByte);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,
                    new SecretKeySpec(key.getBytes(charset), KEY_ALGORITHM),
                    createIVSpec(VI_STR));
            byte[] result = cipher.doFinal(data);
            return new String(result,charset);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private static String replaceBaseStr(String str){
        return str.replaceAll("[\\n\\r]", "");
    }

    public static IvParameterSpec createIVSpec(String ivStr) {
        byte[] data = null;
        if (ivStr == null) {
            ivStr = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ivStr);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }

        try {
            data = sb.toString().getBytes("UTF-8");
        } catch (Exception ex) {
            return null;
        }
        return new IvParameterSpec(data);
    }

    /**
     * 生成AES密钥,密钥大于16位截取16位，小于16位末尾补0
     */
    public static String createSecretKey() throws UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append(uuid);
        while (sb.length() < 16) {
            sb.append("0");
        }
        if (sb.length() > 16) {
            sb.setLength(16);
        }
        return sb.toString();
    }







}
