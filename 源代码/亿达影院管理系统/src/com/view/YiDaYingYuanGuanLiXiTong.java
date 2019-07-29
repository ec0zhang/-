package com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.*;
import com.service.*;

public class YiDaYingYuanGuanLiXiTong extends JFrame implements ActionListener{

	MovieModel mm;
	
	// ѡ��
	Image titelIcon;
	JMenuBar jmb;
	// һ���˵�
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	// �����˵�
	JMenuItem jmm1, jmm2, jmm3, jmm4, jmm5;
	JMenuItem jm_yuangong_chaxun, jm_yuangong_zengjia, jm_yuangong_xiugai, jm_yuangong_shanchu;
	JMenuItem jm_yingpian_tianjia,jm_yingpian_shanchu,jm_yingpian_tiqianxiajia,jm_yingpian_yanchangfangying;

	// ��������
	JLabel jl1GongSiTuPian;

	// �в�����

	// ��һ��ѡ�
	JTabbedPane jtp;
	JPanel jp_shouye, jp_shoupiao, jp_zuowei, jp_yingpian, jp_jihua, jp_yuangong, jp_tongji;

	// ��½
	JLabel jl_HuanYingYu;

	// ��Ʊ
	JTabbedPane jtp_shoupiao;
	JPanel jp_shoupiao_changan, jp_shoupiao_yanta, jp_shoupiao_gaoxin;
	
	//ӰƬ����

	//Ա������

	//����ͳ��
	JPanel jp_tongji_main,jp_tongji_anniu;
	JComboBox jcb_tongji_nian,jcb_tongji_yue,jcb_tongji_ri,jcb_tongji_location;
	
	
	JLabel jl_tongji_nian,jl_tongji_yue,jl_tongji_ri,jl_tongji_location;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		YiDaYingYuanGuanLiXiTong main = new YiDaYingYuanGuanLiXiTong();
//	}

