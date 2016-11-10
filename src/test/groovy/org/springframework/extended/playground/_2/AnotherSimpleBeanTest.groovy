package org.springframework.extended.playground._2

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AnotherSimpleBeanTestConfiguration)
class AnotherSimpleBeanTest extends Specification {

    @Autowired
    AnotherSimpleBean classUnderTest

    void "test"() {
        expect:
            AnotherSimpleBean bean = new AnotherSimpleBean(Mock(SimpleBean))
            classUnderTest != null
    }

    @Configuration
    @ComponentScan("org.springframework.extended.playground._2")
    static class AnotherSimpleBeanTestConfiguration {

    }
}
