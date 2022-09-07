package sm2_1;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.asymmetric.SM2;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.encoders.Hex;

import java.io.IOException;
import java.math.BigInteger;

public class SM2SignVerUtils {

    public static boolean verifySignSM2(String  publicKeyHex, byte[] sourceData,byte[] signValue) throws IOException {
        if(!publicKeyHex.startsWith("04"))
        {
            throw new IllegalArgumentException("publicKeyHex第一字节应为04");
        }
        String xhex = publicKeyHex.substring(2, 66);
        String yhex = publicKeyHex.substring(66, 130);
        ECPublicKeyParameters ecPublicKeyParameters = BCUtil.toSm2Params(xhex, yhex);
        SM2 sm2_client = new SM2(null, ecPublicKeyParameters);

        if (signValue.length == 64) {
            String signature = HexUtil.encodeHexStr(signValue);
            //将签名信息转为der格式
            ASN1Integer d_r = new ASN1Integer(new BigInteger(signature.substring(0, 64), 16));
            ASN1Integer d_s = new ASN1Integer(new BigInteger(signature.substring(64), 16));
            ASN1EncodableVector v2 = new ASN1EncodableVector();
            v2.add(d_r);
            v2.add(d_s);
            DERSequence respsign = new DERSequence(v2);
            signValue = respsign.getEncoded();
        }

        boolean verify = sm2_client.verify(sourceData,signValue );

        return verify;
    }


   public static String sign2SM2(String privatekey,byte[] sourceData){
       ECPrivateKeyParameters privateKeyParameters = BCUtil.toSm2Params(privatekey);
       SM2 sm2 = new SM2(privateKeyParameters, null);
       byte[] sign = sm2.sign(sourceData);

       byte[] valueBytes = filterBerTlv(sign);

       int xLength = valueBytes[1];
       int yLength = valueBytes[xLength+3];
       String value1 =  Hex.toHexString(valueBytes, 2, xLength);
       String value2 = Hex.toHexString(valueBytes,2+xLength+2,yLength);
       if(value1.length()>64) {
           value1 = value1.replaceAll("^(0+)", "");
       }
       if(value2.length()>64) {
           value2 = value2.replaceAll("^(0+)", "");
       }
       String sign_hex = value1+value2;
       return sign_hex;
   }


    /**
     * 获取BerTlv格式中的数据域
     *
     * @param berTlvData
     * @return
     */
    public final static byte[] filterBerTlv(byte[] berTlvData) {
        if (berTlvData == null) {
            throw new NullPointerException("filterBerTlv(): berTlvData.");
        }

        int n = 0;
        if ((berTlvData[1] & 0x80) == 0x80) {
            n += berTlvData[1] & 0x0F;
        }

        int len = 0;
        int index = 0;
        if (n == 0) {
            len = berTlvData[1];
            index = 2;
        } else {
            for (int i = 1; i <= n; i++) {
                len |= (berTlvData[i + 1] & 0xFF) << ((n - i) * 8);
            }
            index = n + 2;
        }

        byte[] temp = new byte[len];
        System.arraycopy(berTlvData, index, temp, 0, len);
        return temp;
    }



}
