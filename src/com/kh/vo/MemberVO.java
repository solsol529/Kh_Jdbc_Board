package com.kh.vo;

import java.sql.Date;

public class MemberVO {
    private int memNo;
    private String nickName;
    private String pwd;
    private String date;

    public MemberVO(int memNo, String nickName, String pwd, Date date) {
        this.memNo = memNo;
        this.nickName = nickName;
        this.pwd = pwd;
        this.date = String.valueOf(date);
    }

    public int getMemNo() {
        return memNo;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
