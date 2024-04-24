package com.local.blockchain;

import java.math.BigInteger;

public final class Encoder {

    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    private static final String HEXES = "0123456789ABCDEF";

    private Encoder() {
    }

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

    public static String encodeToHex(byte[] input) {
        final StringBuilder hex = new StringBuilder(2 * input.length);
        for (final byte b : input) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

}
