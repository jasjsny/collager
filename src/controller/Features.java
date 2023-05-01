package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import model.ILayer;

/**
 * An interface for a controller which is used to detail the functionality of a collage project GUI.
 * This interface is for a controller which has its methods called from the GUI, and which then
 * acts on the model according to what the user selects with the GUI.
 */
public interface Features {
  /**
   * Creates a project from the user-entered name, height, and width.
   * Also makes the controller's model the new created project.
   *
   * @param name   the name for the new project
   * @param height the height for the new project
   * @param width  the width for the new project
   */
  public void createProj(String name, int height, int width);

  /**
   * Saves the current state of a collage project as a .collage file,
   * so that it can be accessed as a project later
   * @param folderPath the path at which to save a .collage file of
   *                   the current collage project
   */
  public void saveProj(String folderPath);

  /**
   * Saves the current state of a collage project as the image type
   * specified by the extension at the end of the file path.
   * Saves the image with the name given in the file path.
   *
   * @param imgPath the file path which provides the location of the image,
   *                as well as the name and its desired type of extension
   */
  public void saveImg(String imgPath);

  /**
   * Loads a given collage project which already exists.
   *
   * @param project the project to be loaded
   * @throws IOException if there is an error when transmitting to the view
   */
  public void loadProj(File project) throws IOException;

  /**
   * Returns all the layers which the collage project has.
   *
   * @return the ILayers of the collage project
   */
  List<ILayer> getLayers();

  /**
   * Sets this controller's "layer-of-interest" index, indicating the selected layer that filters
   * or any images will be applied to. The layer-of-interest is selected in some way by the user
   *
   * @param indexLoi the index of the layer-of-interest. the position of the layer in the
   *                 collage project, relative to other layers in the project.
   *                 A lower loi index corresponds to a lower layer.
   */
  void setLoi(int indexLoi);

  /**
   * Returns the index of the layer-of-interest.
   *
   * @return the layer-of-interest's index, relative to other layers in the collage project.
   */
  int getLoi();

  /**
   * Sets the layer-of-interest to have the given filter.
   *
   * @param fName the filter that will be set as the layer-of-interest's filter
   */
  void loiFilter(String fName) throws IOException;

  /**
   * Creates a layer in the model with a given name.
   *
   * @param name the name for the new filter
   * @throws IllegalArgumentException if a filter with the given name already exists,
   *                                  OR if name == null
   */
  void createLayer(String name) throws IllegalArgumentException;

  /**
   * Creates the current collage project as a BufferedImage. Compresses all the project's
   * layers into a single layer, which is then converted into the final BufferedImage.
   *
   * @return the project as a BufferedImage
   */
  BufferedImage projDisplay();

  /**
   * Adds an image to the layer-of-interest at a specified coordinate.
   *
   * @param ppm the image to be added to the layer-of-interest
   * @param x the x-coordinate of the position in which to place the image
   * @param y the y-coordinate of the position in which to place the image
   */
  void addLoiImage(File ppm, int x, int y);

  /**
   * Gets the name of the project.
   *
   * @return the name of the collage project which the user is working on
   */
  String getProjName();
}