package com.underArmour.underArmour;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

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
		Date date = java.util.Date.from(rs.getTimestamp("expiration_time")
				.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		messageModel.setExpiration_date(sdf.format(date));
		messageModel.setTimeout(rs.getInt("time_out"));
		return messageModel;
	}

	
	
}
