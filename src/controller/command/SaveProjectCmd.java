package controller.command;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.IProject;
import view.IView;


/**
 * Class for the command, save-project, for the collager. Can be used to
 * save a .collage file of the project, which can be accessed later in order
 * to edit the project further.
 */
public class SaveProjectCmd implements ICommand {
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
  public SaveProjectCmd(Scanner sc, IProject project, IView view) {
    this.sc = sc;
    this.project = project;
    this.view = view;
  }

  /**
   * Method to save a project. If a path does not exist it will make a new one,
   * else overwrite existing.
   */
  @Override
  public void execute() {
    String path = "";

    if (sc.hasNext()) {
      path = sc.next();
    }

    try {

      FileWriter fw = new FileWriter(path);

      fw.write(project.formatProject());
      fw.close();


      this.view.renderMessage("\nFile saved successfully to " + path);

    } catch (IOException e) {
      throw new IllegalStateException("IO Exception thrown.");
    }

  }

}
