package FacadeSingletonStrategy.dal.localfile;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.dal.IDataAccessLayer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class MessageBoardLocal implements IDataAccessLayer {

    public static final String LocalFilePath ="src/FacadeSingletonStrategy/dal/localfile/LocalTextFile.xml";

    @Override
    public List<Message> getAllMessages() {

        List<Message> array = new ArrayList<>();
        File file = new File(LocalFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String xmlString="";
            String line;
            while ((line = reader.readLine()) != null) { xmlString=xmlString+""+line; }
            XStream xStream=getXStream();
            array=(List<Message>)xStream.fromXML(xmlString);
        }catch(Exception e){
            e.printStackTrace();
        }
        return array;

    }

    @Override
    public void createAMessage(Message message) {
        XStream xStream = getXStream();
        FileWriter fileWriter = null;
        List<Message> messages=getAllMessages();
        messages.add(0,message);
        try {
            fileWriter = new FileWriter(LocalFilePath);
            fileWriter.write(xStream.toXML(messages));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public XStream getXStream(){
        Class<?>[] classes = new Class[] { List.class, ArrayList.class,Message.class };
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        xStream.alias("messages", List.class);
        return xStream;
    }
}
