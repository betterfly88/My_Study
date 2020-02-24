package net.class101.server1.common;

import net.class101.server1.service.OrderExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class HomeworkRunner implements ApplicationRunner {
    private final OrderExecutor executor;

    @Override
    public void run(ApplicationArguments args) {
        executor.execute();
    }
}
