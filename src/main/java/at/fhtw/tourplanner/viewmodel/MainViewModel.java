package at.fhtw.tourplanner.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainViewModel {
    // http://openbook.rheinwerk-verlag.de/javainsel/12_004.html
    private final StringProperty input = new SimpleStringProperty("");
    private final StringProperty output = new SimpleStringProperty("Enter a final destination!");

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public StringProperty inputProperty() {
        System.out.println("VM: get input prop");
        return input;
    }

    public StringProperty outputProperty() {
        System.out.println("VM: get output prop");
        return output;
    }

    public void calculateOutputString() {
        System.out.println("VM: calculate Output");
        this.output.set("Your destination: ".concat(this.input.get()));
        this.input.set("");
        this.propertyChangeSupport.firePropertyChange("RequiresPropertyChange", false, true);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }
}
