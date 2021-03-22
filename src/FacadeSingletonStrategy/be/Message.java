package FacadeSingletonStrategy.be;

public class Message{

    private int id; //final
    private final String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;

    }

    public Message(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }
    public int getId() {
        return id;
    }

    public String toString(){
        return text;
    }
}
