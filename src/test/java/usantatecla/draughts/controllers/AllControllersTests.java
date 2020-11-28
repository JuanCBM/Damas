package usantatecla.draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PlayControllerTest.class, 
  ResumeControllerTest.class,
  RedoControllerTest.class,
  UndoControllerTest.class})
public class AllControllersTests {
}
