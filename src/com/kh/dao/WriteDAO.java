package com.kh.dao;

import com.kh.util.Common;
import com.kh.vo.BoardVO;
import com.kh.vo.MemberVO;
import com.kh.vo.WriteVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WriteDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<WriteVO> writeSelect() {
        List<WriteVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM WRITE";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String boardName = rs.getString("BOARD_NAME");
                int number = rs.getInt("WRITE_NUM");
                String title = rs.getString("WRITE_NAME");
                int memNo = rs.getInt("MEMBER_NUM");
                String writing = rs.getString("WRITE_CONTENTS");
                WriteVO vo = new WriteVO(boardName, number, title, memNo, writing);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void writeSelectRst(List<WriteVO> list) {
        for (WriteVO e : list) {
            System.out.print(e.getBoardName() + " ");
            System.out.print(e.getNumber() + " ");
            System.out.print(e.getTitle() + " ");
            System.out.print(e.getMemNo() + " ");
            System.out.print(e.getWriting() + " ");
            System.out.println();
        }
    }

    public void writeInsert() {
        System.out.println("글쓰기");
        System.out.print("게시판이름 : ");
        String boardName = sc.next();
        System.out.print("글번호 : ");
        int number = sc.nextInt();
        System.out.print("제목 : ");
        String title = sc.next();
        System.out.print("회원번호 : ");
        int memNo = sc.nextInt();
        System.out.print("글내용 : ");
        String writing = sc.next();

        String sql = "INSERT INTO WRITE(BOARD_NAME, WRITE_NUM, WRITE_NAME, MEMBER_NUM, WRITE_CONTENTS)" +
                "VALUES(?,?,?,?,?)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardName);
            pstmt.setInt(2, number);
            pstmt.setString(3, title);
            pstmt.setInt(4, memNo);
            pstmt.setString(5, writing);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void writeUpdate() {
        System.out.println("변경할 글정보 입력");
        System.out.print("회원번호 : ");
        int memNo = sc.nextInt();
        System.out.print("게시판 : ");
        String boardName = sc.next();
        System.out.print("글제목 : ");
        String title = sc.next();
        System.out.print("글내용 : ");
        String writing = sc.next();
        String sql = "UPDATE WRITE SET MEMBER_NUM = ?, BOARD_NAME = ?, WRITE_NAME = ?, WRITE_CONTENTS = ?";
        try{
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memNo);
            pstmt.setString(2, boardName);
            pstmt.setString(3, title);
            pstmt.setString(4, writing);
            int ret = pstmt.executeUpdate();
            System.out.print("Return : " + ret);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void writeDelete() {
        System.out.print("삭제 할 글번호 입력 : ");
        int number = sc.nextInt();
        System.out.print("비밀번호 입력 : ");
        String pwd = sc.next();
        String sql = "DELETE FROM BOARD WHERE WRITE_NUM = ?, PWD = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            pstmt.setString(2, pwd);
            int ret = pstmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }
}
