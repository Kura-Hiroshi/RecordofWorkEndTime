import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import DAO.ClockOutRecordDao;
import DIO.ClockOutRecord;

class SampleTest {

//	@Test
//	void test() {
//		fail("まだ実装されていません");
//	}

//	@Test
//	void test0(){
//		Account account = new Account("tanaka","asie93id99");
//		AccountDao accountDao = new AccountDao();
//		accountDao.insert(account);
//	}
//
//	@Test
//	void test1(){
//		Company company = new Company(1,"山田工場");
//		CompanyDao companyDao = new CompanyDao();
//		String msg = companyDao.insert(company);
//		System.out.println(msg);
//		
//	}

	@Test
	void test2(){
		ClockOutRecord cor = new ClockOutRecord(1,LocalDate.now(),LocalTime.now(),123.2342,123.2423,null);
		ClockOutRecordDao corDao = new ClockOutRecordDao();
		String msg = corDao.insert(cor);
		System.out.println(msg);
		
	}
	
	@Test
	void test3(){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
		LocalDate date = LocalDate.parse("2025年03月31日", dateFormatter);
		ClockOutRecord cor = new ClockOutRecord(1,date,"A社との会合");
		ClockOutRecordDao corDao = new ClockOutRecordDao();
		String msg = corDao.updateMemo(cor);
		System.out.println(msg);
		
	}

	

}
