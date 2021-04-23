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
            if(single_command == 'L')
            {
                turnLeft();
            }
            else if(single_command == 'R')
            {
                turnRight();
            }
            else if(single_command == 'M')
            {
                move();
            }
        }
    }

    private void move()
    {
        if(dir =='N')
        {
            this.x++;
        }
        else if(dir == 'S')
        {
            this.x--;
        }
        else if(dir == 'E')
        {
            this.y++;
        }
        else
        {
            this.y--;
        }
    }

    private void turnRight()
    {
        if(dir == 'N'){dir = 'E';}
        else if(dir == 'W'){dir='N';}
        else if(dir == 'S'){dir ='W';}
        else{dir = 'S';}
    }

    private void turnLeft()
    {
        if(dir == 'N'){dir = 'W';}
        else if(dir == 'W'){dir='S';}
        else if(dir == 'S'){dir ='E';}
        else{dir = 'N';}
    }

}
