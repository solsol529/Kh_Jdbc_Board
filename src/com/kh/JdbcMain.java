package com.kh;

import com.kh.dao.MemberDAO;

import java.util.Scanner;

public class JdbcMain {
    public static void main(String[] args) {

    }
    public static void menuSelect() {
        Scanner sc = new Scanner(System.in);
        MemberDAO dao = new MemberDAO();
        while(true) {
            System.out.println("===== [게시판] =====");
            System.out.println("메뉴를 조회 하세요");
            System.out.print("[1]회원검색, [2]가입하기, [3]게시판 : ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1 :
                    List<MemberVO> list = dao

            }
        }
    }
}
