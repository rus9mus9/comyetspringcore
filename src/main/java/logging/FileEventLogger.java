package logging;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger
{
    private String fileName;

    public void logEvent(Event event)
    {
        try
        {
            FileUtils.writeStringToFile(new File(fileName), event.getMsg(), true);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public FileEventLogger(String fileName)
    {
        this.fileName = fileName;
    }

    public void init() throws IOException
    {
        if(!new File(fileName).canWrite())
        {
            throw new IOException();
        }
    }
}
