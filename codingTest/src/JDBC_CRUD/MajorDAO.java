package JDBC_CRUD;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MajorDAO {
    BufferedReader br;
    BufferedWriter bw;
    private final Connection con;
    private PreparedStatement pstmt;
    String sql;

    public MajorDAO(Connection con) {
        this.con = con;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void majorSelect() throws SQLException, IOException {
        sql = "SELECT * FROM major order by major_num";
        ResultSet rs;
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        bw.write("[학과 목록]\n");
        bw.write("------------------------\n");
        bw.write("     학과         학과코드\n");
        bw.write("------------------------\n");
        while (rs.next()) {
            bw.write(String.format("%-10s %7d\n", rs.getString("major_name"), rs.getInt("major_num")));
        }
        bw.write("------------------------\n");
        bw.flush();
    }

    public void majorInsert() throws IOException {
        try {
            sql = "INSERT INTO major (major_name) VALUES (?)";
            pstmt = con.prepareStatement(sql);
            bw.write("학과이름 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학과정보가 추가되었습니다!\n");
            }
            bw.flush();
        } catch (SQLException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void majorUpdate() throws IOException {
        try {
            sql = "update major set major_name=? where major_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("수정할 학과번호 : ");bw.flush();
            pstmt.setInt(2, Integer.parseInt(br.readLine()));
            bw.write("수정 학과이름 : ");bw.flush();
            pstmt.setString(1, br.readLine());
            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학과정보가 수정되었습니다!\n");
            }else{
                bw.write("수정 실패! 없는 학과번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }

    public void majorDelete() throws IOException {
        try {
            sql = "delete from major where major_num=?";
            pstmt = con.prepareStatement(sql);
            bw.write("삭제할 학과번호 : ");
            bw.flush();
            pstmt.setInt(1, Integer.parseInt(br.readLine()));

            int insertResult = pstmt.executeUpdate();
            if (insertResult != 0) {
                bw.write("학과정보가 삭제되었습니다!\n");
            }else{
                bw.write("삭제 실패! 없는 학과번호입니다!\n");
            }
            bw.flush();
        } catch (SQLException | NumberFormatException e) {
            bw.write("입력 실패! 잘못된 입력!");
            bw.flush();
        }
    }
}
