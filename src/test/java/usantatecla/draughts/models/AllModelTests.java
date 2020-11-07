package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// @formatter:off
@RunWith(Suite.class)
@SuiteClasses({
  CoordinateTest.class,
  CorrectMovesDraugthGameTest.class,
  CorrectMovesPawnGameTest.class,
  DirectionTest.class,
  GameTest.class,
  GameBuilderTest.class,
  IncorrectMovesDraughtGameTest.class,
  IncorrectMovesPawnGameTest.class,
  InitialGameTest.class,
  IsBlockedGameTest.class,
  PieceTest.class})
//@formatter:on
public class AllModelTests {

}
