package Main;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DAO.DBUtil;

public class DropTable {
    public static void dropTable(String Tname) {
        String drop = "DROP TABLE IF EXISTS " + Tname;
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            PreparedStatement pstmt = con.prepareStatement(drop);
            pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
