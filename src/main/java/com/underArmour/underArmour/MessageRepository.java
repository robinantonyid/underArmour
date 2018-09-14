package com.underArmour.underArmour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	private final static String INSERT_SQL = "insert into usr_data (user_name, user_message ,creation_time,expiration_time,time_out)" + "values(?, ?,?,?,?)";

	
	public MessageBean createUserMessage(MessageBean requestMessageBean) {
		

	    KeyHolder key = new GeneratedKeyHolder();
	    
    	MessageModel messageModel = new MessageModel();
		messageModel.setUsername(requestMessageBean.getUsername());
		messageModel.setMessage(requestMessageBean.getText());
		messageModel.setTimeout(requestMessageBean.getTimeout() > 0 ? requestMessageBean.getTimeout() : DefaultConstants.defaultTimeout);
		messageModel.setExpirationTime
		(Timestamp.from(ZonedDateTime.now().plusSeconds
				(requestMessageBean.getTimeout() > 0 ? requestMessageBean.getTimeout() 
						: DefaultConstants.defaultTimeout).toInstant()));
		messageModel.setCreationTime(Timestamp.from(ZonedDateTime.now().toInstant()));
		
		//jdbcTemplate.update("insert into usr_message (id, user_name, user_message ,creation_time,expiration_time,time_out)" + "values(?,?, ?,?,?,?)",
		//			new Object[] { messageModel.getId(),messageModel.getUsername(),messageModel.getMessage(),messageModel.getCreationTime(),messageModel.getExpiration_time(),messageModel.getTimeout()});
		
		jdbcTemplate.update(new PreparedStatementCreator() {

		      @Override
		      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		        final PreparedStatement ps = connection.prepareStatement(INSERT_SQL, 
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, messageModel.getUsername());
		        ps.setString(2, messageModel.getMessage());
		        ps.setTimestamp(3, messageModel.getCreationTime());
		        ps.setTimestamp(4, messageModel.getExpirationTime());
		        ps.setInt(5, messageModel.getTimeout());

                return ps;
		      }

			
		    }, key);
		    
		    System.out.println(key.getKey().longValue());
		    
		   
		    MessageBean messageBean = new MessageBean();
		    messageBean.setRowID(key.getKey().longValue());
		return messageBean;
	}

	
	public MessageBean findUserMessageDataByID(long ID) {
		
		return jdbcTemplate.queryForObject("select * from usr_data where id=?", new Object[] { ID },
				new BeanPropertyRowMapper<MessageBean>(MessageBean.class));
	}
		
	

	
	public List<MessageBean> findUnexpiredUserMessageDataByUserName(String userName) {
		
		return jdbcTemplate.query("select * from usr_data where user_name=? and expiration_time > ? ", 
				 new Object[] {userName,Timestamp.from(ZonedDateTime.now().toInstant())}, 
				 new MessageRepositoryRowMapper());
	
		}

}
