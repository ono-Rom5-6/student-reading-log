## URL一覧_クラスでの読書記録

- 空白のセルは同上。

| 機能 | URL | コントローラー名 | メソッド名 | フォワード先 | リダイレクト先 | 機能詳細 |
| -------- | ----------------- | -------- | --------- | ----------- | ----------- | ------------------------ |
| ログイン | /login | LoginController | getLogin() | /login | - | ログインフォームを表示する | 
| |  |  | - | - | /home | SpringSecurity でログイン処理を行う |
| ログアウト | /logout | - | - | - | /login | SpringSecurity でログアウト処理を行う |
| ホーム画面 | /home | HomeController | getHome() | /home | - | ホーム画面を表示する |
| 読書メモ検索 | /home/search | HomeController | postHome() | - | /home | 読書メモを検索する |
| パスワード変更 | /change_password | ChangePasswordController | getChangePassword() | /change_password | - | パスワード変更画面を表示する |
| | | | postChangePassword() | - | /../confirm | パスワード変更確認画面を表示する |
| | /../confirm |  | postConfirmChangePassword() | - | /../finish | パスワードを変更する |
| | /../finish |  | getFinishChangePassword() | /../finish | - | パスワード変更完了画面を表示する |
| 読書メモ登録 | /entry_reading_record | ReadingRecordContoroller | getEntryReadingRecord() | /entry_reading_record | - | 読書メモ登録画面を表示する |
| | | | postEntryReadingRedord() | - | /../confirm | 読書メモ登録確認画面を表示する |
| | /../confirm |  | postConfirmEntryReadingRedord() | - | /../finish | 読書メモを登録する |
| | /../finish |  | getFinishEntryReadingRedord() | /../finish | - | パスワード変更完了画面を表示する |
| 読書メモ詳細 | /reading_record_detail |  | getReadingRecordDetail() | /reading_record_detail | - | 読書メモ詳細画面を表示する |
| 読書メモ更新 | /edit_reading_record | ReadingRecordContoroller | getEditReadingRecord() | /edit_reading_record | - | 読書メモ更新画面を表示する |
| | | | postEditReadingRedord() | - | /../confirm | 読書メモ更新確認画面を表示する |
| | /../confirm |  | postConfirmEditReadingRedord() | - | /../finish | 読書メモを更新する |
| | /../finish |  | getFinishEditReadingRedord() | /../finish | - | 読書メモ更新完了画面を表示する |



- 教師アカウント分は省略
