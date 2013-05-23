# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  uid                       integer auto_increment not null,
  name                      varchar(255),
  constraint pk_user primary key (uid))
;

create table user_like (
  id                        bigint auto_increment not null,
  created_at                datetime,
  uid                       integer not null,
  feed_id                   bigint not null,
  constraint pk_user_like primary key (id))
;

alter table user_like add constraint fk_user_like_user_1 foreign key (uid) references user (uid) on delete restrict on update restrict;
create index ix_user_like_user_1 on user_like (uid);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user;

drop table user_like;

SET FOREIGN_KEY_CHECKS=1;

