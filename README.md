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



## DBテーブル
テーブル名：live

| カラム名 | データ型 | NotNull | キー | 備考 |
| ------------ | ------------- | ------------- | ------------- | ------------- |
| id | int | NOT NULL | 主キー | ID、自動生成 |
| schedule | DATETIME  | NOT NULL || 開催日時 |
| name | VARCHAR(100) | NOT NULL || 行きたいライブの名前 |
| location | VARCHAR(100)  | NOT NULL || 開催施設名 |

