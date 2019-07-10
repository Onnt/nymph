package cn.virde.nymph.datetime;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Suna
 */
public class DateTimeDiff {

    private Date  beginDate;
    private Date  endDate;

    private float diffSeconds;

    private float diffMinutes;

    private float diffHours;

    private float diffDays;

    private float diffMonths;

    private float diffYears;

    public DateTimeDiff(Date beginDate,Date endDate){
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
    public int diffSeconds(){
        return diffSeconds(this.beginDate,this.endDate);
    }
    public static int diffSeconds(Date beginDate, Date endDate){
        return (int) (endDate.getTime() - beginDate.getTime())/1000;
    }
    public int diffMinutes(){
        return diffMinutes(this.beginDate,this.endDate);
    }
    public static int diffMinutes(Date beginDate,Date endDate){
        return diffSeconds(beginDate,endDate)/60;
    }
    public int diffHours(){
        return diffHours(this.beginDate,this.endDate);
    }
    public static int diffHours(Date beginDate,Date endDate){
        return diffMinutes(beginDate,endDate)/60;
    }
    public int diffDays(){
        return diffDays(this.beginDate,this.endDate);
    }
    public static int diffDays(Date beginDate,Date endDate){
        return diffHours(beginDate,endDate)/24;
    }
    public int diffMonths(){
        Calendar begCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        begCal.setTime(beginDate);
        endCal.setTime(endDate);
        int dYears = endCal.get(Calendar.YEAR) - begCal.get(Calendar.YEAR) ;
        int dMonths = endCal.get(Calendar.MONTH) - begCal.get(Calendar.MONTH);
        return dYears * 12 + dMonths;
    }
    public int diffMonths(Date beginDate,Date endDate){
        return 0;
    }
    public int diffYears(){
        return 0;
    }
    public static int diffYears(Date beginDate,Date endDate){
        return 0;
    }
    private int diff(int UNIT){
        return 0;
    }

    public static void main(String[] args) throws ParseException {
        int diff = new DateTimeDiff(DateTime.toDate("2020年1月28日 14:41:16"),DateTime.toDate("2019年3月29日 14:41:26")).diffMinutes();
        System.out.println(diff);
    }
}
