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
| 全件取得 | ミュージシャン一覧を返す | /musician |
| 絞り込み検索 | priorityカラムの｛A、B、C｝を指定して検索 | /musician?priority=○○ |
| 新規登録 | 新しいミュージシャンを登録する | /musician |
| リストの編集 | 指定したidの内容を変更する | /musician/{id} |
| 削除 | 指定したidのデータを削除する | /musician/{id} |

## DBテーブル
テーブル名：musician

| カラム名 | データ型 | NotNull | キー | 備考 |
| ------------ | ------------- | ------------- | ------------- | ------------- |
| id | int | NOT NULL | 主キー | ID、自動生成 |
| name| VARCHAR(100) | NOT NULL | ユニーク | 見たいミュージシャンの名前 |
| role | VARCHAR(100)  ||| 役割 |
| priority | VARCHAR(1) | NOT NULL || A>B>Cの順で優先順位が高いとする |

