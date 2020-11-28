package usantatecla.draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  PlayControllerTest.class,
  RedoControllerTest.class,
  ResumeController.class,
  UndoControllerTest.class
})
public class AllControllersTests {
}
