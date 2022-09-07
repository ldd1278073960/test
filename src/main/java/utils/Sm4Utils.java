package utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Hex;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author Ldp
 * @date 2022/7/14
 */
public class Sm4Utils {

    /**
     * SM4加密
     *
     * @param str 参数
     * @param key 随机码
     * @return
     */
    public static String EncryptStr(String str, String key) {
        return DatatypeConverter.printHexBinary(new Sm4ContextUtils().EncryptByte(str.getBytes(), key.getBytes()));
    }

    /**
     * 解密
     *
     * @param cipherStrings 密文
     * @param keyStr        随机码
     * @return
     */
    public static String DecryptStr(String cipherStrings, String keyStr) {
        String result = "";
        Sm4ContextUtils aa = new Sm4ContextUtils();
        byte[] dd = "00".getBytes();

        byte[] cipherText = Hex.decode(cipherStrings);
        byte[] keyBytes = keyStr.getBytes();

        try {

            dd = aa.DecryptStrByte(cipherText, keyBytes);
            result = new String(dd);
        } catch (Exception e) {
        }
        return result;

    }

/*    public static void main(String[] args) {
        String str="{\"msisdn\":\"15102082114\",\"timestamp\": 1657878699943,\"spId\":\"XZX-XYK\"}";
        String syhenospq5d8v125 = EncryptStr(str, "syhenospq5d8v125");
        System.out.println(syhenospq5d8v125);
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }*/


    public static void main(String[] args) {
        long time = new Date().getTime();
        System.out.println(time);
        System.out.println(time / 1000);
    }
}