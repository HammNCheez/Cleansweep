create database cleansweep;
use cleansweep;

create table tasks (
    id serial primary key,
    task_name varchar(100) not null,
    description varchar(255) not null,
    cost decimal(6 , 2 ) not null,
    duration smallint not null
);

create table scheduled_tasks (
    id serial primary key,
    task_id bigint unsigned not null,
    scheduled_date date not null,
    completed_date datetime,
    reviewed_date datetime,
    assignee_id bigint unsigned,
    reviewer_id bigint unsigned
);

create table reoccuring_tasks (
    id serial primary key,
    task_id bigint unsigned not null,
    frequency char(1) not null,
    day_number smallint,
    task_interval smallint,
    week_of_month smallint,
    end_date date,
    occurances smallint,
    start_date date not null
);

create table users (
    id serial primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    username varchar(30) not null,
    password_hash char(64) not null,
    access_level smallint not null,
    allowance_total decimal(6 , 2 )
);

alter table scheduled_tasks
add constraint fk_scheduled_task_id
foreign key (task_id)
references tasks(id);

alter table scheduled_tasks
add constraint fk_assignee_id
foreign key (assignee_id)
references users(id);

alter table scheduled_tasks
add constraint fk_reviewer_id
foreign key (reviewer_id)
references users(id);

alter table reoccuring_tasks
add constraint fk_reoccuring_task_id
foreign key (task_id)
references tasks(id);