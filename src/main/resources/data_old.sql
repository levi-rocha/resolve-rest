INSERT INTO permissions (id, name) VALUES (1,'standard'),(2,'pro'),(3,'admin');
INSERT INTO users (id, email, password, username, permission_id) VALUES (4,'fulano@online.com','202cb962ac59075b964b07152d234b70','fulano',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (5,'beltrano@online.com','202cb962ac59075b964b07152d234b70','beltrano',2);
INSERT INTO users (id, email, password, username, permission_id) VALUES (6,'admin@online.com','202cb962ac59075b964b07152d234b70','admin',3);
INSERT INTO users (id, email, password, username, permission_id) VALUES (38,'fulano2@online.com','202cb962ac59075b964b07152d234b70','Nao sou um bot',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (39,'fulano3@online.com','202cb962ac59075b964b07152d234b70','Jo Soares, sua v****',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (40,'fulano4@online.com','202cb962ac59075b964b07152d234b70','Freddie',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (41,'fulano5@online.com','202cb962ac59075b964b07152d234b70','ジョセフ・ジョースター',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (42,'fulano6@online.com','202cb962ac59075b964b07152d234b70','Sandy',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (43,'fulano7@online.com','202cb962ac59075b964b07152d234b70','Junior',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (44,'fulano8@online.com','202cb962ac59075b964b07152d234b70','Sakura',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (45,'fulano9@online.com','202cb962ac59075b964b07152d234b70','Samuel Silva',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (46,'fulano10@online.com','202cb962ac59075b964b07152d234b70','R.I.P. Probex',1);
INSERT INTO users (id, email, password, username, permission_id) VALUES (47,'fulano11@online.com','202cb962ac59075b964b07152d234b70','Menino do cachorro',1);
INSERT INTO posts (id, content, date, title, author_id) VALUES (7,'dolor sit amet, consectetur adipiscing elit. Sed facilisis porta mi, nec bibendum sapien blandit vel. Ut placerat massa eu dolor imperdiet, in rutrum odio egestas. Cras mollis eros varius, lobortis quam sit amet, dictum lacus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec cursus quis enim nec semper. Sed auctor porta pretium. Fusce egestas semper turpis vel porta. Nulla vulputate ligula in fermentum tincidunt. Sed vel quam gravida, aliquet odio et, semper risus. Aliquam eu purus suscipit, congue ipsum et, porttitor quam. Aenean ante est, consequat eu luctus quis, tincidunt nec mi. Duis imperdiet metus id velit aliquam, ut imperdiet dolor elementum.',now(),'Lorem ipsum',4);
INSERT INTO votes (user_id, post_id) VALUES (6, 7);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (8,'voce tem razao!!!',now(),6,7);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (9,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,7);
INSERT INTO reports (id, description, author_id, post_id) VALUES (10,'nao gostei',4,7);
INSERT INTO posts (id, content, date, title, author_id) VALUES (11,'vel ornare elit finibus id.',now(),'Duis luctus orci nibh',6);
INSERT INTO posts (id, content, date, title, author_id) VALUES (12,'Phasellus commodo tempor erat ac mollis. Fusce id dolor a augue varius porta lobortis ut diam. Pellentesque volutpat id mauris consequat mollis. Vivamus in metus in est gravida semper. Curabitur accumsan et turpis eget posuere. Maecenas nunc dolor, sodales vitae risus sed, malesuada tempor quam. In hac habitasse platea dictumst. Mauris semper feugiat interdum.',now(),'Donec non justo a mi luctus pulvinar',4);
INSERT INTO posts (id, content, date, title, author_id) VALUES (13,'Samuel Silva, Samuel Silva, Samuel Silva. Samuel Silva, Samuel Silva. Samuel Silva, Samuel Silva, Samuel Silva. Samuel Silva, Samuel Silva, Samuel Silva. Samuel Silva, Samuel Silva. Samuel Silva, Samuel Silva, Samuel Silva.',now(),'Samuel Silva',45);
INSERT INTO votes (user_id, post_id) VALUES (5, 7);
INSERT INTO votes (user_id, post_id) VALUES (4, 7);
INSERT INTO votes (user_id, post_id) VALUES (5, 11);
INSERT INTO votes (user_id, post_id) VALUES (4, 13);
INSERT INTO votes (user_id, post_id) VALUES (5, 13);
INSERT INTO reports (id, description, author_id, post_id) VALUES (14,'Que cachorro o que, eu nao sou cachorro nao!',47,12);
INSERT INTO posts (id, content, date, title, author_id) VALUES (16,'✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿',now(),'✿✿✿✿✿✿✿',6);
INSERT INTO posts (id, content, date, title, author_id) VALUES (17,'♪ ♩ ♫ ♬ ♯',now(),'♫ ♬',5);
INSERT INTO posts (id, content, date, title, author_id) VALUES (19,'159265358979323 8462643383279 50288419716939937510582097494459230781640628620 8998628034825342 11706798214808 65132823066470938446 09550582231725359408128481 11745028410 27019385211055596446 229489549 303819644288109 75665933446128 47564823378 678316527120190914564 8566923460 3486104543266482133936072602491412737',now(),'3.14',6);
INSERT INTO posts (id, content, date, title, author_id) VALUES (20,'Is this just fantasy?',now(),'Is this the real life?',40);
INSERT INTO users (id, email, password, username, permission_id) VALUES (66,'capeta@online.com','202cb962ac59075b964b07152d234b70','Capeta',2);
INSERT INTO posts (id, content, date, title, author_id) VALUES (67,'Drogas e alcool',now(),'666',66);
INSERT INTO votes (user_id, post_id) VALUES (66, 67);
INSERT INTO posts (id, content, date, title, author_id) VALUES (15,'̿̿ ̿̿ ̿̿ ̿''̿''\̵͇̿̿\З= ( ▀ ͜͞ʖ▀) =Ε/̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿',now(),'( ͡° ͜ʖ ͡°)',6);
INSERT INTO posts (id, content, date, title, author_id) VALUES (21,'Wololo',now(),'Wololo',39);
INSERT INTO posts (id, content, date, title, author_id) VALUES (22,'Vem brincar comigo',now(),'Dig dig joy dig joy popoy',42);
INSERT INTO posts (id, content, date, title, author_id) VALUES (23,'目覚めるその柱たち 時を越え',now(),'静寂(しじま)の底から',41);
INSERT INTO posts (id, content, date, title, author_id) VALUES (18,'Eu... eu sou sinistro Melhor que seu marido Esculacho seu amigo No escuro eu sou um perigo...',now(),'Digdin digdin digdin',44);
INSERT INTO posts (id, content, date, title, author_id) VALUES (24,'Sed eu semper justo. Duis iaculis non ex in euismod. Nam gravida ipsum vitae urna malesuada euismod. Ut a ipsum semper, scelerisque ante sed, faucibus massa. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In nec nibh enim. Donec id venenatis elit?',now(),'Vestibulum est nibh, blandit sed commodo tincidunt, egestas quis turpis!',38);
INSERT INTO posts (id, content, date, title, author_id) VALUES (25,'Pellentesque quis orci quis sem finibus suscipit. Nunc laoreet, ante a posuere scelerisque, nisi ex convallis augue, id dictum neque mauris vitae lectus. Nunc mauris felis, porta non congue et, varius at mauris. Praesent facilisis massa in dolor vehicula, sed aliquet massa cursus. Vestibulum quis elementum lectus. Sed dignissim ante eget porta molestie. Nunc at interdum orci. Phasellus molestie augue ut condimentum feugiat. Mauris quis augue ut nisl tempus finibus eget blandit justo. Nam porta dolor sit amet nisi consequat, a vehicula quam rutrum. Maecenas felis augue, auctor quis nisi eget, faucibus tristique lacus. Maecenas est risus, pretium vel volutpat vitae, venenatis non diam. Sed non feugiat massa. Mauris a est euismod, tincidunt leo ut, tempor nulla.',now(),'Nullam sed sagittis felis.',38);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (26,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,15);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (27,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,16);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (28,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,17);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (29,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,18);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (30,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,19);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (31,'resolvido. confira solucao no link: http://pudim.com.br',now(),5,13);
INSERT INTO solutions (id, content, date, author_id, post_id) VALUES (32,'Caught in a landslide, no escape from reality',now(),5,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (33,'Open your eyes, look up to the skies and see',now(),4,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (34,'I''m just a poor boy, I need no sympathy',now(),6,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (35,'Because I''m easy come, easy go',now(),5,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (36,'little high, little low',now(),4,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (37,'Any way the wind blows doesn''t really matter to me, to me',now(),6,20);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (48,'Dig dig joy dig joy popoy',now(),42,22);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (49,'Vem ser meu amigo',now(),42,22);
INSERT INTO votes (user_id, post_id) VALUES (5, 15);
INSERT INTO votes (user_id, post_id) VALUES (4, 15);
INSERT INTO votes (user_id, post_id) VALUES (5, 17);
INSERT INTO votes (user_id, post_id) VALUES (4, 18);
INSERT INTO votes (user_id, post_id) VALUES (5, 18);
INSERT INTO votes (user_id, post_id) VALUES (5, 21);
INSERT INTO votes (user_id, post_id) VALUES (4, 22);
INSERT INTO votes (user_id, post_id) VALUES (5, 23);
INSERT INTO votes (user_id, post_id) VALUES (4, 24);
INSERT INTO votes (user_id, post_id) VALUES (5, 16);
INSERT INTO votes (user_id, post_id) VALUES (4, 20);
INSERT INTO votes (user_id, post_id) VALUES (5, 20);
INSERT INTO votes (user_id, post_id) VALUES (6, 20);
INSERT INTO votes (user_id, post_id) VALUES (38, 20);
INSERT INTO votes (user_id, post_id) VALUES (39, 20);
INSERT INTO votes (user_id, post_id) VALUES (40, 20);
INSERT INTO votes (user_id, post_id) VALUES (41, 20);
INSERT INTO votes (user_id, post_id) VALUES (42, 20);
INSERT INTO votes (user_id, post_id) VALUES (43, 20);
INSERT INTO votes (user_id, post_id) VALUES (44, 20);
INSERT INTO votes (user_id, post_id) VALUES (45, 20);
INSERT INTO votes (user_id, post_id) VALUES (46, 20);
INSERT INTO votes (user_id, post_id) VALUES (47, 20);
INSERT INTO votes (user_id, post_id) VALUES (38, 23);
INSERT INTO votes (user_id, post_id) VALUES (39, 19);
INSERT INTO votes (user_id, post_id) VALUES (40, 21);
INSERT INTO votes (user_id, post_id) VALUES (41, 22);
INSERT INTO votes (user_id, post_id) VALUES (42, 23);
INSERT INTO votes (user_id, post_id) VALUES (43, 24);
INSERT INTO votes (user_id, post_id) VALUES (44, 19);
INSERT INTO votes (user_id, post_id) VALUES (45, 23);
INSERT INTO votes (user_id, post_id) VALUES (46, 24);
INSERT INTO votes (user_id, post_id) VALUES (47, 23);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (50,'Beep boop',now(),38,15);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (51,'Beep boop',now(),38,16);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (52,'Beep boop',now(),38,17);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (53,'Beep boop',now(),38,18);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (54,'Beep boop',now(),38,19);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (55,'Beep boop',now(),38,21);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (56,'Beep boop',now(),38,22);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (57,'Beep boop',now(),38,23);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (58,'Beep boop',now(),38,24);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (59,'Beep boop',now(),38,25);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (60,'Beep boop',now(),38,25);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (61,'Beep boop',now(),38,24);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (62,'Beep boop',now(),38,23);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (63,'Beep boop',now(),38,22);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (64,'Beep boop',now(),38,21);
INSERT INTO comments (id, content, date, author_id, post_id) VALUES (65,'Beep boop',now(),38,15);