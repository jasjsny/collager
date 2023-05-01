package controller.command;

/**
 * This is a command interface, as per the command design pattern.
 * Anything that implements it is a command, aka an instruction by the user for the collage.
 * Used to implement different commands which each correspond to an action that can be taken
 * on the collage project
 */
public interface ICommand {


  /**
   * Executes the command specific to the class implementation.
   */
  public void execute();

}

