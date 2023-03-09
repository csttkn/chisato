package cstk.chisato;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChisatoApplicationTests {

    private enum USER_STATE {
        OK(0),
        DISABLE(1),
        LOCK(2),
        EXPIRED(3);

        private Integer value;
        USER_STATE(Integer value) {
            this.value = value;
        }

        public boolean equals(Integer val){
            return this.value.equals(val);
        }

    }

    @Test
    void contextLoads() {

        System.out.println(USER_STATE.DISABLE.equals(1));
    }

}
