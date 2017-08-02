import logging.Event;
import logging.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App
{
    private Client client;
    private Map<EventType, EventLogger> loggers;
    private Event event;
    private EventLogger defaultLogger;

    public EventLogger getDefaultLogger()
    {
        return defaultLogger;
    }

    public void setDefaultLogger(EventLogger defaultLogger)
    {
        this.defaultLogger = defaultLogger;
    }

    public void logEvent(EventType type, String msg)
    {
        EventLogger logger = loggers.get(type);
        if(logger == null)
        {
            logger = defaultLogger;
            System.out.println("Default logger is " + defaultLogger.getClass().getSimpleName());
        }

        String message = msg.replaceAll(String.valueOf(client.getId()), client.getFullName());
        event.setMsg(message);
        logger.logEvent(event);
    }

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configuration.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent(EventType.ERROR, "Some event for 1");
        app.logEvent(null, "Some event for 2");
    }

    public App(Client client, Map<EventType, EventLogger> loggers, Event event)
    {
        this.client = client;
        this.loggers = loggers;
        this.event = event;
    }
}
