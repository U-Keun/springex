package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {

    private final SampleDAO sampleDAO; // @RequiredArgsConstructor를 이용한 생성자 주입(final 필수)
}
