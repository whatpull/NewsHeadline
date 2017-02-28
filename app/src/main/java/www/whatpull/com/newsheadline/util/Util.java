package www.whatpull.com.newsheadline.util;

import android.graphics.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 공통 유틸
 * Created by yeonsu on 2017-02-28.
 */
public class Util {

    /**
     * 랜덤색상 획득
     * @return Color 랜덤색상 결과
     */
    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    /**
     * 현제 포맷의 날짜 텍스트를 다른 포맷으로 변경한다.
     * @param date 현재날짜 텍스트
     * @param format 현재날짜 포맷
     * @return 변경포맷 결과
     */
    public static String getReformDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date currentDate = null;
        try {
            currentDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat reForm = new SimpleDateFormat("yyyy-MM-dd hh:mm aa");
        return reForm.format(currentDate);
    }
}
