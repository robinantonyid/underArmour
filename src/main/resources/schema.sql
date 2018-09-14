create table usr_data
(
   id integer auto_increment not null ,
   user_name varchar(255) not null,
   user_message varchar(255) not null,
   creation_time timestamp,
   expiration_time timestamp,
   time_out int,
   primary key(id)
);