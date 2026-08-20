package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import models.Car;

import ctrl.IControllerForView;

/**
 * Contrôleur de la vue principale.
 * 
 * @author ...
 * 
 * 
 */
public class View implements IViewForController, Initializable {

  private static final String LOGO = "resources/images/emf-info.png";

  @FXML
  private ComboBox<String> cbbxBrand;
  @FXML
  private Label lblCarName;
  @FXML
  private Label lblPrice;
  @FXML
  private ListView<Car> lstvCar;
  @FXML
  private ImageView imvCar;
  @FXML
  private Label lblBrand;

  private final IControllerForView controller;

  Stage mainStage;
  Scene principalScene;

  public View(IControllerForView controller) {
    this.controller = controller;
  }

  @Override
  public void start() {
    Platform.startup(() -> {
      try {
        mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        fxmlLoader.setControllerFactory(type -> {
          return this;
        });

        Parent root = fxmlLoader.load(); // la méthode initialize est appelée ici
        principalScene = new Scene(root);

        principalScene.getStylesheets().add(getClass().getResource("/resources/css/style.css").toExternalForm());

        mainStage.setTitle("Car");
        mainStage.getIcons().add(new Image(LOGO));
        mainStage.setScene(principalScene);

        mainStage.show();

      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

    cbbxBrand.getItems().addAll(this.controller.getMarques());

    cbbxBrand.getSelectionModel().selectFirst();

    lstvCar.getSelectionModel().selectedItemProperty()
        .addListener((observable, oldValue, newValue) -> afficherCar(newValue));

    actionInitFiltre(null);

    filtrerCar();
  }

  public void quitter() {
    // faire qq chose avant de quitter
    // System.out.println("Je vous quitte !");
    // obligatoire pour bien terminer une application JavaFX
    Platform.exit();
  }

  private void afficherCar(Car car) {
    if (car != null) {
      lblBrand.setText(car.getBrand());
      lblCarName.setText(car.getName());
      lblPrice.setText(String.valueOf(car.getPrice() + ".-"));
      imvCar.setImage(new Image(car.getPicture()));
    }
  }

  private void effacerCar() {
    lblBrand.setText("");
    lblCarName.setText("");
    lblPrice.setText("");
    imvCar.setImage(null);
  }

  private void filtrerCar() {

    lstvCar.getItems().clear();
    lstvCar.getItems().addAll(this.controller.filtrerCar(cbbxBrand.getValue()));

    if (lstvCar.getItems().isEmpty()) {
      effacerCar();
    } else {
      lstvCar.getSelectionModel().selectFirst();
      afficherCar(lstvCar.getSelectionModel().getSelectedItem());
    }
  }

  @FXML
  private void actionAboutUs(MouseEvent event) {
    JfxPopup.displayInformation(null, "About us", "DCL Deluxe Car Location",
        "Toujours à votre service \n Le plaisir à l'état pur");
  }

  @FXML
  private void actionFiltreCar(ActionEvent event) {
    filtrerCar();
  }

  @FXML
  private void actionInitFiltre(ActionEvent event) {
    cbbxBrand.setValue("Toutes les marques");
  }

  @FXML
  private void actionQuitter(ActionEvent event) {
    quitter();
  }

  @FXML
  private void actionContact(ActionEvent event) {
    JfxPopup.displayInformation(null, "Contact", "Contactez-nous!",
        "Ecole des Métiers de Fribourg \n Chemin du Musée 2 \n 1700 Fribourg \n T +41 26 305 26 27");
  }

  @FXML
  private void actionHistoire(ActionEvent event) {
    JfxPopup.displayInformation(null, "Histoire", "Pourquoi cette application ?",
        "En vue de l'évaluation des connaissances java-javafx");
  }

}
