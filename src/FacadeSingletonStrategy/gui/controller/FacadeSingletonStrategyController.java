package FacadeSingletonStrategy.gui.controller;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.gui.model.MessageModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FacadeSingletonStrategyController implements Initializable {

    MessageModel messageModel = new MessageModel();

    @FXML
    private ListView<Message> displayMessage;

    @FXML
    private TextField receivesMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateListDisplay();
    }

    @FXML
    public void savesMessage() {
        messageModel.createMessage(receivesMessage.getText());
        receivesMessage.clear();
        UpdateListDisplay();
    }

    public void UpdateListDisplay(){
        displayMessage.setItems(messageModel.getMessageLogs());
    }
    

}
