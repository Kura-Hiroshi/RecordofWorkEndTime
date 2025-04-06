package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import DIO.ClockOutRecord;

public class ClockOutRecordDao {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H時m分s秒");

    public String insert(ClockOutRecord record) {

        String dateStr = record.getDate().format(dateFormatter);
        String timeStr = record.getTime().format(timeFormatter);


        String sql = """
            INSERT INTO ClockOutRecord (
                company_id, date, time, latitude, longitude, memo
            ) VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, record.getCompanyId());
            pstmt.setString(2, dateStr);
            pstmt.setString(3, timeStr);
            if (record.getLatitude() != null) {
                pstmt.setDouble(4, record.getLatitude());
            } else {
                pstmt.setNull(4, java.sql.Types.DOUBLE);
            }
            if (record.getLongitude() != null) {
                pstmt.setDouble(5, record.getLongitude());
            } else {
                pstmt.setNull(5, java.sql.Types.DOUBLE);
            }
            pstmt.setString(6, record.getMemo());

            pstmt.executeUpdate();
            return "本日の退勤時刻を登録しました。お疲れさまでした。";
        } catch (Exception e) {
            e.printStackTrace();
            return "本日は既に退勤時刻を登録しています。";
        }
    }

    public String updateMemo(ClockOutRecord record) {
        String dateStr = record.getDate().format(dateFormatter);
        String sql = "UPDATE ClockOutRecord SET memo = ? WHERE company_id = ? AND date = ?";
        
        //現在日より7日以上前の場合、登録させない。
        if (ChronoUnit.DAYS.between(record.getDate(),LocalDate.now()) >=7) {
            return "7日以上前の記録のメモは更新できません。";
        }

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, record.getMemo());
            pstmt.setInt(2, record.getCompanyId());
            pstmt.setString(3, dateStr);
            
            pstmt.executeUpdate();

            return "メモを登録しました";
        } catch (Exception e) {
            e.printStackTrace();
            return "メモの登録に失敗しました";
        }
    }
}
