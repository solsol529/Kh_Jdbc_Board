package com.kh.dao;

import com.kh.util.Common;
import com.kh.vo.MemberVO;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<MemberVO> memberSelect() {
        List<MemberVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM MEMBER";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int no = rs.getInt("MEMBER_NUM");
                String nick = rs.getString("NICKNAME");
                String pw = rs.getString("PWD");
                MemberVO vo = new MemberVO(no, nick, pw);
                list.add(vo); //생성 된 객체를 리스트에 저장
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void memberInsert() {
        System.out.println("가입정보를 입력 하세요");
        System.out.print("사원번호(4자리) : ");
        int no = sc.nextInt();
        System.out.print("닉네임 : ");
        String nick = sc.next();
        System.out.print("비밀번호 : ");
        String pw = sc.next();

        String sql = "INSERT INTO BOARD(MEMBER_NUM, NICKNAME, PWD)" +
                "VALUES(?,?,?,?)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            pstmt.setString(2, nick);
            pstmt.setString(3, pw);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void memSelectRst(List<MemberVO> list) {
        for (MemberVO e : list) {
            System.out.print(e.getMemNo() + " ");
            System.out.print(e.getNickName() + " ");
            System.out.print(e.getPwd() + " ");
            System.out.println();
        }
    }

    public void memUpdate() {
        System.out.println("변경할 회원 정보 입력");
        System.out.print("닉네임 : ");
        String nickName = sc.next();
        System.out.print("비밀번호 : ");
        String pwd = sc.next();
        String sql = "UPDATE BOARD SET NICKNAME = ?, PWD = ?";
        try{
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nickName);
            pstmt.setString(2, pwd);
            int ret = pstmt.executeUpdate();
            System.out.print("Return : " + ret);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }

    public void memDelete() {
        System.out.print("삭제 할 닉네임 입력 : ");
        String nickname = sc.next();
        System.out.print("비밀번호 입력 : ");
        String pwd = sc.next();
        String sql = "DELETE FROM BOARD WHERE NICKNAME = ?, PWD = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nickname);
            pstmt.setString(2, pwd);
            int ret = pstmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }
}
