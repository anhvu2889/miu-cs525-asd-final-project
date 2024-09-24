package domain.framework.usecase.notification.observer;

import domain.framework.entity.Event;

public interface Observer {
    void onUpdate(Event event, Object object);
}
