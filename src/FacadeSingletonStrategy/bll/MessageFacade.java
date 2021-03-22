package FacadeSingletonStrategy.bll;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.dal.DALFacade;

public class MessageFacade implements IMessageLoggingFacade {

    private final DALFacade dalFacade = DALFacade.getInstance();
    private final MessageCreator messageCreator = new MessageCreator();

    @Override
    public Message logMessage(String msg) {
        Message m = messageCreator.createMessage(msg);
        dalFacade.createAMessage(m);
        return m;
    }

}
