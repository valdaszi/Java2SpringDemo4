CREATE TABLE `users` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `password` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
   `username` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
   `enabled` tinyint(4) NOT NULL DEFAULT '1',
   PRIMARY KEY (`id`),
   UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

CREATE TABLE `roles` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
   `user_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   KEY `FK_role_user` (`user_id`),
   CONSTRAINT `FK_role_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;
