package com.kh.vo;

import java.sql.Date;

public class WriteVO {
    private String boardName;
    private int number;
    private String title;
    private int memNo;
    private String writing;

    public WriteVO(String boardName, int number, String title, int memNo, String writing) {
        this.boardName = boardName;
        this.number = number;
        this.title = title;
        this.memNo = memNo;
        this.writing = writing;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

}
