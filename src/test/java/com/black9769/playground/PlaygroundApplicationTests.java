package com.black9769.playground;

import com.black9769.playground.global.config.JasyptConfig;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundApplicationTests {

    @Test
    void contextLoads() {
    }

}

class JasyptTest extends JasyptConfig {
    @Test
    public void jasypt_encyrpt_and_decrypt_test(){
        String text = "jdbc:mariadb://192.168.35.29:3306/test";
        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("password");

        String encryptedText = jasypt.encrypt(text);
        String decryptedText = jasypt.decrypt(encryptedText);


        System.out.println(text);
        System.out.println(encryptedText);
        System.out.println(decryptedText);


    }
}
