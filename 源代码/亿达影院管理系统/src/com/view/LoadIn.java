package com.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.dao.SqlHelper;

public class LoadIn extends JFrame implements ActionListener{

	JButton jb1,jb2;
	JLabel jl1,jl2,jl3;
	JTextField jtf1;
	JPasswordField jpf;
	JPanel jp1,jp2,jp3,jp4;
	JTabbedPane jtp_shoupiao;
	JPanel jp_shoupiao_changan, jp_shoupiao_yanta, jp_shoupiao_gaoxin;
	JPanel jp_shoupiao;
	public static void main(String[] args) {
		LoadIn li=new LoadIn();
	}

	public LoadIn()
	{
		jb1=new JButton("登陆");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jp1=new JPanel();
		jp1.add(jb1);
		jp1.add(jb2);
		
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp4.setLayout(new GridLayout(2,1));
		jl1=new JLabel("                欢迎使用亿达影院票务管理系统，请登录：");
		jl2=new JLabel("用户名：");
		jl3=new JLabel("密    码：");
		jtf1=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jp2.add(jl2);
		jp2.add(jtf1);
		jp3.add(jl3);
		jp3.add(jpf);
		
		jp4.add(jp2);
		jp4.add(jp3);
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((w/2)-200, (h/2)-150);
		
		this.setLayout(new BorderLayout());
		this.add(jl1,BorderLayout.NORTH);
		this.add(jp4,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			String Name=this.jtf1.getText();
			String Password=this.jpf.getText();
			String sql="select Employee_Password,Employee_Class from Table_Employee where Employee_Name=?";
			String []paras= {Name};
			SqlHelper sh=new SqlHelper();
			ResultSet rs=sh.queryExectue(sql, paras);
			try {
				rs.next();
				if(rs.getString(1).trim().equals(Password))
				{
					if (rs.getInt(2)<2) {
						YiDaYingYuanGuanLiXiTong yd=new YiDaYingYuanGuanLiXiTong();
						this.dispose();
					}
					else
					{
//						jtp_shoupiao = new JTabbedPane();
//						jp_shoupiao_changan = new JPanel();
//						jp_shoupiao_yanta = new JPanel();
//						jp_shoupiao_gaoxin = new JPanel();
						
						ShoupiaoYuan sp=new ShoupiaoYuan();
//						jp_shoupiao_changan.add(sp.Shoupiao_main());
//						jp_shoupiao_yanta.add(sp.Shoupiao_main());
//						jp_shoupiao_gaoxin.add(sp.Shoupiao_main());
//						jtp_shoupiao.add("长安", jp_shoupiao_changan);
//						jtp_shoupiao.add("雁塔", jp_shoupiao_yanta);
//						jtp_shoupiao.add("高新", jp_shoupiao_gaoxin);
////						jtp_shoupiao.setBounds(10,0,1200,600);
//						jp_shoupiao.add(jtp_shoupiao);
						this.dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "密码错误，请重新输入");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		if(e.getSource()==jb2)
		{
			
			this.dispose();
		}
	}

}