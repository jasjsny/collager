package view;

import controller.Features;
import model.IProject;

import java.io.IOException;

/**
 * Represents a text-based visual representation of a Collage project.
 */
public class CollageTextView implements IView {
  private final IProject model;
  private final Appendable dest;

  /**
   * Creates a CollageTextView object.
   *
   * @param model state of the collage which the view is going to render
   * @param dest where the view will send the text-based visual to
   * @throws IllegalArgumentException if the given model or destination == null
   */
  public CollageTextView(IProject model, Appendable dest) throws IllegalArgumentException {
    if (model == null || dest == null) {
      throw new IllegalArgumentException("Cannot create view from a null model or destination.");
    }
    this.model = model;
    this.dest = dest;
  }

  /**
   * Creates a CollageTextView object, where the destination defaults to System.out.
   *
   * @param model state of the collage which the view is going to render
   */
  public CollageTextView(IProject model) {
    if (model == null) {
      throw new IllegalArgumentException("Cannot create view from a null model.");
    }
    this.model = model;
    this.dest = System.out;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.dest.append("\n").append(message);
    } catch (IOException ignore) {
      throw new IOException("Transmission failed.");
    }
  }

  @Override
  public IView makeGui(Features controller) throws IllegalStateException {
    throw new IllegalStateException("Cannot create a GUI for a text visual.");
  }
}

