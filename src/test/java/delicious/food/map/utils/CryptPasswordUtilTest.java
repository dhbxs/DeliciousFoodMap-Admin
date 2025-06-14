package delicious.food.map.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptPasswordUtilTest {

    CryptPasswordUtil  cryptPasswordUtil;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSecureRandomString() {

        String secureRandomString = cryptPasswordUtil.getSecureRandomString();
        System.out.println(secureRandomString);
    }
}