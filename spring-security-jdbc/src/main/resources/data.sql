Insert into users(username, password, enabled) values('user','user',true);
Insert into users(username, password, enabled) values('admin','admin',true);

Insert into authorities(username, authority) values ('user','ROLE_USER');
Insert into authorities(username, authority) values ('admin','ROLE_ADMIN');