package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseInfoDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;
    SubjectDAO subDAO;

    public CourseInfoDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        subDAO = new SubjectDAO(con);
    }

    public void csiSelect() throws IOException {
        sql = "SELECT sub_num, sub_name, pro_name, stu_num FROM courseinfo join subject using (sub_num) join professor using (pro_num) order by sub_num, stu_num";
        ResultSet rs;
        StringBuilder sb = new StringBuilder();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            sb.append("[수강신청 목록]\n");
            sb.append("----------------------------------------------------\n");
            sb.append("과목번호       과목             담당교수        학번\n");
            sb.append("----------------------------------------------------\n");
            while (rs.next()) {
                sb.append(String.format("  %-9d", rs.getInt(1)));
                sb.append(String.format("%-16s", rs.getString(2)));
                sb.append(String.format("%-7s", rs.getString(3)));
                sb.append(String.format("%6d\n", rs.getInt(4)));
            }
            sb.append("-----------------------------------------------------\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public void csiInsert() throws IOException {
        try {
            subDAO.subSelect();
            sql = "INSERT INTO courseInfo (stu_num, sub_num) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            bw.write("과목번호 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            bw.write("학번 : ");bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("수강신청 성공하였습니다!\n");
            }
            bw.flush();
        } catch (SQLException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
            throw new RuntimeException(e);
        }
    }

    public void csiUpdate() throws IOException {
        try {
            sql = "update courseInfo set stu_num=?, sub_num=? where stu_num=? and sub_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("수정할 수강정보의 과목번호와 학번을 입력\n과목번호 : ");bw.flush();
            pstmt.setInt(4, Integer.parseInt(br.readLine()));
            bw.write("학번 : ");bw.flush();
            pstmt.setInt(3, Integer.parseInt(br.readLine()));
            bw.write("수정 과목번호 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            bw.write("수정 학번 : ");bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("수강정보가 수정되었습니다!\n");
            }else{
                bw.write("수정 실패!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("수정 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void csiDelete() throws IOException {
        try {
            sql = "delete from courseInfo where sub_num=? and stu_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("삭제할 수강정보의 과목번호와 학번을 입력\n과목번호 : ");bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));
            bw.write("학번 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("수업정보가 삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 수업번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e ) {
            bw.write("삭제 실패! 잘못된 입력!\n");
            bw.flush();
        }
    }
}
