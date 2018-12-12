INSERT INTO `users` (`id`,`password`,`username`,`enabled`) VALUES (1,'$2a$12$TKuxelQEwWxmMGNBeSHwze4SvAKAMeWhIdDtlL88kZMb2olM6.0n2','admin',1);
INSERT INTO `users` (`id`,`password`,`username`,`enabled`) VALUES (2,'$2a$12$HX85a9GF5XISUz1sZlAA6Or/XcwIXo8Y0Q9LLof72cXOZ67UyiKmG','user',1);

INSERT INTO `roles` (`id`,`name`,`user_id`) VALUES (3,'USER',1);
INSERT INTO `roles` (`id`,`name`,`user_id`) VALUES (4,'ADMIN',1);
INSERT INTO `roles` (`id`,`name`,`user_id`) VALUES (5,'USER',2);
