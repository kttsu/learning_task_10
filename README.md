## Musicianメモアプリ
RaiseTech 24年11月度 最終課題Spring Boot RestAPIのCRUDアプリケーション

## 概要
好きなミュージシャンをメモしておけるCRUDアプリです。  
READ・CREATE・UPDATE・DELETE機能を実装予定。  
単体テスト、結合テスト、GitHub ActionsでのCIも実装予定。

## 構成要件
* Java 
* Spring Boot 
* MySQL 
* Docker 

## 機能一覧
| 機能 | 詳細 | URL |
| ------------ | ------------- | ------------- |
| 全件取得 | ドラマ一覧を返す | /musician |
| 絞り込み検索 | priorityカラムの｛A、B、C｝を指定して検索 | /musician?priority=○○ |
| 新規登録 | 新しいタイトルを登録する | /musician |
| リストの編集 | 指定したidの内容を変更する | /musician/{id} |
| 削除 | 指定したidのデータを削除する | /musician/{id} |
