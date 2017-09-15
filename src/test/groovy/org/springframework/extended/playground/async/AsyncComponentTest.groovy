package org.springframework.extended.playground.async

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.util.concurrent.Future

@ContextConfiguration(classes = AsyncTestConfiguration)
class AsyncComponentTest extends Specification {

    @Autowired
    AsyncComponent classUnderTest

    void "calling async method"() {
        when:
            Future<Long> result = classUnderTest.asynchronousMethod()
        then:
            noExceptionThrown()
            Thread.currentThread().getId() != result.get()
    }
}
