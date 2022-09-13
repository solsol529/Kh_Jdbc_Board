package com.kh;

import com.kh.dao.MemberDAO;
import com.kh.vo.MemberVO;

import java.util.List;
import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {
        menuSelect();
    }
    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        MemberDAO dao = new MemberDAO();
        while(true) {
            System.out.println("===== [게시판] =====");
            System.out.println("메뉴를 조회 하세요");
            System.out.print("[1]모든회원정보 [2]가입하기 [3]회원정보변경 [4]회원탈퇴 [5]게시판종료 : ");
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
                    System.out.println("게시판이 종료 되었습니다.");
                    return;
            }
        }

    }
}
