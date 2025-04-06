package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//テーブルを作成するためのメソッドを書いたクラス
//Databaseがなければ、自動的に作成する。
public class DatabaseInitializer {

    private static final String JDBC_URL = "jdbc:h2:./testdb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public void initializeDatabase() {
        DropTable.dropTable("ClockOutRecord");
        DropTable.dropTable("Company");
        DropTable.dropTable("Account");


        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // アカウントテーブル作成
            String createAccountTable = """
                CREATE TABLE Account (
                    account_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(30) NOT NULL,
                    password VARCHAR(20) NOT NULL CHECK (
                        LENGTH(password) >= 8 AND password ~ '^[a-zA-Z0-9]+$'
                    )
                )
                """;
            stmt.executeUpdate(createAccountTable);

            // 会社テーブル作成
            String createCompanyTable = """
                CREATE TABLE Company (
                    company_id INT AUTO_INCREMENT PRIMARY KEY,
                    account_id INT NOT NULL,
                    company_name VARCHAR(30) NOT NULL,
                    UNIQUE(account_id, company_name),
                    FOREIGN KEY (account_id) REFERENCES Account(account_id)
                )
                """;
            stmt.executeUpdate(createCompanyTable);

            // 退勤時刻記録テーブル作成
            String createClockOutRecordTable = """
                CREATE TABLE ClockOutRecord (
                    company_id INT NOT NULL,
                    date CHAR(11) NOT NULL,
                    time CHAR(11) NOT NULL,
                    latitude DOUBLE,
                    longitude DOUBLE,
                    memo VARCHAR(100),
                    PRIMARY KEY (company_id, date),
                    FOREIGN KEY (company_id) REFERENCES Company(company_id)
                )
                """;
            stmt.executeUpdate(createClockOutRecordTable);

            System.out.println("Database tables created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getJdbcUrl() {
        return JDBC_URL;
    }
}
