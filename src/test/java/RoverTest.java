import Exceptions.MessageCorruptedException;
import Exceptions.PlateauSizeViolatedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("1 3 N",rover.printCurrentPosition());

    }
}
