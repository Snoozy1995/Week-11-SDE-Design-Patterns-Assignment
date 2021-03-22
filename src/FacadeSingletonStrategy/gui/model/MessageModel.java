package FacadeSingletonStrategy.gui.model;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.bll.MessageFacade;
import FacadeSingletonStrategy.bll.MessageListDisplay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MessageModel {
    MessageFacade messageFacade = new MessageFacade();
    MessageListDisplay messageList = new MessageListDisplay();

    private final ObservableList<Message> getTheMessageLogs = FXCollections.observableArrayList();

    public void createMessage(String text) {
        messageFacade.logMessage(text);
    }

    public ObservableList<Message> getMessageLogs() {
        getTheMessageLogs.setAll(messageList.getAllMessages());
        return getTheMessageLogs;
    }
}
