package org.zerock.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class) // JUnit5 버전에서 'spring-test'를 이용하기 위한 설정(JUnit4에서는 @Runwith)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml") // 스프링의 설정 정보를 로딩해온다.(현재 XML로 설정되어 있음)
public class SampleTest {

    @Autowired // 의존성 주입 관련 어노테이션; 해당 타입의 빈(Bean)이 존재하면 여기에 주입하라는 의미
    private SampleService sampleService;

    @Test
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }
}
