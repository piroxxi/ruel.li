drop table if exists notes;
create table notes (
    id         varchar(36)  primary key      default (uuid()),
    title      varchar(255) not null,
    body       text,
    read_only  boolean      not null default false
);