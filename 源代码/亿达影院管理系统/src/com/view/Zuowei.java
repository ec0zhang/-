package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.service.EmployeeModel;
import com.service.SeatModel;

public class Zuowei extends JPanel implements ActionListener {

	SeatModel sm=null;
	// 员工管理
	JPanel jp_zuowei_all;
	JPanel jp_zuowei_chaxun, jp_zuowei_biaoge, jp_zuowei_zengshangai,jp_zuowei_shuliang,jp_zuowei_di;
	JButton jb_zuowei_chaxun, jb_zuowei_zengjia, jb_zuowei_shanchu, jb_zuowei_xiugai;
	JScrollPane jsp_biaoge;
	JTable jt_zuowei_xinxi;
	JTextField jtf_zuowei_chaxun;
	JLabel jl_zuowei_chaxun, jl_zuowei_zuoweirenshu,jl_zuowei_shuliang;
	JPanel jp_jihua_all;

	public Zuowei() {

	}

	public Component Zuowei_main() {
		jp_zuowei_chaxun = new JPanel();
		jp_zuowei_chaxun.setLayout(new FlowLayout());
		jl_zuowei_chaxun = new JLabel("查询：");
		jtf_zuowei_chaxun = new JTextField(10);
		jtf_zuowei_chaxun.setBorder(BorderFactory.createLoweredBevelBorder());
		jb_zuowei_chaxun = new JButton("查询");
		jb_zuowei_chaxun.addActionListener(this);
		jp_zuowei_chaxun.add(jl_zuowei_chaxun);
		jp_zuowei_chaxun.add(jtf_zuowei_chaxun);
		jp_zuowei_chaxun.add(jb_zuowei_chaxun);

		jp_zuowei_biaoge = new JPanel();
//		String sql = "select Employee_Name,Employee_Job,Employee_Phone from Table_Employee where 1=?";
//		String[] paras = {"1"};
		sm = new SeatModel();
		jt_zuowei_xinxi = new JTable(sm);
		jsp_biaoge = new JScrollPane(jt_zuowei_xinxi);
		jp_zuowei_biaoge.add(jsp_biaoge);
		jsp_biaoge = new JScrollPane(jt_zuowei_xinxi);
		jp_zuowei_biaoge.add(jsp_biaoge);
		
		jp_zuowei_zengshangai = new JPanel();
		jp_zuowei_zengshangai.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jb_zuowei_shanchu = new JButton("查看详细信息");
		jb_zuowei_shanchu.addActionListener(this);
		jb_zuowei_xiugai = new JButton("修改");
		jb_zuowei_xiugai.addActionListener(this);
		jp_zuowei_zengshangai.add(jb_zuowei_shanchu);
		jp_zuowei_zengshangai.add(jb_zuowei_xiugai);
		
		jl_zuowei_shuliang = new JLabel("共有**个损坏座位");
		jp_zuowei_shuliang = new JPanel();
		jp_zuowei_shuliang.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_zuowei_shuliang.add(jl_zuowei_shuliang);
		
		jp_zuowei_di = new JPanel();
		jp_zuowei_di.setLayout(new GridLayout(1,2));
		jp_zuowei_di.add(jp_zuowei_shuliang);
		jp_zuowei_di.add(jp_zuowei_zengshangai);
		
		jp_zuowei_all=new JPanel();
		jp_zuowei_all.setLayout(new BorderLayout());
		jp_zuowei_all.add(jp_zuowei_chaxun,BorderLayout.NORTH);
		jp_zuowei_all.add(jp_zuowei_biaoge,BorderLayout.CENTER);
		jp_zuowei_all.add(jp_zuowei_di,BorderLayout.SOUTH);
		
		return jp_zuowei_all;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==jb_zuowei_chaxun)
		{
			String name=this.jtf_zuowei_chaxun.getText();
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat where Seat_ID='"+name+"'";
			 //构建新的模型类，并更新
			 sm=new SeatModel(sql);
			 //更新jtable
			 jt_zuowei_xinxi.setModel(sm);
		}
		if(e.getSource()==jb_zuowei_shanchu)	
		{
			int rowNum = this.jt_zuowei_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			String MovieName=sm.getValueAt(rowNum, 0)+"";
			Zuowei_Xiangxixinxi xx = new Zuowei_Xiangxixinxi(this,"详细信息",true,MovieName);
		}
		if(e.getSource()==jb_zuowei_xiugai)
		{
			int rowNum = this.jt_zuowei_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			
			//显示修改对话框
			new updateSeatDialog(this,"修改",false,sm,rowNum);
			String sql = "select Seat_ID,Seat_Location,Seat_Hall,Seat_Row,Seat_Column,Seat_Useable from Table_Seat";
			sm=new SeatModel(sql);
			 //更新jtable
			 jt_zuowei_xinxi.setModel(sm);
		}
	}
}