package com.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.dao.SqlHelper;
import com.service.MovieModel;

public class Yingpian extends JPanel implements ActionListener {

	MovieModel mm=null;
	
	JPanel jp_dianying_chaxun, jp_dianying_biaoge, jp_dianying_zengshangai,jp_dianying_all;
	JButton jb_dianying_chaxun, jb_dianying_zengjia, jb_dianying_shanchu, jb_dianying_xiugai,jb_dianying_xiangxixinxi;
	JScrollPane jsp_dianying_biaoge;
	JTable jt_dianying_xinxi;
	JTextField jtf_dianying_chaxun;
	JLabel jl_dianying_chaxun;
	public Component Yingpian_all()
	{
		jp_dianying_chaxun = new JPanel();
		jp_dianying_biaoge = new JPanel();
		jp_dianying_zengshangai = new JPanel();
		jl_dianying_chaxun = new JLabel("��ѯ��");
		jtf_dianying_chaxun = new JTextField(10);
		jtf_dianying_chaxun.setBorder(BorderFactory.createLoweredBevelBorder());
		jb_dianying_chaxun = new JButton("��ѯ");
		jb_dianying_chaxun.addActionListener(this);
		jb_dianying_zengjia = new JButton("����");
		jb_dianying_zengjia.addActionListener(this);
		jb_dianying_shanchu = new JButton("ɾ��");
		jb_dianying_shanchu.addActionListener(this);
		jb_dianying_xiugai = new JButton("�޸�");
		jb_dianying_xiugai.addActionListener(this);
		jb_dianying_xiangxixinxi = new JButton("�鿴��ϸ��Ϣ");
		jb_dianying_xiangxixinxi.addActionListener(this);

		jp_dianying_chaxun.add(jl_dianying_chaxun);
		jp_dianying_chaxun.add(jtf_dianying_chaxun);
		jp_dianying_chaxun.add(jb_dianying_chaxun);

		mm = new MovieModel();
		jt_dianying_xinxi = new JTable(mm);
		jsp_dianying_biaoge = new JScrollPane(jt_dianying_xinxi);
		jp_dianying_biaoge.add(jsp_dianying_biaoge);

		jp_dianying_zengshangai.add(jb_dianying_xiangxixinxi);
		jp_dianying_zengshangai.add(jb_dianying_zengjia);
		jp_dianying_zengshangai.add(jb_dianying_xiugai);
		jp_dianying_zengshangai.add(jb_dianying_shanchu);
		
		
		jp_dianying_all = new JPanel();
		jp_dianying_all.setLayout(new BorderLayout());
		jp_dianying_all.add(jp_dianying_chaxun, BorderLayout.NORTH);
		jp_dianying_all.add(jsp_dianying_biaoge, BorderLayout.CENTER);
		jp_dianying_all.add(jp_dianying_zengshangai, BorderLayout.SOUTH);
		return jp_dianying_all;
	}
	
	public Yingpian()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb_dianying_chaxun)
		{
			 String name=this.jtf_dianying_chaxun.getText();
			 String sql = "select Movie_ChineseName,Movie_Type,Movie_Duration,Movie_BeginDate from Table_Movie where Movie_ChineseName='"+name+"'";
			 //�����µ�ģ���࣬������
			 mm=new MovieModel(sql);
			 //����jtable
			 jt_dianying_xinxi.setModel(mm);
		}
		if(e.getSource()==jb_dianying_zengjia)
		{
			MovieDialog md = new MovieDialog(this,"���ӰƬ",true);
			//�����µ�ģ���࣬������
			String sql = "select Movie_ChineseName,Movie_Type,Movie_Duration,Movie_BeginDate from Table_Movie";
			mm=new MovieModel(sql);
			 //����jtable
			jt_dianying_xinxi.setModel(mm);
		}
		if(e.getSource()==jb_dianying_shanchu)
		{
			int rowNum = this.jt_dianying_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return ;
			}
			String MovieName=(String)mm.getValueAt(rowNum, 0);
			String sql = "DELETE FROM Table_Movie WHERE Movie_ChineseName=?";
			String[] paras= {MovieName};
			SqlHelper sh = new SqlHelper();
			sh.update(sql, paras);
			String sql1 = "select Movie_ChineseName,Movie_Type,Movie_Duration,Movie_BeginDate from Table_Movie";
			mm=new MovieModel(sql1);
			 //����jtable
			jt_dianying_xinxi.setModel(mm);
		}
		if(e.getSource()==jb_dianying_xiugai)
		{
			int rowNum = this.jt_dianying_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return ;
			}
			
			//��ʾ�޸ĶԻ���
			new updateMovieDialog(this,"�޸�",false,mm,rowNum);
		}
		if(e.getSource()==jb_dianying_xiangxixinxi)
		{
			int rowNum = this.jt_dianying_xinxi.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showMessageDialog(this, "��ѡ��һ��");
				return ;
			}
			String MovieName=(String)mm.getValueAt(rowNum, 0);
			Xiangxixinxi xx = new Xiangxixinxi(this,"��ϸ��Ϣ",true,MovieName);
		}
	}
}
