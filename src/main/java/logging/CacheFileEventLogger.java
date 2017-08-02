package logging;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger
{
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(int size, String fileName)
    {
        super(fileName);
        this.cacheSize = size;
        cache = new ArrayList<Event>();
    }

    public void logEvent(Event event)
    {
        cache.add(event);
        if(cache.size() == cacheSize)
        {
            for(Event event1 : cache)
            {
            super.logEvent(event1);
            }
            cache.clear();
        }
    }

    public void destroy()
    {
        if(!cache.isEmpty())
        {
            for(Event event1 : cache)
            {
                super.logEvent(event1);
            }
        }
    }
}
