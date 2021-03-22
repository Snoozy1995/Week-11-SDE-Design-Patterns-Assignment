package FacadeSingletonStrategy.dal;

import FacadeSingletonStrategy.be.Message;

import java.util.List;

public interface IDataAccessLayer {
    List<Message> getAllMessages();
    void createAMessage(Message message);
}
