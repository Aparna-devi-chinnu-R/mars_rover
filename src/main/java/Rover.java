import Exceptions.MessageCorruptedException;
import Exceptions.PlateauSizeViolatedException;

public class Rover
{
    private int x;
    private int y;
    private char dir;
    Plateau plateau;
    public void setInitialPosition(int x, int y, char dir,Plateau plateau)
    {
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.plateau=plateau;
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

        if(dir =='N' && this.y+1 <= plateau.getMax_y())
        {
            this.y++;
        }
        else if(dir == 'S' && this.y-1 >=0)
        {
            this.y--;
        }
        else if(dir == 'E' && this.x+1 <= plateau.getMax_x())
        {
            this.x++;
        }
        else if(dir == 'W' && this.x-1 >=0)
        {
            this.x--;
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

    public String printCurrentPosition()
    {
        return x+" "+y+" "+dir;
    }
}

