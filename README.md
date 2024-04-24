## liveメモアプリ
RaiseTech 24年11月度 最終課題Spring Boot RestAPIのCRUDアプリケーション

## 概要
行きたいライブの日付を忘れないようにメモしておけるCRUDアプリです。  
READ・CREATE・UPDATE・DELETE機能を実装予定。  


## 構成要件
* Java 
* Spring Boot 
* MySQL 
* Docker 

## 機能一覧
| 機能 | 詳細 | URL |
| ------------ | ------------- | ------------- |
| 全件取得 | ライブ一覧を返す | /live |
| 新規登録 | 新しいライブを登録する | /live |
| リストの編集 | 指定したidの内容を変更する | /live/{id} |
| 削除 | 指定したidのデータを削除する | /live/{id} |

## DBテーブル
テーブル名：live

| カラム名 | データ型 | NotNull | キー | 備考 |
| ------------ | ------------- | ------------- | ------------- | ------------- |
| id | int | NOT NULL | 主キー | ID、自動生成 |
| schedule | VARCHAR(100)  ||| 開催日時 |
| name | VARCHAR(100) | NOT NULL | ユニーク | 行きたいライブの名前 |
| location | VARCHAR(100)  ||| 開催施設名 |

