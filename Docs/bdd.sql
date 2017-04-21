use dbJEE;
create table users(
     id int,
     userName varchar(50),
     email varchar(255)
);
create table project(
     id int,
     title varchar(100),
     description varchar(200)  
);
create table post(
     id int,
     title varchar(100),
     content varchar(250),
     prjectID int,
     restricted bool
);

create table messages(
     id int,
     title varchar(100),
     message varchar(250),
     userSenderID int,
     userReceiverID int
);

create table followers(
     id int,
     userFollowedID int,
     userFollowerID int
);

create table teams(
     id int,
     projectID int,
     memberID int
);