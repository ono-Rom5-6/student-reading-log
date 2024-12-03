insert into `users` (
    `user`,
    `pass`,
    `student_number`,
    `name`,
    `authority`
)
values
(
    'test1',
    '$2y$10$eSePpwz2hteTQZNXO1BvFeI.VCSGF/YqGdpZda/sHQDQWzAJoehYi', -- パスワード test1
    '1',
    '秋田太郎',
    'GENERAL'
),
(
    'test2',
    '$2y$10$btIzYtozzeEJ2J53ZU/Qz.YBK61RilXtGcVJkrZfz1r/fS8R72F.i', -- パスワード test2
    '2',
    '大阪一郎',
    'GENERAL'
),
(
    'test2teacher',
    '$2y$10$btIzYtozzeEJ2J53ZU/Qz.YBK61RilXtGcVJkrZfz1r/fS8R72F.i', -- パスワード test2
    null,
    '福岡花子',
    'ADMIN'
);
