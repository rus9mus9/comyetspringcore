public class Client
{
    private int id;
    private String fullName;
    private String greeting;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public Client(int id, String fullName)
    {
        this.id = id;
        this.fullName = fullName;
    }

    public void setGreeting(String gr)
    {
        this.greeting = gr;
        System.out.printf("%s is set with Spring property%n",  greeting);
    }
}
