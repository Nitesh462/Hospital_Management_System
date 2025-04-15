package com.example.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String SECRET = "someSecret"; // Change this for production
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    public static String hashPassword(String password) {
        try {
            byte[] salt = SECRET.getBytes();
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException("Error hashing password", ex);
        }
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        String newHash = hashPassword(plainPassword);
        return newHash.equals(hashedPassword);
    }
}
