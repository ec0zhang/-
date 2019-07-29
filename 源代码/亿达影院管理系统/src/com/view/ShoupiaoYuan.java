package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.*;

import com.service.MovieModel;
import com.service.ScheduleModel;

public class ShoupiaoYuan extends JFrame implements ActionListener {

	// 增加修改删除
	JPanel jp_yingpian_all, jp_yingpian_riqi, jp_yingpian_zuobian, jp_yingpian_fangyingting;
	JPanel jp_yingpian_info, jp_yingpian_select, jp_yingpian_zuowei;
	JLabel jl_yingpian_poster, jl_yingpian_chineseName, jl_yingpian_foreignName, jl_yingpian_type, jl_yingpian_duration,
			jl_yingpian_endTime, jl_yingpian_logo;
	JLabel jl_yingpian_month, jl_yingpian_day, jl_yingpian_chankanjihua, jl_yingpian_chakanzuowei;
	JComboBox jcb_yingpian_month, jcb_yingpian_day;
	JButton jb_yingpian_chaxun, jb_yingpian_chakanzuowei;
	JPanel jp_yingpian_xinxi;
	JScrollPane jsp_yingpian_shoupiao;
	JTable jt_yingpian_shoupiao;

	JButton jb_yingpian_0101;
	JButton jb_yingpian_0102;
	JButton jb_yingpian_0103;
	JButton jb_yingpian_0104;
	JButton jb_yingpian_0105;
	JButton jb_yingpian_0106;
	JButton jb_yingpian_0107;
	JButton jb_yingpian_0108;
	JButton jb_yingpian_0109;

	JButton jb_yingpian_0201;
	JButton jb_yingpian_0202;
	JButton jb_yingpian_0203;
	JButton jb_yingpian_0204;
	JButton jb_yingpian_0205;
	JButton jb_yingpian_0206;
	JButton jb_yingpian_0207;
	JButton jb_yingpian_0208;
	JButton jb_yingpian_0209;

	JButton jb_yingpian_0301;
	JButton jb_yingpian_0302;
	JButton jb_yingpian_0303;
	JButton jb_yingpian_0304;
	JButton jb_yingpian_0305;
	JButton jb_yingpian_0306;
	JButton jb_yingpian_0307;
	JButton jb_yingpian_0308;
	JButton jb_yingpian_0309;

	JButton jb_yingpian_0401;
	JButton jb_yingpian_0402;
	JButton jb_yingpian_0403;
	JButton jb_yingpian_0404;
	JButton jb_yingpian_0405;
	JButton jb_yingpian_0406;
	JButton jb_yingpian_0407;
	JButton jb_yingpian_0408;
	JButton jb_yingpian_0409;

	JButton jb_yingpian_0501;
	JButton jb_yingpian_0502;
	JButton jb_yingpian_0503;
	JButton jb_yingpian_0504;
	JButton jb_yingpian_0505;
	JButton jb_yingpian_0506;
	JButton jb_yingpian_0507;
	JButton jb_yingpian_0508;
	JButton jb_yingpian_0509;

