package FacadeSingletonStrategy.dal.db;

import FacadeSingletonStrategy.be.Message;
import FacadeSingletonStrategy.dal.IDataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageBoardDAO implements IDataAccessLayer {

    private final DBconnector datasource = new DBconnector();

    @Override
    public List<Message> getAllMessages() {

        List<Message> allMessages = new ArrayList<>();
        try(Connection con = datasource.getConnection()){
            String sql = "SELECT * FROM MessageLogTable ORDER BY MessageID DESC";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id  = rs.getInt("MessageID");
                String text = rs.getString("MessageText");

                Message message = new Message(id, text);
                allMessages.add(message);
            }
        } catch(SQLException sqle){
            System.out.println("Error: " + sqle);
        }
        return allMessages;
    }

    @Override
    public void createAMessage(Message message){
        try(Connection con = datasource.getConnection()){
            String sql = "INSERT INTO MessageLogTable (MessageText) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, message.getText());
            pstmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
