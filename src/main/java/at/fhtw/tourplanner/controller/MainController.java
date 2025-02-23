package at.fhtw.tourplanner.controller;

import at.fhtw.tourplanner.viewmodel.MainViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // create custom viewmodel
    public MainViewModel viewModel = new MainViewModel();

    // add fx:id and use intelliJ to create field in controller
    public TextField InputTextField;
    public Label OutputLabel;

    public MainController()
    {
        System.out.println("Controller created");
    }

    public void calculateOutput() {
        System.out.println("Controller calculate");
        viewModel.calculateOutputString();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller init");

        this.viewModel.addPropertyChangeListener(evt -> {
            if(evt.getPropertyName().equals("RequiresPropertyChange") && evt.getNewValue().equals(true))
            {
                InputTextField.requestFocus(); // controlled by VM
            }
        });

        InputTextField.textProperty().bindBidirectional(viewModel.inputProperty());

        // OutputLabel.textProperty().bindBidirectional(viewModel.outputProperty());
        Bindings.bindBidirectional(OutputLabel.textProperty(), viewModel.outputProperty());
    }
}
