import com.ananth.game.service.CharacterUtils;
import org.junit.Assert;
import org.junit.Test;

public class CharacterUtilsTest {

    @Test
    public void createCharacterTest() {
        Assert.assertNotNull(CharacterUtils.createCharacter(1));
    }
}
