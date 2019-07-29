package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.*;
import com.service.*;

public class YiDaYingYuanGuanLiXiTong extends JFrame implements ActionListener{

	MovieModel mm;
	
	// 选项
	Image titelIcon;
	JMenuBar jmb;
	// 一级菜单
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	// 二级菜单
	JMenuItem jmm1, jmm2, jmm3, jmm4, jmm5;
	JMenuItem jm_yuangong_chaxun, jm_yuangong_zengjia, jm_yuangong_xiugai, jm_yuangong_shanchu;
	JMenuItem jm_yingpian_tianjia,jm_yingpian_shanchu,jm_yingpian_tiqianxiajia,jm_yingpian_yanchangfangying;

	// 北部区域
	JLabel jl1GongSiTuPian;

	// 中部区域

	// 第一个选项卡
	JTabbedPane jtp;
	JPanel jp_shouye, jp_shoupiao, jp_zuowei, jp_yingpian, jp_jihua, jp_yuangong, jp_tongji;

	// 登陆
	JLabel jl_HuanYingYu;

	// 售票
	JTabbedPane jtp_shoupiao;
	JPanel jp_shoupiao_changan, jp_shoupiao_yanta, jp_shoupiao_gaoxin;
	
	//影片管理

	//员工管理

	//销售统计
	JPanel jp_tongji_main,jp_tongji_anniu;
	JComboBox jcb_tongji_nian,jcb_tongji_yue,jcb_tongji_ri,jcb_tongji_location;
	
	
	JLabel jl_tongji_nian,jl_tongji_yue,jl_tongji_ri,jl_tongji_location;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		YiDaYingYuanGuanLiXiTong main = new YiDaYingYuanGuanLiXiTong();
//	}

