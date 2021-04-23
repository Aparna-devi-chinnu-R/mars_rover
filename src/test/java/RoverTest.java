import Exceptions.MessageCorruptedException;
import Exceptions.PlateauSizeViolatedException;
import org.junit.jupiter.api.Test;

public class RoverTest
{
    @Test
    public void shouldReturnTheCurrentPositionAfterGivenMovements() throws MessageCorruptedException, PlateauSizeViolatedException {
        Plateau plateau=new Plateau();
        plateau.setMax_x(5);
        plateau.setMax_y(5);
        Rover rover = new Rover();
        rover.setInitialPosition(1,2,'N');
        rover.commands("LMLMLMLMM");
        rover.printCurrentPosition();

    }
}
