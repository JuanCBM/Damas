package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import usantatecla.draughts.controllers.AllControllerTests;
import usantatecla.draughts.models.AllModelTests;
import usantatecla.draughts.views.AllViewTests;

//@formatter:off
@RunWith(Suite.class)
@SuiteClasses({
  AllModelTests.class,
  AllControllerTests.class,
  AllViewTests.class,
})
//@formatter:on
public class AllTests {

}
