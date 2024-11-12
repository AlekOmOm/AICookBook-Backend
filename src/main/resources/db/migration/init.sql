CREATE DATABASE IF NOT EXISTS aicookbook_db;
CREATE USER 'docker_user'@'%' IDENTIFIED BY 'docker_password';
GRANT ALL PRIVILEGES ON aicookbook_db.* TO 'docker_user'@'%';
FLUSH PRIVILEGES;