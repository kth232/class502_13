package org.choongang.statistic.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MemberStatisticService {
    //기본값: millisec ->timeUnit으로 단위 변경 가능
    @Scheduled(fixedRate = 5000, timeUnit = TimeUnit.SECONDS) //스케줄 주기는 상황에 맞게 사용자가 직접 설정
    public void makeData() {
        log.info("실행");
    }
}
