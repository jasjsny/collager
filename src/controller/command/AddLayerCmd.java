package controller.command;

import java.io.IOException;
import java.util.Scanner;

import model.IProject;
import view.IView;

/**
 * Class for add-layer command. Can be used to add a layer to the supplied model.
 * The desired name for the layer is received through the scanner
 */
public class AddLayerCmd implements ICommand {
  Scanner sc;
  IProject project;
  IView view;

  /**
   * Constructor for this command. Takes in the scanner for receiving input,
   * the model which will be affected by this command's actions, and the view
   * which is associated with the project
   *
   * @param sc      scanner which will read the input from the user
   * @param project model which will be affected by this command's actions
   * @param view the visual of the collage project
   */
  public AddLayerCmd(Scanner sc, IProject project, IView view) {
    this.sc = sc;
    this.project = project;
    this.view = view;
  }

  /**
   * Method to add a layer given the layer name.
   */
  @Override
  public void execute() {

    while (sc.hasNext()) {
      String name = sc.next();
      try {
        project.addLayer(name);
        try {
          this.view.renderMessage("\nLayer created with name: " + name);
        }
        catch (IOException ex) {
          throw new IllegalStateException("IOE thrown.");

        }
        break;
      }
      catch (IllegalArgumentException e) {
        // if exception is caught, that means another layer with that name is found

        try {
          this.view.renderMessage("Layer already exists with this name, please enter new name.\n");
        }
        catch (IOException ex) {
          throw new IllegalStateException("IOE thrown.");

        }
      }
    }

  }
}
