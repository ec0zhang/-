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
	//��ӳ�ƻ�
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
		jl_jihua_chaxun = new JLabel("��ѯ��");
		jl_jihua_month = new JLabel("�·�");
		String[] month = {"һ��","����","����","����","����","����","����","����","����","ʮ��","ʮһ��","ʮ����"};
		jl_jihua_day = new JLabel("����");
		String[] day = {"һ��","����","����","�ĺ�","���","����","�ߺ�","�˺�","�ź�","ʮ��","ʮһ��","ʮ����","ʮ����","ʮ�ĺ�","ʮ���","ʮ����","ʮ�ߺ�","ʮ�˺�","ʮ�ź�","��ʮ��","��ʮһ��","��ʮ����","��ʮ����","��ʮ�ĺ�","��ʮ���","��ʮ����","��ʮ�ߺ�","��ʮ�˺�","��ʮ�ź�","��ʮ��","��ʮһ��"};
		jcb_jihua_month=new JComboBox(month);
		jcb_jihua_day=new JComboBox(day);
		jb_jihua_chaxun = new JButton("��ѯ");
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
		jb_jihua_zengjia = new JButton("����");
		jb_jihua_zengjia.addActionListener(this);
		jb_jihua_shanchu = new JButton("ɾ��");
		jb_jihua_shanchu.addActionListener(this);
		jb_jihua_xiugai = new JButton("�޸�");
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
			 //����jtable
				jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_zengjia)
		{
//			MovieDialog md = new ScheduleDialog(this,"��ӷ�ӳ�ƻ�",true);
			//�����µ�ģ���࣬������
			ScheduleModel smm = new ScheduleModel();
			jt_jihua_xinxi = new JTable(smm);
		 //����jtable
			jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_shanchu)
		{
			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return ;
			}
			String MovieName=(String)smm.getValueAt(rowNum, 0);
			String sql = "DELETE FROM Table_Movie WHERE Movie_ChineseName=?";
			String[] paras= {MovieName};
			SqlHelper sh = new SqlHelper();
			sh.update(sql, paras);
			smm = new ScheduleModel();
			jt_jihua_xinxi = new JTable(smm);
		 //����jtable
			jt_jihua_xinxi.setModel(smm);
		}
		if(e.getSource()==jb_jihua_xiugai)
		{
			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return ;
			}
			
			//��ʾ�޸ĶԻ���
			new updateScheduleDialog(this,"�޸�",false,smm,rowNum);
		}
//		if(e.getSource()==jb_jihua_xiangxixinxi)
//		{
//			int rowNum = this.jt_jihua_xinxi.getSelectedRow();
//			if(rowNum==-1)
//			{
//				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
//				return ;
//			}
//			String MovieName=(String)mm.getValueAt(rowNum, 0);
//			Xiangxixinxi xx = new Xiangxixinxi(this,"��ϸ��Ϣ",true,MovieName);
//		}
	}
}