	JButton jb_yingpian_0601;
	JButton jb_yingpian_0602;
	JButton jb_yingpian_0603;
	JButton jb_yingpian_0604;
	JButton jb_yingpian_0605;
	JButton jb_yingpian_0606;
	JButton jb_yingpian_0607;
	JButton jb_yingpian_0608;
	JButton jb_yingpian_0609;
	int count = 0;

	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	
	public ShoupiaoYuan() {

		jp_yingpian_info = new JPanel();
		jp_yingpian_info.setLayout(new GridLayout(1, 3));
		ImageIcon post = new ImageIcon("images/post2.png");
		jl_yingpian_poster = new JLabel();
		jl_yingpian_poster.setIcon(post);
		jl_yingpian_chineseName = new JLabel("白蛇缘起");
		jl_yingpian_foreignName = new JLabel("white snake");
		jl_yingpian_type = new JLabel("玄幻");
		jl_yingpian_duration = new JLabel("95");
		jl_yingpian_endTime = new JLabel("16:00");
		ImageIcon logo = new ImageIcon("images/logo2.png");
		jl_yingpian_logo = new JLabel();
		jl_yingpian_logo.setIcon(logo);
		jp_yingpian_xinxi = new JPanel();
		jp_yingpian_xinxi.setLayout(new GridLayout(5, 1));
		jp_yingpian_xinxi.add(jl_yingpian_chineseName);
		jp_yingpian_xinxi.add(jl_yingpian_foreignName);
		jp_yingpian_xinxi.add(jl_yingpian_type);
		jp_yingpian_xinxi.add(jl_yingpian_duration);
		jp_yingpian_xinxi.add(jl_yingpian_endTime);
		jp_yingpian_info.add(jl_yingpian_poster);
		jp_yingpian_info.add(jp_yingpian_xinxi);
		jp_yingpian_info.add(jl_yingpian_logo);
		
		jp_yingpian_zuowei = new JPanel();
		jp_yingpian_zuowei.setLayout(null);
		jb_yingpian_0101 = new JButton();
		jb_yingpian_0101.addActionListener(this);
		ImageIcon icon = new ImageIcon("images/seat.png");
		jb_yingpian_0101.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0101);
		jb_yingpian_0101.setBounds(50, 50, 30, 30);
		//

