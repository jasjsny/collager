package model;

/**
 * Enumeration to represent different types of filters which can be applied to layers.
 */
public enum FilterOption implements IFilterOption {
  // the "normal" filter for when no changes should be made to a layer's image
  NORM("normal"),
  // filters the layer by its red components
  RED("red-component"),
  // filters the layer by its blue components
  BLUE("blue-component"),
  // filters the layer by its green components
  GREEN("green-component"),
  // brightens the layer according to alpha value
  BRIGHTV("brighten-value"),
  // darkens the layer according to alpha value
  DARKV("darken-value"),
  // brightens the layer according to intensity
  BRIGHTI("brighten-intensity"),
  // darkens the layer according to intensity
  DARKI("darken-intensity"),
  // brightens the layer according to luma
  BRIGHTL("brighten-luma"),
  // darkens the layer according to luma
  DARKL("darken-luma"),
  // the difference filter
  DIFFERENCE("difference"),
  // the multiply filter
  MULTIPLY("multiply"),
  // the screen filter
  SCREEN("screen"),
  // ERROR is only used for testing exceptions
  ERROR("unsupported");

  // the description of the layer name
  private final String descriptor;

  // a constructor for a FilterOption
  FilterOption(String descriptor) {
    this.descriptor = descriptor;
  }

  /**
   * ToString method converting fo into a string.
   *
   * @return the descriptor of this IFilterOption
   */
  @Override
  public String toString() {
    return this.descriptor;
  }

  /**
   * From string method converts a string to a FilterOption.
   * @param str the String which describes the filter.
   * @return the FilterOption corresponding with the string.
   * @throws IllegalArgumentException if the provided string does not describe
   *                                  a supported filter.
   */
  public FilterOption fromString(String str) throws IllegalArgumentException {

    switch (str) {
      case "normal":
        return FilterOption.NORM;
      case "red-component":
        return FilterOption.RED;
      case "blue-component":
        return FilterOption.BLUE;
      case "green-component":
        return FilterOption.GREEN;
      case "brighten-value":
        return FilterOption.BRIGHTV;
      case "darken-value":
        return FilterOption.DARKV;
      case "brighten-intensity":
        return FilterOption.BRIGHTI;
      case "darken-intensity":
        return FilterOption.DARKI;
      case "brighten-luma":
        return FilterOption.BRIGHTL;
      case "darken-luma":
        return FilterOption.DARKL;
      case "multiply":
        return FilterOption.MULTIPLY;
      case "difference":
        return FilterOption.DIFFERENCE;
      case "screen":
        return FilterOption.SCREEN;
      default:
        throw new IllegalArgumentException("Filter option with that name does not exist.");
    }
  }
}