package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({GameTest.class, CorrectMovesDraugthGameTest.class, CorrectMovesPawnGameTest.class,
    IsBlockedGameTest.class})
public class AllModelTests {

}
