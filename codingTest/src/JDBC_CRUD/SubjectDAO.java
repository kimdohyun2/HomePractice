package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;
    ProfessorDAO proDAO;

    public SubjectDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        proDAO = new ProfessorDAO(con);
    }

    public void subSelect() throws IOException {
        sql = "SELECT * FROM subject join professor using (pro_num) order by sub_num";
        ResultSet rs;
        StringBuilder sb = new StringBuilder();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            sb.append("[과목 목록]\n");
            sb.append("---------------------------------------------------------------------------\n");
            sb.append("과목번호       과목명          담당교수(교수번호)       개강일            종강일\n");
            sb.append("---------------------------------------------------------------------------\n");
            while (rs.next()) {
                sb.append(String.format("  %-9d", rs.getInt("sub_num")));
                sb.append(String.format("%-16s", rs.getString("sub_name")));
                sb.append(String.format("%s(%d)", rs.getString("pro_name"), rs.getInt("pro_num")));
                sb.append(String.format("%19s", rs.getString("first_day")));
                sb.append(String.format("%18s\n", rs.getString("last_day")));
            }
            sb.append("---------------------------------------------------------------------------\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public void subInsert() throws IOException {
        try {
            sql = "INSERT INTO subject (sub_name, pro_num, first_day, last_day) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            bw.write("과목명 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            proDAO.proSelect();
            bw.write("담당교수번호 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            bw.write("개강일(yyyy-MM-dd) : ");bw.flush();
            pstmt.setDate(3, java.sql.Date.valueOf(br.readLine()));
            bw.write("종강일(yyyy-MM-dd) : ");bw.flush();
            pstmt.setDate(4, java.sql.Date.valueOf(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("과목 정보가 추가되었습니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
            throw new RuntimeException(e);
        }
    }

    public void subUpdate() throws IOException {
        try {
            sql = "update subject set sub_name=?, pro_num=?, first_day=?, last_day=? where sub_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("수정할 과목번호 : ");bw.flush();
            pstmt.setInt(5, Integer.parseInt(br.readLine()));
            bw.write("수정 과목명 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            proDAO.proSelect();
            bw.write("수정 담당교수번호 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            bw.write("수정 개강일(yyyy-MM-dd) : ");bw.flush();
            pstmt.setDate(3, java.sql.Date.valueOf(br.readLine()));
            bw.write("수정 종강일(yyyy-MM-dd) : ");bw.flush();
            pstmt.setDate(4, java.sql.Date.valueOf(br.readLine()));
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("과목정보가 수정되었습니다!\n");
            }else{
                bw.write("수정 실패! 없는 과목번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void subDelete() throws IOException {
        try {
            sql = "delete from subject where sub_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("삭제할 과목번호 : ");
            bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("과목정보가 삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 과목번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e ) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }
}
