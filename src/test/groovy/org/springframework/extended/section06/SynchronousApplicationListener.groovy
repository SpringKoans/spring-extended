package org.springframework.extended.section06

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SynchronousApplicationListener/* implements ApplicationListener<CustomApplicationEvent> */ {

    List<Long> startEvents = new ArrayList<>()
    List<Long> stopEvents = new ArrayList<>()

    @EventListener(condition = "event.start")
    public void handleStartEvent(CustomApplicationEvent event) {
        this.startEvents.add(Thread.currentThread().id)
    }

    @EventListener(condition = "event.stop")
    public void handleStopEvent(CustomApplicationEvent event) {
        this.stopEvents.add(Thread.currentThread().id)
    }

    /* @Override
     void onApplicationEvent(CustomApplicationEvent event) {
         if (event.start) {
             handleStartEvent(event)
         }
         if (event.stop) {
             handleStopEvent(event)
         }
     }*/
}
