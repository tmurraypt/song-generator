--liquibase formatted sql
--changeset tmurray:20220926163000
--comment: dropping user table
DROP TABLE if exists user_profile;