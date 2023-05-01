package model;

import java.util.List;

/**
 * Represents an interface for a collage project which uses layers, and allows the filtering of
 * its layers. Also allows the adding of images to the layers.
 * This interface represents the Collager's model, consisting of a list of layers which each are
 * a 2D list of IPixels. This is the model is used in the MVC.
 */
public interface IProject {

  /**
   * This method gets the layers from the project as a copy, not a reference.
   *
   * @return a list of copies of this project's layers.
   */
  public List<ILayer> returnAllLayers();

  /**
   * This method puts the project into the desired format to be saved.
   *
   * @return the string format desired.
   */
  public String formatProject();

  /**
   * Adds a fully-transparent, white layer to the top of this project.
   *
   * @param name what the new layer will be named
   * @throws IllegalArgumentException if a layer with the given name already exists in this project
   */
  public void addLayer(String name) throws IllegalArgumentException;

  /**
   * Adds an image to the layer with the given name, with the provided coordinate being the
   * location within the layer of the image's top-left corner.
   *
   * @param layerName the name of the layer which the image is being added to
   * @param img the actual image to be added to the layer
   * @param x the x-coordinate within the layer, of the image's top-left corner location
   * @param y the y-coordinate within the layer, of the image's top-left corner location
   * @throws IllegalArgumentException if layerName is null, if img is null,
   *                                  if layerName is not the name of a layer which exists,
   *                                  if the provided x or y coordinates are negative,
   *                                  if the provided coordinate is not on the layer,
   *                                  or if part of the image would be off of the layer, given its
   *                                  size and desired location
   */
  public void addLayerImg(String layerName, List<List<IPixel>> img, int x, int y) throws
          IllegalArgumentException;

  /**
   * Compresses the project's layers to one, making an image.
   *
   * @param name name you want the image to be.
   * @return the ILayer which represents the compressed image.
   */
  public ILayer compressToImage(String name);

  /**
   * Gets the name of this IProject.
   * @return the String representing the name of the Project.
   */
  public String getName();

  /**
   * Applies the given FilterOption to the given file name.
   *
   * @param s the name of the layer to have the filter applied
   * @param f the filter that will be applied to the layer
   */
  public void applyFilterToCertainLayer(IFilterOption f, String s) throws IllegalArgumentException;

  /**
   * Sets the given filter to the given layer.
   *
   * @param f filterOption that is given
   * @param s layerName that is given
   * @throws IllegalArgumentException if the given String does not correspond to a layer
   *                                  in this collage project
   *                                   OR if the given name == null
   */
  public void setFilterToCertainLayers(IFilterOption f, String s) throws IllegalArgumentException;

  /**
   * Starts this project with the given attributes.
   *
   * @param name the name to be given to this collage project
   * @param height the height to be given to this collage project
   * @param width the width to be given to this collage project
   * @throws IllegalStateException if this collage project has already been started
   * @throws IllegalArgumentException if a null String is given for the name
   *                                  OR if the given height/width are invalid
   */
  public void startProject(String name, int height, int width)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * Starts this project with the given attributes.
   *
   * @param name the name to be given to this collage project
   * @param layers the layers to be given to this collage project
   * @param height the height to be given to this collage project
   * @param width the width to be given to this collage project
   * @throws IllegalStateException if this collage project has already been started
   * @throws IllegalArgumentException if a null String is given for the name
   *                                 OR if an empty list of layers is given
   *                                 OR if the given height/width are invalid
   */
  public void startProject(String name, List<ILayer> layers, int height, int width)
          throws IllegalStateException, IllegalArgumentException;

  /**
   * Creates a 2D array of the RGB pixel representation being used by this project.
   *
   * @param height the height of the 2D array of RGB pixels to be created
   * @param width the width of the 2D array of RGB pixels to be created
   * @return the 2D array of RGB pixels which has the specified height and width
   * @throws IllegalArgumentException if the given height or width are <= 0
   */
  public IPixel[][] doubleArrayRGB(int height, int width) throws IllegalArgumentException;

  /**
   * Creates an object which represents an RGB pixel, using whichever representation of
   * an RGB pixel that this project utilizes.
   *
   * @param r the r value of the RGB pixel to be created
   * @param g the g value of the RGB pixel to be created
   * @param b the b value of the RGB pixel to be created
   * @param maxVal the maximum value for any color value in the RGB pixel created
   * @return the RGB pixel with the specified values
   * @throws IllegalArgumentException if any of the given values are negative,
   *        OR if they go above the maximum value provided
   */
  IPixel createRGB(int r, int g, int b, int maxVal) throws IllegalArgumentException;

  /**
   * Creates an object of the layer implementation used by this project, with the
   * specified attributes.
   *
   * @param name the name of the layer object to be created
   * @param pix the list of pixels which the layer object will have
   * @param height the height that the layer object will have
   * @param width the width that the layer object will have
   * @return an object of the layer implementation used by this project, with the given attributes
   * @throws IllegalArgumentException if the given name is null,
   *        OR if the size of pix is not consistent with the given height/width
   *        OR if pix is empty
   *        OR if the rows in pix are empty
   *        OR if the rows in pix do not have the same amounts of pixels
   *        OR if the given height/width are <= 0
   */
  ILayer createLayerImp(String name, List<List<IPixel>> pix, int height, int width)
          throws IllegalArgumentException;

  /**
   * Creates an object which represents an RGBA pixel, using whichever representation of
   * an RGBA pixel that this project uses.
   *
   * @param r the red component of the RGBA pixel to be created
   * @param g the green componenet of the RGBA pixel to be created
   * @param b the blue component of the RGBA pixel to be created
   * @param a the alpha value of the RGBA pixel to be created
   * @return an RGBA pixel implementation with the given values
   * @throws IllegalArgumentException if invalid values are given for the pixel components
   */
  IPixel createRGBA(int r, int g, int b, int a);
}
