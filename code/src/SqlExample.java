import DAO.AccountDao;
import DAO.ClockOutRecordDao;
import DAO.CompanyDao;
import DIO.Account;
import DIO.ClockOutRecord;
import DIO.Company;
import Main.DatabaseInitializer;

public class SqlExample {
	public void sqlEx() {
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.initializeDatabase();

        AccountDao accountDao = new AccountDao();
        CompanyDao companyDao = new CompanyDao();
        ClockOutRecordDao recordDao = new ClockOutRecordDao();

        Account account = new Account(1, "John Doe", "password123");
        accountDao.insert(account);

        Company company = new Company(101, 1, "Example Corp");
        companyDao.insert(company);

        ClockOutRecord record = new ClockOutRecord(
                101,
                java.time.LocalDate.now(),
                java.time.LocalTime.now(),
                35.6895,
                139.6917,
                "Left work on time"
        );
        recordDao.insert(record);

        // メモ更新
        ClockOutRecord recordMemo = new ClockOutRecord(101, java.time.LocalDate.now(), "Updated memo text");
        recordDao.updateMemo(recordMemo);
    }
}
