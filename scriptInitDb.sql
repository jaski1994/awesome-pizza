create database AwesomePizza;
create user 'springuser'@'%' identified by 'ThePassword';
grant all on AwesomePizza.* to 'springuser'@'%';