/**
 * Created by Hang on 16/4/16.
 */
public class DataForm {
    private int num = 0;
    private double lastYearBill = 0;
    private int minutes = 0;
    private int times = 0;
    private double expectedBill = 0;
    private double actualBill = 0;
    private String result = "error";

    public DataForm() {
        this.num = 0;
        this.lastYearBill = 0;
        this.minutes = 0;
        this.times = 0;
        this.expectedBill = 0;
        this.actualBill = 0;
        this.result = "error";
    }

    public DataForm(int num, double lastYearBill, int minutes, int times, double expectedBill) {
        this.num = num;
        this.lastYearBill = lastYearBill;
        this.minutes = minutes;
        this.times = times;
        this.expectedBill = expectedBill;
    }

    public DataForm(int num, double lastYearBill, int minutes, int times, double expectedBill, double actualBill) {
        this.num = num;
        this.lastYearBill = lastYearBill;
        this.minutes = minutes;
        this.times = times;
        this.expectedBill = expectedBill;
        this.actualBill = actualBill;
        result();
    }

    public void result(){
        if(Math.abs(this.expectedBill - this.actualBill) <= 0.001){
            this.result = "pass";
        }else{
            this.result = "error";
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getLastYearBill() {
        return lastYearBill;
    }

    public void setLastYearBill(double lastYearBill) {
        this.lastYearBill = lastYearBill;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getExpectedBill() {
        return expectedBill;
    }

    public void setExpectedBill(double expectedBill) {
        this.expectedBill = expectedBill;
    }

    public double getActualBill() {
        return actualBill;
    }

    public void setActualBill(double actualBill) {
        this.actualBill = actualBill;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
