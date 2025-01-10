package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;
    MajorDAO majorDAO;

    public ProfessorDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        majorDAO = new MajorDAO(con);
    }

    public void proSelect() throws IOException {
        sql = "SELECT * FROM professor join major using (major_num) order by pro_num";
        ResultSet rs;
        StringBuilder sb = new StringBuilder();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            sb.append("[교수 목록]\n");
            sb.append("-----------------------------------\n");
            sb.append("교수번호       이름             전공\n");
            sb.append("-----------------------------------\n");
            while (rs.next()) {
                sb.append(String.format("  %-10d", rs.getInt("pro_num")));
                sb.append(String.format("%-10s", rs.getString("pro_name")));
                sb.append(String.format("%8s\n", rs.getString("major_name")));
            }
            sb.append("-----------------------------------\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public void proInsert() throws IOException {
        try {
            majorDAO.majorSelect();
            sql = "INSERT INTO professor (pro_name, major_num) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            bw.write("교수이름 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            bw.write("전공코드 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("교수 정보가 추가되었습니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void proUpdate() throws IOException {
        try {
            majorDAO.majorSelect();
            sql = "update professor set pro_name=?, major_num=? where pro_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("수정할 교수번호 : ");bw.flush();
            pstmt.setInt(3, Integer.parseInt(br.readLine()));
            bw.write("수정 교수이름 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            bw.write("수정 전공코드 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("교수정보가 수정되었습니다!\n");
            }else{
                bw.write("수정 실패! 없는 교수번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void proDelete() throws IOException {
        try {
            sql = "delete from professor where pro_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("삭제할 교수번호 : ");
            bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("교수정보가 삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 교수번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e ) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }
}