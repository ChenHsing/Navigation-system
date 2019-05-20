package view;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Road extends JFrame {

	private JPanel contentPane;
	int Max = 20000;
	int NUM = 78;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Road frame = new Road();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public class ArcCell {
		int adj;
		String name;

		public ArcCell() {

		}
	}

	public class VertexType {
		int number;// ������
		String sight; // ��������

		public VertexType() {

		}
	}

	public class MGraph {
		public VertexType vex[] = new VertexType[NUM]; /* ͼ�еĶ��㣬��Ϊ���� */
		public ArcCell arcs[][] = new ArcCell[NUM][NUM]; /* ͼ�еıߣ���Ϊ�����ľ��� */
		int vexnum, arcnum; /* ������������ */

		public MGraph() {
			for (int i = 0; i < NUM; i++) {
				vex[i] = new VertexType();
			}

			for (int i = 0; i < NUM; i++) {
				for (int j = 0; j < NUM; j++) {
					arcs[i][j] = new ArcCell();
				}
			}
		}
	}

	MGraph G = new MGraph();
	int P[][] = new int[NUM][NUM]; /*  */
	long D[] = new long[NUM]; /* ���������洢���·������ */

	void CreateUDN(int v, int a, int type) /* ��ͼ���� */
	{
		int i, j;
		G.vexnum = v; /* ��ʼ���ṹ�еľ������ͱ��� */
		G.arcnum = a;
		System.out.println(G.vex[0].number);
		for (i = 0; i < G.vexnum; i++) {
			G.vex[i].number = i; /* ��ʼ��ÿһ������ı�� */
		}

		/* ��ʼ��ûһ�����������侰������ */

		G.vex[0].sight = "��԰1ի";
		G.vex[1].sight = "��԰2ի";
		G.vex[2].sight = "��԰3ի";
		G.vex[3].sight = "֪԰4ի";
		G.vex[4].sight = "֪԰5ի";
		G.vex[5].sight = "��԰6ի";
		G.vex[6].sight = "��԰7ի";
		G.vex[7].sight = "��԰8ի";
		G.vex[8].sight = "��԰9ի";
		G.vex[9].sight = "��԰10ի";
		G.vex[10].sight = "��԰11ի";
		G.vex[11].sight = "��԰12ի";
		G.vex[12].sight = "��԰13ի";
		G.vex[13].sight = "��԰14ի";
		G.vex[14].sight = "��԰15ի";
		G.vex[15].sight = "��԰16ի";
		G.vex[16].sight = "��԰17ի";
		G.vex[17].sight = "��԰18ի";
		G.vex[18].sight = "��԰19ի";
		G.vex[19].sight = "��԰20ի";
		G.vex[20].sight = "ƽ԰21ի";
		G.vex[21].sight = "ƽ԰22ի";
		G.vex[22].sight = "ƽ԰23ի";
		G.vex[23].sight = "ƽ԰24ի";
		G.vex[24].sight = "31��ѧ¥";
		G.vex[25].sight = "32��ѧ¥";
		G.vex[26].sight = "33��ѧ¥";
		G.vex[27].sight = "34��ѧ¥";
		G.vex[28].sight = "35��ѧ¥";
		G.vex[29].sight = "36��ѧ¥";
		G.vex[30].sight = "37��ѧ¥";
		G.vex[31].sight = "38��ѧ¥";
		G.vex[32].sight = "39��ѧ¥";
		G.vex[33].sight = "40��ѧ¥";
		G.vex[34].sight = "41��ѧ¥";
		G.vex[35].sight = "42��ѧ¥";
		G.vex[36].sight = "43��ѧ¥";
		G.vex[37].sight = "44��ѧ¥";
		G.vex[38].sight = "45��ѧ¥";
		G.vex[39].sight = "46��ѧ¥";
		G.vex[40].sight = "47��ѧ¥";
		G.vex[41].sight = "48��ѧ¥";
		G.vex[42].sight = "49��ѧ¥";
		G.vex[43].sight = "50��ѧ¥";
		G.vex[44].sight = "51��ѧ¥";
		G.vex[45].sight = "52��ѧ¥";
		G.vex[46].sight = "53��ѧ¥";
		G.vex[47].sight = "54��ѧ¥";
		G.vex[48].sight = "55��ѧ¥";
		G.vex[49].sight = "ѧһ(÷԰)";
		G.vex[50].sight = "ѧ��(��԰)";
		G.vex[51].sight = "ѧ��(��԰)";
		G.vex[52].sight = "ѧ��(��԰)";
		G.vex[53].sight = "ѧ��(��԰)";
		G.vex[54].sight = "ѧ��(��԰)";
		G.vex[55].sight = "��԰����";
		G.vex[56].sight = "��԰����";
		G.vex[57].sight = "��԰��";
		G.vex[58].sight = "�����";
		G.vex[59].sight = "��ҵ��";
		G.vex[60].sight = "ѧ������";
		G.vex[61].sight = "̫�׹㳡";
		G.vex[62].sight = "֣��ͼ���";
		G.vex[63].sight = "��԰";
		G.vex[64].sight = "�����ʦ��Ԣ";
		G.vex[65].sight = "УҽԺ";
		G.vex[66].sight = "�ۺ�������";
		G.vex[67].sight = "������";
		G.vex[68].sight = "������������";
		G.vex[69].sight = "����";
		G.vex[70].sight = "��ְ����������";
		G.vex[71].sight = "����㳡";
		G.vex[72].sight = "������԰";
		G.vex[73].sight = "����";
		G.vex[74].sight = "������";
		G.vex[75].sight = "����";
		G.vex[76].sight = "������";
		G.vex[77].sight = "����";

		// ��������еı߼ٶ�Ϊ20000������������������֮���ǲ��ɵ��� 
		for (i = 0; i < G.vexnum; ++i)
			for (j = 0; j < G.vexnum; ++j) {
				G.arcs[i][j].adj = Max;
	    }

	
		
		if(type==1) {
			G.arcs[0][1].adj=20;G.arcs[0][1].name="С·ֱ��";
			G.arcs[0][63].adj=25;G.arcs[0][63].name="������·";
			G.arcs[0][2].adj=30;G.arcs[0][2].name="С·ֱ��";
			G.arcs[1][0].adj=20;G.arcs[1][0].name="С·ֱ��";
			G.arcs[1][55].adj=30;G.arcs[1][55].name="��°�·";
			G.arcs[1][3].adj=37;G.arcs[1][3].name="������·";
			G.arcs[1][47].adj=37;G.arcs[1][47].name="������·";
			G.arcs[2][63].adj=25;G.arcs[2][63].name="���Ǳ�·";
			G.arcs[2][55].adj=37;G.arcs[2][55].name="������·";
			G.arcs[3][4].adj=20;G.arcs[3][4].name="С·ֱ��";
			G.arcs[3][55].adj=31;G.arcs[3][55].name="��°�·";
			G.arcs[3][54].adj=30;G.arcs[3][54].name="��°�·";
			G.arcs[3][47].adj=35;G.arcs[3][47].name="��°�·";
			G.arcs[4][3].adj=20;G.arcs[4][3].name="С·ֱ��";
			G.arcs[4][49].adj=32;G.arcs[4][49].name="���񱱵�";
			G.arcs[4][5].adj=32;G.arcs[4][5].name="������·";
			G.arcs[4][46].adj=37;G.arcs[4][46].name="���񱱵�";
			G.arcs[4][43].adj=50;G.arcs[4][43].name="���񱱵�";
			G.arcs[4][54].adj=37;G.arcs[4][54].name="С·ֱ��";
			G.arcs[5][4].adj=32;G.arcs[5][4].name="������·";
			G.arcs[5][6].adj=25;G.arcs[5][6].name="С·ֱ��";
			G.arcs[5][7].adj=37;G.arcs[5][7].name="С·ֱ��";
			G.arcs[5][43].adj=50;G.arcs[5][43].name="���񱱵�";
			G.arcs[5][46].adj=33;G.arcs[5][46].name="������·";
			G.arcs[5][49].adj=32;G.arcs[5][49].name="���񱱵�";
			G.arcs[6][5].adj=25;G.arcs[6][5].name="С·ֱ��";
			G.arcs[6][7].adj=32;G.arcs[6][7].name="С·ֱ��";
			G.arcs[6][43].adj=50;G.arcs[6][43].name="���±���";
			G.arcs[6][8].adj=60;G.arcs[6][8].name="������·��������·";
			G.arcs[6][50].adj=60;G.arcs[6][50].name="������·";
			G.arcs[7][5].adj=37;G.arcs[7][5].name="С·ֱ��";
			G.arcs[7][6].adj=32;G.arcs[7][6].name="С·ֱ��";
			G.arcs[7][48].adj=50;G.arcs[7][48].name="���±���";
			G.arcs[7][9].adj=68;G.arcs[7][9].name="���Ǳ�·��������·";
			G.arcs[7][49].adj=33;G.arcs[7][49].name="���Ǳ�·";
			G.arcs[8][9].adj=30;G.arcs[8][9].name="С·ֱ��";
			G.arcs[8][50].adj=45;G.arcs[8][50].name="Ӣ����/���Ǳ���";
			G.arcs[8][43].adj=68;G.arcs[8][43].name="������·��������·";
			G.arcs[8][6].adj=60;G.arcs[8][6].name="������·��������·";
			G.arcs[8][39].adj=22;G.arcs[8][39].name="������·";
			G.arcs[8][42].adj=22;G.arcs[8][42].name="������·";
			G.arcs[9][8].adj=30;G.arcs[9][8].name="С·ֱ��";
			G.arcs[9][7].adj=68;G.arcs[9][7].name="������·�����Ǳ�·";
			G.arcs[9][48].adj=60;G.arcs[9][48].name="������·�����Ǳ�·";
			G.arcs[9][39].adj=22;G.arcs[9][39].name="������·";
			G.arcs[9][51].adj=95;G.arcs[9][51].name="Ӣ����";
			G.arcs[9][62].adj=47;G.arcs[9][62].name="������·";
			G.arcs[10][38].adj=27;G.arcs[10][38].name="������·";
			G.arcs[10][41].adj=27;G.arcs[10][41].name="������·";
			G.arcs[10][40].adj=45;G.arcs[10][40].name="���̵�/�����ϵ�";
			G.arcs[10][11].adj=30;G.arcs[10][11].name="С·ֱ��";
			G.arcs[10][12].adj=55;G.arcs[10][12].name="������·��������·";
			G.arcs[10][30].adj=68;G.arcs[10][30].name="������·��������·";
			G.arcs[11][10].adj=30;G.arcs[11][10].name="С·ֱ��";
			G.arcs[11][38].adj=27;G.arcs[11][38].name="������·";
			G.arcs[11][41].adj=27;G.arcs[11][41].name="������·";
			G.arcs[11][62].adj=45;G.arcs[11][62].name="������·";
			G.arcs[11][37].adj=50;G.arcs[11][37].name="���̵�";
			G.arcs[11][14].adj=50;G.arcs[11][14].name="������·��������·";
			G.arcs[11][36].adj=65;G.arcs[11][36].name="������·��������·";
			G.arcs[12][10].adj=55;G.arcs[12][10].name="������·��������·";
			G.arcs[12][14].adj=30;G.arcs[12][14].name="С·ֱ��";
			G.arcs[12][13].adj=30;G.arcs[12][13].name="С·ֱ��";
			G.arcs[12][40].adj=55;G.arcs[12][40].name="������·��������·";
			G.arcs[12][30].adj=50;G.arcs[12][30].name="�����ϵ�";
			G.arcs[12][15].adj=42;G.arcs[12][15].name="С·ֱ��";
			G.arcs[13][12].adj=30;G.arcs[13][12].name="С·ֱ��";
			G.arcs[13][14].adj=42;G.arcs[13][14].name="С·ֱ��";
			G.arcs[13][15].adj=30;G.arcs[13][15].name="С·ֱ��";
			G.arcs[13][30].adj=50;G.arcs[13][30].name="�����ϵ�";
			G.arcs[13][52].adj=25;G.arcs[13][52].name="�����ϵ�";
			G.arcs[13][29].adj=40;G.arcs[13][29].name="������·";
			G.arcs[14][12].adj=30;G.arcs[14][12].name="С·ֱ��";
			G.arcs[14][13].adj=42;G.arcs[14][13].name="С·ֱ��";
			G.arcs[14][15].adj=30;G.arcs[14][15].name="С·ֱ��";
			G.arcs[14][37].adj=50;G.arcs[14][37].name="������·��������·";
			G.arcs[14][36].adj=50;G.arcs[14][36].name="�����ϵ�";
			G.arcs[14][11].adj=50;G.arcs[14][11].name="������·��������·";
			G.arcs[15][12].adj=42;G.arcs[15][12].name="С·ֱ��";
			G.arcs[15][13].adj=30;G.arcs[15][13].name="С·ֱ��";
			G.arcs[15][14].adj=30;G.arcs[15][14].name="С·ֱ��";
			G.arcs[15][36].adj=50;G.arcs[15][36].name="�����ϵ�";
			G.arcs[15][52].adj=32;G.arcs[15][52].name="������·";
			G.arcs[15][35].adj=32;G.arcs[15][35].name="������·";
			G.arcs[16][17].adj=30;G.arcs[16][17].name="��Ԫ��·/˫̨��·";
			G.arcs[16][18].adj=35;G.arcs[16][18].name="�����ϵ�";
			G.arcs[16][19].adj=30;G.arcs[16][19].name="��Ԫ��·";
			G.arcs[16][53].adj=50;G.arcs[16][53].name="��Ԫ��·����Ԫ��·";
			G.arcs[16][61].adj=55;G.arcs[16][61].name="��Ԫ��·����԰��·";
			G.arcs[16][36].adj=47;G.arcs[16][36].name="�����ϵ�";
			G.arcs[16][37].adj=50;G.arcs[16][37].name="˫̨��·";
			G.arcs[17][16].adj=30;G.arcs[17][16].name="��Ԫ��·/˫̨��·";
			G.arcs[17][18].adj=30;G.arcs[17][18].name="��Ԫ��·";
			G.arcs[17][19].adj=35;G.arcs[17][19].name="�����ϵ�";
			G.arcs[17][36].adj=47;G.arcs[17][36].name="�����ϵ�";
			G.arcs[17][35].adj=30;G.arcs[17][35].name="˫̨��·";
			G.arcs[17][77].adj=75;G.arcs[17][77].name="��Ԫ��·";
			G.arcs[18][16].adj=35;G.arcs[18][16].name="�����ϵ�";
			G.arcs[18][19].adj=30;G.arcs[18][19].name="��Ԫ��·";
			G.arcs[18][17].adj=30;G.arcs[18][17].name="��Ԫ��·";
			G.arcs[18][61].adj=55;G.arcs[18][61].name="��Ԫ��·����԰��·";
			G.arcs[18][53].adj=50;G.arcs[18][53].name="��Ԫ��·����԰��·";
			G.arcs[18][58].adj=150;G.arcs[18][58].name="��������";
			G.arcs[19][16].adj=30;G.arcs[19][16].name="��Ԫ��·";
			G.arcs[19][17].adj=35;G.arcs[19][17].name="�����ϵ�";
			G.arcs[19][18].adj=30;G.arcs[19][18].name="��Ԫ��·";
			G.arcs[19][57].adj=300;G.arcs[19][57].name="��������";
			G.arcs[19][77].adj=75;G.arcs[19][77].name="��Ԫ��·";
			G.arcs[20][21].adj=30;G.arcs[20][21].name="��Ԫ��·/˫̨��·";
			G.arcs[20][22].adj=35;G.arcs[20][22].name="���񱱵�";
			G.arcs[20][23].adj=30;G.arcs[20][23].name="��Ԫ��·";
			G.arcs[20][48].adj=25;G.arcs[20][48].name="˫̨��·";
			G.arcs[20][7].adj=93;G.arcs[20][7].name="���񱱵�";
			G.arcs[20][73].adj=118;G.arcs[20][73].name="��Ԫ��·";
			G.arcs[20][49].adj=92;G.arcs[20][49].name="���񱱵�";
			G.arcs[21][20].adj=30;G.arcs[21][20].name="��Ԫ��·/˫̨��·";
			G.arcs[21][22].adj=30;G.arcs[21][22].name="��Ԫ��·";
			G.arcs[21][23].adj=35;G.arcs[21][23].name="���±���";
			G.arcs[21][51].adj=50;G.arcs[21][51].name="��Ԫ��·����԰��·";
			G.arcs[21][48].adj=47;G.arcs[21][48].name="���±���";
			G.arcs[22][20].adj=35;G.arcs[22][20].name="���񱱵�";
			G.arcs[22][21].adj=30;G.arcs[22][21].name="��Ԫ��·";
			G.arcs[22][23].adj=30;G.arcs[22][23].name="��Ԫ��·";
			G.arcs[22][73].adj=118;G.arcs[22][73].name="��Ԫ��·";
			G.arcs[22][57].adj=162;G.arcs[22][57].name="��������";
			G.arcs[23][20].adj=30;G.arcs[23][20].name="��Ԫ��·";
			G.arcs[23][21].adj=35;G.arcs[23][21].name="���±���";
			G.arcs[23][22].adj=30;G.arcs[23][22].name="��Ԫ��·";
			G.arcs[23][57].adj=125;G.arcs[23][57].name="��������";
			G.arcs[23][58].adj=100;G.arcs[23][58].name="��������";
			G.arcs[23][51].adj=50;G.arcs[23][51].name="��Ԫ��·����Ԫ��·";
			G.arcs[24][25].adj=50;G.arcs[24][25].name="С·ֱ��";
			G.arcs[24][71].adj=75;G.arcs[24][71].name="С·ֱ��";
			G.arcs[24][59].adj=75;G.arcs[24][59].name="С·ֱ��";
			G.arcs[24][70].adj=50;G.arcs[24][70].name="С·ֱ��";
			G.arcs[24][68].adj=50;G.arcs[24][68].name="��ҵ·";
			G.arcs[25][24].adj=50;G.arcs[25][24].name="С·ֱ��";
			G.arcs[25][71].adj=57;G.arcs[25][71].name="С·ֱ��";
			G.arcs[25][26].adj=62;G.arcs[25][26].name="С·ֱ��";
			G.arcs[25][41].adj=112;G.arcs[25][41].name="���Ǵ��";
			G.arcs[25][42].adj=112;G.arcs[25][42].name="���Ǵ��";
			G.arcs[26][25].adj=62;G.arcs[26][25].name="С·ֱ��";
			G.arcs[26][71].adj=82;G.arcs[26][71].name="С·ֱ��";
			G.arcs[26][30].adj=65;G.arcs[26][30].name="������·��������·";
			G.arcs[27][72].adj=62;G.arcs[27][72].name="С·ֱ��";
			G.arcs[27][28].adj=75;G.arcs[27][28].name="�����ϵ�";
			G.arcs[27][76].adj=50;G.arcs[27][76].name="������·";
			G.arcs[28][27].adj=75;G.arcs[28][27].name="�����ϵ�";
			G.arcs[28][72].adj=87;G.arcs[28][72].name="С·ֱ��";
			G.arcs[28][29].adj=50;G.arcs[28][29].name="������·/������·";
			G.arcs[28][76].adj=62;G.arcs[28][76].name="������·";
			G.arcs[28][31].adj=10;G.arcs[28][31].name="������·";
			G.arcs[29][72].adj=87;G.arcs[29][72].name="�����ϵ�";
			G.arcs[29][28].adj=50;G.arcs[29][28].name="������·/������·";
			G.arcs[29][30].adj=50;G.arcs[29][30].name="������·/������·";
			G.arcs[29][32].adj=17;G.arcs[29][32].name="������·";
			G.arcs[29][13].adj=37;G.arcs[29][13].name="������·";
			G.arcs[30][10].adj=62;G.arcs[30][10].name="������·��������·";
			G.arcs[30][40].adj=62;G.arcs[30][40].name="������·��������·";
			G.arcs[30][12].adj=50;G.arcs[30][12].name="�����ϵ�";
			G.arcs[30][13].adj=50;G.arcs[30][13].name="�����ϵ�";
			G.arcs[30][29].adj=50;G.arcs[30][29].name="������·/������·";
			G.arcs[30][72].adj=87;G.arcs[30][72].name="�����ϵ�";
			G.arcs[30][26].adj=75;G.arcs[30][26].name="�����ϵ�";
			G.arcs[31][28].adj=10;G.arcs[31][28].name="������·";
			G.arcs[31][32].adj=25;G.arcs[31][32].name="������·/������·";
			G.arcs[31][33].adj=12;G.arcs[31][33].name="������·";
			G.arcs[32][31].adj=25;G.arcs[32][31].name="������·/������·";
			G.arcs[32][33].adj=15;G.arcs[32][33].name="������·";
			G.arcs[32][34].adj=10;G.arcs[32][34].name="������·";
			G.arcs[32][29].adj=12;G.arcs[32][29].name="������·";
			G.arcs[32][52].adj=20;G.arcs[32][52].name="������·";
			G.arcs[33][31].adj=12;G.arcs[33][31].name="������·";
			G.arcs[33][32].adj=15;G.arcs[33][32].name="������·";
			G.arcs[33][34].adj=17;G.arcs[33][34].name="������·/˫̨��·";
			G.arcs[33][77].adj=75;G.arcs[33][77].name="�����ϵ�";
			G.arcs[34][33].adj=17;G.arcs[34][33].name="������·/˫̨��·";
			G.arcs[34][32].adj=10;G.arcs[34][32].name="������·";
			G.arcs[34][35].adj=25;G.arcs[34][35].name="������·/˫̨��·";
			G.arcs[34][52].adj=25;G.arcs[34][52].name="������·";
			G.arcs[35][36].adj=50;G.arcs[35][36].name="������·/˫̨��·";
			G.arcs[35][34].adj=25;G.arcs[35][34].name="������·/˫̨��·";
			G.arcs[35][52].adj=5;G.arcs[35][52].name="������·";
			G.arcs[35][15].adj=50;G.arcs[35][15].name="�����ϵ�";
			G.arcs[35][17].adj=50;G.arcs[35][17].name="�����ϵ�";
			G.arcs[36][35].adj=50;G.arcs[36][35].name="������·/˫̨��·";
			G.arcs[36][52].adj=50;G.arcs[36][52].name="������·";
			G.arcs[36][15].adj=50;G.arcs[36][15].name="������·";
			G.arcs[36][17].adj=47;G.arcs[36][17].name="������·";
			G.arcs[36][14].adj=50;G.arcs[36][14].name="������·";
			G.arcs[36][16].adj=47;G.arcs[36][16].name="������·";
			G.arcs[36][37].adj=62;G.arcs[36][37].name="������·��������·";
			G.arcs[36][11].adj=65;G.arcs[36][11].name="������·��������·";
			G.arcs[37][36].adj=62;G.arcs[37][36].name="������·��������·";
			G.arcs[37][11].adj=50;G.arcs[37][11].name="���̵�";
			G.arcs[37][53].adj=25;G.arcs[37][53].name="���̵�/�����ϵ�";
			G.arcs[37][62].adj=50;G.arcs[37][62].name="������·/˫̨��·";
			G.arcs[38][11].adj=27;G.arcs[38][11].name="������·";
			G.arcs[38][10].adj=27;G.arcs[38][10].name="������·";
			G.arcs[38][62].adj=50;G.arcs[38][62].name="������·";
			G.arcs[38][39].adj=25;G.arcs[38][39].name="������·/������·";
			G.arcs[38][11].adj=27;G.arcs[38][11].name="������·";
			G.arcs[38][40].adj=27;G.arcs[38][40].name="������·";
			G.arcs[38][41].adj=25;G.arcs[38][41].name="������·";
			G.arcs[38][42].adj=25;G.arcs[38][42].name="������·";
			G.arcs[39][62].adj=50;G.arcs[39][62].name="������·";
			G.arcs[39][38].adj=25;G.arcs[39][38].name="������·/������·";
			G.arcs[39][42].adj=25;G.arcs[39][42].name="������·";
			G.arcs[39][41].adj=25;G.arcs[39][41].name="������·";
			G.arcs[39][8].adj=22;G.arcs[39][8].name="������·";
			G.arcs[39][9].adj=22;G.arcs[39][9].name="������·";
			G.arcs[39][50].adj=50;G.arcs[39][50].name="���Ǳ���";
			G.arcs[40][10].adj=45;G.arcs[40][10].name="������·";
			G.arcs[40][12].adj=55;G.arcs[40][12].name="������·��������·";
			G.arcs[40][30].adj=62;G.arcs[40][30].name="������·��������·";
			G.arcs[40][38].adj=27;G.arcs[40][38].name="������·";
			G.arcs[40][41].adj=27;G.arcs[40][41].name="������·";
			G.arcs[41][38].adj=25;G.arcs[41][38].name="������·";
			G.arcs[41][40].adj=27;G.arcs[41][40].name="������·";
			G.arcs[41][10].adj=27;G.arcs[41][10].name="������·";
			G.arcs[41][39].adj=25;G.arcs[41][39].name="������·";
			G.arcs[41][42].adj=25;G.arcs[41][42].name="������·";
			G.arcs[41][25].adj=112;G.arcs[41][25].name="���Ǵ��";
			G.arcs[42][39].adj=25;G.arcs[42][39].name="������·";
			G.arcs[42][41].adj=25;G.arcs[42][41].name="������·";
			G.arcs[42][38].adj=25;G.arcs[42][38].name="������·";
			G.arcs[42][8].adj=22;G.arcs[42][8].name="������·";
			G.arcs[42][50].adj=22;G.arcs[42][50].name="������·";
			G.arcs[42][25].adj=112;G.arcs[42][25].name="���Ǵ��";
			G.arcs[43][5].adj=50;G.arcs[43][5].name="���񱱵�";
			G.arcs[43][6].adj=50;G.arcs[43][6].name="���±���";
			G.arcs[43][8].adj=68;G.arcs[43][8].name="������·��������·";
			G.arcs[43][50].adj=68;G.arcs[43][50].name="������·��������·";
			G.arcs[43][4].adj=50;G.arcs[43][4].name="������·";
			G.arcs[43][46].adj=45;G.arcs[43][46].name="������·";
			G.arcs[43][44].adj=50;G.arcs[43][44].name="���ı�·";
			G.arcs[43][68].adj=62;G.arcs[43][68].name="���񱱵�/���±���";
			G.arcs[44][45].adj=37;G.arcs[44][45].name="С·ֱ��";
			G.arcs[44][46].adj=25;G.arcs[44][46].name="С·ֱ��";
			G.arcs[44][47].adj=37;G.arcs[44][47].name="С·ֱ��";
			G.arcs[44][43].adj=50;G.arcs[44][43].name="���ı�·";
			G.arcs[44][68].adj=62;G.arcs[44][68].name="���񱱵�";
			G.arcs[44][45].adj=37;G.arcs[44][45].name="С·ֱ��";
			G.arcs[44][66].adj=40;G.arcs[44][66].name="���񱱵�";
			G.arcs[45][44].adj=37;G.arcs[45][44].name="С·ֱ��";
			G.arcs[45][66].adj=40;G.arcs[45][66].name="��°�·";
			G.arcs[45][47].adj=30;G.arcs[45][47].name="С·ֱ��";
			G.arcs[45][46].adj=50;G.arcs[45][46].name="С·ֱ��";
			G.arcs[46][44].adj=25;G.arcs[46][44].name="С·ֱ��";
			G.arcs[46][45].adj=50;G.arcs[46][45].name="С·ֱ��";
			G.arcs[46][47].adj=32;G.arcs[46][47].name="С·ֱ��";
			G.arcs[46][4].adj=37;G.arcs[46][4].name="���񱱵�";
			G.arcs[46][43].adj=45;G.arcs[46][43].name="������·";
			G.arcs[46][5].adj=33;G.arcs[46][5].name="������·";
			G.arcs[47][44].adj=37;G.arcs[47][44].name="С·ֱ��";
			G.arcs[47][45].adj=30;G.arcs[47][45].name="С·ֱ��";
			G.arcs[47][46].adj=32;G.arcs[47][46].name="С·ֱ��";
			G.arcs[47][3].adj=35;G.arcs[47][3].name="��°�·";
			G.arcs[47][1].adj=37;G.arcs[47][1].name="������·";
			G.arcs[48][7].adj=50;G.arcs[48][7].name="���±���";
			G.arcs[48][20].adj=25;G.arcs[48][20].name="˫̨��·";
			G.arcs[48][21].adj=47;G.arcs[48][21].name="���±���";
			G.arcs[48][9].adj=60;G.arcs[48][9].name="���Ǳ�·��������·";
			G.arcs[49][4].adj=32;G.arcs[49][4].name="���񱱵�";
			G.arcs[49][54].adj=17;G.arcs[49][54].name="���Ǳ�·";
			G.arcs[49][5].adj=32;G.arcs[49][5].name="���񱱵�";
			G.arcs[49][7].adj=33;G.arcs[49][7].name="���Ǳ�·";
			G.arcs[49][20].adj=92;G.arcs[49][20].name="���񱱵�";
			G.arcs[50][8].adj=45;G.arcs[50][8].name="��Ӣ��/���Ǳ���";
			G.arcs[50][39].adj=22;G.arcs[50][39].name="������·";
			G.arcs[50][42].adj=22;G.arcs[50][42].name="������·";
			G.arcs[50][6].adj=60;G.arcs[50][6].name="������·��������·";
			G.arcs[50][43].adj=68;G.arcs[50][43].name="������·��������·";
			G.arcs[51][9].adj=95;G.arcs[51][9].name="��Ӣ��";
			G.arcs[51][62].adj=42;G.arcs[51][62].name="˫̨��·";
			G.arcs[51][60].adj=37;G.arcs[51][60].name="��Ԫ��·";
			G.arcs[51][21].adj=50;G.arcs[51][21].name="��Ԫ��·����Ԫ��·";
			G.arcs[51][23].adj=50;G.arcs[51][23].name="��Ԫ��·����Ԫ��·";
			G.arcs[52][32].adj=20;G.arcs[52][32].name="������·";
			G.arcs[52][34].adj=25;G.arcs[52][34].name="������·";
			G.arcs[52][35].adj=5;G.arcs[52][35].name="������·";
			G.arcs[52][13].adj=25;G.arcs[52][13].name="�����ϵ�";
			G.arcs[52][15].adj=32;G.arcs[52][15].name="������·";
			G.arcs[52][36].adj=50;G.arcs[52][36].name="������·";
			G.arcs[53][61].adj=25;G.arcs[53][61].name="��԰��·";
			G.arcs[53][37].adj=25;G.arcs[53][37].name="�����ϵ�/���̵�";
			G.arcs[53][62].adj=47;G.arcs[53][62].name="˫̨��·";
			G.arcs[53][16].adj=50;G.arcs[53][16].name="��Ԫ��·����Ԫ��·";
			G.arcs[53][18].adj=50;G.arcs[53][18].name="��Ԫ��·����Ԫ��·";
			G.arcs[54][49].adj=17;G.arcs[54][49].name="���Ǳ�·";
			G.arcs[54][3].adj=30;G.arcs[54][3].name="��°�·";
			G.arcs[54][4].adj=37;G.arcs[54][4].name="С·ֱ��";
			G.arcs[54][55].adj=25;G.arcs[54][55].name="���Ǳ�·";
			G.arcs[54][49].adj=17;G.arcs[54][49].name="���Ǳ�·";
			G.arcs[55][54].adj=25;G.arcs[55][54].name="���Ǳ�·";
			G.arcs[55][1].adj=30;G.arcs[55][1].name="��°�·";
			G.arcs[55][2].adj=31;G.arcs[55][2].name="���Ǳ�·";
			G.arcs[55][3].adj=37;G.arcs[55][3].name="��°�·";
			G.arcs[56][66].adj=25;G.arcs[56][66].name="��°�·";
			G.arcs[56][65].adj=25;G.arcs[56][65].name="��°�·";
			G.arcs[56][67].adj=75;G.arcs[56][67].name="���ƶ���";
			G.arcs[56][74].adj=62;G.arcs[56][74].name="��°�·";
			G.arcs[56][64].adj=30;G.arcs[56][64].name="���ı�·/���ƶ���";
			G.arcs[57][58].adj=50;G.arcs[57][58].name="��������";
			G.arcs[57][22].adj=162;G.arcs[57][22].name="��������";
			G.arcs[57][23].adj=125;G.arcs[57][23].name="��������";
			G.arcs[58][57].adj=50;G.arcs[58][57].name="��������";
			G.arcs[58][23].adj=100;G.arcs[58][23].name="��������";
			G.arcs[58][18].adj=150;G.arcs[58][18].name="��������";
			G.arcs[58][60].adj=37;G.arcs[58][60].name="С·ֱ��";
			G.arcs[59][69].adj=62;G.arcs[59][69].name="С·ֱ��";
			G.arcs[59][70].adj=50;G.arcs[59][70].name="С·ֱ��";
			G.arcs[59][24].adj=50;G.arcs[59][24].name="���±���";
			G.arcs[59][67].adj=50;G.arcs[59][67].name="���񱱵�";
			G.arcs[59][71].adj=87;G.arcs[59][71].name="��ѧ·";
			G.arcs[60][58].adj=37;G.arcs[60][58].name="С·ֱ��";
			G.arcs[60][61].adj=50;G.arcs[60][61].name="С·ֱ��";
			G.arcs[60][51].adj=37;G.arcs[60][51].name="��Ԫ��·";
			G.arcs[61][60].adj=50;G.arcs[61][60].name="С·ֱ��";
			G.arcs[61][16].adj=55;G.arcs[61][16].name="��Ԫ��·����Ԫ��·";
			G.arcs[61][18].adj=55;G.arcs[61][18].name="��Ԫ��·����Ԫ��·";
			G.arcs[61][53].adj=25;G.arcs[61][53].name="��Ԫ��·";
			G.arcs[62][9].adj=47;G.arcs[62][9].name="������·";
			G.arcs[62][11].adj=45;G.arcs[62][11].name="������·";
			G.arcs[62][37].adj=50;G.arcs[62][37].name="������·/˫̨��·";
			G.arcs[62][38].adj=50;G.arcs[62][38].name="������·";
			G.arcs[62][39].adj=50;G.arcs[62][39].name="������·";
			G.arcs[62][51].adj=42;G.arcs[62][51].name="˫̨��·";
			G.arcs[62][53].adj=47;G.arcs[62][53].name="˫̨��·";
			G.arcs[63][0].adj=25;G.arcs[63][0].name="������·";
			G.arcs[63][2].adj=25;G.arcs[63][2].name="���Ǳ�·";
			G.arcs[63][73].adj=100;G.arcs[63][73].name="���Ʊ���";
			G.arcs[63][64].adj=145;G.arcs[63][64].name="���Ʊ���";
			G.arcs[64][56].adj=30;G.arcs[64][56].name="���ı�·/���ƶ���";
			G.arcs[64][63].adj=145;G.arcs[64][63].name="���Ʊ���";
			G.arcs[64][74].adj=50;G.arcs[64][74].name="���ƶ���";
			G.arcs[65][56].adj=25;G.arcs[64][56].name="��°�·";
			G.arcs[65][66].adj=50;G.arcs[65][66].name="С·ֱ��";
			G.arcs[65][67].adj=50;G.arcs[65][67].name="С·ֱ��";
			G.arcs[65][74].adj=50;G.arcs[65][74].name="��°�·";
			G.arcs[66][65].adj=50;G.arcs[66][65].name="С·ֱ��";
			G.arcs[66][56].adj=25;G.arcs[66][56].name="��°�·";
			G.arcs[66][67].adj=50;G.arcs[66][67].name="С·ֱ��";
			G.arcs[66][44].adj=40;G.arcs[66][44].name="���񱱵�";
			G.arcs[66][45].adj=40;G.arcs[66][45].name="��°�·";
			G.arcs[66][68].adj=75;G.arcs[66][68].name="���ı�·";
			G.arcs[67][66].adj=50;G.arcs[67][66].name="С·ֱ��";
			G.arcs[67][59].adj=50;G.arcs[67][59].name="���񱱵�";
			G.arcs[67][69].adj=37;G.arcs[67][69].name="���񱱵�";
			G.arcs[67][68].adj=50;G.arcs[67][68].name="���񱱵�";
			G.arcs[67][65].adj=50;G.arcs[67][65].name="С·ֱ��";
			G.arcs[67][74].adj=75;G.arcs[67][74].name="���ƶ���";
			G.arcs[68][67].adj=50;G.arcs[68][67].name="���񱱵�";
			G.arcs[68][66].adj=75;G.arcs[68][66].name="���ı�·";
			G.arcs[68][69].adj=15;G.arcs[68][69].name="��ҵ·";
			G.arcs[68][43].adj=62;G.arcs[68][43].name="���񱱵�/���±���";
			G.arcs[68][44].adj=62;G.arcs[68][44].name="���ı�·";
			G.arcs[68][24].adj=50;G.arcs[68][24].name="��ҵ·";
			G.arcs[69][68].adj=15;G.arcs[69][68].name="��ҵ·";
			G.arcs[69][67].adj=37;G.arcs[69][67].name="���񱱵�";
			G.arcs[69][59].adj=62;G.arcs[69][59].name="С·ֱ��";
			G.arcs[69][70].adj=25;G.arcs[69][70].name="С·ֱ��";
			G.arcs[70][69].adj=25;G.arcs[70][69].name="С·ֱ��";
			G.arcs[70][59].adj=50;G.arcs[70][59].name="С·ֱ��";
			G.arcs[70][24].adj=50;G.arcs[70][24].name="С·ֱ��";
			G.arcs[71][24].adj=75;G.arcs[71][24].name="С·ֱ��";
			G.arcs[71][25].adj=57;G.arcs[71][25].name="С·ֱ��";
			G.arcs[71][26].adj=82;G.arcs[71][26].name="С·ֱ��";
			G.arcs[71][75].adj=75;G.arcs[71][75].name="С·ֱ��";
			G.arcs[72][27].adj=62;G.arcs[72][27].name="С·ֱ��";
			G.arcs[72][28].adj=87;G.arcs[72][28].name="С·ֱ��";
			G.arcs[72][29].adj=87;G.arcs[72][29].name="�����ϵ�";
			G.arcs[72][30].adj=87;G.arcs[72][30].name="�����ϵ�";
			G.arcs[73][63].adj=100;G.arcs[73][63].name="���Ʊ���";
			G.arcs[73][20].adj=118;G.arcs[73][20].name="��Ԫ��·";
			G.arcs[73][22].adj=118;G.arcs[73][22].name="��Ԫ��·";
			G.arcs[74][64].adj=50;G.arcs[74][64].name="���ƶ���";
			G.arcs[74][65].adj=50;G.arcs[74][65].name="��°�·";
			G.arcs[74][67].adj=75;G.arcs[74][67].name="���ƶ���";
			G.arcs[74][56].adj=62;G.arcs[74][56].name="��°�·";
			G.arcs[75][71].adj=75;G.arcs[75][71].name="С·ֱ��";
			G.arcs[76][27].adj=50;G.arcs[76][27].name="������·";
			G.arcs[76][28].adj=62;G.arcs[76][28].name="������·";
			G.arcs[77][17].adj=75;G.arcs[77][17].name="��Ԫ��·";
			G.arcs[77][19].adj=75;G.arcs[77][19].name="��Ԫ��·";
			G.arcs[77][33].adj=75;G.arcs[77][33].name="�����ϵ�";
		}else {

			G.arcs[0][1].adj = 20;
			G.arcs[0][1].name = "������·";
			G.arcs[0][63].adj = 25;
			G.arcs[0][63].name = "������·";
			G.arcs[1][0].adj = 20;
			G.arcs[1][0].name = "������·";
			G.arcs[1][55].adj = 30;
			G.arcs[1][55].name = "��°�·";
			G.arcs[1][3].adj = 37;
			G.arcs[1][3].name = "������·";
			G.arcs[1][47].adj = 37;
			G.arcs[1][47].name = "������·";
			G.arcs[2][63].adj = 25;
			G.arcs[2][63].name = "���Ǳ�·";
			G.arcs[2][55].adj = 37;
			G.arcs[2][55].name = "������·";
			G.arcs[3][4].adj = 20;
			G.arcs[3][4].name = "������·";
			G.arcs[3][55].adj = 31;
			G.arcs[3][55].name = "��°�·";
			G.arcs[3][54].adj = 30;
			G.arcs[3][54].name = "��°�·";
			G.arcs[3][47].adj = 35;
			G.arcs[3][47].name = "��°�·";
			G.arcs[4][3].adj = 20;
			G.arcs[4][3].name = "������·";
			G.arcs[4][49].adj = 32;
			G.arcs[4][49].name = "���񱱵�";
			G.arcs[4][5].adj = 32;
			G.arcs[4][5].name = "������·";
			G.arcs[4][46].adj = 37;
			G.arcs[4][46].name = "���񱱵�";
			G.arcs[4][43].adj = 50;
			G.arcs[4][43].name = "���񱱵�";
			G.arcs[5][4].adj = 32;
			G.arcs[5][4].name = "������·";
			G.arcs[5][6].adj = 25;
			G.arcs[5][6].name = "������·";
			G.arcs[5][7].adj = 37;
			G.arcs[5][7].name = "���񱱵�";
			G.arcs[5][43].adj = 50;
			G.arcs[5][43].name = "���񱱵�";
			G.arcs[5][46].adj = 33;
			G.arcs[5][46].name = "������·";
			G.arcs[5][49].adj = 32;
			G.arcs[5][49].name = "���񱱵�";
			G.arcs[6][5].adj = 25;
			G.arcs[6][5].name = "������·";
			G.arcs[6][7].adj = 32;
			G.arcs[6][7].name = "������·";
			G.arcs[6][43].adj = 50;
			G.arcs[6][43].name = "���±���";
			G.arcs[6][50].adj = 60;
			G.arcs[6][50].name = "������·";
			G.arcs[7][5].adj = 37;
			G.arcs[7][5].name = "���񱱵�";
			G.arcs[7][6].adj = 32;
			G.arcs[7][6].name = "���±���";
			G.arcs[7][48].adj = 50;
			G.arcs[7][48].name = "���±���";
			G.arcs[7][49].adj = 33;
			G.arcs[7][49].name = "���Ǳ�·";
			G.arcs[12][14].adj = 30;
			G.arcs[12][14].name = "�����ϵ�";
			G.arcs[12][13].adj = 30;
			G.arcs[12][13].name = "������·";
			G.arcs[12][30].adj = 50;
			G.arcs[12][30].name = "�����ϵ�";
			G.arcs[13][12].adj = 30;
			G.arcs[13][12].name = "������·";
			G.arcs[13][15].adj = 30;
			G.arcs[13][15].name = "�����ϵ�";
			G.arcs[13][30].adj = 50;
			G.arcs[13][30].name = "�����ϵ�";
			G.arcs[13][52].adj = 25;
			G.arcs[13][52].name = "�����ϵ�";
			G.arcs[13][29].adj = 40;
			G.arcs[13][29].name = "������·";
			G.arcs[14][12].adj = 30;
			G.arcs[14][12].name = "�����ϵ�";
			G.arcs[14][15].adj = 30;
			G.arcs[14][15].name = "������·";
			G.arcs[14][36].adj = 50;
			G.arcs[14][36].name = "�����ϵ�";
			G.arcs[15][13].adj = 30;
			G.arcs[15][13].name = "�����ϵ�";
			G.arcs[15][14].adj = 30;
			G.arcs[15][14].name = "������·";
			G.arcs[15][36].adj = 50;
			G.arcs[15][36].name = "�����ϵ�";
			G.arcs[15][52].adj = 32;
			G.arcs[15][52].name = "������·";
			G.arcs[15][35].adj = 32;
			G.arcs[15][35].name = "������·";
			G.arcs[16][17].adj = 30;
			G.arcs[16][17].name = "��Ԫ��·/˫̨��·";
			G.arcs[16][18].adj = 35;
			G.arcs[16][18].name = "�����ϵ�";
			G.arcs[16][19].adj = 30;
			G.arcs[16][19].name = "��Ԫ��·";
			G.arcs[16][53].adj = 50;
			G.arcs[16][53].name = "��Ԫ��·����Ԫ��·";
			G.arcs[16][61].adj = 55;
			G.arcs[16][61].name = "��Ԫ��·����԰��·";
			G.arcs[16][36].adj = 47;
			G.arcs[16][36].name = "�����ϵ�";
			G.arcs[17][16].adj = 30;
			G.arcs[17][16].name = "��Ԫ��·/˫̨��·";
			G.arcs[17][18].adj = 30;
			G.arcs[17][18].name = "��Ԫ��·";
			G.arcs[17][19].adj = 35;
			G.arcs[17][19].name = "�����ϵ�";
			G.arcs[17][36].adj = 47;
			G.arcs[17][36].name = "�����ϵ�";
			G.arcs[17][35].adj = 30;
			G.arcs[17][35].name = "˫̨��·";
			G.arcs[17][77].adj = 75;
			G.arcs[17][77].name = "��Ԫ��·";
			G.arcs[18][16].adj = 35;
			G.arcs[18][16].name = "�����ϵ�";
			G.arcs[18][19].adj = 30;
			G.arcs[18][19].name = "��Ԫ��·";
			G.arcs[18][17].adj = 30;
			G.arcs[18][17].name = "��Ԫ��·";
			G.arcs[18][61].adj = 55;
			G.arcs[18][61].name = "��Ԫ��·����԰��·";
			G.arcs[18][53].adj = 50;
			G.arcs[18][53].name = "��Ԫ��·����԰��·";
			G.arcs[18][58].adj = 150;
			G.arcs[18][58].name = "��������";
			G.arcs[19][16].adj = 30;
			G.arcs[19][16].name = "��Ԫ��·";
			G.arcs[19][17].adj = 35;
			G.arcs[19][17].name = "�����ϵ�";
			G.arcs[19][18].adj = 30;
			G.arcs[19][18].name = "��Ԫ��·";
			G.arcs[19][57].adj = 300;
			G.arcs[19][57].name = "��������";
			G.arcs[19][77].adj = 75;
			G.arcs[19][77].name = "��Ԫ��·";
			G.arcs[20][21].adj = 30;
			G.arcs[20][21].name = "��Ԫ��·/˫̨��·";
			G.arcs[20][22].adj = 35;
			G.arcs[20][22].name = "���񱱵�";
			G.arcs[20][23].adj = 30;
			G.arcs[20][23].name = "��Ԫ��·";
			G.arcs[20][48].adj = 25;
			G.arcs[20][48].name = "˫̨��·";
			G.arcs[20][7].adj = 93;
			G.arcs[20][7].name = "���񱱵�";
			G.arcs[20][73].adj = 118;
			G.arcs[20][73].name = "��Ԫ��·";
			G.arcs[20][49].adj = 92;
			G.arcs[20][49].name = "���񱱵�";
			G.arcs[21][20].adj = 30;
			G.arcs[21][20].name = "��Ԫ��·/˫̨��·";
			G.arcs[21][22].adj = 30;
			G.arcs[21][22].name = "��Ԫ��·";
			G.arcs[21][23].adj = 35;
			G.arcs[21][23].name = "���±���";
			G.arcs[21][51].adj = 50;
			G.arcs[21][51].name = "��Ԫ��·����԰��·";
			G.arcs[21][48].adj = 47;
			G.arcs[21][48].name = "���±���";
			G.arcs[22][20].adj = 35;
			G.arcs[22][20].name = "���񱱵�";
			G.arcs[22][21].adj = 30;
			G.arcs[22][21].name = "��Ԫ��·";
			G.arcs[22][23].adj = 30;
			G.arcs[22][23].name = "��Ԫ��·";
			G.arcs[22][73].adj = 118;
			G.arcs[22][73].name = "��Ԫ��·";
			G.arcs[22][57].adj = 162;
			G.arcs[22][57].name = "��������";
			G.arcs[23][20].adj = 30;
			G.arcs[23][20].name = "��Ԫ��·";
			G.arcs[23][21].adj = 35;
			G.arcs[23][21].name = "���±���";
			G.arcs[23][22].adj = 30;
			G.arcs[23][22].name = "��Ԫ��·";
			G.arcs[23][57].adj = 125;
			G.arcs[23][57].name = "��������";
			G.arcs[23][58].adj = 100;
			G.arcs[23][58].name = "��������";
			G.arcs[23][51].adj = 50;
			G.arcs[23][51].name = "��Ԫ��·����Ԫ��·";
			G.arcs[24][25].adj = 50;
			G.arcs[24][25].name = "��ҵ·��������·";
			G.arcs[24][71].adj = 75;
			G.arcs[24][71].name = "��Ļ�·";
			G.arcs[24][68].adj = 50;
			G.arcs[24][68].name = "��ҵ·";
			G.arcs[25][24].adj = 50;
			G.arcs[25][24].name = "������·����ҵ·";
			G.arcs[25][71].adj = 57;
			G.arcs[25][71].name = "С·ֱ��";
			G.arcs[25][26].adj = 62;
			G.arcs[25][26].name = "������·";
			G.arcs[25][41].adj = 112;
			G.arcs[25][41].name = "���Ǵ��";
			G.arcs[25][42].adj = 112;
			G.arcs[25][42].name = "���Ǵ��";
			G.arcs[26][25].adj = 62;
			G.arcs[26][25].name = "������·";
			G.arcs[26][71].adj = 82;
			G.arcs[26][71].name = "�ɵ»�·";
			G.arcs[26][30].adj = 65;
			G.arcs[26][30].name = "������·��������·";
			G.arcs[27][72].adj = 62;
			G.arcs[27][72].name = "������·";
			G.arcs[27][28].adj = 75;
			G.arcs[27][28].name = "�����ϵ�";
			G.arcs[27][76].adj = 50;
			G.arcs[27][76].name = "������·";
			G.arcs[28][27].adj = 75;
			G.arcs[28][27].name = "�����ϵ�";
			G.arcs[28][72].adj = 87;
			G.arcs[28][72].name = "������·";
			G.arcs[28][29].adj = 50;
			G.arcs[28][29].name = "������·/������·";
			G.arcs[28][76].adj = 62;
			G.arcs[28][76].name = "������·";
			G.arcs[28][31].adj = 10;
			G.arcs[28][31].name = "������·";
			G.arcs[29][72].adj = 87;
			G.arcs[29][72].name = "�����ϵ�";
			G.arcs[29][28].adj = 50;
			G.arcs[29][28].name = "������·/������·";
			G.arcs[29][30].adj = 50;
			G.arcs[29][30].name = "������·/������·";
			G.arcs[29][32].adj = 17;
			G.arcs[29][32].name = "������·";
			G.arcs[29][13].adj = 37;
			G.arcs[29][13].name = "������·";
			G.arcs[30][12].adj = 50;
			G.arcs[30][12].name = "�����ϵ�";
			G.arcs[30][13].adj = 50;
			G.arcs[30][13].name = "�����ϵ�";
			G.arcs[30][29].adj = 50;
			G.arcs[30][29].name = "������·/������·";
			G.arcs[30][72].adj = 87;
			G.arcs[30][72].name = "�����ϵ�";
			G.arcs[30][26].adj = 75;
			G.arcs[30][26].name = "�����ϵ�";
			G.arcs[31][28].adj = 10;
			G.arcs[31][28].name = "������·";
			G.arcs[31][32].adj = 25;
			G.arcs[31][32].name = "������·/������·";
			G.arcs[31][33].adj = 12;
			G.arcs[31][33].name = "������·";
			G.arcs[32][31].adj = 25;
			G.arcs[32][31].name = "������·/������·";
			G.arcs[32][33].adj = 15;
			G.arcs[32][33].name = "������·";
			G.arcs[32][34].adj = 10;
			G.arcs[32][34].name = "������·";
			G.arcs[32][29].adj = 12;
			G.arcs[32][29].name = "������·";
			G.arcs[32][52].adj = 20;
			G.arcs[32][52].name = "������·";
			G.arcs[33][31].adj = 12;
			G.arcs[33][31].name = "������·";
			G.arcs[33][32].adj = 15;
			G.arcs[33][32].name = "������·";
			G.arcs[33][34].adj = 17;
			G.arcs[33][34].name = "������·/˫̨��·";
			G.arcs[33][77].adj = 75;
			G.arcs[33][77].name = "�����ϵ�";
			G.arcs[34][33].adj = 17;
			G.arcs[34][33].name = "������·/˫̨��·";
			G.arcs[34][32].adj = 10;
			G.arcs[34][32].name = "������·";
			G.arcs[34][35].adj = 25;
			G.arcs[34][35].name = "������·/˫̨��·";
			G.arcs[34][52].adj = 25;
			G.arcs[34][52].name = "������·";
			G.arcs[35][36].adj = 50;
			G.arcs[35][36].name = "������·/˫̨��·";
			G.arcs[35][34].adj = 25;
			G.arcs[35][34].name = "������·/˫̨��·";
			G.arcs[35][52].adj = 5;
			G.arcs[35][52].name = "������·";
			G.arcs[35][15].adj = 50;
			G.arcs[35][15].name = "�����ϵ�";
			G.arcs[35][17].adj = 50;
			G.arcs[35][17].name = "�����ϵ�";
			G.arcs[36][35].adj = 50;
			G.arcs[36][35].name = "������·/˫̨��·";
			G.arcs[36][52].adj = 50;
			G.arcs[36][52].name = "������·";
			G.arcs[36][15].adj = 50;
			G.arcs[36][15].name = "������·";
			G.arcs[36][17].adj = 47;
			G.arcs[36][17].name = "������·";
			G.arcs[36][14].adj = 50;
			G.arcs[36][14].name = "������·";
			G.arcs[36][16].adj = 47;
			G.arcs[36][16].name = "������·";
			G.arcs[39][50].adj = 50;
			G.arcs[39][50].name = "���Ǳ���";
			G.arcs[41][25].adj = 112;
			G.arcs[41][25].name = "���Ǵ��";
			G.arcs[42][25].adj = 112;
			G.arcs[42][25].name = "���Ǵ��";
			G.arcs[43][5].adj = 50;
			G.arcs[43][5].name = "���񱱵�";
			G.arcs[43][6].adj = 50;
			G.arcs[43][6].name = "���±���";
			G.arcs[43][4].adj = 50;
			G.arcs[43][4].name = "������·";
			G.arcs[43][46].adj = 45;
			G.arcs[43][46].name = "������·";
			G.arcs[43][44].adj = 50;
			G.arcs[43][44].name = "���ı�·";
			G.arcs[43][68].adj = 62;
			G.arcs[43][68].name = "���񱱵�/���±���";
			G.arcs[44][45].adj = 37;
			G.arcs[44][45].name = "���ı�·";
			G.arcs[44][46].adj = 25;
			G.arcs[44][46].name = "���񱱵�";
			G.arcs[44][43].adj = 50;
			G.arcs[44][43].name = "���ı�·";
			G.arcs[44][68].adj = 62;
			G.arcs[44][68].name = "���񱱵�";
			G.arcs[44][45].adj = 37;
			G.arcs[44][45].name = "���ı�·";
			G.arcs[44][66].adj = 40;
			G.arcs[44][66].name = "���񱱵�";
			G.arcs[45][44].adj = 37;
			G.arcs[45][44].name = "���ı�·";
			G.arcs[45][66].adj = 40;
			G.arcs[45][66].name = "��°�·";
			G.arcs[45][47].adj = 30;
			G.arcs[45][47].name = "��°�·";
			G.arcs[46][44].adj = 25;
			G.arcs[46][44].name = "���񱱵�";
			G.arcs[46][47].adj = 32;
			G.arcs[46][47].name = "������·";
			G.arcs[46][4].adj = 37;
			G.arcs[46][4].name = "���񱱵�";
			G.arcs[46][43].adj = 45;
			G.arcs[46][43].name = "������·";
			G.arcs[46][5].adj = 33;
			G.arcs[46][5].name = "������·";
			G.arcs[47][45].adj = 30;
			G.arcs[47][45].name = "��°�·";
			G.arcs[47][46].adj = 32;
			G.arcs[47][46].name = "������·";
			G.arcs[47][3].adj = 35;
			G.arcs[47][3].name = "��°�·";
			G.arcs[47][1].adj = 37;
			G.arcs[47][1].name = "������·";
			G.arcs[48][7].adj = 50;
			G.arcs[48][7].name = "���±���";
			G.arcs[48][20].adj = 25;
			G.arcs[48][20].name = "˫̨��·";
			G.arcs[48][21].adj = 47;
			G.arcs[48][21].name = "���±���";
			G.arcs[49][4].adj = 32;
			G.arcs[49][4].name = "���񱱵�";
			G.arcs[49][54].adj = 17;
			G.arcs[49][54].name = "���Ǳ�·";
			G.arcs[49][5].adj = 32;
			G.arcs[49][5].name = "���񱱵�";
			G.arcs[49][7].adj = 33;
			G.arcs[49][7].name = "���Ǳ�·";
			G.arcs[49][20].adj = 92;
			G.arcs[49][20].name = "���񱱵�";
			G.arcs[51][60].adj = 37;
			G.arcs[51][60].name = "��Ԫ��·";
			G.arcs[51][21].adj = 50;
			G.arcs[51][21].name = "��Ԫ��·����Ԫ��·";
			G.arcs[51][23].adj = 50;G.arcs[51][23].name = "��Ԫ��·����Ԫ��·";
			G.arcs[52][32].adj = 20;
			G.arcs[52][32].name = "������·";
		    G.arcs[52][34].adj = 25;
			G.arcs[52][34].name = "������·";
			G.arcs[52][35].adj = 5;
			G.arcs[52][35].name = "������·";
			G.arcs[52][13].adj = 25;
			G.arcs[52][13].name = "�����ϵ�";
			G.arcs[52][15].adj = 32;
			G.arcs[52][15].name = "������·";
			G.arcs[52][36].adj = 50;
			G.arcs[52][36].name = "������·";
			G.arcs[53][61].adj = 25;
			G.arcs[53][61].name = "��԰��·";
			G.arcs[53][16].adj = 50;
			G.arcs[53][16].name = "��Ԫ��·����Ԫ��·";
			G.arcs[53][18].adj = 50;
			G.arcs[53][18].name = "��Ԫ��·����Ԫ��·";
			G.arcs[54][49].adj = 17;
			G.arcs[54][49].name = "���Ǳ�·";
			G.arcs[54][3].adj = 30;
			G.arcs[54][3].name = "��°�·";
			G.arcs[54][55].adj = 25;
			G.arcs[54][55].name = "���Ǳ�·";
			G.arcs[54][49].adj = 17;G.arcs[54][49].name = "���Ǳ�·";
			G.arcs[55][54].adj = 25;G.arcs[55][54].name = "���Ǳ�·";
			G.arcs[55][1].adj = 30;G.arcs[55][1].name = "��°�·";
			G.arcs[55][2].adj = 31;G.arcs[55][2].name = "���Ǳ�·";
			G.arcs[55][3].adj = 37;G.arcs[55][3].name = "��°�·";
			G.arcs[56][66].adj = 25;G.arcs[56][66].name = "��°�·";
			G.arcs[56][65].adj = 25;G.arcs[56][65].name = "��°�·";
			G.arcs[56][67].adj = 75;G.arcs[56][67].name = "���ƶ���";
			G.arcs[56][74].adj = 62;G.arcs[56][74].name = "��°�·";
			G.arcs[56][64].adj = 30;G.arcs[56][64].name = "���ı�·/���ƶ���";
			G.arcs[57][58].adj = 50;G.arcs[57][58].name = "��������";
			G.arcs[57][22].adj = 162;G.arcs[57][22].name = "��������";
			G.arcs[57][23].adj = 125;G.arcs[57][23].name = "��������";
			G.arcs[58][57].adj = 50;G.arcs[58][57].name = "��������";
			G.arcs[58][23].adj = 100;G.arcs[58][23].name = "��������";
			G.arcs[58][18].adj = 150;G.arcs[58][18].name = "��������";
			G.arcs[58][60].adj = 37;G.arcs[58][60].name = "С·ֱ��";
			G.arcs[59][69].adj = 62;G.arcs[59][69].name = "�����ϵ�";
			G.arcs[59][24].adj = 50;G.arcs[59][24].name = "���±���";
			G.arcs[59][67].adj = 50;G.arcs[59][67].name = "���񱱵�";
			G.arcs[59][71].adj = 87;G.arcs[59][71].name = "��ѧ·";
			G.arcs[60][58].adj = 37;G.arcs[60][58].name = "С·ֱ��";
			G.arcs[60][61].adj = 50;G.arcs[60][61].name = "��԰��·";
			G.arcs[60][51].adj = 37;G.arcs[60][51].name = "��Ԫ��·";
			G.arcs[61][60].adj = 50;G.arcs[61][60].name = "��԰��·";
			G.arcs[61][16].adj = 55;G.arcs[61][16].name = "��Ԫ��·����Ԫ��·";
			G.arcs[61][18].adj = 55;G.arcs[61][18].name = "��Ԫ��·����Ԫ��·";
			G.arcs[61][53].adj = 25;G.arcs[61][53].name = "��Ԫ��·";
			G.arcs[63][0].adj = 25;G.arcs[63][0].name = "������·";
			G.arcs[63][2].adj = 25;G.arcs[63][2].name = "���Ǳ�·";
			G.arcs[63][73].adj = 100;G.arcs[63][73].name = "���Ʊ���";
			G.arcs[63][64].adj = 145;G.arcs[63][64].name = "���Ʊ���";
			G.arcs[64][56].adj = 30;G.arcs[64][56].name = "���ı�·/���ƶ���";
			G.arcs[64][63].adj = 145;G.arcs[64][63].name = "���Ʊ���";
			G.arcs[64][74].adj = 50;G.arcs[64][74].name = "���ƶ���";
			G.arcs[65][56].adj = 25;G.arcs[64][56].name = "��°�·";
			G.arcs[65][66].adj = 50;G.arcs[65][66].name = "��°�·";
			G.arcs[65][67].adj = 50;G.arcs[65][67].name = "С·ֱ��";
			G.arcs[65][74].adj = 50;G.arcs[65][74].name = "��°�·";
			G.arcs[66][65].adj = 50;G.arcs[66][65].name = "��°�·";
			G.arcs[66][56].adj = 25;G.arcs[66][56].name = "��°�·";
			G.arcs[66][67].adj = 50;G.arcs[66][67].name = "���񱱵�";
			G.arcs[66][44].adj = 40;G.arcs[66][44].name = "���񱱵�";
			G.arcs[66][45].adj = 40;G.arcs[66][45].name = "��°�·";
			G.arcs[66][68].adj = 75;G.arcs[66][68].name = "���ı�·";
			G.arcs[67][66].adj = 50;G.arcs[67][66].name = "���񱱵�";
			G.arcs[67][59].adj = 50;G.arcs[67][59].name = "���񱱵�";
			G.arcs[67][69].adj = 37;G.arcs[67][69].name = "���񱱵�";
			G.arcs[67][68].adj = 50;G.arcs[67][68].name = "���񱱵�";
			G.arcs[67][65].adj = 50;G.arcs[67][65].name = "С·ֱ��";
			G.arcs[67][74].adj = 75;G.arcs[67][74].name = "���ƶ���";
			G.arcs[68][67].adj = 50;G.arcs[68][67].name = "���񱱵�";
			G.arcs[68][66].adj = 75;G.arcs[68][66].name = "���ı�·";
			G.arcs[68][69].adj = 15;G.arcs[68][69].name = "��ҵ·";
			G.arcs[68][43].adj = 62;G.arcs[68][43].name = "���񱱵�/���±���";
			G.arcs[68][44].adj = 62;G.arcs[68][44].name = "���ı�·";
			G.arcs[68][24].adj = 50;G.arcs[68][24].name = "��ҵ·";
			G.arcs[69][68].adj = 15;G.arcs[69][68].name = "��ҵ·";
			G.arcs[69][67].adj = 37;G.arcs[69][67].name = "���񱱵�";
			G.arcs[69][59].adj = 62;G.arcs[69][59].name = "���񱱵�";
			G.arcs[69][70].adj = 25;G.arcs[69][70].name = "С·ֱ��";
			G.arcs[70][69].adj = 25;G.arcs[70][69].name = "С·ֱ��";
			G.arcs[71][24].adj = 75;G.arcs[71][24].name = "�ﻷ��·";
			G.arcs[71][25].adj = 57;G.arcs[71][25].name = "С·ֱ��";
			G.arcs[71][26].adj = 82;G.arcs[71][26].name = "�ɵ»�·";
			G.arcs[71][75].adj = 75;G.arcs[71][75].name = "С·ֱ��";
			G.arcs[72][27].adj = 62;G.arcs[72][27].name = "������·";
			G.arcs[72][28].adj = 87;G.arcs[72][28].name = "������·";
			G.arcs[72][29].adj = 87;G.arcs[72][29].name = "�����ϵ�";
			G.arcs[72][30].adj = 87;G.arcs[72][30].name = "�����ϵ�";
			G.arcs[73][63].adj = 100;G.arcs[73][63].name = "���Ʊ���";
			G.arcs[73][20].adj = 118;G.arcs[73][20].name = "��Ԫ��·";
			G.arcs[73][22].adj = 118;G.arcs[73][22].name = "��Ԫ��·";
			G.arcs[74][64].adj = 50;G.arcs[74][64].name = "���ƶ���";
			G.arcs[74][65].adj = 50;G.arcs[74][65].name = "��°�·";
			G.arcs[74][67].adj = 75;G.arcs[74][67].name = "���ƶ���";
			G.arcs[74][56].adj = 62;G.arcs[74][56].name = "��°�·";
			G.arcs[75][71].adj = 75;G.arcs[75][71].name = "С·ֱ��";
			G.arcs[76][27].adj = 50;G.arcs[76][27].name = "������·";
			G.arcs[76][28].adj = 62;G.arcs[76][28].name = "������·";
			G.arcs[77][17].adj = 75;G.arcs[77][17].name = "��Ԫ��·";
			G.arcs[77][19].adj = 75;G.arcs[77][19].name = "��Ԫ��·";
			G.arcs[77][33].adj = 75;G.arcs[77][33].name = "�����ϵ�";
		}
		


	}

	void ShortestPath(int num) // �Ͻ�˹�����㷨���·������ numΪ��ڵ�ı�� 
	{
		int v, w, i, t; // i��w��vΪ�������� 
		boolean finals[] = new boolean[NUM];
		int min;
		for (v = 0; v < NUM; v++) {
			finals[v] = false; // ����Ӷ���num������vû�����·�� 
			D[v] = G.arcs[num][v].adj;// ����֮��ص�Ȩֵ����D�д�� 

			for (w = 0; w < NUM; w++) // ����Ϊ��·�� 
				P[v][w] = 0;
			if (D[v] < 20000) // ����·�� 
			{
				P[v][num] = 1; // ���ڱ�־��Ϊһ 
				P[v][v] = 1; // �������� 
			}
		}

		D[num] = 0;
		finals[num] = true; // ��ʼ��num��������S���� 
		// ��ʼ��ѭ����ÿһ�����num��ĳ����������·������������뵽S����
		for (i = 0; i < NUM; ++i) // ����G.vexnum-1������ 
		{
			min = Max; // ��ǰ��֪�붥��num���������
			for (w = 0; w < NUM; ++w)
				if (!finals[w]) // w������v-s�� 
					if (D[w] < min) // w������num������� 
					{
						v = w;
						min = (int) D[w];
					}
			System.out.println("v="+v);
			if(v<78) {
				finals[v] = true; // ��num���������v���뵽s���� 
				for (w = 0; w < NUM; ++w) // ���µ�ǰ���·���������
					if (!finals[w] && ((min + G.arcs[v][w].adj) < D[w]))// ����s���ϣ����ұ���ǰ���ҵ���·�����̾͸��µ�ǰ·�� 
					{
						D[w] = min + G.arcs[v][w].adj;
						for (t = 0; t < NUM; t++)
							P[w][t] = P[v][t];
						P[w][w] = 1;
					}
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public Road() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Label1 = new JLabel("����ѧУ԰����ϵͳ");
		Label1.setFont(new Font("���ֹ������Σ������ã�������", Font.PLAIN, 35));
		Label1.setBounds(49, 13, 368, 82);
		contentPane.add(Label1);

		JButton Button1 = new JButton("ȷ��");
		Button1.setBounds(332, 278, 99, 27);
		contentPane.add(Button1);

		JLabel Label2 = new JLabel("�����ص�");
		Label2.setFont(new Font("����", Font.PLAIN, 18));
		Label2.setBounds(49, 135, 89, 18);
		contentPane.add(Label2);

		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setFont(new Font("����", Font.PLAIN, 18));
		comboBox1.setBounds(152, 132, 99, 24);
		contentPane.add(comboBox1);

		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setFont(new Font("����", Font.PLAIN, 18));
		comboBox2.setBounds(276, 132, 123, 24);
		contentPane.add(comboBox2);

		JLabel Label3 = new JLabel("Ŀ�ĵص�");
		Label3.setFont(new Font("����", Font.PLAIN, 18));
		Label3.setBounds(49, 196, 72, 18);
		contentPane.add(Label3);

		JComboBox<String> comboBox3 = new JComboBox<String>();
		comboBox3.setFont(new Font("����", Font.PLAIN, 18));
		comboBox3.setBounds(152, 193, 99, 24);
		contentPane.add(comboBox3);

		JComboBox<String> comboBox4 = new JComboBox<String>();
		comboBox4.setFont(new Font("����", Font.PLAIN, 18));
		comboBox4.setBounds(276, 196, 123, 24);
		contentPane.add(comboBox4);

		JPanel panel = new JPanel();
		panel.setBounds(0, 74, 462, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 13, 389, 148);
		panel.add(scrollPane);
		
		JTextArea textArea1 = new JTextArea();
		scrollPane.setViewportView(textArea1);
		
		JRadioButton RadioButton1 = new JRadioButton("������");
		RadioButton1.setFont(new Font("����", Font.PLAIN, 18));
		RadioButton1.setBounds(192, 242, 83, 27);
		contentPane.add(RadioButton1);
		
		JRadioButton RadioButton2 = new JRadioButton("���г�");
		RadioButton2.setFont(new Font("����", Font.PLAIN, 18));
		RadioButton2.setBounds(305, 242, 83, 27);
		contentPane.add(RadioButton2);
		
		JLabel LabelNot = new JLabel("��ע��˫̨��·��������·��������·��������ֹͨ��");
		LabelNot.setBounds(14, 273, 356, 36);
		contentPane.add(LabelNot);
		//LabelNot.setVisible(false);
		
		if(RadioButton1.isSelected()) {
			RadioButton1.setSelected(true);
			RadioButton2.setSelected(false);
		}
		else {
			RadioButton1.setSelected(false);
			RadioButton2.setSelected(true);
		}
		
		RadioButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadioButton1.setSelected(false);
			}
		});
		
		RadioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadioButton2.setSelected(false);
			}
		});
		

		String type[] = { "ѡ������", "����¥", "��ѧ¥", "ʳ��", "��ص�", "У԰����", "У԰����" };
		String sushe[] = { "��԰1ի", "��԰2ի", "��԰3ի", "֪԰4ի", "֪԰5ի", "��԰6ի", "��԰7ի", "��԰8ի", "��԰9ի", "��԰10ի", "��԰11ի",
				"��԰12ի", "��԰13ի", "��԰14ի", "��԰15ի", "��԰16ի", "��԰17ի", "��԰18ի", "��԰19ի", "��԰20ի", "ƽ԰21ի", "ƽ԰22ի",
				"ƽ԰23ի", "ƽ԰24ի" };
		String jiaoxuelou[] = { "31��ѧ¥", "32��ѧ¥¥", "33��ѧ¥", "34��ѧ¥", "35��ѧ¥", "36��ѧ¥", "37��ѧ¥", "38��ѧ¥", "39��ѧ¥",
				"40��ѧ¥", "41��ѧ¥", "42��ѧ¥", "43��ѧ¥", "44��ѧ¥", "45��ѧ¥", "46��ѧ¥", "47��ѧ¥", "48��ѧ¥", "49��ѧ¥", "50��ѧ¥",
				"51��ѧ¥", "52��ѧ¥", "53��ѧ¥", "54��ѧ¥", "55��ѧ¥" };
		String shitang[] = { "ѧһ(÷԰)", "ѧ��(��԰)", "ѧ��(��԰)", "ѧ��(��԰)", "ѧ��(��԰)", "ѧ��(��԰)", "��԰����", "��԰����" };
		String lake[] = { "��԰��", "�����", "��ҵ��" };
		String huodonglou[] = { "ѧ������", "̫�׹㳡", "֣��ͼ���", "��ѧ����Ԣ", "�����ʦ��Ԣ", "УҽԺ", "�ۺ�������", "������", "������������", "����",
				"��ְ����������", "����㳡", "������԰" };
		String door[] = { "����", "������", "����", "������", "����" };

		for (int i = 0; i < type.length; i++) {
			comboBox1.addItem(type[i]);
			comboBox3.addItem(type[i]);
		}

		comboBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String choose = (String) comboBox1.getSelectedItem();
				System.out.println(choose);
				// TODO Auto-generated method stub
				if (choose.equals("����¥")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < sushe.length; i++) {
						comboBox2.addItem(sushe[i]);
					}
				} else if (choose.equals("ʳ��")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < shitang.length; i++) {
						comboBox2.addItem(shitang[i]);
					}
				} else if (choose.equals("��ѧ¥")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < jiaoxuelou.length; i++) {
						comboBox2.addItem(jiaoxuelou[i]);
					}
				} else if (choose.equals("��ص�")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < huodonglou.length; i++) {
						comboBox2.addItem(huodonglou[i]);
					}
				} else if (choose.equals("У԰����")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < door.length; i++) {
						comboBox2.addItem(door[i]);
					}
				} else if (choose.equals("У԰����")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < lake.length; i++) {
						comboBox2.addItem(lake[i]);
					}
				} else if (choose.equals("ѡ������")) {
					comboBox2.removeAllItems();
				}
			}
		});

		comboBox3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String choose = (String) comboBox3.getSelectedItem();
				System.out.println(choose);
				// TODO Auto-generated method stub
				if (choose.equals("����¥")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < sushe.length; i++) {
						comboBox4.addItem(sushe[i]);
					}
				} else if (choose.equals("ʳ��")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < shitang.length; i++) {
						comboBox4.addItem(shitang[i]);
					}
				} else if (choose.equals("��ѧ¥")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < jiaoxuelou.length; i++) {
						comboBox4.addItem(jiaoxuelou[i]);
					}
				} else if (choose.equals("��ص�")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < huodonglou.length; i++) {
						comboBox4.addItem(huodonglou[i]);
					}
				} else if (choose.equals("У԰����")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < door.length; i++) {
						comboBox4.addItem(door[i]);
					}
				} else if (choose.equals("У԰����")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < lake.length; i++) {
						comboBox4.addItem(lake[i]);
					}
				} else if (choose.equals("ѡ������")) {
					comboBox4.removeAllItems();
				}
			}
		});

		Button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Button1.getText().equals("ȷ��") && !comboBox1.getSelectedItem().equals("ѡ������")
						&& !comboBox3.getSelectedItem().equals("ѡ������")&&RadioButton2.isSelected()) {
					CreateUDN(NUM, 210,1);
					int sight1 = 0;
					int sight2 = 0;
					System.out.println(comboBox2.getSelectedItem());
					System.out.println(comboBox4.getSelectedItem());

					for (int i = 0; i < 78; i++) {
						if (comboBox2.getSelectedItem().equals(G.vex[i].sight))
							sight1 = i;
					}

					for (int i = 0; i < 78; i++) {
						if (comboBox4.getSelectedItem().equals(G.vex[i].sight))
							sight2 = i;
					}
					Button1.setText("�˳�");
					Label2.setVisible(false);
					Label3.setVisible(false);
					comboBox1.setVisible(false);
					comboBox2.setVisible(false);
					comboBox3.setVisible(false);
					comboBox4.setVisible(false);
					RadioButton1.setVisible(false);
					RadioButton2.setVisible(false);
					panel.setVisible(true);
					System.out.println(sight1 + " " + sight2);

					ShortestPath(sight1);
					int a=0, b=0, c=0, d=0, q = 0;
					a = sight2; // ���������ֵ��a 
					if (a != sight1) //�����������;���һ�����غϣ������...
					{
						String ans = "��" + G.vex[sight1].sight + "��" + G.vex[sight2].sight;
						ans += "��̾���Ϊ " + D[a] + "��\n";
						ans += G.vex[sight1].sight;
						
						d = sight1; // ������һ�ı�Ÿ�ֵ��d 

						for (c = 0; c < NUM; ++c) {
							P[a][sight1] = 0;
							for (b = 0; b < NUM; b++) {
								if (G.arcs[d][b].adj < 20000 && P[a][b] >= 1) // �������һ������һ���ٽ��֮�����·�������·�� 
								{
									ans += "-->" +"����"+  G.arcs[d][b].name+"-->"+ G.vex[b].sight+"\n";
									
									q = q + 1; // ����������һ����8�������ʱ�Ļ��� 
									P[a][b] = 0;
									d = b; // ��b��Ϊ�����������һ��ѭ���������˷���
									if (q % 8 == 0)
										ans += "\n";
									break;
								}
							}
						}
						textArea1.setText(ans);
					}
				} else if (Button1.getText().equals("ȷ��") && !comboBox1.getSelectedItem().equals("ѡ������")
						&& !comboBox3.getSelectedItem().equals("ѡ������")&&RadioButton1.isSelected()) {
					CreateUDN(NUM, 210,2);
					int sight1 = 0;
					int sight2 = 0;
					System.out.println(comboBox2.getSelectedItem());
					System.out.println(comboBox4.getSelectedItem());

					for (int i = 0; i < 78; i++) {
						if (comboBox2.getSelectedItem().equals(G.vex[i].sight))
							sight1 = i;
					}

					for (int i = 0; i < 78; i++) {
						if (comboBox4.getSelectedItem().equals(G.vex[i].sight))
							sight2 = i;
					}
					Button1.setText("�˳�");
					Label2.setVisible(false);
					Label3.setVisible(false);
					comboBox1.setVisible(false);
					comboBox2.setVisible(false);
					comboBox3.setVisible(false);
					comboBox4.setVisible(false);
					RadioButton1.setVisible(false);
					RadioButton2.setVisible(false);
					panel.setVisible(true);
					System.out.println(sight1 + " " + sight2);

					ShortestPath(sight1);
					int a, b, c, d, q = 0;
					a = sight2; // ���������ֵ��a 
					if (a != sight1&&D[a]!=1) //�����������;���һ�����غϣ������... 
					{
						String ans = "��" + G.vex[sight1].sight + "��" + G.vex[sight2].sight;
						ans += "��̾���Ϊ " + D[a] + "��\n";
						ans += G.vex[sight1].sight;
						
						d = sight1; // ������һ�ı�Ÿ�ֵ��d 

						for (c = 0; c < NUM; ++c) {
							P[a][sight1] = 0;
							for (b = 0; b < NUM; b++) {
								if (G.arcs[d][b].adj < 20000 && P[a][b] >= 1) // �������һ������һ���ٽ��֮�����·�������·�� 
								{
									ans += "-->" +"����"+  G.arcs[d][b].name+"-->"+ G.vex[b].sight+"\n";
									q = q + 1; // ����������һ����8�������ʱ�Ļ��� 
									P[a][b] = 0;
									d = b; // ��b��Ϊ�����������һ��ѭ���������˷��� 
									if (q % 8 == 0)
										ans += "\n";
									break;
								}
							}
						}
						textArea1.setText(ans);
						 for(b=0;b<NUM;b++){
							 if(P[a][b]==20000){
								 textArea1.setText("��·�ν�ֹ������ͨ�У��޷�����Ŀ�ĵأ��벽��ǰ��");
							 }
						}
						 if(D[a]>=20000) {
							 textArea1.setText("��·�ν�ֹ������ͨ�У��޷�����Ŀ�ĵأ��벽��ǰ��");
						 }
					}
				}else if (Button1.getText().equals("�˳�")) {
					System.exit(0);
				} else {
					if (comboBox1.getSelectedItem().equals("ѡ������"))
						JOptionPane.showMessageDialog(contentPane, "��û��ѡ������ص�", "ע��", 1);
					else if (comboBox3.getSelectedItem().equals("ѡ������"))
						JOptionPane.showMessageDialog(contentPane, "��û��ѡ��Ŀ�ĵص�", "ע��", 1);
				}
			}
		});
	}
}
