import com.ananth.game.model.player.Character;
import com.ananth.game.model.player.Fighter;
import com.ananth.game.service.BattleUtils;
import org.junit.Assert;
import org.junit.Test;

public class BattleUtilsTest {

    @Test
    public void initializeFighterWithWeaponTest() {
        Fighter fighter = new Fighter("TEST") {
            @Override
            public void initialize() {

            }

            @Override
            public void attack(Character opponent) {

            }
        };

        BattleUtils.initializeFighterWithWeapon(fighter,1);
        Assert.assertTrue(fighter.getSkillSetMap().size() > 0);
    }

    @Test
    public void addFireBallWeaponTest() {
        Fighter fighter = new Fighter("TEST") {
            @Override
            public void initialize() {

            }

            @Override
            public void attack(Character opponent) {

            }
        };

        BattleUtils.initializeFighterWithWeapon(fighter,1);
        Assert.assertTrue(fighter.getSkillSetMap().size() > 0);
    }
}
