
package com.local.blockchain;

import java.math.BigInteger;

public class Utils {
    
    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

    
    public static String encodeToBase58(byte[] input) {
        BigInteger bi = new BigInteger(1, input);
        StringBuilder sb = new StringBuilder();

        while (bi.compareTo(BigInteger.ZERO) > 0) {
            int index = bi.mod(BigInteger.valueOf(58)).intValue();
            sb.append(ALPHABET.charAt(index));
            bi = bi.divide(BigInteger.valueOf(58));
        }

        return sb.reverse().toString();
    }

    
}
