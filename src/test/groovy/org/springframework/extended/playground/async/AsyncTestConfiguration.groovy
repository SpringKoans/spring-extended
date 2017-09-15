package org.springframework.extended.playground.async

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import java.util.concurrent.Executor

@EnableAsync
@Configuration
@ComponentScan(basePackages = "org.springframework.extended.playground.async")
class AsyncTestConfiguration {
    @Bean
    Executor executor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor()
        executor.setCorePoolSize(2)
        executor.setMaxPoolSize(2)
        executor.setQueueCapacity(500)
        executor.setThreadNamePrefix("bearingpoint-spring-training-")
        executor.initialize()
        return executor;
    }
}
