import org.junit.jupiter.api.Test;

public class RoverTest
{
    @Test
    public void shouldReturnTheCurrentPositionAfterGivenMovements()
    {
        Plateau plateau=new Plateau();
        plateau.setMax_x(5);
        plateau.setMax_y(5);
       Rover rover = new Rover();
       rover.setInitialPosition(1,2,'N')

    }
}