	public YiDaYingYuanGuanLiXiTong() {
		// �������

		{// ����һ���˵�
			jm1 = new JMenu("��Ʊ����");
			// ���������˵�
			jmm1 = new JMenuItem("�����Ų�֪��ʲô�õ�1");
			jmm1.addActionListener(this);
			jmm2 = new JMenuItem("�����Ų�֪��ʲô�õ�2");
			jmm2.addActionListener(this);
			jmm3 = new JMenuItem("�����Ų�֪��ʲô�õ�3");
			jmm3.addActionListener(this);
			jmm4 = new JMenuItem("�����Ų�֪��ʲô�õ�4");
			jmm4.addActionListener(this);
			jmm5 = new JMenuItem("�����Ų�֪��ʲô�õ�5");
			jmm5.addActionListener(this);
			// ����
			jm1.add(jmm1);
			jm1.add(jmm2);
			jm1.add(jmm3);
			jm1.add(jmm4);
			jm1.add(jmm5);

			jm2 = new JMenu("��λ����");
			jm3 = new JMenu("ӰƬ����");
			jm_yingpian_tianjia=new JMenuItem("ӰƬ��ӳ�����ӰƬ");
			jm_yingpian_tianjia.addActionListener(this);
			jm_yingpian_shanchu=new JMenuItem("ӰƬ�¼ܣ�ɾ��ӰƬ");
			jm_yingpian_shanchu.addActionListener(this);
			jm_yingpian_tiqianxiajia=new JMenuItem("���Ĳ��ã�������");
			jm_yingpian_tiqianxiajia.addActionListener(this);
			jm_yingpian_yanchangfangying=new JMenuItem("����̫�ã�������Ƭ");
			jm_yingpian_yanchangfangying.addActionListener(this);
			
			jm3.add(jm_yingpian_tianjia);
			jm3.add(jm_yingpian_shanchu);
			jm3.add(jm_yingpian_tiqianxiajia);
			jm3.add(jm_yingpian_yanchangfangying);
			
			jm4 = new JMenu("��ӳ�ƻ�");
			jm5 = new JMenu("Ա������");
			// ���������˵�
			jm_yuangong_chaxun = new JMenuItem("��ѯԱ����Ϣ");
			jm_yuangong_zengjia = new JMenuItem("������Ա��");
			jm_yuangong_xiugai = new JMenuItem("�޸�Ա����Ϣ");
			jm_yuangong_shanchu = new JMenuItem("Ա����ְ��ɾ����Ϣ");
			jm5.add(jm_yuangong_chaxun);
			jm5.add(jm_yuangong_zengjia);
			jm5.add(jm_yuangong_xiugai);
			jm5.add(jm_yuangong_shanchu);

			jm6 = new JMenu("����ͳ��");

			jmb = new JMenuBar();
			jmb.add(jm1);
			jmb.add(jm2);
			jmb.add(jm3);
			jmb.add(jm4);
			jmb.add(jm5);
			jmb.add(jm6);

			// ��JMenuBar��ӵ�JFrame
			this.setJMenuBar(jmb);
		}

		// ��������
		jl1GongSiTuPian = new JLabel("��ӭʹ���ڴ�ӰԺ����ϵͳ");

		// �в���Ҫ���
		{
			// ��һ��ѡ����
			{
				// �������
				jtp = new JTabbedPane(JTabbedPane.LEFT);
				jp_shouye = new JPanel();
				jp_shoupiao = new JPanel();
				jp_zuowei = new JPanel();
				jp_yingpian = new JPanel();
				jp_jihua = new JPanel();
				jp_yuangong = new JPanel();
				jp_tongji = new JPanel();

				// ������
				jtp.add("��ӭ", jp_shouye);
//				jp_shouye.setBackground(Color.gray);
				jtp.add("��Ʊ", jp_shoupiao);
				jp_shoupiao.setBackground(Color.pink);
				jp_shoupiao.setLayout(new BorderLayout());
				jtp.add("��λ", jp_zuowei);
				jp_zuowei.setBackground(Color.yellow);
				jp_zuowei.setLayout(new BorderLayout());
				jtp.add("ӰƬ", jp_yingpian);
				jp_yingpian.setBackground(Color.green);
				jp_yingpian.setLayout(new BorderLayout());
				jtp.add("�ƻ�", jp_jihua);
				jp_jihua.setBackground(Color.cyan);
				jp_jihua.setLayout(new BorderLayout());
				jtp.add("Ա��", jp_yuangong);
				jp_yuangong.setBackground(Color.blue);
				jp_yuangong.setLayout(new BorderLayout());
				jtp.add("ͳ��", jp_tongji);
				jp_tongji.setBackground(Color.blue);
				jp_tongji.setLayout(new BorderLayout());
			}

			// ��ӭѡ�
			{
				// �������
				jl_HuanYingYu = new JLabel();
				ImageIcon wel = new ImageIcon("images/��ӭ.png");
				jl_HuanYingYu.setIcon(wel);
				jp_shouye.add(jl_HuanYingYu);
				// ���ô�С
			}

			// ��Ʊ
			{
				//�������
				jtp_shoupiao = new JTabbedPane();
				jp_shoupiao_changan = new JPanel();
				jp_shoupiao_yanta = new JPanel();
				jp_shoupiao_gaoxin = new JPanel();
				
				Shoupiao sp=new Shoupiao();
				jp_shoupiao_changan.add(sp.Shoupiao_main());
				jp_shoupiao_yanta.add(sp.Shoupiao_main());
				jp_shoupiao_gaoxin.add(sp.Shoupiao_main());
				jtp_shoupiao.add("����", jp_shoupiao_changan);
				jtp_shoupiao.add("����", jp_shoupiao_yanta);
				jtp_shoupiao.add("����", jp_shoupiao_gaoxin);
//				jtp_shoupiao.setBounds(10,0,1200,600);
				jp_shoupiao.add(jtp_shoupiao);
			}
			
			//��λ����
			{
				Zuowei zw = new Zuowei();
				jp_zuowei.add(zw.Zuowei_main());
			}
			
			//ӰƬ����
			{
				Yingpian yp=new Yingpian();
				jp_yingpian.add(yp.Yingpian_all());
			}

			//��ӳ�ƻ�
			{
				Jihua jihua = new Jihua();
				jp_jihua.add(jihua.Jihua_chaxun(), BorderLayout.NORTH);
				jp_jihua.add(jihua.Jihua_biaoge(), BorderLayout.CENTER);
				jp_jihua.add(jihua.Jihua_zengshangai(), BorderLayout.SOUTH);
			}
			
			// Ա��
			{
				Yuangong yg=new Yuangong();
				jp_yuangong.add(yg.Jihua_main());
			}
			
			//ͳ��
			{
				
			}
		}
		this.add(jl1GongSiTuPian, BorderLayout.NORTH);
		this.add(jtp, BorderLayout.CENTER);

		// չ�����
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		ImageIcon icon = new ImageIcon("images/��ͷ��.jpg");
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