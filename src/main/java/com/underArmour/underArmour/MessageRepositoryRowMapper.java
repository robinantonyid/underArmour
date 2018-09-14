package com.underArmour.underArmour;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageRepositoryRowMapper implements RowMapper {
	
	
	@Override
	public MessageBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessageBean messageModel = new MessageBean();
		messageModel.setRowID(rs.getLong("id"));
		messageModel.setUsername(rs.getString("user_name"));
		messageModel.setText(rs.getString("user_message"));
		//messageModel.setCreationTime(rs.getTimestamp("creation_time"));
		messageModel.setExpiration_date(rs.getTimestamp("expiration_time"));
		//messageModel.setTimeout(rs.getInt("time_out"));
		return messageModel;
	}

	
	
}
