package model;

/**
 * Represents a pixel for various visual projects.
 * Can be used to represent different types of pixel implementations and types.
 */
public interface IPixel {

  /**
   * Creates a String representation of this IPixel's color and alpha values.
   * @return this pixel as a String representation of its components.
   */
  String toString();

  /**
   * Applies a given filter to this pixel.
   *
   * @param f the filter to apply to this pixel
   */
  void apply(IFilterOption f);

  /**
   * Creates a copy of this pixel, so that any filters applied to the
   * returned object will not apply to this pixel which is being copied.
   *
   * @return separate pixel object identical to this pixel.
   */
  IPixel copy();

  /**
   * Using the formula provided, merges two pixels into one. The provided pixel
   * will be underneath this pixel.
   *
   * @param pix other pixel being combined. The pixel to be merged under this one.
   * @return the new pixel which is a combo of the two.
   */
  IPixel merge(IPixel pix);

  /**
   * Gets the brighten/darken value for this pixel.
   *
   * @return the integer for the brighten/darken value.
   */
  double getValue();

  /**
   * Gets the brighten/darken Luma for this pixel.
   *
   * @return the integer for the Luma.
   */
  double getLuma();

  /**
   * Gets the brighten/darken intensity for this pixel.
   *
   * @return the integer for the intensity.
   */
  double getIntensity();

  /**
   * Gets the max value of the pixel.
   *
   * @return the int for the max value.
   */
  int getMaxValue();

  /**
   * Determines if the IPixel is of the type RGB.
   *
   * @return a boolean which answers the question, "is this pixel an RGB representation?".
   */
  boolean isRGB();

  /**
   * Determines if the IPixel type HSL.
   *
   * @return a boolean which answers the question, "is this pixel an HSL representation?".
   */
  boolean isHSL();

  /**
   * Gets the IPixel below this IPixel.
   *
   * @return the IPixel below this IPixel.
   */
  IPixel getPixelBelow();

  /**
   * Sets this IPixel's pixelBelow field to be the given IPixel.
   *
   * @param below the IPixel which will be set to be beneath this IPixel.
   */
  void setPixelBelow(IPixel below);

}
