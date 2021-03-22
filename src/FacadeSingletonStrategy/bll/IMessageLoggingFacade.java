package FacadeSingletonStrategy.bll;

import FacadeSingletonStrategy.be.Message;

public interface IMessageLoggingFacade {

    Message logMessage(String msg);

}
