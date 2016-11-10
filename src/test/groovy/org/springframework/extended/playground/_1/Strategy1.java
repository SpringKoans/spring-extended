package org.springframework.extended.playground._1;

import org.springframework.stereotype.Component;

/**
 * @author stefan.pachler
 */
@Component
public class Strategy1 implements MyStrategy {
    @Override
    public boolean applicable(String name) {
        return name.equals("1");
    }

    @Override
    public void doSomething() {
        System.out.println("Runnnig strategy 1");
    }
}