		jb_yingpian_0101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0101.getBackground() == Color.green)) {
					jb_yingpian_0101.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0101.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0102 = new JButton();
		jb_yingpian_0102.addActionListener(this);
		jb_yingpian_0102.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0102);
		jb_yingpian_0102.setBounds(90, 50, 30, 30);

		jb_yingpian_0102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0102.getBackground() == Color.green)) {
					jb_yingpian_0102.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0102.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0103 = new JButton();
		jb_yingpian_0103.addActionListener(this);
		jb_yingpian_0103.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0103);
		jb_yingpian_0103.setBounds(130, 50, 30, 30);

		jb_yingpian_0103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0103.getBackground() == Color.green)) {
					jb_yingpian_0103.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0103.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0104 = new JButton();
		jb_yingpian_0104.addActionListener(this);
		jb_yingpian_0104.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0104);
		jb_yingpian_0104.setBounds(170, 50, 30, 30);
		jb_yingpian_0104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0104.getBackground() == Color.green)) {
					jb_yingpian_0104.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0104.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 5
		jb_yingpian_0105 = new JButton();
		jb_yingpian_0105.addActionListener(this);
		jb_yingpian_0105.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0105);
		jb_yingpian_0105.setBounds(210, 50, 30, 30);
		jb_yingpian_0105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0105.getBackground() == Color.green)) {
					jb_yingpian_0105.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0105.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 6
		jb_yingpian_0106 = new JButton();
		jb_yingpian_0106.addActionListener(this);
		jb_yingpian_0106.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0106);
		jb_yingpian_0106.setBounds(250, 50, 30, 30);
		jb_yingpian_0106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0106.getBackground() == Color.green)) {
					jb_yingpian_0106.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0106.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 7
		jb_yingpian_0107 = new JButton();
		jb_yingpian_0107.addActionListener(this);
		jb_yingpian_0107.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0107);
		jb_yingpian_0107.setBounds(290, 50, 30, 30);
		jb_yingpian_0107.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0107.getBackground() == Color.green)) {
					jb_yingpian_0107.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0107.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 8
		jb_yingpian_0108 = new JButton();
		jb_yingpian_0108.addActionListener(this);
		jb_yingpian_0108.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0108);
		jb_yingpian_0108.setBounds(330, 50, 30, 30);
		jb_yingpian_0108.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0108.getBackground() == Color.green)) {
					jb_yingpian_0108.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0108.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 9
		jb_yingpian_0109 = new JButton();
		jb_yingpian_0109.addActionListener(this);
		jb_yingpian_0109.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0109);
		jb_yingpian_0109.setBounds(370, 50, 30, 30);
		jb_yingpian_0109.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0109.getBackground() == Color.green)) {
					jb_yingpian_0109.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0109.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 21
		jb_yingpian_0201 = new JButton();
		jb_yingpian_0201.addActionListener(this);
		jb_yingpian_0201.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0201);
		jb_yingpian_0201.setBounds(50, 90, 30, 30);
		jb_yingpian_0201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0201.getBackground() == Color.green)) {
					jb_yingpian_0201.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0201.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0202 = new JButton();
		jb_yingpian_0202.addActionListener(this);
		jb_yingpian_0202.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0202);
		jb_yingpian_0202.setBounds(90, 90, 30, 30);
		jb_yingpian_0202.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0202.getBackground() == Color.green)) {
					jb_yingpian_0202.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0202.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0203 = new JButton();
		jb_yingpian_0203.addActionListener(this);
		jb_yingpian_0203.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0203);
		jb_yingpian_0203.setBounds(130, 90, 30, 30);
		jb_yingpian_0203.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0203.getBackground() == Color.green)) {
					jb_yingpian_0203.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0203.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0204 = new JButton();
		jb_yingpian_0204.addActionListener(this);
		jb_yingpian_0204.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0204);
		jb_yingpian_0204.setBounds(170, 90, 30, 30);
		jb_yingpian_0204.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0204.getBackground() == Color.green)) {
					jb_yingpian_0204.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0204.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 5
		jb_yingpian_0205 = new JButton();
		jb_yingpian_0205.addActionListener(this);
		jb_yingpian_0205.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0205);
		jb_yingpian_0205.setBounds(210, 90, 30, 30);
		jb_yingpian_0205.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0205.getBackground() == Color.green)) {
					jb_yingpian_0205.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0205.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 6
		jb_yingpian_0206 = new JButton();
		jb_yingpian_0206.addActionListener(this);
		jb_yingpian_0206.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0206);
		jb_yingpian_0206.setBounds(250, 90, 30, 30);
		jb_yingpian_0206.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0206.getBackground() == Color.green)) {
					jb_yingpian_0206.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0206.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 7
		jb_yingpian_0207 = new JButton();
		jb_yingpian_0207.addActionListener(this);
		jb_yingpian_0207.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0207);
		jb_yingpian_0207.setBounds(290, 90, 30, 30);
		jb_yingpian_0207.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0207.getBackground() == Color.green)) {
					jb_yingpian_0207.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0207.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 8
		jb_yingpian_0208 = new JButton();
		jb_yingpian_0208.addActionListener(this);
		jb_yingpian_0208.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0208);
		jb_yingpian_0208.setBounds(330, 90, 30, 30);
		jb_yingpian_0208.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0208.getBackground() == Color.green)) {
					jb_yingpian_0208.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0208.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 9
		jb_yingpian_0209 = new JButton();
		jb_yingpian_0209.addActionListener(this);
		jb_yingpian_0209.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0209);
		jb_yingpian_0209.setBounds(370, 90, 30, 30);
		jb_yingpian_0209.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0209.getBackground() == Color.green)) {
					jb_yingpian_0209.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0209.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 31
		jb_yingpian_0301 = new JButton();
		jb_yingpian_0301.addActionListener(this);
		jb_yingpian_0301.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0301);
		jb_yingpian_0301.setBounds(50, 130, 30, 30);
		jb_yingpian_0301.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0301.getBackground() == Color.green)) {
					jb_yingpian_0301.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0301.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0302 = new JButton();
		jb_yingpian_0302.addActionListener(this);
		jb_yingpian_0302.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0302);
		jb_yingpian_0302.setBounds(90, 130, 30, 30);
		jb_yingpian_0302.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0302.getBackground() == Color.green)) {
					jb_yingpian_0302.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0302.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0303 = new JButton();
		jb_yingpian_0303.addActionListener(this);
		jb_yingpian_0303.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0303);
		jb_yingpian_0303.setBounds(130, 130, 30, 30);
		jb_yingpian_0303.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0303.getBackground() == Color.green)) {
					jb_yingpian_0303.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0303.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0304 = new JButton();
		jb_yingpian_0304.addActionListener(this);
		jb_yingpian_0304.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0304);
		jb_yingpian_0304.setBounds(170, 130, 30, 30);
		jb_yingpian_0304.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0304.getBackground() == Color.green)) {
					jb_yingpian_0304.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0304.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 5
		jb_yingpian_0305 = new JButton();
		jb_yingpian_0305.addActionListener(this);
		jb_yingpian_0305.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0305);
		jb_yingpian_0305.setBounds(210, 130, 30, 30);
		jb_yingpian_0305.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0305.getBackground() == Color.green)) {
					jb_yingpian_0305.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0305.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 6
		jb_yingpian_0306 = new JButton();
		jb_yingpian_0306.addActionListener(this);
		jb_yingpian_0306.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0306);
		jb_yingpian_0306.setBounds(250, 130, 30, 30);
		jb_yingpian_0306.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0306.getBackground() == Color.green)) {
					jb_yingpian_0306.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0306.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 7
		jb_yingpian_0307 = new JButton();
		jb_yingpian_0307.addActionListener(this);
		jb_yingpian_0307.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0307);
		jb_yingpian_0307.setBounds(290, 130, 30, 30);
		jb_yingpian_0307.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0307.getBackground() == Color.green)) {
					jb_yingpian_0307.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0307.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 8
		jb_yingpian_0308 = new JButton();
		jb_yingpian_0308.addActionListener(this);
		jb_yingpian_0308.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0308);
		jb_yingpian_0308.setBounds(330, 130, 30, 30);
		jb_yingpian_0308.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0308.getBackground() == Color.green)) {
					jb_yingpian_0308.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0308.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 9
		jb_yingpian_0309 = new JButton();
		jb_yingpian_0309.addActionListener(this);
		jb_yingpian_0309.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0309);
		jb_yingpian_0309.setBounds(370, 130, 30, 30);
		jb_yingpian_0309.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0309.getBackground() == Color.green)) {
					jb_yingpian_0309.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0309.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 41
		jb_yingpian_0401 = new JButton();
		jb_yingpian_0401.addActionListener(this);
		jb_yingpian_0401.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0401);
		jb_yingpian_0401.setBounds(50, 170, 30, 30);
		jb_yingpian_0401.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0401.getBackground() == Color.green)) {
					jb_yingpian_0401.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0401.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0402 = new JButton();
		jb_yingpian_0402.addActionListener(this);
		jb_yingpian_0402.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0402);
		jb_yingpian_0402.setBounds(90, 170, 30, 30);
		jb_yingpian_0402.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0402.getBackground() == Color.green)) {
					jb_yingpian_0402.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0402.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0403 = new JButton();
		jb_yingpian_0403.addActionListener(this);
		jb_yingpian_0403.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0403);
		jb_yingpian_0403.setBounds(130, 170, 30, 30);
		jb_yingpian_0403.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0403.getBackground() == Color.green)) {
					jb_yingpian_0403.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0403.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0404 = new JButton();
		jb_yingpian_0404.addActionListener(this);
		jb_yingpian_0404.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0404);
		jb_yingpian_0404.setBounds(170, 170, 30, 30);
		jb_yingpian_0404.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0404.getBackground() == Color.green)) {
					jb_yingpian_0404.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0404.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 5
		jb_yingpian_0405 = new JButton();
		jb_yingpian_0405.addActionListener(this);
		jb_yingpian_0405.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0405);
		jb_yingpian_0405.setBounds(210, 170, 30, 30);
		jb_yingpian_0405.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0405.getBackground() == Color.green)) {
					jb_yingpian_0405.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0405.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 6
		jb_yingpian_0406 = new JButton();
		jb_yingpian_0406.addActionListener(this);
		jb_yingpian_0406.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0406);
		jb_yingpian_0406.setBounds(250, 170, 30, 30);
		jb_yingpian_0406.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0406.getBackground() == Color.green)) {
					jb_yingpian_0406.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0406.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 7
		jb_yingpian_0407 = new JButton();
		jb_yingpian_0407.addActionListener(this);
		jb_yingpian_0407.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0407);
		jb_yingpian_0407.setBounds(290, 170, 30, 30);
		jb_yingpian_0407.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0407.getBackground() == Color.green)) {
					jb_yingpian_0407.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0407.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 8
		jb_yingpian_0408 = new JButton();
		jb_yingpian_0408.addActionListener(this);
		jb_yingpian_0408.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0408);
		jb_yingpian_0408.setBounds(330, 170, 30, 30);
		jb_yingpian_0408.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0408.getBackground() == Color.green)) {
					jb_yingpian_0408.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0408.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 9
		jb_yingpian_0409 = new JButton();
		jb_yingpian_0409.addActionListener(this);
		jb_yingpian_0409.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0409);
		jb_yingpian_0409.setBounds(370, 170, 30, 30);
		jb_yingpian_0409.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0409.getBackground() == Color.green)) {
					jb_yingpian_0409.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0409.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 51
		jb_yingpian_0501 = new JButton();
		jb_yingpian_0501.addActionListener(this);
		jb_yingpian_0501.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0501);
		jb_yingpian_0501.setBounds(50, 210, 30, 30);
		jb_yingpian_0501.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0501.getBackground() == Color.green)) {
					jb_yingpian_0501.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0501.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0502 = new JButton();
		jb_yingpian_0502.addActionListener(this);
		jb_yingpian_0502.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0502);
		jb_yingpian_0502.setBounds(90, 210, 30, 30);
		jb_yingpian_0502.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0502.getBackground() == Color.green)) {
					jb_yingpian_0502.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0502.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0503 = new JButton();
		jb_yingpian_0503.addActionListener(this);
		jb_yingpian_0503.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0503);
		jb_yingpian_0503.setBounds(130, 210, 30, 30);
		jb_yingpian_0503.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0503.getBackground() == Color.green)) {
					jb_yingpian_0503.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0503.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0504 = new JButton();
		jb_yingpian_0504.addActionListener(this);
		jb_yingpian_0504.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0504);
		jb_yingpian_0504.setBounds(170, 210, 30, 30);
		jb_yingpian_0504.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0504.getBackground() == Color.green)) {
					jb_yingpian_0504.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0504.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 5
		jb_yingpian_0505 = new JButton();
		jb_yingpian_0505.addActionListener(this);
		jb_yingpian_0505.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0505);
		jb_yingpian_0505.setBounds(210, 210, 30, 30);
		jb_yingpian_0505.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0505.getBackground() == Color.green)) {
					jb_yingpian_0505.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0505.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 6
		jb_yingpian_0506 = new JButton();
		jb_yingpian_0506.addActionListener(this);
		jb_yingpian_0506.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0506);
		jb_yingpian_0506.setBounds(250, 210, 30, 30);
		jb_yingpian_0506.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0506.getBackground() == Color.green)) {
					jb_yingpian_0506.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0506.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 7
		jb_yingpian_0507 = new JButton();
		jb_yingpian_0507.addActionListener(this);
		jb_yingpian_0507.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0507);
		jb_yingpian_0507.setBounds(290, 210, 30, 30);
		jb_yingpian_0507.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0507.getBackground() == Color.green)) {
					jb_yingpian_0507.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0507.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 8
		jb_yingpian_0508 = new JButton();
		jb_yingpian_0508.addActionListener(this);
		jb_yingpian_0508.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0508);
		jb_yingpian_0508.setBounds(330, 210, 30, 30);
		jb_yingpian_0508.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0508.getBackground() == Color.green)) {
					jb_yingpian_0508.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0508.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 9
		jb_yingpian_0509 = new JButton();
		jb_yingpian_0509.addActionListener(this);
		jb_yingpian_0509.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0509);
		jb_yingpian_0509.setBounds(370, 210, 30, 30);
		jb_yingpian_0509.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0509.getBackground() == Color.green)) {
					jb_yingpian_0509.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0509.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 61
		jb_yingpian_0601 = new JButton();
		jb_yingpian_0601.addActionListener(this);
		jb_yingpian_0601.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0601);
		jb_yingpian_0601.setBounds(50, 250, 30, 30);
		jb_yingpian_0601.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0601.getBackground() == Color.green)) {
					jb_yingpian_0601.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0601.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 2
		jb_yingpian_0602 = new JButton();
		jb_yingpian_0602.addActionListener(this);
		jb_yingpian_0602.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0602);
		jb_yingpian_0602.setBounds(90, 250, 30, 30);
		jb_yingpian_0602.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0602.getBackground() == Color.green)) {
					jb_yingpian_0602.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0602.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 3
		jb_yingpian_0603 = new JButton();
		jb_yingpian_0603.addActionListener(this);
		jb_yingpian_0603.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0603);
		jb_yingpian_0603.setBounds(130, 250, 30, 30);
		jb_yingpian_0603.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0603.getBackground() == Color.green)) {
					jb_yingpian_0603.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0603.setBackground(Color.WHITE);
					count--;
				}
			}
		});

		// 4
		jb_yingpian_0604 = new JButton();
		jb_yingpian_0604.addActionListener(this);
		jb_yingpian_0604.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0604);
		jb_yingpian_0604.setBounds(170, 250, 30, 30);
		jb_yingpian_0604.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0604.getBackground() == Color.green)) {
					jb_yingpian_0604.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0604.setBackground(Color.WHITE);
				}
			}
		});

		// 5
		jb_yingpian_0605 = new JButton();
		jb_yingpian_0605.addActionListener(this);
		jb_yingpian_0605.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0605);
		jb_yingpian_0605.setBounds(210, 250, 30, 30);
		jb_yingpian_0605.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0605.getBackground() == Color.green)) {
					jb_yingpian_0605.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0605.setBackground(Color.WHITE);
				}
			}
		});

		// 6
		jb_yingpian_0606 = new JButton();
		jb_yingpian_0606.addActionListener(this);
		jb_yingpian_0606.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0606);
		jb_yingpian_0606.setBounds(250, 250, 30, 30);
		jb_yingpian_0606.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0606.getBackground() == Color.green)) {
					jb_yingpian_0606.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0606.setBackground(Color.WHITE);
				}
			}
		});

		// 7
		jb_yingpian_0607 = new JButton();
		jb_yingpian_0607.addActionListener(this);
		jb_yingpian_0607.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0607);
		jb_yingpian_0607.setBounds(290, 250, 30, 30);
		jb_yingpian_0607.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0607.getBackground() == Color.green)) {
					jb_yingpian_0607.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0607.setBackground(Color.WHITE);
				}
			}
		});

		// 8
		jb_yingpian_0608 = new JButton();
		jb_yingpian_0608.addActionListener(this);
		jb_yingpian_0608.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0608);
		jb_yingpian_0608.setBounds(330, 250, 30, 30);
		jb_yingpian_0608.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0608.getBackground() == Color.green)) {
					jb_yingpian_0608.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0608.setBackground(Color.WHITE);
				}
			}
		});

		// 9
		jb_yingpian_0609 = new JButton();
		jb_yingpian_0609.addActionListener(this);
		jb_yingpian_0609.setIcon(icon);

		jp_yingpian_zuowei.add(jb_yingpian_0609);
		jb_yingpian_0609.setBounds(370, 250, 30, 30);
		jb_yingpian_0609.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(jb_yingpian_0609.getBackground() == Color.green)) {
					jb_yingpian_0609.setBackground(Color.green);
					count++;
				} else {
					jb_yingpian_0609.setBackground(Color.WHITE);
					count--;
				}
			}
		});


		jp1=new JPanel();
		jp2=new JPanel();
		jb1=new JButton("确认");
		jb2=new JButton("取消");
