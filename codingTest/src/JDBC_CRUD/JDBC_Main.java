package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ProfessorDAO proDAO;
    static SubjectDAO subDAO;
    static StudentDAO stuDAO;
    static MajorDAO majorDAO;
    static CourseInfoDAO csiDAO;
    static CourseCancleDAO ccDAO;
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/homework";
        String user = "root";
        String password = "0000";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            majorDAO = new MajorDAO(con);
            stuDAO = new StudentDAO(con);
            proDAO = new ProfessorDAO(con);
            subDAO = new SubjectDAO(con);
            csiDAO = new CourseInfoDAO(con);
            ccDAO = new CourseCancleDAO(con);
            loop:
            while (true) {
                bw.write("\n관리 테이블 목록\n");
                bw.write("1.학과 ");
                bw.write("2.학생 ");
                bw.write("3.교수 ");
                bw.write("4.과목 ");
                bw.write("5.수강 ");
                bw.write("6.수강취소 ");
                bw.write("7.종료 ");
                bw.write("\n입력 : ");
                bw.flush();
                String in = br.readLine();
                switch(in){
                    case "1":
                        major_mgmt();
                        break;
                    case "2":
                        stu_mgmt();
                        break;
                    case "3":
                        pro_mgmt();
                        break;
                    case "4":
                        sub_mgmt();
                        break;
                    case "5":
                        csi_mgmt();
                        break;
                    case "6":
                        cc_mgmt();
                        break;
                    case "7":
                        break loop;
                    default:
                        bw.write("잘못된 입력입니다!\n");
                        break;
                }
            }
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void major_mgmt() throws IOException, SQLException {
        loop:
        while (true) {
            majorDAO.majorSelect();
            bw.write("메뉴 1.학과정보추가 2.학과정보수정 3.학과정보삭제 4.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    majorDAO.majorInsert();
                    break;
                case "2":
                    majorDAO.majorUpdate();
                    break;
                case "3":
                    majorDAO.majorDelete();
                    break;
                case "4":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }

    static void stu_mgmt() throws IOException {
        loop:
        while (true) {
            stuDAO.stuSelect();
            bw.write("메뉴 1.학생정보추가 2.학생정보수정 3.학생정보삭제 4.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    stuDAO.stuInsert();
                    break;
                case "2":
                    stuDAO.stuUpdate();
                    break;
                case "3":
                    stuDAO.stuDelete();
                    break;
                case "4":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }

    static void pro_mgmt() throws IOException {
        loop:
        while (true) {
            proDAO.proSelect();
            bw.write("메뉴 1.교수정보추가 2.교수정보수정 3.교수정보삭제 4.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    proDAO.proInsert();
                    break;
                case "2":
                    proDAO.proUpdate();
                    break;
                case "3":
                    proDAO.proDelete();
                    break;
                case "4":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }

    static void sub_mgmt() throws IOException, SQLException {
        loop:
        while (true) {
            subDAO.subSelect();
            bw.write("메뉴 1.과목정보추가 2.과목정보수정 3.과목정보삭제 4.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    subDAO.subInsert();
                    break;
                case "2":
                    subDAO.subUpdate();
                    break;
                case "3":
                    subDAO.subDelete();
                    break;
                case "4":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }

    static void csi_mgmt() throws IOException, SQLException {
        loop:
        while (true) {
            csiDAO.csiSelect();
            bw.write("메뉴 1.수강신청추가 2.수강신청수정 3.수강신청삭제 4.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    csiDAO.csiInsert();
                    break;
                case "2":
                    csiDAO.csiUpdate();
                    break;
                case "3":
                    csiDAO.csiDelete();
                    break;
                case "4":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }

    static void cc_mgmt() throws IOException {
        loop:
        while (true) {
            ccDAO.ccSelect();
            bw.write("메뉴 1.영구삭제 2.뒤로가기");
            bw.write("\n입력 : ");
            bw.flush();
            String in = br.readLine();
            switch(in){
                case "1":
                    ccDAO.ccDelete();
                    break;
                case "2":
                    break loop;
                default:
                    bw.write("잘못된 입력입니다!\n");
                    bw.flush();
                    break;
            }
        }
    }
}