package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class CodeGenerator {
    public abstract String makeCode(String id);
    public String convertToString(byte[] array) {
        return IntStream.range(0, array.length / 4)
                .map(i -> array[i])
                .map(i -> (i < 0) ? i + 127 : i)
                .mapToObj(Integer::toHexString)
                .collect(Collectors.joining());
    }
}
