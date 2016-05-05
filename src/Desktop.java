import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Happy on 2016/5/5.
 */
public class Desktop extends JFrame implements ActionListener{

    private JPanel row1 = new JPanel();

    private JPanel row2 = new JPanel();

    private JPanel row3 = new JPanel();

    private JPanel row4 = new JPanel();

    private JPanel row5 = new JPanel();

    private JTextField user_id;

    JLabel got1Label = new JLabel("月租" , JLabel.RIGHT);
    JTextField got1 = new JTextField("0");

    JLabel got2Label = new JLabel("费用/分钟" , JLabel.RIGHT);
    JTextField got2 = new JTextField("0");

    JLabel got3Label = new JLabel("通话时间" , JLabel.RIGHT);
    JTextField got3 = new JTextField("0");

    JLabel got4Label = new JLabel("折扣" , JLabel.RIGHT);
    JTextField got4 = new JTextField("0");

    JLabel got5Label = new JLabel("未按时缴费次数" , JLabel.RIGHT);
    JTextField got5 = new JTextField("0");

    JLabel got6Label = new JLabel("去年未交金额" , JLabel.RIGHT);
    JTextField got6 = new JTextField("0");

    public Desktop (){
        super("话费缴纳系统");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(5, 1, 5, 10);
        setLayout(gridLayout);

        //first row input uer_id
        FlowLayout flowLayout1 = new FlowLayout(FlowLayout.CENTER,0,0);
        row1.setLayout(flowLayout1);
        JLabel id = new JLabel("id : ");
         user_id = new JTextField("      ");
        row1.add(id);
        row1.add(user_id);
        add(row1);

        //submit button
        FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER,0,0);
        row2.setLayout(flowLayout2);
        JButton submit = new JButton("查找");
        submit.addActionListener(this);
        row2.add(submit);
        add(row2);

        //user infomation
        GridLayout info = new GridLayout(2, 3, 20, 10);
        got1.setEnabled(false);
        got2.setEnabled(false);
        got3.setEnabled(false);
        got4.setEnabled(false);
        got5.setEnabled(false);
        got6.setEnabled(false);

        row3.setLayout(info);

        row3.add(got1Label);
        row3.add(got1);
        row3.add(got2Label);
        row3.add(got2);
        row3.add(got3Label);
        row3.add(got3);
        row3.add(got4Label);
        row3.add(got4);
        row3.add(got5Label);
        row3.add(got5);
        row3.add(got6Label);
        row3.add(got6);
        add(row3);

        //money button
        FlowLayout flowLayout4 = new FlowLayout(FlowLayout.CENTER,0,0);
        row5.setLayout(flowLayout4);
        JButton handin = new JButton("支付");
        handin.addActionListener(this);
        row5.add(handin);
        add(row5);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getText().equals("查找")){
               String id =  user_id.getText().trim();
            try{
                List<DataForm> list = new ArrayList<DataForm>();
                list =  readXls.readXls();
                for(int i = 0; i < list.size(); i++){
                    DataForm dataForm = list.get(i);
                    if(String.valueOf(i).equals(id)){
                        got1.setText("25");
                        got2.setText("0.15");
                        got3.setText(String.valueOf(dataForm.getMinutes()));
                   //     got4.setText(String.valueOf(dataForm.get));
                        got5.setText(String.valueOf(dataForm.getTimes()));
                        got6.setText(String.valueOf(dataForm.getLastYearBill()));
                    }
                    double discount = 0;
                    int maxTimes = dataForm.getTimes();
                    int minutes = dataForm.getMinutes();
                    if(0 <= minutes && minutes <= 60){//0~60分钟 折扣1% 次数1次
                        discount = 1 - 0.01;
                    }else if(60 < minutes && minutes <= 120){//60~120分钟 折扣1.5% 次数2次
                        discount = 1 - 0.015;
                    }else if(120 < minutes && minutes <= 180){//120~180分钟 折扣2.0% 次数3次
                        discount = 1 - 0.02;
                    }else if(180 < minutes && minutes <= 300){//180~300分钟 折扣2.5% 次数3次
                        discount = 1 - 0.025;
                    }else if(minutes > 300){//300~ 分钟 折扣3.0% 次数6次
                        discount = 1 - 0.03;
                    }else{//输入时间不在范围内, 输入信息判断为出错
                        discount = 1;
                    }
                    got4.setText(String.valueOf(discount));
                }
            }catch (Exception ex){
                   ex.printStackTrace();
            }

        }else{
               System.out.println("click is 支付");
               JOptionPane.showMessageDialog(this,"支付成功","提示",JOptionPane.WARNING_MESSAGE);
        }
    }
}
