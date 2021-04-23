public class Rover
{
    private int x;
    private int y;
    private char dir;

    public void setInitialPosition(int x, int y, char dir)
    {
        this.x=x;
        this.y=y;
        this.dir=dir;
    }

    public void commands(String command)
    {
        for(int i=0;i<command.length();i++)
        {
            char single_command = command.charAt(i);

        }
    }
}
