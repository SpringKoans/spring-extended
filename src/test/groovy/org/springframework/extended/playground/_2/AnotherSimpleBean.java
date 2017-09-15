package org.springframework.extended.playground._2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author stefan.pachler
 */
@Component
public class AnotherSimpleBean {
    private final SimpleBean mySimpleBean;


    public AnotherSimpleBean(SimpleBean mySimpleBean) {
        this.mySimpleBean = mySimpleBean;
    }

}
