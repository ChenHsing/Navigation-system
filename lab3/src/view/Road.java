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
		int number;// 景点编号
		String sight; // 景点名称

		public VertexType() {

		}
	}

	public class MGraph {
		public VertexType vex[] = new VertexType[NUM]; /* 图中的顶点，即为景点 */
		public ArcCell arcs[][] = new ArcCell[NUM][NUM]; /* 图中的边，即为景点间的距离 */
		int vexnum, arcnum; /* 顶点数，边数 */

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
	long D[] = new long[NUM]; /* 辅助变量存储最短路径长度 */

	void CreateUDN(int v, int a, int type) /* 造图函数 */
	{
		int i, j;
		G.vexnum = v; /* 初始化结构中的景点数和边数 */
		G.arcnum = a;
		System.out.println(G.vex[0].number);
		for (i = 0; i < G.vexnum; i++) {
			G.vex[i].number = i; /* 初始化每一个景点的编号 */
		}

		/* 初始化没一个景点名及其景点描述 */

		G.vex[0].sight = "格园1斋";
		G.vex[1].sight = "格园2斋";
		G.vex[2].sight = "格园3斋";
		G.vex[3].sight = "知园4斋";
		G.vex[4].sight = "知园5斋";
		G.vex[5].sight = "诚园6斋";
		G.vex[6].sight = "诚园7斋";
		G.vex[7].sight = "诚园8斋";
		G.vex[8].sight = "正园9斋";
		G.vex[9].sight = "正园10斋";
		G.vex[10].sight = "修园11斋";
		G.vex[11].sight = "修园12斋";
		G.vex[12].sight = "齐园13斋";
		G.vex[13].sight = "齐园14斋";
		G.vex[14].sight = "齐园15斋";
		G.vex[15].sight = "齐园16斋";
		G.vex[16].sight = "治园17斋";
		G.vex[17].sight = "治园18斋";
		G.vex[18].sight = "治园19斋";
		G.vex[19].sight = "治园20斋";
		G.vex[20].sight = "平园21斋";
		G.vex[21].sight = "平园22斋";
		G.vex[22].sight = "平园23斋";
		G.vex[23].sight = "平园24斋";
		G.vex[24].sight = "31教学楼";
		G.vex[25].sight = "32教学楼";
		G.vex[26].sight = "33教学楼";
		G.vex[27].sight = "34教学楼";
		G.vex[28].sight = "35教学楼";
		G.vex[29].sight = "36教学楼";
		G.vex[30].sight = "37教学楼";
		G.vex[31].sight = "38教学楼";
		G.vex[32].sight = "39教学楼";
		G.vex[33].sight = "40教学楼";
		G.vex[34].sight = "41教学楼";
		G.vex[35].sight = "42教学楼";
		G.vex[36].sight = "43教学楼";
		G.vex[37].sight = "44教学楼";
		G.vex[38].sight = "45教学楼";
		G.vex[39].sight = "46教学楼";
		G.vex[40].sight = "47教学楼";
		G.vex[41].sight = "48教学楼";
		G.vex[42].sight = "49教学楼";
		G.vex[43].sight = "50教学楼";
		G.vex[44].sight = "51教学楼";
		G.vex[45].sight = "52教学楼";
		G.vex[46].sight = "53教学楼";
		G.vex[47].sight = "54教学楼";
		G.vex[48].sight = "55教学楼";
		G.vex[49].sight = "学一(梅园)";
		G.vex[50].sight = "学二(兰园)";
		G.vex[51].sight = "学三(棠园)";
		G.vex[52].sight = "学四(竹园)";
		G.vex[53].sight = "学五(桃园)";
		G.vex[54].sight = "学六(菊园)";
		G.vex[55].sight = "留园餐厅";
		G.vex[56].sight = "青园餐厅";
		G.vex[57].sight = "龙园湖";
		G.vex[58].sight = "青年湖";
		G.vex[59].sight = "敬业湖";
		G.vex[60].sight = "学生中心";
		G.vex[61].sight = "太雷广场";
		G.vex[62].sight = "郑东图书馆";
		G.vex[63].sight = "留园";
		G.vex[64].sight = "青年教师公寓";
		G.vex[65].sight = "校医院";
		G.vex[66].sight = "综合体育馆";
		G.vex[67].sight = "体育场";
		G.vex[68].sight = "行政服务中心";
		G.vex[69].sight = "工会";
		G.vex[70].sight = "教职工服务中心";
		G.vex[71].sight = "北洋广场";
		G.vex[72].sight = "体育公园";
		G.vex[73].sight = "北门";
		G.vex[74].sight = "东北门";
		G.vex[75].sight = "东门";
		G.vex[76].sight = "东南门";
		G.vex[77].sight = "南门";

		// 这里把所有的边假定为20000，含义是这两个景点之间是不可到达 
		for (i = 0; i < G.vexnum; ++i)
			for (j = 0; j < G.vexnum; ++j) {
				G.arcs[i][j].adj = Max;
	    }

	
		
		if(type==1) {
			G.arcs[0][1].adj=20;G.arcs[0][1].name="小路直达";
			G.arcs[0][63].adj=25;G.arcs[0][63].name="西沽北路";
			G.arcs[0][2].adj=30;G.arcs[0][2].name="小路直达";
			G.arcs[1][0].adj=20;G.arcs[1][0].name="小路直达";
			G.arcs[1][55].adj=30;G.arcs[1][55].name="侯德榜路";
			G.arcs[1][3].adj=37;G.arcs[1][3].name="西沽北路";
			G.arcs[1][47].adj=37;G.arcs[1][47].name="西沽北路";
			G.arcs[2][63].adj=25;G.arcs[2][63].name="七星北路";
			G.arcs[2][55].adj=37;G.arcs[2][55].name="西沽北路";
			G.arcs[3][4].adj=20;G.arcs[3][4].name="小路直达";
			G.arcs[3][55].adj=31;G.arcs[3][55].name="侯德榜路";
			G.arcs[3][54].adj=30;G.arcs[3][54].name="侯德榜路";
			G.arcs[3][47].adj=35;G.arcs[3][47].name="侯德榜路";
			G.arcs[4][3].adj=20;G.arcs[4][3].name="小路直达";
			G.arcs[4][49].adj=32;G.arcs[4][49].name="亲民北道";
			G.arcs[4][5].adj=32;G.arcs[4][5].name="西沽北路";
			G.arcs[4][46].adj=37;G.arcs[4][46].name="亲民北道";
			G.arcs[4][43].adj=50;G.arcs[4][43].name="亲民北道";
			G.arcs[4][54].adj=37;G.arcs[4][54].name="小路直达";
			G.arcs[5][4].adj=32;G.arcs[5][4].name="西沽北路";
			G.arcs[5][6].adj=25;G.arcs[5][6].name="小路直达";
			G.arcs[5][7].adj=37;G.arcs[5][7].name="小路直达";
			G.arcs[5][43].adj=50;G.arcs[5][43].name="亲民北道";
			G.arcs[5][46].adj=33;G.arcs[5][46].name="西沽北路";
			G.arcs[5][49].adj=32;G.arcs[5][49].name="亲民北道";
			G.arcs[6][5].adj=25;G.arcs[6][5].name="小路直达";
			G.arcs[6][7].adj=32;G.arcs[6][7].name="小路直达";
			G.arcs[6][43].adj=50;G.arcs[6][43].name="明德北道";
			G.arcs[6][8].adj=60;G.arcs[6][8].name="西沽北路，西沽中路";
			G.arcs[6][50].adj=60;G.arcs[6][50].name="西沽北路";
			G.arcs[7][5].adj=37;G.arcs[7][5].name="小路直达";
			G.arcs[7][6].adj=32;G.arcs[7][6].name="小路直达";
			G.arcs[7][48].adj=50;G.arcs[7][48].name="明德北道";
			G.arcs[7][9].adj=68;G.arcs[7][9].name="七星北路，七星中路";
			G.arcs[7][49].adj=33;G.arcs[7][49].name="七星北路";
			G.arcs[8][9].adj=30;G.arcs[8][9].name="小路直达";
			G.arcs[8][50].adj=45;G.arcs[8][50].name="英华道/求是北道";
			G.arcs[8][43].adj=68;G.arcs[8][43].name="西沽中路，西沽北路";
			G.arcs[8][6].adj=60;G.arcs[8][6].name="西沽中路，西沽北路";
			G.arcs[8][39].adj=22;G.arcs[8][39].name="西沽中路";
			G.arcs[8][42].adj=22;G.arcs[8][42].name="西沽中路";
			G.arcs[9][8].adj=30;G.arcs[9][8].name="小路直达";
			G.arcs[9][7].adj=68;G.arcs[9][7].name="七星中路，七星北路";
			G.arcs[9][48].adj=60;G.arcs[9][48].name="七星中路，七星北路";
			G.arcs[9][39].adj=22;G.arcs[9][39].name="七星中路";
			G.arcs[9][51].adj=95;G.arcs[9][51].name="英华道";
			G.arcs[9][62].adj=47;G.arcs[9][62].name="七星中路";
			G.arcs[10][38].adj=27;G.arcs[10][38].name="西沽中路";
			G.arcs[10][41].adj=27;G.arcs[10][41].name="西沽中路";
			G.arcs[10][40].adj=45;G.arcs[10][40].name="花堤道/求是南道";
			G.arcs[10][11].adj=30;G.arcs[10][11].name="小路直达";
			G.arcs[10][12].adj=55;G.arcs[10][12].name="西沽中路，西沽南路";
			G.arcs[10][30].adj=68;G.arcs[10][30].name="西沽中路，西沽南路";
			G.arcs[11][10].adj=30;G.arcs[11][10].name="小路直达";
			G.arcs[11][38].adj=27;G.arcs[11][38].name="七星中路";
			G.arcs[11][41].adj=27;G.arcs[11][41].name="七星中路";
			G.arcs[11][62].adj=45;G.arcs[11][62].name="七星中路";
			G.arcs[11][37].adj=50;G.arcs[11][37].name="花堤道";
			G.arcs[11][14].adj=50;G.arcs[11][14].name="七星中路，七星南路";
			G.arcs[11][36].adj=65;G.arcs[11][36].name="七星中路，七星南路";
			G.arcs[12][10].adj=55;G.arcs[12][10].name="西沽南路，西沽中路";
			G.arcs[12][14].adj=30;G.arcs[12][14].name="小路直达";
			G.arcs[12][13].adj=30;G.arcs[12][13].name="小路直达";
			G.arcs[12][40].adj=55;G.arcs[12][40].name="西沽南路，西沽中路";
			G.arcs[12][30].adj=50;G.arcs[12][30].name="明德南道";
			G.arcs[12][15].adj=42;G.arcs[12][15].name="小路直达";
			G.arcs[13][12].adj=30;G.arcs[13][12].name="小路直达";
			G.arcs[13][14].adj=42;G.arcs[13][14].name="小路直达";
			G.arcs[13][15].adj=30;G.arcs[13][15].name="小路直达";
			G.arcs[13][30].adj=50;G.arcs[13][30].name="亲民南道";
			G.arcs[13][52].adj=25;G.arcs[13][52].name="亲民南道";
			G.arcs[13][29].adj=40;G.arcs[13][29].name="西沽南路";
			G.arcs[14][12].adj=30;G.arcs[14][12].name="小路直达";
			G.arcs[14][13].adj=42;G.arcs[14][13].name="小路直达";
			G.arcs[14][15].adj=30;G.arcs[14][15].name="小路直达";
			G.arcs[14][37].adj=50;G.arcs[14][37].name="七星南路，七星中路";
			G.arcs[14][36].adj=50;G.arcs[14][36].name="明德南道";
			G.arcs[14][11].adj=50;G.arcs[14][11].name="七星南路，七星中路";
			G.arcs[15][12].adj=42;G.arcs[15][12].name="小路直达";
			G.arcs[15][13].adj=30;G.arcs[15][13].name="小路直达";
			G.arcs[15][14].adj=30;G.arcs[15][14].name="小路直达";
			G.arcs[15][36].adj=50;G.arcs[15][36].name="亲民南道";
			G.arcs[15][52].adj=32;G.arcs[15][52].name="七星南路";
			G.arcs[15][35].adj=32;G.arcs[15][35].name="七星南路";
			G.arcs[16][17].adj=30;G.arcs[16][17].name="新元南路/双台南路";
			G.arcs[16][18].adj=35;G.arcs[16][18].name="明德南道";
			G.arcs[16][19].adj=30;G.arcs[16][19].name="新元南路";
			G.arcs[16][53].adj=50;G.arcs[16][53].name="新元南路，新元中路";
			G.arcs[16][61].adj=55;G.arcs[16][61].name="新元南路，新园中路";
			G.arcs[16][36].adj=47;G.arcs[16][36].name="明德南道";
			G.arcs[16][37].adj=50;G.arcs[16][37].name="双台南路";
			G.arcs[17][16].adj=30;G.arcs[17][16].name="新元南路/双台南路";
			G.arcs[17][18].adj=30;G.arcs[17][18].name="新元南路";
			G.arcs[17][19].adj=35;G.arcs[17][19].name="亲民南道";
			G.arcs[17][36].adj=47;G.arcs[17][36].name="亲民南道";
			G.arcs[17][35].adj=30;G.arcs[17][35].name="双台南路";
			G.arcs[17][77].adj=75;G.arcs[17][77].name="新元南路";
			G.arcs[18][16].adj=35;G.arcs[18][16].name="明德南道";
			G.arcs[18][19].adj=30;G.arcs[18][19].name="新元南路";
			G.arcs[18][17].adj=30;G.arcs[18][17].name="新元南路";
			G.arcs[18][61].adj=55;G.arcs[18][61].name="新元南路，新园中路";
			G.arcs[18][53].adj=50;G.arcs[18][53].name="新元南路，新园中路";
			G.arcs[18][58].adj=150;G.arcs[18][58].name="明德西道";
			G.arcs[19][16].adj=30;G.arcs[19][16].name="新元南路";
			G.arcs[19][17].adj=35;G.arcs[19][17].name="亲民南道";
			G.arcs[19][18].adj=30;G.arcs[19][18].name="新元南路";
			G.arcs[19][57].adj=300;G.arcs[19][57].name="亲民西道";
			G.arcs[19][77].adj=75;G.arcs[19][77].name="新元南路";
			G.arcs[20][21].adj=30;G.arcs[20][21].name="新元北路/双台北路";
			G.arcs[20][22].adj=35;G.arcs[20][22].name="亲民北道";
			G.arcs[20][23].adj=30;G.arcs[20][23].name="新元北路";
			G.arcs[20][48].adj=25;G.arcs[20][48].name="双台北路";
			G.arcs[20][7].adj=93;G.arcs[20][7].name="亲民北道";
			G.arcs[20][73].adj=118;G.arcs[20][73].name="新元北路";
			G.arcs[20][49].adj=92;G.arcs[20][49].name="亲民北道";
			G.arcs[21][20].adj=30;G.arcs[21][20].name="新元北路/双台北路";
			G.arcs[21][22].adj=30;G.arcs[21][22].name="新元北路";
			G.arcs[21][23].adj=35;G.arcs[21][23].name="明德北道";
			G.arcs[21][51].adj=50;G.arcs[21][51].name="新元北路，新园中路";
			G.arcs[21][48].adj=47;G.arcs[21][48].name="明德北道";
			G.arcs[22][20].adj=35;G.arcs[22][20].name="亲民北道";
			G.arcs[22][21].adj=30;G.arcs[22][21].name="新元北路";
			G.arcs[22][23].adj=30;G.arcs[22][23].name="新元北路";
			G.arcs[22][73].adj=118;G.arcs[22][73].name="新元北路";
			G.arcs[22][57].adj=162;G.arcs[22][57].name="亲民西道";
			G.arcs[23][20].adj=30;G.arcs[23][20].name="新元北路";
			G.arcs[23][21].adj=35;G.arcs[23][21].name="明德北道";
			G.arcs[23][22].adj=30;G.arcs[23][22].name="新元北路";
			G.arcs[23][57].adj=125;G.arcs[23][57].name="明德西道";
			G.arcs[23][58].adj=100;G.arcs[23][58].name="明德西道";
			G.arcs[23][51].adj=50;G.arcs[23][51].name="新元北路，新元中路";
			G.arcs[24][25].adj=50;G.arcs[24][25].name="小路直达";
			G.arcs[24][71].adj=75;G.arcs[24][71].name="小路直达";
			G.arcs[24][59].adj=75;G.arcs[24][59].name="小路直达";
			G.arcs[24][70].adj=50;G.arcs[24][70].name="小路直达";
			G.arcs[24][68].adj=50;G.arcs[24][68].name="敬业路";
			G.arcs[25][24].adj=50;G.arcs[25][24].name="小路直达";
			G.arcs[25][71].adj=57;G.arcs[25][71].name="小路直达";
			G.arcs[25][26].adj=62;G.arcs[25][26].name="小路直达";
			G.arcs[25][41].adj=112;G.arcs[25][41].name="求是大道";
			G.arcs[25][42].adj=112;G.arcs[25][42].name="求是大道";
			G.arcs[26][25].adj=62;G.arcs[26][25].name="小路直达";
			G.arcs[26][71].adj=82;G.arcs[26][71].name="小路直达";
			G.arcs[26][30].adj=65;G.arcs[26][30].name="博文中路，博文南路";
			G.arcs[27][72].adj=62;G.arcs[27][72].name="小路直达";
			G.arcs[27][28].adj=75;G.arcs[27][28].name="至善南道";
			G.arcs[27][76].adj=50;G.arcs[27][76].name="博文南路";
			G.arcs[28][27].adj=75;G.arcs[28][27].name="至善南道";
			G.arcs[28][72].adj=87;G.arcs[28][72].name="小路直达";
			G.arcs[28][29].adj=50;G.arcs[28][29].name="博文南路/西沽南路";
			G.arcs[28][76].adj=62;G.arcs[28][76].name="博文南路";
			G.arcs[28][31].adj=10;G.arcs[28][31].name="西沽南路";
			G.arcs[29][72].adj=87;G.arcs[29][72].name="亲民南道";
			G.arcs[29][28].adj=50;G.arcs[29][28].name="博文南路/西沽南路";
			G.arcs[29][30].adj=50;G.arcs[29][30].name="博文南路/西沽南路";
			G.arcs[29][32].adj=17;G.arcs[29][32].name="西沽南路";
			G.arcs[29][13].adj=37;G.arcs[29][13].name="西沽南路";
			G.arcs[30][10].adj=62;G.arcs[30][10].name="西沽南路，西沽中路";
			G.arcs[30][40].adj=62;G.arcs[30][40].name="西沽南路，西沽中路";
			G.arcs[30][12].adj=50;G.arcs[30][12].name="明德南道";
			G.arcs[30][13].adj=50;G.arcs[30][13].name="亲民南道";
			G.arcs[30][29].adj=50;G.arcs[30][29].name="博文南路/西沽南路";
			G.arcs[30][72].adj=87;G.arcs[30][72].name="亲民南道";
			G.arcs[30][26].adj=75;G.arcs[30][26].name="明德南道";
			G.arcs[31][28].adj=10;G.arcs[31][28].name="西沽南路";
			G.arcs[31][32].adj=25;G.arcs[31][32].name="西沽南路/七星南路";
			G.arcs[31][33].adj=12;G.arcs[31][33].name="七星南路";
			G.arcs[32][31].adj=25;G.arcs[32][31].name="西沽南路/七星南路";
			G.arcs[32][33].adj=15;G.arcs[32][33].name="七星南路";
			G.arcs[32][34].adj=10;G.arcs[32][34].name="七星南路";
			G.arcs[32][29].adj=12;G.arcs[32][29].name="西沽南路";
			G.arcs[32][52].adj=20;G.arcs[32][52].name="七星南路";
			G.arcs[33][31].adj=12;G.arcs[33][31].name="七星南路";
			G.arcs[33][32].adj=15;G.arcs[33][32].name="七星南路";
			G.arcs[33][34].adj=17;G.arcs[33][34].name="七星南路/双台南路";
			G.arcs[33][77].adj=75;G.arcs[33][77].name="至善南道";
			G.arcs[34][33].adj=17;G.arcs[34][33].name="七星南路/双台南路";
			G.arcs[34][32].adj=10;G.arcs[34][32].name="七星南路";
			G.arcs[34][35].adj=25;G.arcs[34][35].name="七星南路/双台南路";
			G.arcs[34][52].adj=25;G.arcs[34][52].name="七星南路";
			G.arcs[35][36].adj=50;G.arcs[35][36].name="七星南路/双台南路";
			G.arcs[35][34].adj=25;G.arcs[35][34].name="七星南路/双台南路";
			G.arcs[35][52].adj=5;G.arcs[35][52].name="七星南路";
			G.arcs[35][15].adj=50;G.arcs[35][15].name="亲民南道";
			G.arcs[35][17].adj=50;G.arcs[35][17].name="亲民南道";
			G.arcs[36][35].adj=50;G.arcs[36][35].name="七星南路/双台南路";
			G.arcs[36][52].adj=50;G.arcs[36][52].name="七星南路";
			G.arcs[36][15].adj=50;G.arcs[36][15].name="七星南路";
			G.arcs[36][17].adj=47;G.arcs[36][17].name="七星南路";
			G.arcs[36][14].adj=50;G.arcs[36][14].name="七星南路";
			G.arcs[36][16].adj=47;G.arcs[36][16].name="七星南路";
			G.arcs[36][37].adj=62;G.arcs[36][37].name="七星南路，七星中路";
			G.arcs[36][11].adj=65;G.arcs[36][11].name="七星南路，七星中路";
			G.arcs[37][36].adj=62;G.arcs[37][36].name="七星南路，七星中路";
			G.arcs[37][11].adj=50;G.arcs[37][11].name="花堤道";
			G.arcs[37][53].adj=25;G.arcs[37][53].name="花堤道/书田南道";
			G.arcs[37][62].adj=50;G.arcs[37][62].name="七星中路/双台南路";
			G.arcs[38][11].adj=27;G.arcs[38][11].name="七星中路";
			G.arcs[38][10].adj=27;G.arcs[38][10].name="西沽中路";
			G.arcs[38][62].adj=50;G.arcs[38][62].name="七星中路";
			G.arcs[38][39].adj=25;G.arcs[38][39].name="七星中路/西沽中路";
			G.arcs[38][11].adj=27;G.arcs[38][11].name="七星中路";
			G.arcs[38][40].adj=27;G.arcs[38][40].name="西沽中路";
			G.arcs[38][41].adj=25;G.arcs[38][41].name="西沽中路";
			G.arcs[38][42].adj=25;G.arcs[38][42].name="西沽中路";
			G.arcs[39][62].adj=50;G.arcs[39][62].name="七星中路";
			G.arcs[39][38].adj=25;G.arcs[39][38].name="七星中路/西沽中路";
			G.arcs[39][42].adj=25;G.arcs[39][42].name="西沽中路";
			G.arcs[39][41].adj=25;G.arcs[39][41].name="西沽中路";
			G.arcs[39][8].adj=22;G.arcs[39][8].name="西沽中路";
			G.arcs[39][9].adj=22;G.arcs[39][9].name="七星中路";
			G.arcs[39][50].adj=50;G.arcs[39][50].name="求是北道";
			G.arcs[40][10].adj=45;G.arcs[40][10].name="西沽中路";
			G.arcs[40][12].adj=55;G.arcs[40][12].name="西沽中路，西沽南路";
			G.arcs[40][30].adj=62;G.arcs[40][30].name="西沽中路，西沽南路";
			G.arcs[40][38].adj=27;G.arcs[40][38].name="西沽中路";
			G.arcs[40][41].adj=27;G.arcs[40][41].name="西沽中路";
			G.arcs[41][38].adj=25;G.arcs[41][38].name="西沽中路";
			G.arcs[41][40].adj=27;G.arcs[41][40].name="西沽中路";
			G.arcs[41][10].adj=27;G.arcs[41][10].name="西沽中路";
			G.arcs[41][39].adj=25;G.arcs[41][39].name="西沽中路";
			G.arcs[41][42].adj=25;G.arcs[41][42].name="西沽中路";
			G.arcs[41][25].adj=112;G.arcs[41][25].name="求是大道";
			G.arcs[42][39].adj=25;G.arcs[42][39].name="西沽中路";
			G.arcs[42][41].adj=25;G.arcs[42][41].name="西沽中路";
			G.arcs[42][38].adj=25;G.arcs[42][38].name="西沽中路";
			G.arcs[42][8].adj=22;G.arcs[42][8].name="西沽中路";
			G.arcs[42][50].adj=22;G.arcs[42][50].name="西沽中路";
			G.arcs[42][25].adj=112;G.arcs[42][25].name="求是大道";
			G.arcs[43][5].adj=50;G.arcs[43][5].name="亲民北道";
			G.arcs[43][6].adj=50;G.arcs[43][6].name="明德北道";
			G.arcs[43][8].adj=68;G.arcs[43][8].name="西沽北路，西沽中路";
			G.arcs[43][50].adj=68;G.arcs[43][50].name="西沽北路，西沽中路";
			G.arcs[43][4].adj=50;G.arcs[43][4].name="西沽北路";
			G.arcs[43][46].adj=45;G.arcs[43][46].name="西沽北路";
			G.arcs[43][44].adj=50;G.arcs[43][44].name="博文北路";
			G.arcs[43][68].adj=62;G.arcs[43][68].name="亲民北道/明德北道";
			G.arcs[44][45].adj=37;G.arcs[44][45].name="小路直达";
			G.arcs[44][46].adj=25;G.arcs[44][46].name="小路直达";
			G.arcs[44][47].adj=37;G.arcs[44][47].name="小路直达";
			G.arcs[44][43].adj=50;G.arcs[44][43].name="博文北路";
			G.arcs[44][68].adj=62;G.arcs[44][68].name="亲民北道";
			G.arcs[44][45].adj=37;G.arcs[44][45].name="小路直达";
			G.arcs[44][66].adj=40;G.arcs[44][66].name="亲民北道";
			G.arcs[45][44].adj=37;G.arcs[45][44].name="小路直达";
			G.arcs[45][66].adj=40;G.arcs[45][66].name="侯德榜路";
			G.arcs[45][47].adj=30;G.arcs[45][47].name="小路直达";
			G.arcs[45][46].adj=50;G.arcs[45][46].name="小路直达";
			G.arcs[46][44].adj=25;G.arcs[46][44].name="小路直达";
			G.arcs[46][45].adj=50;G.arcs[46][45].name="小路直达";
			G.arcs[46][47].adj=32;G.arcs[46][47].name="小路直达";
			G.arcs[46][4].adj=37;G.arcs[46][4].name="亲民北道";
			G.arcs[46][43].adj=45;G.arcs[46][43].name="西沽北路";
			G.arcs[46][5].adj=33;G.arcs[46][5].name="西沽北路";
			G.arcs[47][44].adj=37;G.arcs[47][44].name="小路直达";
			G.arcs[47][45].adj=30;G.arcs[47][45].name="小路直达";
			G.arcs[47][46].adj=32;G.arcs[47][46].name="小路直达";
			G.arcs[47][3].adj=35;G.arcs[47][3].name="侯德榜路";
			G.arcs[47][1].adj=37;G.arcs[47][1].name="西沽北路";
			G.arcs[48][7].adj=50;G.arcs[48][7].name="明德北道";
			G.arcs[48][20].adj=25;G.arcs[48][20].name="双台北路";
			G.arcs[48][21].adj=47;G.arcs[48][21].name="明德北道";
			G.arcs[48][9].adj=60;G.arcs[48][9].name="七星北路，七星中路";
			G.arcs[49][4].adj=32;G.arcs[49][4].name="亲民北道";
			G.arcs[49][54].adj=17;G.arcs[49][54].name="七星北路";
			G.arcs[49][5].adj=32;G.arcs[49][5].name="亲民北道";
			G.arcs[49][7].adj=33;G.arcs[49][7].name="七星北路";
			G.arcs[49][20].adj=92;G.arcs[49][20].name="亲民北道";
			G.arcs[50][8].adj=45;G.arcs[50][8].name="华英道/求是北道";
			G.arcs[50][39].adj=22;G.arcs[50][39].name="西沽中路";
			G.arcs[50][42].adj=22;G.arcs[50][42].name="西沽中路";
			G.arcs[50][6].adj=60;G.arcs[50][6].name="西沽中路，西沽北路";
			G.arcs[50][43].adj=68;G.arcs[50][43].name="西沽中路，西沽北路";
			G.arcs[51][9].adj=95;G.arcs[51][9].name="华英道";
			G.arcs[51][62].adj=42;G.arcs[51][62].name="双台中路";
			G.arcs[51][60].adj=37;G.arcs[51][60].name="新元中路";
			G.arcs[51][21].adj=50;G.arcs[51][21].name="新元中路，新元北路";
			G.arcs[51][23].adj=50;G.arcs[51][23].name="新元中路，新元北路";
			G.arcs[52][32].adj=20;G.arcs[52][32].name="七星南路";
			G.arcs[52][34].adj=25;G.arcs[52][34].name="七星南路";
			G.arcs[52][35].adj=5;G.arcs[52][35].name="七星南路";
			G.arcs[52][13].adj=25;G.arcs[52][13].name="亲民南道";
			G.arcs[52][15].adj=32;G.arcs[52][15].name="七星南路";
			G.arcs[52][36].adj=50;G.arcs[52][36].name="七星南路";
			G.arcs[53][61].adj=25;G.arcs[53][61].name="新园中路";
			G.arcs[53][37].adj=25;G.arcs[53][37].name="书田南道/花堤道";
			G.arcs[53][62].adj=47;G.arcs[53][62].name="双台中路";
			G.arcs[53][16].adj=50;G.arcs[53][16].name="新元中路，新元南路";
			G.arcs[53][18].adj=50;G.arcs[53][18].name="新元中路，新元南路";
			G.arcs[54][49].adj=17;G.arcs[54][49].name="七星北路";
			G.arcs[54][3].adj=30;G.arcs[54][3].name="侯德榜路";
			G.arcs[54][4].adj=37;G.arcs[54][4].name="小路直达";
			G.arcs[54][55].adj=25;G.arcs[54][55].name="七星北路";
			G.arcs[54][49].adj=17;G.arcs[54][49].name="七星北路";
			G.arcs[55][54].adj=25;G.arcs[55][54].name="七星北路";
			G.arcs[55][1].adj=30;G.arcs[55][1].name="侯德榜路";
			G.arcs[55][2].adj=31;G.arcs[55][2].name="七星北路";
			G.arcs[55][3].adj=37;G.arcs[55][3].name="侯德榜路";
			G.arcs[56][66].adj=25;G.arcs[56][66].name="侯德榜路";
			G.arcs[56][65].adj=25;G.arcs[56][65].name="侯德榜路";
			G.arcs[56][67].adj=75;G.arcs[56][67].name="至善东道";
			G.arcs[56][74].adj=62;G.arcs[56][74].name="侯德榜路";
			G.arcs[56][64].adj=30;G.arcs[56][64].name="博文北路/至善东道";
			G.arcs[57][58].adj=50;G.arcs[57][58].name="明德西道";
			G.arcs[57][22].adj=162;G.arcs[57][22].name="亲民西道";
			G.arcs[57][23].adj=125;G.arcs[57][23].name="明德西道";
			G.arcs[58][57].adj=50;G.arcs[58][57].name="明德西道";
			G.arcs[58][23].adj=100;G.arcs[58][23].name="明德西道";
			G.arcs[58][18].adj=150;G.arcs[58][18].name="明德西道";
			G.arcs[58][60].adj=37;G.arcs[58][60].name="小路直达";
			G.arcs[59][69].adj=62;G.arcs[59][69].name="小路直达";
			G.arcs[59][70].adj=50;G.arcs[59][70].name="小路直达";
			G.arcs[59][24].adj=50;G.arcs[59][24].name="明德北道";
			G.arcs[59][67].adj=50;G.arcs[59][67].name="亲民北道";
			G.arcs[59][71].adj=87;G.arcs[59][71].name="兴学路";
			G.arcs[60][58].adj=37;G.arcs[60][58].name="小路直达";
			G.arcs[60][61].adj=50;G.arcs[60][61].name="小路直达";
			G.arcs[60][51].adj=37;G.arcs[60][51].name="新元中路";
			G.arcs[61][60].adj=50;G.arcs[61][60].name="小路直达";
			G.arcs[61][16].adj=55;G.arcs[61][16].name="新元中路，新元南路";
			G.arcs[61][18].adj=55;G.arcs[61][18].name="新元中路，新元南路";
			G.arcs[61][53].adj=25;G.arcs[61][53].name="新元中路";
			G.arcs[62][9].adj=47;G.arcs[62][9].name="七星中路";
			G.arcs[62][11].adj=45;G.arcs[62][11].name="七星中路";
			G.arcs[62][37].adj=50;G.arcs[62][37].name="七星中路/双台中路";
			G.arcs[62][38].adj=50;G.arcs[62][38].name="七星中路";
			G.arcs[62][39].adj=50;G.arcs[62][39].name="七星中路";
			G.arcs[62][51].adj=42;G.arcs[62][51].name="双台中路";
			G.arcs[62][53].adj=47;G.arcs[62][53].name="双台中路";
			G.arcs[63][0].adj=25;G.arcs[63][0].name="西沽北路";
			G.arcs[63][2].adj=25;G.arcs[63][2].name="七星北路";
			G.arcs[63][73].adj=100;G.arcs[63][73].name="至善北道";
			G.arcs[63][64].adj=145;G.arcs[63][64].name="至善北道";
			G.arcs[64][56].adj=30;G.arcs[64][56].name="博文北路/至善东道";
			G.arcs[64][63].adj=145;G.arcs[64][63].name="至善北道";
			G.arcs[64][74].adj=50;G.arcs[64][74].name="至善东道";
			G.arcs[65][56].adj=25;G.arcs[64][56].name="侯德榜路";
			G.arcs[65][66].adj=50;G.arcs[65][66].name="小路直达";
			G.arcs[65][67].adj=50;G.arcs[65][67].name="小路直达";
			G.arcs[65][74].adj=50;G.arcs[65][74].name="侯德榜路";
			G.arcs[66][65].adj=50;G.arcs[66][65].name="小路直达";
			G.arcs[66][56].adj=25;G.arcs[66][56].name="侯德榜路";
			G.arcs[66][67].adj=50;G.arcs[66][67].name="小路直达";
			G.arcs[66][44].adj=40;G.arcs[66][44].name="亲民北道";
			G.arcs[66][45].adj=40;G.arcs[66][45].name="侯德榜路";
			G.arcs[66][68].adj=75;G.arcs[66][68].name="博文北路";
			G.arcs[67][66].adj=50;G.arcs[67][66].name="小路直达";
			G.arcs[67][59].adj=50;G.arcs[67][59].name="亲民北道";
			G.arcs[67][69].adj=37;G.arcs[67][69].name="亲民北道";
			G.arcs[67][68].adj=50;G.arcs[67][68].name="亲民北道";
			G.arcs[67][65].adj=50;G.arcs[67][65].name="小路直达";
			G.arcs[67][74].adj=75;G.arcs[67][74].name="至善东道";
			G.arcs[68][67].adj=50;G.arcs[68][67].name="亲民北道";
			G.arcs[68][66].adj=75;G.arcs[68][66].name="博文北路";
			G.arcs[68][69].adj=15;G.arcs[68][69].name="敬业路";
			G.arcs[68][43].adj=62;G.arcs[68][43].name="亲民北道/明德北道";
			G.arcs[68][44].adj=62;G.arcs[68][44].name="博文北路";
			G.arcs[68][24].adj=50;G.arcs[68][24].name="敬业路";
			G.arcs[69][68].adj=15;G.arcs[69][68].name="敬业路";
			G.arcs[69][67].adj=37;G.arcs[69][67].name="亲民北道";
			G.arcs[69][59].adj=62;G.arcs[69][59].name="小路直达";
			G.arcs[69][70].adj=25;G.arcs[69][70].name="小路直达";
			G.arcs[70][69].adj=25;G.arcs[70][69].name="小路直达";
			G.arcs[70][59].adj=50;G.arcs[70][59].name="小路直达";
			G.arcs[70][24].adj=50;G.arcs[70][24].name="小路直达";
			G.arcs[71][24].adj=75;G.arcs[71][24].name="小路直达";
			G.arcs[71][25].adj=57;G.arcs[71][25].name="小路直达";
			G.arcs[71][26].adj=82;G.arcs[71][26].name="小路直达";
			G.arcs[71][75].adj=75;G.arcs[71][75].name="小路直达";
			G.arcs[72][27].adj=62;G.arcs[72][27].name="小路直达";
			G.arcs[72][28].adj=87;G.arcs[72][28].name="小路直达";
			G.arcs[72][29].adj=87;G.arcs[72][29].name="亲民南道";
			G.arcs[72][30].adj=87;G.arcs[72][30].name="亲民南道";
			G.arcs[73][63].adj=100;G.arcs[73][63].name="至善北道";
			G.arcs[73][20].adj=118;G.arcs[73][20].name="新元北路";
			G.arcs[73][22].adj=118;G.arcs[73][22].name="新元北路";
			G.arcs[74][64].adj=50;G.arcs[74][64].name="至善东道";
			G.arcs[74][65].adj=50;G.arcs[74][65].name="侯德榜路";
			G.arcs[74][67].adj=75;G.arcs[74][67].name="至善东道";
			G.arcs[74][56].adj=62;G.arcs[74][56].name="侯德榜路";
			G.arcs[75][71].adj=75;G.arcs[75][71].name="小路直达";
			G.arcs[76][27].adj=50;G.arcs[76][27].name="博文南路";
			G.arcs[76][28].adj=62;G.arcs[76][28].name="博文南路";
			G.arcs[77][17].adj=75;G.arcs[77][17].name="新元南路";
			G.arcs[77][19].adj=75;G.arcs[77][19].name="新元南路";
			G.arcs[77][33].adj=75;G.arcs[77][33].name="至善南道";
		}else {

			G.arcs[0][1].adj = 20;
			G.arcs[0][1].name = "西沽北路";
			G.arcs[0][63].adj = 25;
			G.arcs[0][63].name = "西沽北路";
			G.arcs[1][0].adj = 20;
			G.arcs[1][0].name = "西沽北路";
			G.arcs[1][55].adj = 30;
			G.arcs[1][55].name = "侯德榜路";
			G.arcs[1][3].adj = 37;
			G.arcs[1][3].name = "西沽北路";
			G.arcs[1][47].adj = 37;
			G.arcs[1][47].name = "西沽北路";
			G.arcs[2][63].adj = 25;
			G.arcs[2][63].name = "七星北路";
			G.arcs[2][55].adj = 37;
			G.arcs[2][55].name = "西沽北路";
			G.arcs[3][4].adj = 20;
			G.arcs[3][4].name = "西沽北路";
			G.arcs[3][55].adj = 31;
			G.arcs[3][55].name = "侯德榜路";
			G.arcs[3][54].adj = 30;
			G.arcs[3][54].name = "侯德榜路";
			G.arcs[3][47].adj = 35;
			G.arcs[3][47].name = "侯德榜路";
			G.arcs[4][3].adj = 20;
			G.arcs[4][3].name = "西沽北路";
			G.arcs[4][49].adj = 32;
			G.arcs[4][49].name = "亲民北道";
			G.arcs[4][5].adj = 32;
			G.arcs[4][5].name = "西沽北路";
			G.arcs[4][46].adj = 37;
			G.arcs[4][46].name = "亲民北道";
			G.arcs[4][43].adj = 50;
			G.arcs[4][43].name = "亲民北道";
			G.arcs[5][4].adj = 32;
			G.arcs[5][4].name = "西沽北路";
			G.arcs[5][6].adj = 25;
			G.arcs[5][6].name = "西沽北路";
			G.arcs[5][7].adj = 37;
			G.arcs[5][7].name = "亲民北道";
			G.arcs[5][43].adj = 50;
			G.arcs[5][43].name = "亲民北道";
			G.arcs[5][46].adj = 33;
			G.arcs[5][46].name = "西沽北路";
			G.arcs[5][49].adj = 32;
			G.arcs[5][49].name = "亲民北道";
			G.arcs[6][5].adj = 25;
			G.arcs[6][5].name = "西沽北路";
			G.arcs[6][7].adj = 32;
			G.arcs[6][7].name = "西沽北路";
			G.arcs[6][43].adj = 50;
			G.arcs[6][43].name = "明德北道";
			G.arcs[6][50].adj = 60;
			G.arcs[6][50].name = "西沽北路";
			G.arcs[7][5].adj = 37;
			G.arcs[7][5].name = "亲民北道";
			G.arcs[7][6].adj = 32;
			G.arcs[7][6].name = "明德北道";
			G.arcs[7][48].adj = 50;
			G.arcs[7][48].name = "明德北道";
			G.arcs[7][49].adj = 33;
			G.arcs[7][49].name = "七星北路";
			G.arcs[12][14].adj = 30;
			G.arcs[12][14].name = "明德南道";
			G.arcs[12][13].adj = 30;
			G.arcs[12][13].name = "西沽南路";
			G.arcs[12][30].adj = 50;
			G.arcs[12][30].name = "明德南道";
			G.arcs[13][12].adj = 30;
			G.arcs[13][12].name = "西沽南路";
			G.arcs[13][15].adj = 30;
			G.arcs[13][15].name = "亲民南道";
			G.arcs[13][30].adj = 50;
			G.arcs[13][30].name = "亲民南道";
			G.arcs[13][52].adj = 25;
			G.arcs[13][52].name = "亲民南道";
			G.arcs[13][29].adj = 40;
			G.arcs[13][29].name = "西沽南路";
			G.arcs[14][12].adj = 30;
			G.arcs[14][12].name = "明德南道";
			G.arcs[14][15].adj = 30;
			G.arcs[14][15].name = "七星南路";
			G.arcs[14][36].adj = 50;
			G.arcs[14][36].name = "明德南道";
			G.arcs[15][13].adj = 30;
			G.arcs[15][13].name = "亲民南道";
			G.arcs[15][14].adj = 30;
			G.arcs[15][14].name = "七星南路";
			G.arcs[15][36].adj = 50;
			G.arcs[15][36].name = "亲民南道";
			G.arcs[15][52].adj = 32;
			G.arcs[15][52].name = "七星南路";
			G.arcs[15][35].adj = 32;
			G.arcs[15][35].name = "七星南路";
			G.arcs[16][17].adj = 30;
			G.arcs[16][17].name = "新元南路/双台南路";
			G.arcs[16][18].adj = 35;
			G.arcs[16][18].name = "明德南道";
			G.arcs[16][19].adj = 30;
			G.arcs[16][19].name = "新元南路";
			G.arcs[16][53].adj = 50;
			G.arcs[16][53].name = "新元南路，新元中路";
			G.arcs[16][61].adj = 55;
			G.arcs[16][61].name = "新元南路，新园中路";
			G.arcs[16][36].adj = 47;
			G.arcs[16][36].name = "明德南道";
			G.arcs[17][16].adj = 30;
			G.arcs[17][16].name = "新元南路/双台南路";
			G.arcs[17][18].adj = 30;
			G.arcs[17][18].name = "新元南路";
			G.arcs[17][19].adj = 35;
			G.arcs[17][19].name = "亲民南道";
			G.arcs[17][36].adj = 47;
			G.arcs[17][36].name = "亲民南道";
			G.arcs[17][35].adj = 30;
			G.arcs[17][35].name = "双台南路";
			G.arcs[17][77].adj = 75;
			G.arcs[17][77].name = "新元南路";
			G.arcs[18][16].adj = 35;
			G.arcs[18][16].name = "明德南道";
			G.arcs[18][19].adj = 30;
			G.arcs[18][19].name = "新元南路";
			G.arcs[18][17].adj = 30;
			G.arcs[18][17].name = "新元南路";
			G.arcs[18][61].adj = 55;
			G.arcs[18][61].name = "新元南路，新园中路";
			G.arcs[18][53].adj = 50;
			G.arcs[18][53].name = "新元南路，新园中路";
			G.arcs[18][58].adj = 150;
			G.arcs[18][58].name = "明德西道";
			G.arcs[19][16].adj = 30;
			G.arcs[19][16].name = "新元南路";
			G.arcs[19][17].adj = 35;
			G.arcs[19][17].name = "亲民南道";
			G.arcs[19][18].adj = 30;
			G.arcs[19][18].name = "新元南路";
			G.arcs[19][57].adj = 300;
			G.arcs[19][57].name = "亲民西道";
			G.arcs[19][77].adj = 75;
			G.arcs[19][77].name = "新元南路";
			G.arcs[20][21].adj = 30;
			G.arcs[20][21].name = "新元北路/双台北路";
			G.arcs[20][22].adj = 35;
			G.arcs[20][22].name = "亲民北道";
			G.arcs[20][23].adj = 30;
			G.arcs[20][23].name = "新元北路";
			G.arcs[20][48].adj = 25;
			G.arcs[20][48].name = "双台北路";
			G.arcs[20][7].adj = 93;
			G.arcs[20][7].name = "亲民北道";
			G.arcs[20][73].adj = 118;
			G.arcs[20][73].name = "新元北路";
			G.arcs[20][49].adj = 92;
			G.arcs[20][49].name = "亲民北道";
			G.arcs[21][20].adj = 30;
			G.arcs[21][20].name = "新元北路/双台北路";
			G.arcs[21][22].adj = 30;
			G.arcs[21][22].name = "新元北路";
			G.arcs[21][23].adj = 35;
			G.arcs[21][23].name = "明德北道";
			G.arcs[21][51].adj = 50;
			G.arcs[21][51].name = "新元北路，新园中路";
			G.arcs[21][48].adj = 47;
			G.arcs[21][48].name = "明德北道";
			G.arcs[22][20].adj = 35;
			G.arcs[22][20].name = "亲民北道";
			G.arcs[22][21].adj = 30;
			G.arcs[22][21].name = "新元北路";
			G.arcs[22][23].adj = 30;
			G.arcs[22][23].name = "新元北路";
			G.arcs[22][73].adj = 118;
			G.arcs[22][73].name = "新元北路";
			G.arcs[22][57].adj = 162;
			G.arcs[22][57].name = "亲民西道";
			G.arcs[23][20].adj = 30;
			G.arcs[23][20].name = "新元北路";
			G.arcs[23][21].adj = 35;
			G.arcs[23][21].name = "明德北道";
			G.arcs[23][22].adj = 30;
			G.arcs[23][22].name = "新元北路";
			G.arcs[23][57].adj = 125;
			G.arcs[23][57].name = "明德西道";
			G.arcs[23][58].adj = 100;
			G.arcs[23][58].name = "明德西道";
			G.arcs[23][51].adj = 50;
			G.arcs[23][51].name = "新元北路，新元中路";
			G.arcs[24][25].adj = 50;
			G.arcs[24][25].name = "敬业路，博文中路";
			G.arcs[24][71].adj = 75;
			G.arcs[24][71].name = "达材环路";
			G.arcs[24][68].adj = 50;
			G.arcs[24][68].name = "敬业路";
			G.arcs[25][24].adj = 50;
			G.arcs[25][24].name = "博文中路，敬业路";
			G.arcs[25][71].adj = 57;
			G.arcs[25][71].name = "小路直达";
			G.arcs[25][26].adj = 62;
			G.arcs[25][26].name = "博文中路";
			G.arcs[25][41].adj = 112;
			G.arcs[25][41].name = "求是大道";
			G.arcs[25][42].adj = 112;
			G.arcs[25][42].name = "求是大道";
			G.arcs[26][25].adj = 62;
			G.arcs[26][25].name = "博文中路";
			G.arcs[26][71].adj = 82;
			G.arcs[26][71].name = "成德环路";
			G.arcs[26][30].adj = 65;
			G.arcs[26][30].name = "博文中路，博文南路";
			G.arcs[27][72].adj = 62;
			G.arcs[27][72].name = "博文南路";
			G.arcs[27][28].adj = 75;
			G.arcs[27][28].name = "至善南道";
			G.arcs[27][76].adj = 50;
			G.arcs[27][76].name = "博文南路";
			G.arcs[28][27].adj = 75;
			G.arcs[28][27].name = "至善南道";
			G.arcs[28][72].adj = 87;
			G.arcs[28][72].name = "博文南路";
			G.arcs[28][29].adj = 50;
			G.arcs[28][29].name = "博文南路/西沽南路";
			G.arcs[28][76].adj = 62;
			G.arcs[28][76].name = "博文南路";
			G.arcs[28][31].adj = 10;
			G.arcs[28][31].name = "西沽南路";
			G.arcs[29][72].adj = 87;
			G.arcs[29][72].name = "亲民南道";
			G.arcs[29][28].adj = 50;
			G.arcs[29][28].name = "博文南路/西沽南路";
			G.arcs[29][30].adj = 50;
			G.arcs[29][30].name = "博文南路/西沽南路";
			G.arcs[29][32].adj = 17;
			G.arcs[29][32].name = "西沽南路";
			G.arcs[29][13].adj = 37;
			G.arcs[29][13].name = "西沽南路";
			G.arcs[30][12].adj = 50;
			G.arcs[30][12].name = "明德南道";
			G.arcs[30][13].adj = 50;
			G.arcs[30][13].name = "亲民南道";
			G.arcs[30][29].adj = 50;
			G.arcs[30][29].name = "博文南路/西沽南路";
			G.arcs[30][72].adj = 87;
			G.arcs[30][72].name = "亲民南道";
			G.arcs[30][26].adj = 75;
			G.arcs[30][26].name = "明德南道";
			G.arcs[31][28].adj = 10;
			G.arcs[31][28].name = "西沽南路";
			G.arcs[31][32].adj = 25;
			G.arcs[31][32].name = "西沽南路/七星南路";
			G.arcs[31][33].adj = 12;
			G.arcs[31][33].name = "七星南路";
			G.arcs[32][31].adj = 25;
			G.arcs[32][31].name = "西沽南路/七星南路";
			G.arcs[32][33].adj = 15;
			G.arcs[32][33].name = "七星南路";
			G.arcs[32][34].adj = 10;
			G.arcs[32][34].name = "七星南路";
			G.arcs[32][29].adj = 12;
			G.arcs[32][29].name = "西沽南路";
			G.arcs[32][52].adj = 20;
			G.arcs[32][52].name = "七星南路";
			G.arcs[33][31].adj = 12;
			G.arcs[33][31].name = "七星南路";
			G.arcs[33][32].adj = 15;
			G.arcs[33][32].name = "七星南路";
			G.arcs[33][34].adj = 17;
			G.arcs[33][34].name = "七星南路/双台南路";
			G.arcs[33][77].adj = 75;
			G.arcs[33][77].name = "至善南道";
			G.arcs[34][33].adj = 17;
			G.arcs[34][33].name = "七星南路/双台南路";
			G.arcs[34][32].adj = 10;
			G.arcs[34][32].name = "七星南路";
			G.arcs[34][35].adj = 25;
			G.arcs[34][35].name = "七星南路/双台南路";
			G.arcs[34][52].adj = 25;
			G.arcs[34][52].name = "七星南路";
			G.arcs[35][36].adj = 50;
			G.arcs[35][36].name = "七星南路/双台南路";
			G.arcs[35][34].adj = 25;
			G.arcs[35][34].name = "七星南路/双台南路";
			G.arcs[35][52].adj = 5;
			G.arcs[35][52].name = "七星南路";
			G.arcs[35][15].adj = 50;
			G.arcs[35][15].name = "亲民南道";
			G.arcs[35][17].adj = 50;
			G.arcs[35][17].name = "亲民南道";
			G.arcs[36][35].adj = 50;
			G.arcs[36][35].name = "七星南路/双台南路";
			G.arcs[36][52].adj = 50;
			G.arcs[36][52].name = "七星南路";
			G.arcs[36][15].adj = 50;
			G.arcs[36][15].name = "七星南路";
			G.arcs[36][17].adj = 47;
			G.arcs[36][17].name = "七星南路";
			G.arcs[36][14].adj = 50;
			G.arcs[36][14].name = "七星南路";
			G.arcs[36][16].adj = 47;
			G.arcs[36][16].name = "七星南路";
			G.arcs[39][50].adj = 50;
			G.arcs[39][50].name = "求是北道";
			G.arcs[41][25].adj = 112;
			G.arcs[41][25].name = "求是大道";
			G.arcs[42][25].adj = 112;
			G.arcs[42][25].name = "求是大道";
			G.arcs[43][5].adj = 50;
			G.arcs[43][5].name = "亲民北道";
			G.arcs[43][6].adj = 50;
			G.arcs[43][6].name = "明德北道";
			G.arcs[43][4].adj = 50;
			G.arcs[43][4].name = "西沽北路";
			G.arcs[43][46].adj = 45;
			G.arcs[43][46].name = "西沽北路";
			G.arcs[43][44].adj = 50;
			G.arcs[43][44].name = "博文北路";
			G.arcs[43][68].adj = 62;
			G.arcs[43][68].name = "亲民北道/明德北道";
			G.arcs[44][45].adj = 37;
			G.arcs[44][45].name = "博文北路";
			G.arcs[44][46].adj = 25;
			G.arcs[44][46].name = "亲民北道";
			G.arcs[44][43].adj = 50;
			G.arcs[44][43].name = "博文北路";
			G.arcs[44][68].adj = 62;
			G.arcs[44][68].name = "亲民北道";
			G.arcs[44][45].adj = 37;
			G.arcs[44][45].name = "博文北路";
			G.arcs[44][66].adj = 40;
			G.arcs[44][66].name = "亲民北道";
			G.arcs[45][44].adj = 37;
			G.arcs[45][44].name = "博文北路";
			G.arcs[45][66].adj = 40;
			G.arcs[45][66].name = "侯德榜路";
			G.arcs[45][47].adj = 30;
			G.arcs[45][47].name = "侯德榜路";
			G.arcs[46][44].adj = 25;
			G.arcs[46][44].name = "亲民北道";
			G.arcs[46][47].adj = 32;
			G.arcs[46][47].name = "西沽北路";
			G.arcs[46][4].adj = 37;
			G.arcs[46][4].name = "亲民北道";
			G.arcs[46][43].adj = 45;
			G.arcs[46][43].name = "西沽北路";
			G.arcs[46][5].adj = 33;
			G.arcs[46][5].name = "西沽北路";
			G.arcs[47][45].adj = 30;
			G.arcs[47][45].name = "侯德榜路";
			G.arcs[47][46].adj = 32;
			G.arcs[47][46].name = "西沽北路";
			G.arcs[47][3].adj = 35;
			G.arcs[47][3].name = "侯德榜路";
			G.arcs[47][1].adj = 37;
			G.arcs[47][1].name = "西沽北路";
			G.arcs[48][7].adj = 50;
			G.arcs[48][7].name = "明德北道";
			G.arcs[48][20].adj = 25;
			G.arcs[48][20].name = "双台北路";
			G.arcs[48][21].adj = 47;
			G.arcs[48][21].name = "明德北道";
			G.arcs[49][4].adj = 32;
			G.arcs[49][4].name = "亲民北道";
			G.arcs[49][54].adj = 17;
			G.arcs[49][54].name = "七星北路";
			G.arcs[49][5].adj = 32;
			G.arcs[49][5].name = "亲民北道";
			G.arcs[49][7].adj = 33;
			G.arcs[49][7].name = "七星北路";
			G.arcs[49][20].adj = 92;
			G.arcs[49][20].name = "亲民北道";
			G.arcs[51][60].adj = 37;
			G.arcs[51][60].name = "新元中路";
			G.arcs[51][21].adj = 50;
			G.arcs[51][21].name = "新元中路，新元北路";
			G.arcs[51][23].adj = 50;G.arcs[51][23].name = "新元中路，新元北路";
			G.arcs[52][32].adj = 20;
			G.arcs[52][32].name = "七星南路";
		    G.arcs[52][34].adj = 25;
			G.arcs[52][34].name = "七星南路";
			G.arcs[52][35].adj = 5;
			G.arcs[52][35].name = "七星南路";
			G.arcs[52][13].adj = 25;
			G.arcs[52][13].name = "亲民南道";
			G.arcs[52][15].adj = 32;
			G.arcs[52][15].name = "七星南路";
			G.arcs[52][36].adj = 50;
			G.arcs[52][36].name = "七星南路";
			G.arcs[53][61].adj = 25;
			G.arcs[53][61].name = "新园中路";
			G.arcs[53][16].adj = 50;
			G.arcs[53][16].name = "新元中路，新元南路";
			G.arcs[53][18].adj = 50;
			G.arcs[53][18].name = "新元中路，新元南路";
			G.arcs[54][49].adj = 17;
			G.arcs[54][49].name = "七星北路";
			G.arcs[54][3].adj = 30;
			G.arcs[54][3].name = "侯德榜路";
			G.arcs[54][55].adj = 25;
			G.arcs[54][55].name = "七星北路";
			G.arcs[54][49].adj = 17;G.arcs[54][49].name = "七星北路";
			G.arcs[55][54].adj = 25;G.arcs[55][54].name = "七星北路";
			G.arcs[55][1].adj = 30;G.arcs[55][1].name = "侯德榜路";
			G.arcs[55][2].adj = 31;G.arcs[55][2].name = "七星北路";
			G.arcs[55][3].adj = 37;G.arcs[55][3].name = "侯德榜路";
			G.arcs[56][66].adj = 25;G.arcs[56][66].name = "侯德榜路";
			G.arcs[56][65].adj = 25;G.arcs[56][65].name = "侯德榜路";
			G.arcs[56][67].adj = 75;G.arcs[56][67].name = "至善东道";
			G.arcs[56][74].adj = 62;G.arcs[56][74].name = "侯德榜路";
			G.arcs[56][64].adj = 30;G.arcs[56][64].name = "博文北路/至善东道";
			G.arcs[57][58].adj = 50;G.arcs[57][58].name = "明德西道";
			G.arcs[57][22].adj = 162;G.arcs[57][22].name = "亲民西道";
			G.arcs[57][23].adj = 125;G.arcs[57][23].name = "明德西道";
			G.arcs[58][57].adj = 50;G.arcs[58][57].name = "明德西道";
			G.arcs[58][23].adj = 100;G.arcs[58][23].name = "明德西道";
			G.arcs[58][18].adj = 150;G.arcs[58][18].name = "明德西道";
			G.arcs[58][60].adj = 37;G.arcs[58][60].name = "小路直达";
			G.arcs[59][69].adj = 62;G.arcs[59][69].name = "亲民南道";
			G.arcs[59][24].adj = 50;G.arcs[59][24].name = "明德北道";
			G.arcs[59][67].adj = 50;G.arcs[59][67].name = "亲民北道";
			G.arcs[59][71].adj = 87;G.arcs[59][71].name = "兴学路";
			G.arcs[60][58].adj = 37;G.arcs[60][58].name = "小路直达";
			G.arcs[60][61].adj = 50;G.arcs[60][61].name = "新园中路";
			G.arcs[60][51].adj = 37;G.arcs[60][51].name = "新元中路";
			G.arcs[61][60].adj = 50;G.arcs[61][60].name = "新园中路";
			G.arcs[61][16].adj = 55;G.arcs[61][16].name = "新元中路，新元南路";
			G.arcs[61][18].adj = 55;G.arcs[61][18].name = "新元中路，新元南路";
			G.arcs[61][53].adj = 25;G.arcs[61][53].name = "新元中路";
			G.arcs[63][0].adj = 25;G.arcs[63][0].name = "西沽北路";
			G.arcs[63][2].adj = 25;G.arcs[63][2].name = "七星北路";
			G.arcs[63][73].adj = 100;G.arcs[63][73].name = "至善北道";
			G.arcs[63][64].adj = 145;G.arcs[63][64].name = "至善北道";
			G.arcs[64][56].adj = 30;G.arcs[64][56].name = "博文北路/至善东道";
			G.arcs[64][63].adj = 145;G.arcs[64][63].name = "至善北道";
			G.arcs[64][74].adj = 50;G.arcs[64][74].name = "至善东道";
			G.arcs[65][56].adj = 25;G.arcs[64][56].name = "侯德榜路";
			G.arcs[65][66].adj = 50;G.arcs[65][66].name = "侯德榜路";
			G.arcs[65][67].adj = 50;G.arcs[65][67].name = "小路直达";
			G.arcs[65][74].adj = 50;G.arcs[65][74].name = "侯德榜路";
			G.arcs[66][65].adj = 50;G.arcs[66][65].name = "侯德榜路";
			G.arcs[66][56].adj = 25;G.arcs[66][56].name = "侯德榜路";
			G.arcs[66][67].adj = 50;G.arcs[66][67].name = "亲民北道";
			G.arcs[66][44].adj = 40;G.arcs[66][44].name = "亲民北道";
			G.arcs[66][45].adj = 40;G.arcs[66][45].name = "侯德榜路";
			G.arcs[66][68].adj = 75;G.arcs[66][68].name = "博文北路";
			G.arcs[67][66].adj = 50;G.arcs[67][66].name = "亲民北道";
			G.arcs[67][59].adj = 50;G.arcs[67][59].name = "亲民北道";
			G.arcs[67][69].adj = 37;G.arcs[67][69].name = "亲民北道";
			G.arcs[67][68].adj = 50;G.arcs[67][68].name = "亲民北道";
			G.arcs[67][65].adj = 50;G.arcs[67][65].name = "小路直达";
			G.arcs[67][74].adj = 75;G.arcs[67][74].name = "至善东道";
			G.arcs[68][67].adj = 50;G.arcs[68][67].name = "亲民北道";
			G.arcs[68][66].adj = 75;G.arcs[68][66].name = "博文北路";
			G.arcs[68][69].adj = 15;G.arcs[68][69].name = "敬业路";
			G.arcs[68][43].adj = 62;G.arcs[68][43].name = "亲民北道/明德北道";
			G.arcs[68][44].adj = 62;G.arcs[68][44].name = "博文北路";
			G.arcs[68][24].adj = 50;G.arcs[68][24].name = "敬业路";
			G.arcs[69][68].adj = 15;G.arcs[69][68].name = "敬业路";
			G.arcs[69][67].adj = 37;G.arcs[69][67].name = "亲民北道";
			G.arcs[69][59].adj = 62;G.arcs[69][59].name = "亲民北道";
			G.arcs[69][70].adj = 25;G.arcs[69][70].name = "小路直达";
			G.arcs[70][69].adj = 25;G.arcs[70][69].name = "小路直达";
			G.arcs[71][24].adj = 75;G.arcs[71][24].name = "达环材路";
			G.arcs[71][25].adj = 57;G.arcs[71][25].name = "小路直达";
			G.arcs[71][26].adj = 82;G.arcs[71][26].name = "成德环路";
			G.arcs[71][75].adj = 75;G.arcs[71][75].name = "小路直达";
			G.arcs[72][27].adj = 62;G.arcs[72][27].name = "博文南路";
			G.arcs[72][28].adj = 87;G.arcs[72][28].name = "博文南路";
			G.arcs[72][29].adj = 87;G.arcs[72][29].name = "亲民南道";
			G.arcs[72][30].adj = 87;G.arcs[72][30].name = "亲民南道";
			G.arcs[73][63].adj = 100;G.arcs[73][63].name = "至善北道";
			G.arcs[73][20].adj = 118;G.arcs[73][20].name = "新元北路";
			G.arcs[73][22].adj = 118;G.arcs[73][22].name = "新元北路";
			G.arcs[74][64].adj = 50;G.arcs[74][64].name = "至善东道";
			G.arcs[74][65].adj = 50;G.arcs[74][65].name = "侯德榜路";
			G.arcs[74][67].adj = 75;G.arcs[74][67].name = "至善东道";
			G.arcs[74][56].adj = 62;G.arcs[74][56].name = "侯德榜路";
			G.arcs[75][71].adj = 75;G.arcs[75][71].name = "小路直达";
			G.arcs[76][27].adj = 50;G.arcs[76][27].name = "博文南路";
			G.arcs[76][28].adj = 62;G.arcs[76][28].name = "博文南路";
			G.arcs[77][17].adj = 75;G.arcs[77][17].name = "新元南路";
			G.arcs[77][19].adj = 75;G.arcs[77][19].name = "新元南路";
			G.arcs[77][33].adj = 75;G.arcs[77][33].name = "至善南道";
		}
		


	}

	void ShortestPath(int num) // 迪杰斯特拉算法最短路径函数 num为入口点的编号 
	{
		int v, w, i, t; // i、w和v为计数变量 
		boolean finals[] = new boolean[NUM];
		int min;
		for (v = 0; v < NUM; v++) {
			finals[v] = false; // 假设从顶点num到顶点v没有最短路径 
			D[v] = G.arcs[num][v].adj;// 将与之相关的权值放入D中存放 

			for (w = 0; w < NUM; w++) // 设置为空路径 
				P[v][w] = 0;
			if (D[v] < 20000) // 存在路径 
			{
				P[v][num] = 1; // 存在标志置为一 
				P[v][v] = 1; // 自身到自身 
			}
		}

		D[num] = 0;
		finals[num] = true; // 初始化num顶点属于S集合 
		// 开始主循环，每一次求得num到某个顶点的最短路径，并将其加入到S集合
		for (i = 0; i < NUM; ++i) // 其余G.vexnum-1个顶点 
		{
			min = Max; // 当前所知离顶点num的最近距离
			for (w = 0; w < NUM; ++w)
				if (!finals[w]) // w顶点在v-s中 
					if (D[w] < min) // w顶点离num顶点更近 
					{
						v = w;
						min = (int) D[w];
					}
			System.out.println("v="+v);
			if(v<78) {
				finals[v] = true; // 离num顶点更近的v加入到s集合 
				for (w = 0; w < NUM; ++w) // 更新当前最短路径极其距离
					if (!finals[w] && ((min + G.arcs[v][w].adj) < D[w]))// 不在s集合，并且比以前所找到的路径都短就更新当前路径 
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

		JLabel Label1 = new JLabel("天津大学校园导航系统");
		Label1.setFont(new Font("造字工房言宋（非商用）常规体", Font.PLAIN, 35));
		Label1.setBounds(49, 13, 368, 82);
		contentPane.add(Label1);

		JButton Button1 = new JButton("确认");
		Button1.setBounds(332, 278, 99, 27);
		contentPane.add(Button1);

		JLabel Label2 = new JLabel("出发地点");
		Label2.setFont(new Font("宋体", Font.PLAIN, 18));
		Label2.setBounds(49, 135, 89, 18);
		contentPane.add(Label2);

		JComboBox<String> comboBox1 = new JComboBox<String>();
		comboBox1.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox1.setBounds(152, 132, 99, 24);
		contentPane.add(comboBox1);

		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox2.setBounds(276, 132, 123, 24);
		contentPane.add(comboBox2);

		JLabel Label3 = new JLabel("目的地点");
		Label3.setFont(new Font("宋体", Font.PLAIN, 18));
		Label3.setBounds(49, 196, 72, 18);
		contentPane.add(Label3);

		JComboBox<String> comboBox3 = new JComboBox<String>();
		comboBox3.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox3.setBounds(152, 193, 99, 24);
		contentPane.add(comboBox3);

		JComboBox<String> comboBox4 = new JComboBox<String>();
		comboBox4.setFont(new Font("宋体", Font.PLAIN, 18));
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
		
		JRadioButton RadioButton1 = new JRadioButton("机动车");
		RadioButton1.setFont(new Font("宋体", Font.PLAIN, 18));
		RadioButton1.setBounds(192, 242, 83, 27);
		contentPane.add(RadioButton1);
		
		JRadioButton RadioButton2 = new JRadioButton("自行车");
		RadioButton2.setFont(new Font("宋体", Font.PLAIN, 18));
		RadioButton2.setBounds(305, 242, 83, 27);
		contentPane.add(RadioButton2);
		
		JLabel LabelNot = new JLabel("【注】双台中路、七星中路、西沽中路机动车禁止通行");
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
		

		String type[] = { "选择类型", "宿舍楼", "教学楼", "食堂", "活动地点", "校园湖泊", "校园大门" };
		String sushe[] = { "格园1斋", "格园2斋", "格园3斋", "知园4斋", "知园5斋", "诚园6斋", "诚园7斋", "诚园8斋", "正园9斋", "正园10斋", "修园11斋",
				"修园12斋", "齐园13斋", "齐园14斋", "齐园15斋", "齐园16斋", "治园17斋", "治园18斋", "治园19斋", "治园20斋", "平园21斋", "平园22斋",
				"平园23斋", "平园24斋" };
		String jiaoxuelou[] = { "31教学楼", "32教学楼楼", "33教学楼", "34教学楼", "35教学楼", "36教学楼", "37教学楼", "38教学楼", "39教学楼",
				"40教学楼", "41教学楼", "42教学楼", "43教学楼", "44教学楼", "45教学楼", "46教学楼", "47教学楼", "48教学楼", "49教学楼", "50教学楼",
				"51教学楼", "52教学楼", "53教学楼", "54教学楼", "55教学楼" };
		String shitang[] = { "学一(梅园)", "学二(兰园)", "学三(棠园)", "学四(竹园)", "学五(桃园)", "学六(菊园)", "留园餐厅", "青园餐厅" };
		String lake[] = { "龙园湖", "青年湖", "敬业湖" };
		String huodonglou[] = { "学生中心", "太雷广场", "郑东图书馆", "留学生公寓", "青年教师公寓", "校医院", "综合体育馆", "体育场", "行政服务中心", "工会",
				"教职工服务中心", "北洋广场", "体育公园" };
		String door[] = { "北门", "东北门", "南门", "东南门", "东门" };

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
				if (choose.equals("宿舍楼")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < sushe.length; i++) {
						comboBox2.addItem(sushe[i]);
					}
				} else if (choose.equals("食堂")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < shitang.length; i++) {
						comboBox2.addItem(shitang[i]);
					}
				} else if (choose.equals("教学楼")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < jiaoxuelou.length; i++) {
						comboBox2.addItem(jiaoxuelou[i]);
					}
				} else if (choose.equals("活动地点")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < huodonglou.length; i++) {
						comboBox2.addItem(huodonglou[i]);
					}
				} else if (choose.equals("校园大门")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < door.length; i++) {
						comboBox2.addItem(door[i]);
					}
				} else if (choose.equals("校园湖泊")) {
					comboBox2.removeAllItems();
					for (int i = 0; i < lake.length; i++) {
						comboBox2.addItem(lake[i]);
					}
				} else if (choose.equals("选择类型")) {
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
				if (choose.equals("宿舍楼")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < sushe.length; i++) {
						comboBox4.addItem(sushe[i]);
					}
				} else if (choose.equals("食堂")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < shitang.length; i++) {
						comboBox4.addItem(shitang[i]);
					}
				} else if (choose.equals("教学楼")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < jiaoxuelou.length; i++) {
						comboBox4.addItem(jiaoxuelou[i]);
					}
				} else if (choose.equals("活动地点")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < huodonglou.length; i++) {
						comboBox4.addItem(huodonglou[i]);
					}
				} else if (choose.equals("校园大门")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < door.length; i++) {
						comboBox4.addItem(door[i]);
					}
				} else if (choose.equals("校园湖泊")) {
					comboBox4.removeAllItems();
					for (int i = 0; i < lake.length; i++) {
						comboBox4.addItem(lake[i]);
					}
				} else if (choose.equals("选择类型")) {
					comboBox4.removeAllItems();
				}
			}
		});

		Button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Button1.getText().equals("确认") && !comboBox1.getSelectedItem().equals("选择类型")
						&& !comboBox3.getSelectedItem().equals("选择类型")&&RadioButton2.isSelected()) {
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
					Button1.setText("退出");
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
					a = sight2; // 将景点二赋值给a 
					if (a != sight1) //如果景点二不和景点一输入重合，则进行...
					{
						String ans = "从" + G.vex[sight1].sight + "到" + G.vex[sight2].sight;
						ans += "最短距离为 " + D[a] + "米\n";
						ans += G.vex[sight1].sight;
						
						d = sight1; // 将景点一的编号赋值给d 

						for (c = 0; c < NUM; ++c) {
							P[a][sight1] = 0;
							for (b = 0; b < NUM; b++) {
								if (G.arcs[d][b].adj < 20000 && P[a][b] >= 1) // 如果景点一和它的一个临界点之间存在路径且最短路径 
								{
									ans += "-->" +"经过"+  G.arcs[d][b].name+"-->"+ G.vex[b].sight+"\n";
									
									q = q + 1; // 计数变量加一，满8控制输出时的换行 
									P[a][b] = 0;
									d = b; // 将b作为出发点进行下一次循环输出，如此反复
									if (q % 8 == 0)
										ans += "\n";
									break;
								}
							}
						}
						textArea1.setText(ans);
					}
				} else if (Button1.getText().equals("确认") && !comboBox1.getSelectedItem().equals("选择类型")
						&& !comboBox3.getSelectedItem().equals("选择类型")&&RadioButton1.isSelected()) {
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
					Button1.setText("退出");
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
					a = sight2; // 将景点二赋值给a 
					if (a != sight1&&D[a]!=1) //如果景点二不和景点一输入重合，则进行... 
					{
						String ans = "从" + G.vex[sight1].sight + "到" + G.vex[sight2].sight;
						ans += "最短距离为 " + D[a] + "米\n";
						ans += G.vex[sight1].sight;
						
						d = sight1; // 将景点一的编号赋值给d 

						for (c = 0; c < NUM; ++c) {
							P[a][sight1] = 0;
							for (b = 0; b < NUM; b++) {
								if (G.arcs[d][b].adj < 20000 && P[a][b] >= 1) // 如果景点一和它的一个临界点之间存在路径且最短路径 
								{
									ans += "-->" +"经过"+  G.arcs[d][b].name+"-->"+ G.vex[b].sight+"\n";
									q = q + 1; // 计数变量加一，满8控制输出时的换行 
									P[a][b] = 0;
									d = b; // 将b作为出发点进行下一次循环输出，如此反复 
									if (q % 8 == 0)
										ans += "\n";
									break;
								}
							}
						}
						textArea1.setText(ans);
						 for(b=0;b<NUM;b++){
							 if(P[a][b]==20000){
								 textArea1.setText("该路段禁止机动车通行，无法到达目的地，请步行前往");
							 }
						}
						 if(D[a]>=20000) {
							 textArea1.setText("该路段禁止机动车通行，无法到达目的地，请步行前往");
						 }
					}
				}else if (Button1.getText().equals("退出")) {
					System.exit(0);
				} else {
					if (comboBox1.getSelectedItem().equals("选择类型"))
						JOptionPane.showMessageDialog(contentPane, "你没有选择出发地点", "注意", 1);
					else if (comboBox3.getSelectedItem().equals("选择类型"))
						JOptionPane.showMessageDialog(contentPane, "你没有选择目的地点", "注意", 1);
				}
			}
		});
	}
}
