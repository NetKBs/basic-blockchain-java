package com.local.blockchain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigInteger;
import java.util.Random;

public class EncoderTest {

    @Test
    public void base58() {
        Random rand = new Random();
        Integer numero = rand.nextInt(999999999);
        byte[] numeroBytes = BigInteger.valueOf(numero).toByteArray();

        String numeroBase58 = Encoder.encodeToBase58(numeroBytes);
        BigInteger numeroParsed = this.base58ToInteger(numeroBase58);

        Assertions.assertEquals(numero.intValue(), numeroParsed.intValue());
    }

    private BigInteger base58ToInteger(String input) {
        final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
        final BigInteger BASE = BigInteger.valueOf(58);

        BigInteger num = BigInteger.ZERO;
        for (char c : input.toCharArray()) {
            int digit = ALPHABET.indexOf(c);
            if (digit == -1) {
                throw new IllegalArgumentException("Invalid character found: " + c);
            }
            num = num.multiply(BASE).add(BigInteger.valueOf(digit));
        }
        
        return num;
    }

    @Test
    public void baseHexadecimal() {
        Random rand = new Random();
        Integer numero = rand.nextInt(999999999);
        byte[] numeroBytes = BigInteger.valueOf(numero).toByteArray();

        String numeroHex = Encoder.encodeToHex(numeroBytes);
        Integer numeroParsed = Integer.parseInt(numeroHex, 16);

        Assertions.assertEquals(numero.intValue(), numeroParsed.intValue());
    }
}
