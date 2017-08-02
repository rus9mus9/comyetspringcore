package logging;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger
{
    private Collection<EventLogger> allLoggers;

    public CombinedEventLogger(Collection<EventLogger> loggers)
    {
        this.allLoggers = loggers;
    }

    public void logEvent(Event event)
    {
        for(EventLogger event1 : allLoggers)
        {
            event1.logEvent(event);
        }
    }
}
