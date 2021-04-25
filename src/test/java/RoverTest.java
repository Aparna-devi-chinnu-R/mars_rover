import Exceptions.MessageCorruptedException;
import Exceptions.PlateauSizeViolatedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverTest
{
    @Test
    public void shouldReturnTheCurrentPositionAfterGivenMovements() throws MessageCorruptedException, PlateauSizeViolatedException {
        Plateau plateau=new Plateau();
        plateau.setMax_x(5);
        plateau.setMax_y(5);
        Rover first_rover = new Rover();
        first_rover.setInitialPosition(1,2,'N',plateau);
        first_rover.commands("LMLMLMLMM");
        assertEquals("1 3 N",first_rover.printCurrentPosition());
        Rover second_rover = new Rover();
        second_rover.setInitialPosition(3, 3, 'E',plateau);
        second_rover.commands("MMRMMRMRRM");
        assertEquals("5 1 E",second_rover.printCurrentPosition());

    }

    @Test 
    public void shouldRaiseAnExceptionIfRoverGoesOutOfPlateau() throws MessageCorruptedException, PlateauSizeViolatedException {
        Plateau plateau =new Plateau();
        plateau.setMax_x(4);
        plateau.setMax_y(4);
        Rover rover = new Rover();
        rover.setInitialPosition(3,3,'E',plateau);
        assertThrows(PlateauSizeViolatedException.class ,() -> rover.commands("MMRMMRMRRM"));

    }
    @Test
    public void shouldRaiseAnExceptionIfMessageContainsOtherAlphabetThanLRM() throws PlateauSizeViolatedException
    {
        Plateau plateau =new Plateau();
        plateau.setMax_x(5);
        plateau.setMax_y(5);
        Rover rover = new Rover();
        rover.setInitialPosition(3,3,'E',plateau);
        assertThrows(MessageCorruptedException.class ,() -> rover.commands("MMRPKLSM"));
    }
}
