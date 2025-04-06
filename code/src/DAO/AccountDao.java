package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DIO.Account;

public class AccountDao {
    //成功時及び失敗時にそれぞれString型でメッセージを返す。
    public String insert(Account account) {
        String sql = "INSERT INTO Account (name, password) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getPassword());

            pstmt.executeUpdate();
            return "アカウント登録完了";
        } catch (Exception e) {
            e.printStackTrace();
            return "アカウント登録失敗";
        }
    }
}
