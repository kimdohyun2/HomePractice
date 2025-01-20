package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;
    MajorDAO majorDAO;

    public StudentDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        majorDAO = new MajorDAO(con);
    }

    public void stuSelect() throws IOException {
        sql = "SELECT * FROM student join major using (major_num) order by stu_num";
        ResultSet rs;
        StringBuilder sb = new StringBuilder();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            sb.append("[학생 목록]\n");
            sb.append("--------------------------------------------\n");
            sb.append("학번       이름            키         학과\n");
            sb.append("--------------------------------------------\n");
            while (rs.next()) {
                sb.append(String.format(" %-8d", rs.getInt("stu_num")));
                sb.append(String.format("%-12s", rs.getString("stu_name")));
                sb.append(String.format("%-6.2f", rs.getDouble("height")));
                sb.append(String.format("%10s\n", rs.getString("major_name")));
            }
            sb.append("--------------------------------------------\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public void stuInsert() throws IOException {
        try {
            majorDAO.majorSelect();
            sql = "INSERT INTO student (stu_name, height, major_num) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            bw.write("이름 : ");
            bw.flush();
            pstmt.setString(1, br.readLine());
            bw.write("키 : ");
            bw.flush();
            pstmt.setDouble(2, Double.parseDouble(br.readLine()));
            bw.write("학과코드 : ");
            bw.flush();
            pstmt.setInt(3, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학생정보가 추가되었습니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void stuUpdate() throws IOException {
        try {
            majorDAO.majorSelect();
            sql = "update student set stu_name=?, height=?, major_num=? where stu_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("수정할 학생번호 : ");
            bw.flush();
            pstmt.setInt(4, Integer.parseInt(br.readLine()));
            bw.write("수정 이름 : ");
            bw.flush();
            pstmt.setString(1, br.readLine());
            bw.write("수정 키 : ");
            bw.flush();
            pstmt.setDouble(2, Double.parseDouble(br.readLine()));
            bw.write("수정 학과코드 : ");
            bw.flush();
            pstmt.setInt(3, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학생정보가 수정되었습니다!\n");
            }else{
                bw.write("수정 실패! 없는 학번입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void stuDelete() throws IOException {
        try {
            sql = "delete from student where stu_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("삭제할 학생번호 : ");
            bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학생정보가 삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 학번입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }
}