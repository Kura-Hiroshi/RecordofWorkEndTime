package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DIO.Company;

public class CompanyDao {
    //成功時及び失敗時にメッセージを返す
    public String insert(Company company) {
        String sql = "INSERT INTO Company (account_id, company_name) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, company.getAccountId());
            pstmt.setString(2, company.getCompanyName());

            pstmt.executeUpdate();
            return "会社名の登録完了";
        } catch (Exception e) {
            e.printStackTrace();
            return """
                    会社名の登録ができませんでした
                    既に登録済みの会社名ではありませんか？
                """;
        }
    }
}
