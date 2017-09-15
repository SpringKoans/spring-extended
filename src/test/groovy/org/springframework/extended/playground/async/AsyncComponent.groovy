package org.springframework.extended.playground.async

import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Component

import java.util.concurrent.Future

@Component
class AsyncComponent {
    @Async
    Future<Long> asynchronousMethod() {
        Thread.sleep(1_000)
        return new AsyncResult<>(Thread.currentThread().getId())
    }
}