	public YiDaYingYuanGuanLiXiTong() {
		// 创建组件

		{// 创建一级菜单
			jm1 = new JMenu("售票管理");
			// 创建二级菜单
			jmm1 = new JMenuItem("先留着不知道什么用的1");
			jmm1.addActionListener(this);
			jmm2 = new JMenuItem("先留着不知道什么用的2");
			jmm2.addActionListener(this);
			jmm3 = new JMenuItem("先留着不知道什么用的3");
			jmm3.addActionListener(this);
			jmm4 = new JMenuItem("先留着不知道什么用的4");
			jmm4.addActionListener(this);
			jmm5 = new JMenuItem("先留着不知道什么用的5");
			jmm5.addActionListener(this);
			// 加入
			jm1.add(jmm1);
			jm1.add(jmm2);
			jm1.add(jmm3);
			jm1.add(jmm4);
			jm1.add(jmm5);

			jm2 = new JMenu("座位管理");
			jm3 = new JMenu("影片管理");
			jm_yingpian_tianjia=new JMenuItem("影片上映，添加影片");
			jm_yingpian_tianjia.addActionListener(this);
			jm_yingpian_shanchu=new JMenuItem("影片下架，删除影片");
			jm_yingpian_shanchu.addActionListener(this);
			jm_yingpian_tiqianxiajia=new JMenuItem("卖的不好，不卖了");
			jm_yingpian_tiqianxiajia.addActionListener(this);
			jm_yingpian_yanchangfangying=new JMenuItem("卖的太好，增加排片");
			jm_yingpian_yanchangfangying.addActionListener(this);
			
			jm3.add(jm_yingpian_tianjia);
			jm3.add(jm_yingpian_shanchu);
			jm3.add(jm_yingpian_tiqianxiajia);
			jm3.add(jm_yingpian_yanchangfangying);
			
			jm4 = new JMenu("放映计划");
			jm5 = new JMenu("员工管理");
			// 创建二级菜单
			jm_yuangong_chaxun = new JMenuItem("查询员工信息");
			jm_yuangong_zengjia = new JMenuItem("增加新员工");
			jm_yuangong_xiugai = new JMenuItem("修改员工信息");
			jm_yuangong_shanchu = new JMenuItem("员工离职，删除信息");
			jm5.add(jm_yuangong_chaxun);
			jm5.add(jm_yuangong_zengjia);
			jm5.add(jm_yuangong_xiugai);
			jm5.add(jm_yuangong_shanchu);

			jm6 = new JMenu("销售统计");

			jmb = new JMenuBar();
			jmb.add(jm1);
			jmb.add(jm2);
			jmb.add(jm3);
			jmb.add(jm4);
			jmb.add(jm5);
			jmb.add(jm6);

			// 把JMenuBar添加到JFrame
			this.setJMenuBar(jmb);
		}

		// 北部区域
		jl1GongSiTuPian = new JLabel("欢迎使用亿达影院管理系统");

		// 中部主要组件
		{
			// 第一个选项卡组件
			{
				// 创建组件
				jtp = new JTabbedPane(JTabbedPane.LEFT);
				jp_shouye = new JPanel();
				jp_shoupiao = new JPanel();
				jp_zuowei = new JPanel();
				jp_yingpian = new JPanel();
				jp_jihua = new JPanel();
				jp_yuangong = new JPanel();
				jp_tongji = new JPanel();

				// 添加组件
				jtp.add("欢迎", jp_shouye);
//				jp_shouye.setBackground(Color.gray);
				jtp.add("售票", jp_shoupiao);
				jp_shoupiao.setBackground(Color.pink);
				jp_shoupiao.setLayout(new BorderLayout());
				jtp.add("座位", jp_zuowei);
				jp_zuowei.setBackground(Color.yellow);
				jp_zuowei.setLayout(new BorderLayout());
				jtp.add("影片", jp_yingpian);
				jp_yingpian.setBackground(Color.green);
				jp_yingpian.setLayout(new BorderLayout());
				jtp.add("计划", jp_jihua);
				jp_jihua.setBackground(Color.cyan);
				jp_jihua.setLayout(new BorderLayout());
				jtp.add("员工", jp_yuangong);
				jp_yuangong.setBackground(Color.blue);
				jp_yuangong.setLayout(new BorderLayout());
				jtp.add("统计", jp_tongji);
				jp_tongji.setBackground(Color.blue);
				jp_tongji.setLayout(new BorderLayout());
			}

			// 欢迎选项卡
			{
				// 创建组件
				jl_HuanYingYu = new JLabel();
				ImageIcon wel = new ImageIcon("images/欢迎.png");
				jl_HuanYingYu.setIcon(wel);
				jp_shouye.add(jl_HuanYingYu);
				// 设置大小
			}

			// 售票
			{
				//创建组件
				jtp_shoupiao = new JTabbedPane();
				jp_shoupiao_changan = new JPanel();
				jp_shoupiao_yanta = new JPanel();
				jp_shoupiao_gaoxin = new JPanel();
				
				Shoupiao sp=new Shoupiao();
				jp_shoupiao_changan.add(sp.Shoupiao_main());
				jp_shoupiao_yanta.add(sp.Shoupiao_main());
				jp_shoupiao_gaoxin.add(sp.Shoupiao_main());
				jtp_shoupiao.add("长安", jp_shoupiao_changan);
				jtp_shoupiao.add("雁塔", jp_shoupiao_yanta);
				jtp_shoupiao.add("高新", jp_shoupiao_gaoxin);
//				jtp_shoupiao.setBounds(10,0,1200,600);
				jp_shoupiao.add(jtp_shoupiao);
			}
			
			//座位管理
			{
				Zuowei zw = new Zuowei();
				jp_zuowei.add(zw.Zuowei_main());
			}
			
			//影片管理
			{
				Yingpian yp=new Yingpian();
				jp_yingpian.add(yp.Yingpian_all());
			}

			//放映计划
			{
				Jihua jihua = new Jihua();
				jp_jihua.add(jihua.Jihua_chaxun(), BorderLayout.NORTH);
				jp_jihua.add(jihua.Jihua_biaoge(), BorderLayout.CENTER);
				jp_jihua.add(jihua.Jihua_zengshangai(), BorderLayout.SOUTH);
			}
			
			// 员工
			{
				Yuangong yg=new Yuangong();
				jp_yuangong.add(yg.Jihua_main());
			}
			
			//统计
			{
				
			}
		}
		this.add(jl1GongSiTuPian, BorderLayout.NORTH);
		this.add(jtp, BorderLayout.CENTER);

		// 展现组件
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		ImageIcon icon = new ImageIcon("images/炜炜头像.jpg");
		this.setIconImage(icon.getImage());
		this.setSize(w, h-35);
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

	}
}