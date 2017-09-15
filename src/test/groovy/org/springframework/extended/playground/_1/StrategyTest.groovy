package org.springframework.extended.playground._1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = StrategyTestConfiguration)
class StrategyTest extends Specification {

    @Autowired
    List<MyStrategy> strategies

    void "stratgey test"() {
        expect:
            for (MyStrategy s : strategies) {
                if (s.applicable("2")) {
                    s.doSomething()
                }
            }
    }

    @Configuration
    @ComponentScan("org.springframework.extended.playground._1")
    static class StrategyTestConfiguration {

    }
}