//		jp1.add(jp_yingpian_zuowei);
		jp2.add(jb1);
		jp2.add(jb2);
		jp3=new JPanel();
		jp3.setLayout(new BorderLayout());
		jp3.add(jp_yingpian_zuowei,BorderLayout.CENTER);
		jp3.add(jp2,BorderLayout.SOUTH);
		jp_yingpian_zuobian = new JPanel();
		jp_yingpian_zuobian.setLayout(new BorderLayout());
		jp_yingpian_zuobian.add(jp_yingpian_info, BorderLayout.NORTH);
		jp_yingpian_zuobian.add(jp3, BorderLayout.CENTER);

		jp_yingpian_select = new JPanel();
		jp_yingpian_select.setBackground(Color.red);
		jp_yingpian_select.setLayout(new BorderLayout());

		ScheduleModel sm = new ScheduleModel();
		jt_yingpian_shoupiao = new JTable(sm);
		jsp_yingpian_shoupiao = new JScrollPane(jt_yingpian_shoupiao);

		jl_yingpian_month = new JLabel("月份");
		String[] month = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
		jl_yingpian_day = new JLabel("日期");
		String[] day = { "一号", "二号", "三号", "四号", "五号", "六号", "七号", "八号", "九号", "十号", "十一号", "十二号", "十三号", "十四号", "十五号",
				"十六号", "十七号", "十八号", "十九号", "二十号", "二十一号", "二十二号", "二十三号", "二十四号", "二十五号", "二十六号", "二十七号", "二十八号",
				"二十九号", "三十号", "三十一号" };
		jcb_yingpian_month = new JComboBox(month);
		jcb_yingpian_day = new JComboBox(day);
		jl_yingpian_chankanjihua = new JLabel("查看计划");
		jl_yingpian_chakanzuowei = new JLabel("查看放映厅");
		jb_yingpian_chaxun = new JButton("查询");
		jb_yingpian_chaxun.addActionListener(this);
		jb_yingpian_chakanzuowei = new JButton("查看");
		jb_yingpian_chakanzuowei.addActionListener(this);
		jp_yingpian_riqi = new JPanel();
		jp_yingpian_riqi.setLayout(new GridLayout(3, 2));
		jp_yingpian_riqi.add(jl_yingpian_month);
		jp_yingpian_riqi.add(jcb_yingpian_month);
		jp_yingpian_riqi.add(jl_yingpian_day);
		jp_yingpian_riqi.add(jcb_yingpian_day);
		jp_yingpian_riqi.add(jl_yingpian_chankanjihua);
		jp_yingpian_riqi.add(jb_yingpian_chaxun);

		jp_yingpian_fangyingting = new JPanel();
		jp_yingpian_fangyingting.setLayout(new GridLayout(1, 2));
		jp_yingpian_fangyingting.add(jl_yingpian_chakanzuowei);
		jp_yingpian_fangyingting.add(jb_yingpian_chakanzuowei);

		jp_yingpian_select.add(jp_yingpian_riqi, BorderLayout.NORTH);
		jp_yingpian_select.add(jsp_yingpian_shoupiao, BorderLayout.CENTER);
		jp_yingpian_select.add(jp_yingpian_fangyingting, BorderLayout.SOUTH);

		jp_yingpian_all = new JPanel();
		jp_yingpian_all.setLayout(new BorderLayout());
		jp_yingpian_all.add(jp_yingpian_zuobian, BorderLayout.CENTER);
		jp_yingpian_all.add(jp_yingpian_select, BorderLayout.EAST);

		this.add(jp_yingpian_all);
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		ImageIcon ic = new ImageIcon("images/炜炜头像.jpg");
		this.setIconImage(ic.getImage());
		this.setSize(w, h-35);
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb_yingpian_chaxun) {
//			ScheduleModel sm = new ScheduleModel();
//			jt_yingpian_shoupiao = new JTable(sm);
//			jt_yingpian_shoupiao.setModel(sm);
			System.out.println("客户想要查询放映计划，不过这块正在整合，还没弄好。");
		}
		if (e.getSource() == jb_yingpian_chakanzuowei) {
			System.out.println("客户想要查询座位，不过这块正在整合，还没弄好。");
		}
	}

}
