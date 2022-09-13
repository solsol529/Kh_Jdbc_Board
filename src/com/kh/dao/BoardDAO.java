package com.kh.dao;

import com.kh.util.Common;
import com.kh.vo.BoardVO;
import com.kh.vo.MemberVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<BoardVO> boardSelect() {
        List<BoardVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM BOARD";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String boardName = rs.getString("BOARD_NAME");
                BoardVO vo = new BoardVO(boardName);
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

    public void boardSelectRst(List<BoardVO> list) {
        for (BoardVO e : list) {
            System.out.print(e.getBoardName() + " ");
            System.out.println();
        }
    }
}
