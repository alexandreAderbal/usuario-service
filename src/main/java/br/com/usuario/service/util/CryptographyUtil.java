package br.com.usuario.service.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptographyUtil {
    public static String bcryptEncoder(String valor) {
        return  new BCryptPasswordEncoder().encode(valor);
    }
}
