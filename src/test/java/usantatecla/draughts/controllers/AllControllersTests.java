package usantatecla.draughts.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PlayControllerTest.class, UndoRedoControllerTest.class, ResumeControllerTest.class})
public class AllControllersTests {
}
