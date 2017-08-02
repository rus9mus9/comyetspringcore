package logging;

import java.text.DateFormat;
import java.util.Date;

public class Event
{
    private int id;
    private String msg;
    private static Date date;
    private DateFormat df;

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getMsg()
    {
        return msg;
    }

    public Event(Date date, DateFormat df)
    {
        this.id = (int) (Math.random() * 100);
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString()
    {
        return "logging.Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }

    public static boolean isDay()
    {
        return date.getHours() >= 8 && date.getHours() <= 17;
    }
}
