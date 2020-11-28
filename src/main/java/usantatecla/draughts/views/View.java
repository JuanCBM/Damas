package usantatecla.draughts.views;

import usantatecla.draughts.controllers.AcceptorController;
import usantatecla.draughts.controllers.InteractorControllersVisitor;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

public class View implements InteractorControllersVisitor {

  private static final String MESSAGE = "¿Queréis jugar otra";

  private PlayView playView;
  private YesNoDialog yesNoDialog;

  public View() {
    this.yesNoDialog = new YesNoDialog();
    this.playView = new PlayView();
  }

  public void interact(AcceptorController controller) {
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

    if (this.yesNoDialog.read(MESSAGE))
      resumeController.reset();
    else
      resumeController.next();
  }

}
