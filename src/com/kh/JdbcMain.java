package com.kh;

import com.kh.dao.BoardDAO;
import com.kh.dao.MemberDAO;
import com.kh.dao.WriteDAO;
import com.kh.vo.BoardVO;
import com.kh.vo.MemberVO;
import com.kh.vo.WriteVO;

import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        memSelect();
        boardSelect();
        writeSelect();
    }
    public static void memSelect() {
        Scanner sc = new Scanner(System.in);
        MemberDAO dao = new MemberDAO();
        while(true) {
            System.out.println("===== [회원정보] =====");
            System.out.println("메뉴를 선택 하세요");
            System.out.print("[1]모든회원정보 [2]가입하기 [3]회원정보변경 [4]회원탈퇴 [5]게시판메뉴 : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 :
                    List<MemberVO> list = dao.memberSelect();
                    dao.memSelectRst(list);
                    break;
                case 2 :
                    dao.memberInsert();
                    break;
                case 3 :
                    dao.memUpdate();
                    break;
                case 4 :
                    dao.memDelete();
                case 5 :
                    System.out.println("회원정보가 종료되었습니다.");
                    return;
            }
        }
    }
    public static void boardSelect() {
        Scanner sc = new Scanner(System.in);
        BoardDAO dao = new BoardDAO();
        while(true) {
            System.out.println("===== [게시판] =====");
            System.out.println("메뉴를 선택 하세요");
            System.out.print("[1]게시판목록 [2]게시글메뉴 ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 :
                    List<BoardVO> list = dao.boardSelect();
                    dao.boardSelectRst(list);
                    break;
                case 2 :
                    System.out.println("게시판이 종료되었습니다.");
                    return;
            }
        }
    }
    public static void writeSelect() {
        Scanner sc = new Scanner(System.in);
        WriteDAO dao = new WriteDAO();
        while (true) {
            System.out.print("[1]게시글목록 [2]글쓰기 [3]글수정 [4]글삭제 [5]종료 ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 :
                    List<WriteVO> list = dao.writeSelect();
                    dao.writeSelectRst(list);
                    break;
                case 2 :
                    dao.writeInsert();
                    break;
                case 3 :
                    dao.writeUpdate();
                    break;
                case 4 :
                    dao.writeDelete();
                    break;
                case 5 :
                    System.out.print("게시글이 종료되었습니다.");
                    return;
            }
        }
    }
}