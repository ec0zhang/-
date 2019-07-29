package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.SqlHelper;
import com.service.MovieModel;
import com.service.ScheduleModel;

public class Jihua extends JPanel implements ActionListener{

	ScheduleModel smm=null;
	//放映计划
		JPanel jp_jihua_chaxun, jp_jihua_biaoge, jp_jihua_zengshangai;
		JButton jb_jihua_chaxun, jb_jihua_zengjia, jb_jihua_shanchu, jb_jihua_xiugai;
		JScrollPane jsp_jihua_biaoge;
		JTable jt_jihua_xinxi;
		JTextField jtf_jihua_chaxun;
		JLabel jl_jihua_chaxun;
		JLabel jl_jihua_month,jl_jihua_day;
		JComboBox jcb_jihua_month,jcb_jihua_day;
	
	public Jihua()
	{
		
	}
	
	public Component Jihua_chaxun()
	{
		jp_jihua_chaxun = new JPanel();
		jp_jihua_biaoge = new JPanel();
		jp_jihua_zengshangai = new JPanel();
		jl_jihua_chaxun = new JLabel("查询：");
		jl_jihua_month = new JLabel("月份");
		String[] month = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		jl_jihua_day = new JLabel("日期");
		String[] day = {"一号","二号","三号","四号","五号","六号","七号","八号","九号","十号","十一号","十二号","十三号","十四号","十五号","十六号","十七号","十八号","十九号","二十号","二十一号","二十二号","二十三号","二十四号","二十五号","二十六号","二十七号","二十八号","二十九号","三十号","三十一号"};
		jcb_jihua_month=new JComboBox(month);
		jcb_jihua_day=new JComboBox(day);
		jb_jihua_chaxun = new JButton("查询");
		jb_jihua_chaxun.addActionListener(this);
		jp_jihua_chaxun.add(jl_jihua_chaxun);
		jp_jihua_chaxun.add(jl_jihua_month);
		jp_jihua_chaxun.add(jcb_jihua_month);
		jp_jihua_chaxun.add(jl_jihua_day);
		jp_jihua_chaxun.add(jcb_jihua_day);
		jp_jihua_chaxun.add(jb_jihua_chaxun);
		return jp_jihua_chaxun;
		
	}
	
	public Component Jihua_biaoge()
	{
		ScheduleModel smm = new ScheduleModel();
		jt_jihua_xinxi = new JTable(smm);
		jt_jihua_xinxi.setShowGrid(true);
		jsp_jihua_biaoge = new JScrollPane(jt_jihua_xinxi);
		jp_jihua_biaoge.add(jsp_jihua_biaoge);
		return jsp_jihua_biaoge;
	}

	public Component Jihua_zengshangai()
	{
		jb_jihua_zengjia = new JButton("增加");
		jb_jihua_zengjia.addActionListener(this);
		jb_jihua_shanchu = new JButton("删除");
		jb_jihua_shanchu.addActionListener(this);
		jb_jihua_xiugai = new JButton("修改");
		jb_jihua_xiugai.addActionListener(this);
		
		
		jp_jihua_zengshangai.add(jb_jihua_xiugai);
		jp_jihua_zengshangai.add(jb_jihua_zengjia);
		jp_jihua_zengshangai.add(jb_jihua_shanchu);
		return jp_jihua_zengshangai;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb_jihua_chaxun)
		{
			 String name=this.jtf_jihua_chaxun.getText();
			 ScheduleModel smm = new ScheduleModel();
				jt_jihua_xinxi = new JTable(smm);
			 //更新jtable
				jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_zengjia)
		{
//			MovieDialog md = new ScheduleDialog(this,"添加放映计划",true);
			//构建新的模型类，并更新
			ScheduleModel smm = new ScheduleModel();
			jt_jihua_xinxi = new JTable(smm);
		 //更新jtable
			jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_shanchu)
		{
			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			String MovieName=(String)smm.getValueAt(rowNum, 0);
			String sql = "DELETE FROM Table_Movie WHERE Movie_ChineseName=?";
			String[] paras= {MovieName};
			SqlHelper sh = new SqlHelper();
			sh.update(sql, paras);
			smm = new ScheduleModel();
			jt_jihua_xinxi = new JTable(smm);
		 //更新jtable
			jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_xiugai)
		{
			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "请选择一行");
				return ;
			}
			
			//显示修改对话框
			new updateScheduleDialog(this,"修改",false,smm,rowNum);
		}
//		if(e.getSource()==jb_jihua_xiangxixinxi)
//		{
//			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
//			if(rowNum==-1)
//			{
//				JOptionPane.showMessageDialog(this, "请选择一行");
//				return ;
//			}
//			String MovieName=(String)mm.getValueAt(rowNum, 0);
//			Xiangxixinxi xx = new Xiangxixinxi(this,"详细信息",true,MovieName);
//		}
	}
}
