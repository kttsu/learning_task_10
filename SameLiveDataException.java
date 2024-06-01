package com.tsuchiya.live;

 // 既存のレコードと同じライブ情報を更新しようとした場合にスローするための例外処理クラス。
public class SameLiveDataException extends RuntimeException {
    public SameLiveDataException(String message) {
        super(message);
    }
}

