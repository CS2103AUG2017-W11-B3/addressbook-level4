package seedu.address.ui;

import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.ui.NewResultAvailableEvent;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final Logger logger = LogsCenter.getLogger(ResultDisplay.class);
    private static final String FXML = "ResultDisplay.fxml";

    private static final String ERROR_STYLE_CLASS = "error";

    private final StringProperty displayed = new SimpleStringProperty("");

    @FXML
    private TextArea resultDisplay;

    public ResultDisplay() {
        super(FXML);
        resultDisplay.textProperty().bind(displayed);
        registerAsAnEventHandler(this);
    }

    @Subscribe
    private void handleNewResultAvailableEvent(NewResultAvailableEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        Platform.runLater(() -> displayed.setValue(event.message));

        //@@author teclu
        if (event.isError) {
            setCommandFailureStyle();
        } else {
            setDefaultStyle();
        }
        //@@author
    }

    //@@author teclu
    /**
     * Sets {@code ResultDisplay} style to the default style.
     */
    private void setDefaultStyle() {
        resultDisplay.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    //@@author teclu
    /**
     * Sets {@code ResultDisplay} style to the fail-state style.
     */
    private void setCommandFailureStyle() {
        ObservableList<String> styleClass = resultDisplay.getStyleClass();

        if (styleClass.contains(ERROR_STYLE_CLASS)) { // Previous command was also invalid (failure)
            return;
        }

        styleClass.add(ERROR_STYLE_CLASS);
    }

}
