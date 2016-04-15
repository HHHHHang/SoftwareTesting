/**
 * Created by Hang on 16/4/13.
 */
public class MonthInfo {
    private int BasicCost = 25;//基本月租费用
    private double CostPerMin = 0.15;//每分钟通话费用
    private int minutes = 0;//当月通话分钟数
    private int maxTimes = 0;//最大容许不按时缴费次数
    private double discount = 1;//折扣
//    private double lastYearBill = 0;//去年未缴金额
    private boolean dataError = false;//判断数据是否错误

    //Constructor
    public MonthInfo(){
        this.minutes = 0;
        this.maxTimes = 0;
        this.discount = 1;
//        this.lastYearBill = 0;
        this.dataError = false;
    }

    public MonthInfo(int minutes){
        this.dataError = false;
        this.minutes = minutes;
        calculate();
//        if(minutes >= 0) {
//            this.dataError = false;
//        }else {
//            this.dataError = true;
//        }
    }

    //calculate the current month's discount & maxTime
    public void calculate(){
        if(0 <= this.minutes && this.minutes <= 60){//0~60分钟 折扣1% 次数1次
            this.discount = 1 - 0.01;
            this.maxTimes = 1;
        }else if(60 < this.minutes && this.minutes <= 120){//60~120分钟 折扣1.5% 次数2次
            this.discount = 1 - 0.015;
            this.maxTimes = 2;
        }else if(120 < this.minutes && this.minutes <= 180){//120~180分钟 折扣2.0% 次数3次
            this.discount = 1 - 0.02;
            this.maxTimes = 3;
        }else if(180 < this.minutes && this.minutes <= 300){//180~300分钟 折扣2.5% 次数3次
            this.discount = 1 - 0.025;
            this.maxTimes = 3;
        }else if(this.minutes > 300){//300~ 分钟 折扣3.0% 次数6次
            this.discount = 1 - 0.03;
            this.maxTimes = 6;
        }else{//输入时间不在范围内, 输入信息判断为出错
            this.discount = 1;
            this.maxTimes = 0;
            this.dataError = true;
        }
    }

    public int getBasicCost() {
        return BasicCost;
    }

    public void setBasicCost(int basicCost) {
        BasicCost = basicCost;
    }

    public double getCostPerMin() {
        return CostPerMin;
    }

    public void setCostPerMin(double costPerMin) {
        CostPerMin = costPerMin;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(int maxTimes) {
        this.maxTimes = maxTimes;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isDataError() {
        return dataError;
    }

    public void setDataError(boolean dataError) {
        this.dataError = dataError;
    }
}
