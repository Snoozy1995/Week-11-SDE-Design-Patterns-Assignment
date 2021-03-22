package FacadeSingletonStrategy.bll;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.dal.DALFacade;

import java.util.List;

public class MessageListDisplay {
    private final DALFacade dalFacade = DALFacade.getInstance();

    public List<Message> getAllMessages() {
        return dalFacade.getAllMessages();
    }
}
