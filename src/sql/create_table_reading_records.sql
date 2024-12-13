CREATE TABLE `reading_records` (
  `id` int AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'ID',
  `user_id` int NOT NULL COMMENT 'ユーザーID',
  `title` varchar(100) NOT NULL COMMENT '書名',
  `author` varchar(50) COMMENT '著者名',
  `starting_date` date COMMENT '読書開始日',
  `finished_date` date COMMENT '読了日',
  `memos` varchar(3000) COMMENT '読書メモ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='読書記録';
