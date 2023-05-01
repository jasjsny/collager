package model;

/**
 * Interface for the options for filters in the collager.
 */
public interface IFilterOption {

  /**
   * Creates the description for this IFilterOption.
   * @return the description of this IFilterOption as a String.
   */
  public String toString();

  /**
   * Creates the corresponding IFilterOption from a given String.
   * @param s the String which is used to create the IFilterOption.
   * @return the corresponding IFilterOption.
   * @throws IllegalArgumentException if the given String does not correspond to a
   *                                  supported IFilterOption.
   */
  public IFilterOption fromString(String s) throws IllegalArgumentException;
}
