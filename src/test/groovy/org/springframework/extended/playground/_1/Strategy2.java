package org.springframework.extended.playground._1;

import org.springframework.stereotype.Component;

/**
 * @author stefan.pachler
 */
@Component
public class Strategy2 implements MyStrategy {
    @Override
    public boolean applicable(String name) {
        return name.equals("2");
    }

    @Override
    public void doSomething() {
        System.out.println("running strategy 2");
    }
}
