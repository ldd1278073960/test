package utils;


/**
 * @author Ldp
 * @date 2022/7/14
 */
public class Sm4ContextUtils {
    public int mode = 1;
    public long[] sk = new long[32];
    public boolean isPadding = true;

    protected Sm4ContextUtils() {
    }

    /**
     * 加密
     * @param plainText  参数
     * @param keyBytes  随机码
     * @return
     */
    public byte[] EncryptByte(byte[] plainText,byte[] keyBytes) {
        if (keyBytes != null && keyBytes.length == 16) {
            if (plainText != null && plainText.length > 0) {
                try {
                    Sm4ContextUtils ctx = new Sm4ContextUtils();
                    ctx.isPadding = true;
                    ctx.mode = 1;
                    Sm4ByteUtils sm4ByteUtils = new Sm4ByteUtils();
                    sm4ByteUtils.sm4_setkey_enc(ctx, keyBytes);
                    return sm4ByteUtils.sm4_crypt_ecb(ctx, plainText);
                } catch (Exception var6) {
                    var6.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 解密
     * @param cipherText 密文
     * @param keyBytes 随机码
     * @return
     */
    public byte[] DecryptStrByte(byte[] cipherText,byte[] keyBytes) {
        if (keyBytes != null && keyBytes.length == 16) {
            if (cipherText != null && cipherText.length > 0 && cipherText.length % 16 == 0) {
                try {
                    Sm4ContextUtils ctx = new Sm4ContextUtils();
                    ctx.isPadding = true;
                    ctx.mode = 0;
                    Sm4ByteUtils sm4ByteUtils = new Sm4ByteUtils();
                    sm4ByteUtils.sm4_setkey_dec(ctx, keyBytes);
                    byte[] decrypted = sm4ByteUtils.sm4_crypt_ecb(ctx, cipherText);
                    int decryptedLen = decrypted.length;

                    for (int i = decrypted.length - 1; i >= 0 && decrypted[i] == 0; --decryptedLen) {
                        --i;
                    }

                    byte[] temp = new byte[decryptedLen];
                    System.arraycopy(decrypted, 0, temp, 0, decryptedLen);
                    return temp;
                } catch (Exception var8) {
                    var8.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
