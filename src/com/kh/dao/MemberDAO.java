package com.kh.dao;

import com.kh.util.Common;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public void boardInsert() {
        System.out.println("가입정보를 입력 하세요");
        System.out.print("사원번호(4자리) : ");
        int no = sc.nextInt();
        System.out.print("닉네임 : ");
        String nick = sc.next();
        System.out.print("비밀번호 : ");
        String pw = sc.next();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatedNow = now.format(formatter);
        System.out.print("날짜 : " + formatedNow);

        String sql = "INSERT INTO BOARD(MEMBER_NUM, NICKNAME, PWD, REG_DATE)" +
                "VALUES(?,?,?,?)";
        try{
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            pstmt.setString(2, nick);
            pstmt.setString(3, pw);
            pstmt.setString(4, formatedNow);
            pstmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

}
