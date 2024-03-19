INSERT INTO users (username, password, enabled)
VALUES ('user', '{bcrypt}$2a$10$HYcEAgg9kjuX0GlHMSp33.Rm8j.gWVE.tuYcrBMc4/EnPiI3EtptS', true);
INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
