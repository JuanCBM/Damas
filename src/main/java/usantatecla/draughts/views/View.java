package usantatecla.draughts.views;

import usantatecla.draughts.controllers.InteractorController;
import usantatecla.draughts.controllers.InteractorControllersVisitor;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;

public class View extends SubView implements InteractorControllersVisitor {

  private static final String TITTLE = "Draughts";
  private PlayView playView;
  private ResumeView resumeView;


  public View() {
    this.console.writeln(TITTLE);

    this.playView = new PlayView();
    this.resumeView = new ResumeView();
  }

  public void interact(InteractorController controller) {
    assert controller != null;
    controller.accept(this);
  }

  @Override
  public void visit(PlayController playController) {
    assert playController != null;
    this.playView.interact(playController);
  }

  @Override
  public void visit(ResumeController resumeController) {
    assert resumeController != null;
    this.resumeView.interact(resumeController);
  }

}
