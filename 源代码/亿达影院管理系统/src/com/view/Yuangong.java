package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.SqlHelper;
import com.service.EmployeeModel;
import com.service.MovieModel;

public class Yuangong extends JPanel implements ActionListener {

	
	EmployeeModel em=null;
	// Ա������
	JPanel jp_yuangong_chaxun, jp_yuangong_biaoge, jp_yuangong_zengshangai;
	JButton jb_yuangong_chaxun, jb_yuangong_zengjia, jb_yuangong_shanchu, jb_yuangong_xiugai;
	JScrollPane jsp_biaoge;
	JTable jt_yuangong_xinxi;
	JTextField jtf_yuangong_chaxun;
	JLabel jl_yuangong_chaxun, jl_yuangong_yuangongrenshu;
	JPanel jp_jihua_all;

	public Yuangong() {

	}

	public Component Jihua_main() {
		jp_yuangong_chaxun = new JPanel();
		jl_yuangong_chaxun = new JLabel("��ѯԱ����");
		jtf_yuangong_chaxun = new JTextField(10);
		jtf_yuangong_chaxun.setBorder(BorderFactory.createLoweredBevelBorder());
		jb_yuangong_chaxun = new JButton("��ѯ");
		jb_yuangong_chaxun.addActionListener(this);
		jp_yuangong_chaxun.add(jl_yuangong_chaxun);
		jp_yuangong_chaxun.add(jtf_yuangong_chaxun);
		jp_yuangong_chaxun.add(jb_yuangong_chaxun);

		jp_yuangong_biaoge = new JPanel();
//		String sql = "select Employee_Name,Employee_Job,Employee_Phone from Table_Employee where 1=?";
//		String[] paras = {"1"};
		EmployeeModel em = new EmployeeModel();
		jt_yuangong_xinxi = new JTable(em);
		jsp_biaoge = new JScrollPane(jt_yuangong_xinxi);
		jp_yuangong_biaoge.add(jsp_biaoge);
		jsp_biaoge = new JScrollPane(jt_yuangong_xinxi);
		jp_yuangong_biaoge.add(jsp_biaoge);
		
		jp_yuangong_zengshangai = new JPanel();
		jb_yuangong_zengjia = new JButton("����");
		jb_yuangong_zengjia.addActionListener(this);
		jb_yuangong_shanchu = new JButton("ɾ��");
		jb_yuangong_shanchu.addActionListener(this);
		jb_yuangong_xiugai = new JButton("�޸�");
		jb_yuangong_xiugai.addActionListener(this);
		jp_yuangong_zengshangai.add(jb_yuangong_zengjia);
		jp_yuangong_zengshangai.add(jb_yuangong_shanchu);
		jp_yuangong_zengshangai.add(jb_yuangong_xiugai);

		jp_jihua_all=new JPanel();
		jp_jihua_all.setLayout(new BorderLayout());
		jp_jihua_all.add(jp_yuangong_chaxun,BorderLayout.NORTH);
		jp_jihua_all.add(jp_yuangong_biaoge,BorderLayout.CENTER);
		jp_jihua_all.add(jp_yuangong_zengshangai,BorderLayout.SOUTH);
		
		return jp_jihua_all;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				if(e.getSource() == jb_yuangong_chaxun)
				{
					 String name=this.jtf_yuangong_chaxun.getText();
					 String sql = "select Employee_Name,Employee_Job,Employee_Phone from Table_Employee where Employee_Name='"+name+"'";
					 //�����µ�ģ���࣬������
					 em=new EmployeeModel(sql);
					 //����jtable
					 jt_yuangong_xinxi.setModel(em);
				}
				if(e.getSource()==jb_yuangong_zengjia)
				{
					EmployeeDialog ed = new EmployeeDialog(this,"���Ա��",true);
					//�����µ�ģ���࣬������
					String sql = "select Employee_Name,Employee_Job,Employee_Phone from Table_Employee";
					em=new EmployeeModel(sql);
					 //����jtable
					jt_yuangong_xinxi.setModel(em);
				}
				if(e.getSource()==jb_yuangong_shanchu)
				{
					int rowNum = this.jt_yuangong_xinxi.getSelectedRow();
					if(rowNum==-1)
					{
						JOptionPane.showMessageDialog(this, "��ѡ��һ��");
						return ;
					}
					String MovieName=(String)em.getValueAt(rowNum, 0);
					String sql = "DELETE FROM Table_Employee WHERE Employee_Name=?";
					String[] paras= {MovieName};
					SqlHelper sh = new SqlHelper();
					sh.update(sql, paras);
					em=new EmployeeModel(sql);
					 //����jtable
					jt_yuangong_xinxi.setModel(em);
				}
				if(e.getSource()==jb_yuangong_xiugai)
				{
					int rowNum = this.jt_yuangong_xinxi.getSelectedRow();
					if(rowNum==-1)
					{
						JOptionPane.showMessageDialog(this, "��ѡ��һ��");
						return ;
					}
					
					//��ʾ�޸ĶԻ���
//					new updateMovieDialog(this,"�޸�",false,em,rowNum);
				}
//				if(e.getSource()==jb_yuangong_xiangxixinxi)
//				{
//					int rowNum = this.jt_yuangong_xinxi.getSelectedRow();
//					if(rowNum==-1)
//					{
//						JOptionPane.showMessageDialog(this, "��ѡ��һ��");
//						return ;
//					}
//					String YuangongName=(String)em.getValueAt(rowNum, 0);
//					Xiangxixinxi xx = new Xiangxixinxi(this,"��ϸ��Ϣ",true,YuangongName);
//				}
	}
}
