import Exceptions.MessageCorruptedException;
import Exceptions.PlateauSizeViolatedException;

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

    public void commands(String command) throws MessageCorruptedException, PlateauSizeViolatedException {
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
            else
            {
                throw new MessageCorruptedException("Message is corrupted.Message cannot be identified");
            }
        }
    }

    private void move() throws PlateauSizeViolatedException {

        if(dir =='N' && this.x+1 <= Plateau.getMax_x())
        {
            this.x++;
        }
        else if(dir == 'S' && this.x-1 <=0)
        {
            this.x--;
        }
        else if(dir == 'E' && this.y+1 <= Plateau.getMax_y())
        {
            this.y++;
        }
        else if(dir == 'W' && this.y-1 <=0)
        {
            this.y--;
        }
        else
        {
            throw new PlateauSizeViolatedException("Size of the plateau is violated");
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
