package com.exProject.utilities;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author Suguru
 */
public class TokenGenerator {
    
    public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int SECURE_TOKEN_LENGTH = 255;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final char[] SYMBOLS = CHARACTERS.toCharArray();
    private static final char[] BUF = new char[SECURE_TOKEN_LENGTH];
    
    public String getToken() {
        for (int i = 0; i < BUF.length; i++)
            BUF[i] = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        return new String(BUF);
    }
    
}
