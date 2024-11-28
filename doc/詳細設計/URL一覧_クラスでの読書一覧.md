## URL一覧_クラスでの読書記録

- 空白のセルは同上。

| 機能 | URL | コントローラー名 | メソッド名 | view | リダイレクト先 | 機能詳細 |
| -------- | ----------------- | -------- | --------- | ----------- | ----------- | ------------------------ |
| ログイン | /login | LoginController | get() | login | - | ログインフォームを表示する | 
| |  |  | - | - | /home | SpringSecurity でログイン処理を行う |
| ログアウト | /logout | - | - | - | /login | SpringSecurity でログアウト処理を行う |
| ホーム画面 | /home | HomeController | get() | home | - | ホーム画面を表示する |
| 読書メモ検索 | /home/search | | | | - | 読書メモを検索する |
| パスワード変更 | /change-password/index | ChangePasswordController | get() | /change_password/index | - | パスワード変更画面を表示する |
| | | | post() | - | /change-password/confirm | パスワード変更確認画面を表示する |
| | /change-password/confirm |  | postConfirm() | - | /change-password/finish | パスワードを変更する |
| | /change-password/finish |  | getFinish() | /change_password/finish | - | パスワード変更完了画面を表示する |
| 読書メモ登録 | /reading-record/entry/index | ReadingRecordContoroller | getEntry() | /reading_record/entry/index | - | 読書メモ登録画面を表示する |
| | | | postEntry() | - | /reading-record/entry/confirm | 読書メモ登録確認画面を表示する |
| | /reading-record/entry/confirm |  | postEntryConfirm() | - | /reading-record/entry/finish | 読書メモを登録する |
| | /reading_record/entry/finish |  | getEntryFinish() | /reading_record/entry/finish | - | パスワード変更完了画面を表示する |
| 読書メモ詳細 | /reading-record/detail |  | getDetail() | /reading_record/detail | - | 読書メモ詳細画面を表示する |
| 読書メモ更新 | /reading-record/edit/index | ReadingRecordContoroller | getEdit() | /reading_record/edit/index | - | 読書メモ更新画面を表示する |
| | | | postEdit() | - | /reading-record/edit/confirm | 読書メモ更新確認画面を表示する |
| | /reading-record/edit/confirm |  | postEditConfirm() | - | /reading_record/edit/finish | 読書メモを更新する |
| | /reading-record/edit/finish |  | getEditFinish() | /reading_record/edit/finish | - | 読書メモ更新完了画面を表示する |



- 教師アカウント分は省略
