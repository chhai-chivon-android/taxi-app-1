INSERT INTO roles (id, role_name, description) VALUES (1, 'CLIENT', 'Standard User - client of the app');
INSERT INTO roles (id, role_name, description) VALUES (2, 'DRIVER', 'Driver User - Taxi driver working for the company');

INSERT INTO users (id, password_hash, username) VALUES (1, '$2a$04$x9WzzWtubsvXXfAkodtVC.SPP0vb2qjjQHpYFOIQdqDNeQXuCbvbG', 'lukigostek.client1');
INSERT INTO users (id, password_hash, username) VALUES (2, '$2a$04$x9WzzWtubsvXXfAkodtVC.SPP0vb2qjjQHpYFOIQdqDNeQXuCbvbG', 'lukigostek.client2');
INSERT INTO users (id, password_hash, username) VALUES (3, '$2a$04$x9WzzWtubsvXXfAkodtVC.SPP0vb2qjjQHpYFOIQdqDNeQXuCbvbG', 'lukigostek.client3');
INSERT INTO users (id, password_hash, username) VALUES (4, '$2a$04$x9WzzWtubsvXXfAkodtVC.SPP0vb2qjjQHpYFOIQdqDNeQXuCbvbG', 'lukigostek.client4');
INSERT INTO users (id, password_hash, username) VALUES (5, '$2a$04$x9WzzWtubsvXXfAkodtVC.SPP0vb2qjjQHpYFOIQdqDNeQXuCbvbG', 'lukigostek.client5');
INSERT INTO users (id, password_hash, username) VALUES (6, '$2a$04$YqyKSDoA2HNsmkdJ.eBoWufF2IsWsDN0xjBJ/faPpHCAzVOdJsRMe', 'lukigostek.driver1');
INSERT INTO users (id, password_hash, username) VALUES (7, '$2a$04$YqyKSDoA2HNsmkdJ.eBoWufF2IsWsDN0xjBJ/faPpHCAzVOdJsRMe', 'lukigostek.driver2');
INSERT INTO users (id, password_hash, username) VALUES (8, '$2a$04$YqyKSDoA2HNsmkdJ.eBoWufF2IsWsDN0xjBJ/faPpHCAzVOdJsRMe', 'lukigostek.driver3');
INSERT INTO users (id, password_hash, username) VALUES (9, '$2a$04$YqyKSDoA2HNsmkdJ.eBoWufF2IsWsDN0xjBJ/faPpHCAzVOdJsRMe', 'lukigostek.driver4');
INSERT INTO users (id, password_hash, username) VALUES (10, '$2a$04$YqyKSDoA2HNsmkdJ.eBoWufF2IsWsDN0xjBJ/faPpHCAzVOdJsRMe', 'lukigostek.driver5');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(3,1);
INSERT INTO user_role(user_id, role_id) VALUES(4,1);
INSERT INTO user_role(user_id, role_id) VALUES(5,1);
INSERT INTO user_role(user_id, role_id) VALUES(6,2);
INSERT INTO user_role(user_id, role_id) VALUES(7,2);
INSERT INTO user_role(user_id, role_id) VALUES(8,2);
INSERT INTO user_role(user_id, role_id) VALUES(9,2);
INSERT INTO user_role(user_id, role_id) VALUES(10,2);