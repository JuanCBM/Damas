package usantatecla.draughts.views;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ViewTest.class, 
              GameViewTest.class, 
              PlayViewTest.class,
              UndoCommandTest.class,
              RedoCommandTest.class})
public class AllViewTests {
}
