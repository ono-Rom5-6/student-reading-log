CREATE TABLE `users` (
  `id` int AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'ID',
  `user` varchar(50) NOT NULL COMMENT 'ログインユーザー名',
  `pass` varchar(255) NOT NULL COMMENT 'ログインパスワード',
  `student_number` int COMMENT '出席番号',
  `name` varchar(50) NOT NULL COMMENT '名前',
  `authority` enum("GENERAL", "ADMIN") NOT NULL COMMENT '管理者権限'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='ユーザー';