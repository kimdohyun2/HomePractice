package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseCancleDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;

    public CourseCancleDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void ccSelect() throws IOException {
        sql = "SELECT cc_num, sub_num, sub_name, stu_num FROM course_cancle join subject using (sub_num) order by sub_num, stu_num";
        ResultSet rs;
        StringBuilder sb = new StringBuilder();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            sb.append("[수강삭제정보 목록]\n");
            sb.append("------------------------------------------------------\n");
            sb.append("삭제번호    과목번호         과목             학번\n");
            sb.append("------------------------------------------------------\n");
            while (rs.next()) {
                sb.append(String.format("  %-9d", rs.getInt("cc_num")));
                sb.append(String.format("  %-11d", rs.getInt("sub_num")));
                sb.append(String.format("%-16s", rs.getString("sub_name")));
                sb.append(String.format("%4d\n", rs.getInt("stu_num")));
            }
            sb.append("------------------------------------------------------\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public void ccDelete() throws IOException {
        try {
            sql = "delete from course_cancle where cc_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("영구삭제할 삭제번호 : ");bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("수강정보가 영구삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e ) {
            bw.write("삭제 실패! 잘못된 입력!\n");
            bw.flush();
        }
    }
}
