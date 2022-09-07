package sm2_1;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.SM2;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SM2EncDecUtils {

    public static SM2 generateKeyPair() {
        SM2 sm2 = SmUtil.sm2();
        byte[] privateKey = BCUtil.encodeECPrivateKey(sm2.getPrivateKey());
        //这里公钥不压缩  公钥的第一个字节用于表示是否压缩  可以不要
        byte[] publicKey = ((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(false);
        System.out.println(HexUtil.encodeHexStr(privateKey));
        System.out.println(HexUtil.encodeHexStr(publicKey));
        return sm2;
    }

    //数据加密
    public static String encrypt(String publicKeyHex, byte[] data) throws IOException {
        if (!publicKeyHex.startsWith("04")) {
            throw new IllegalArgumentException("publicKeyHex第一字节应为04");
        }

        if (data == null || data.length == 0) {
            return null;
        }

        String xhex = publicKeyHex.substring(2, 66);
        String yhex = publicKeyHex.substring(66, 130);
        ECPublicKeyParameters ecPublicKeyParameters = BCUtil.toSm2Params(xhex, yhex);

        SM2 sm2_client = new SM2(null, ecPublicKeyParameters);

        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(ecPublicKeyParameters);

        byte[] encrypt = sm2_client.encrypt(data, parametersWithRandom);

        return HexUtil.encodeHexStr(encrypt);

    }

    //数据解密
    public static byte[] decrypt(byte[] privateKey, byte[] encryptedData) throws IOException {
        if (privateKey == null || privateKey.length == 0) {
            return null;
        }

        if (encryptedData == null || encryptedData.length == 0) {
            return null;
        }

        ECPrivateKeyParameters privateKeyParameters = BCUtil.toSm2Params(privateKey);
        SM2 sm2 = new SM2(privateKeyParameters, null);

        byte[] decrypt = sm2.decrypt(encryptedData, privateKeyParameters);
        //返回解密结果
        return decrypt;
    }


    public static void main(String[] args) throws Exception {
        JSONObject json = new JSONObject();
        
    }
}