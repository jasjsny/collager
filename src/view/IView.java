package view;

import java.io.IOException;

import controller.Features;

/**
 * Interface which details the methods to display a visual project with layers.
 */
public interface IView {

  /**
   * Renders a message in the view.
   *
   * @param message is the message to be rendered
   * @throws IOException if the view is unable to transmit a rendering of the message
   */
  void renderMessage(String message) throws IOException;

  /**
   * Reinstates this GUI view, if the implementation of this interface can be used
   * as a GUI.
   *
   * @param controller the controller which this view will be reinstated with
   * @throws IllegalStateException if this view implementation does not support a GUI
   */
  IView makeGui(Features controller) throws IllegalStateException;
}