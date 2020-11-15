package usantatecla.dobles.runWith;

import usantatecla.dobles.runWith.DOC;

public class SUT {

  private DOC doc;

  public SUT(DOC doc) {
    this.doc = doc;
  }

  public int exerciseSUT(boolean value) {
    return this.doc.exerciseDOC(value);
  }

}
