package com.kh.vo;

import java.sql.Date;

public class MemberVO {
    private int memNo;
    private String nickName;
    private String pwd;

    public MemberVO(int memNo, String nickName, String pwd) {
        this.memNo = memNo;
        this.nickName = nickName;
        this.pwd = pwd;
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

}
