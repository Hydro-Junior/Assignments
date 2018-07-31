import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This program is to compare the times of four different
 * operations(add(),get(),remove(),sort()) on two kinds of list : ArrayList and
 * LinkedList,and show the results through GUI.
 * 
 * Note: 1. There are some different ways to do the method sort().I have tried
 * getting every elements and putting it on the correct position of the list,but
 * in this way ,the efficiency become very low,so finally I chose
 * Collection.sort(List). 
 * 
 * 2. The magnitude of time may be different in different
 * methods, so I will adjust the height of bar in the proper way to achieve the
 * best presentation,rather than divide each time by 10.
 * 
 * @author
 *
 */
public class ArrayListVSLinkedList extends JFrame {
	// four lists
	private static ArrayList<Integer> originArrayList, sortedArrayList;
	private static LinkedList<Integer> originLinkedList, sortedLinkedList;
	// different operation times
	private static double addTimeOfArrayList, getTimeOfArrayList, removeTimeOfArrayList, sortTimeOfArrayList;
	private static double addTimeOfLinkedList, getTimeOfLinkedList, removeTimeOfLinkedList, sortTimeOfLinkedList;

	// initialize four lists
	public static void init() {
		originArrayList = new ArrayList<Integer>();
		sortedArrayList = new ArrayList<Integer>();
		originLinkedList = new LinkedList<Integer>();
		sortedLinkedList = new LinkedList<Integer>();
		System.out.println("game start!");
	}

	// add 6000000 numbers into two lists
	public static void add() {
		originArrayList.clear();
		originLinkedList.clear();
		Random r = new Random();
		long startArray = System.currentTimeMillis();// Starting time
		for (int i = 0; i < 6000000; i++) {
			originArrayList.add(r.nextInt(10000));
		}
		long endArray = System.currentTimeMillis();// Ending time for ArrayList and starting time for LinkedList
		for (int i = 0; i < 6000000; i++) {
			originLinkedList.add(r.nextInt(10000));
		}
		long endLinked = System.currentTimeMillis();// Ending time for LinkedList.
		//results
		addTimeOfArrayList = (endArray - startArray) / 1000.0;
		addTimeOfLinkedList = (endLinked - endArray) / 1000.0;
		System.out.println("Time Of add method:\r\n" + "ArrayList: " + String.format("%.3f", addTimeOfArrayList) + "\n"
				+ "LinkedList: " + String.format("%.3f", addTimeOfLinkedList));
	}

	// get 1000 numbers from list whose size is 6000000
	public static void get() {
		Random r = new Random();
		// In case of doing get() before add() <there is no elements in the list>,add
		// 6000000 numbers into it firstly.
		if (originArrayList.isEmpty()) {
			for (int i = 0; i < 6000000; i++) {
				originArrayList.add(r.nextInt(10000));
			}
		}
		if (originLinkedList.isEmpty()) {
			for (int i = 0; i < 6000000; i++) {
				originLinkedList.add(r.nextInt(10000));
			}
		}
		long startArray = System.currentTimeMillis();// Starting time
		for (int i = 0; i < 1000; i++) {
			originArrayList.get(r.nextInt(6000000));
		}
		long endArray = System.currentTimeMillis();// Ending time for ArrayList and starting time for LinkedList

		for (int i = 0; i < 1000; i++) {
			originLinkedList.get(r.nextInt(6000000));
		}
		long endLinked = System.currentTimeMillis();// Ending time for LinkedList.
		//results
		getTimeOfArrayList = (endArray - startArray) / 1000.0;
		getTimeOfLinkedList = (endLinked - endArray) / 1000.0;
		System.out.println("Time Of get method:\r\n" + "ArrayList: " + String.format("%.3f", getTimeOfArrayList) + "\n"
				+ "LinkedList: " + String.format("%.3f", getTimeOfLinkedList));
	}

	// remove 1000 numbers from list whose size is 100000
	public static void remove() {
		Random r = new Random();
		// In case of doing remove() before add() <there is no elements in the list>,add
		// 6000000 numbers into it firstly.
		if (originArrayList.isEmpty()) {
			for (int i = 0; i < 6000000; i++) {
				originArrayList.add(r.nextInt(10000));
			}
		}
		if (originLinkedList.isEmpty()) {
			for (int i = 0; i < 6000000; i++) {
				originLinkedList.add(r.nextInt(10000));
			}
		}
		long startArray = System.currentTimeMillis();// Starting time
		for (int i = 0; i < 1000; i++) {
			originArrayList.remove(r.nextInt(100000));
		}
		long endArray = System.currentTimeMillis();// Ending time for ArrayList and starting time for LinkedList
		for (int i = 0; i < 1000; i++) {
			originLinkedList.remove(r.nextInt(100000));
		}
		long endLinked = System.currentTimeMillis();// Ending time for LinkedList.
		//results
		removeTimeOfArrayList = (endArray - startArray) / 1000.0;
		removeTimeOfLinkedList = (endLinked - endArray) / 1000.0;
		System.out.println("Time Of remove method:\r\n" + "ArrayList: " + String.format("%.3f", removeTimeOfArrayList)
				+ "\n" + "LinkedList: " + String.format("%.3f", removeTimeOfLinkedList));
	}

	// sort two lists whose sizes both are 10000
	public static void sort() {
		originArrayList.clear();
		originLinkedList.clear();
		// ensure that the sorted lists are empty before sorting
		if (!sortedArrayList.isEmpty()) {
			sortedArrayList.clear();
		}
		if (!sortedLinkedList.isEmpty()) {
			sortedLinkedList.clear();
		}
		Random r = new Random();
		// add the same random sequence into two lists
		for (int i = 0; i < 10000; i++) {
			int generatedInt = r.nextInt(100000);
			originArrayList.add(generatedInt);
			originLinkedList.add(generatedInt);
		}

		long start = System.currentTimeMillis();// Starting time
		// copy the original list
		for (int i = 0; i < 10000; i++) {
			sortedArrayList.add(originArrayList.get(i));
		}
		//do sort
		Collections.sort(sortedArrayList);
		long endArray = System.currentTimeMillis();// Ending time for ArrayList and starting time for LinkedList
		// copy the original list
		for (int i = 0; i < 10000; i++) {
			sortedLinkedList.add(originArrayList.get(i));
		}
		//do sort
		Collections.sort(sortedLinkedList);
		long endLinked = System.currentTimeMillis();// Ending time for LinkedList.
		//results
		sortTimeOfArrayList = (endArray - start) / 1000.0;
		sortTimeOfLinkedList = (endLinked - endArray) / 1000.0;
		System.out.println("Time Of sort method:\r\n" + "ArrayList: " + String.format("%.3f", sortTimeOfArrayList)
				+ "\n" + "LinkedList: " + String.format("%.3f", sortTimeOfLinkedList));
	}

	public static void main(String[] args) {
		init();
		add();
		get();
		remove();
		sort();
		new barFrame(addTimeOfArrayList, addTimeOfLinkedList, getTimeOfArrayList, getTimeOfLinkedList,
				removeTimeOfArrayList, removeTimeOfLinkedList, sortTimeOfArrayList, sortTimeOfLinkedList);

	}

	static class barFrame {
		static final int W = 1200, H = 800;// width and height of JFrame
		private JFrame f;
		private JPanel p;
		private JLabel lab0, lab1, lab2, lab3, lab4, refLab1, refLab2;
		private JButton barALadd, barLLadd, barALget, barLLget, barALrmv, barLLrmv, barALsort, barLLsort;

		final String[] barTitle = new String[] { "add()", "get()", "remove()", "sort()" };
		static final String mainTitle = "ArrayList vs LinkedList";
		int detaList = 175;// the interval range between lists on the same operation
		int detaOp = 250; // the interval range between adjacent operations
		// x coordinate for eight results
		int x1 = 100, x2 = x1 + detaList;
		int x3 = x1 + detaOp, x4 = x3 + detaList;
		int x5 = x3 + detaOp, x6 = x5 + detaList;
		int x7 = x5 + detaOp, x8 = x7 + detaList;
		int y = 700;// the same y coordinate for 4 lines

		public barFrame(double timeALadd, double timeLLadd, double timeALget, double timeLLget, double timeALremove,
				double timeLLremove, double timeALsort, double timeLLsort) { // constructor
			int width = 50;
			int height = 200;
			// calculate proper heights for bars
			int h1 = (int) (height * timeALadd * 0.2);
			int h2 = (int) (height * timeLLadd * 0.2);
			int h3 = (int) (height * timeALget * 0.2);
			int h4 = (int) (height * timeLLget * 0.2);
			int h5 = (int) (height * timeALremove * 0.2);
			int h6 = (int) (height * timeLLremove * 0.2);
			int h7 = (int) (height * timeALsort * 10);
			int h8 = (int) (height * timeLLsort * 10);
			f = new JFrame("Welcome to ArrayList & LinkedList World!");
			f.setSize(W, H);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			p = new JPanel() {
				public void paintComponent(Graphics g) {
					// Draw what you want to appear on your JPanel here.
					super.paintComponent(g);
					setBackground(Color.GRAY);
					// base lines
					g.setColor(Color.black);
					g.drawLine(x1, y, x2, y);
					g.drawLine(x3, y, x4, y);
					g.drawLine(x5, y, x6, y);
					g.drawLine(x7, y, x8, y);

					g.setColor(Color.BLUE);
					g.fillRect(4 * W / 5, 40, 20, 20);// reference color for ArrayList
					g.setColor(Color.BLACK);
					g.fillRect(4 * W / 5, 70, 20, 20);// reference color for LinkedList
					/**
					 * the bar can also be drown
					 */
					/*
					 * // bar g.setColor(Color.BLUE); g.fillRect(4*W/5, 40, 20, 20);//reference
					 * color for ArrayList //draw the bars g.fillRect(x1+width/2, y-h1, width, h1);
					 * g.fillRect(x3+width/2, y-h3, width, h3); g.fillRect(x5+width/2, y-h5, width,
					 * h5); g.fillRect(x7+width/2, y-h7, width, h7); g.setColor(Color.BLACK);
					 * g.fillRect(4*W/5, 70, 20, 20);//reference color for LinkedList //draw the
					 * bars g.fillRect(x2-width-width/2, y-h2, width, h2);
					 * g.fillRect(x4-width-width/2, y-h4, width, h4); g.fillRect(x6-width-width/2,
					 * y-h6, width, h6); g.fillRect(x8-width-width/2, y-h8, width, h8);
					 */

					// show the time results
					g.setColor(Color.WHITE);
					g.setFont(new Font("Serif", Font.BOLD, 20));
					// little interval range for string results
					int intervalX = 7;
					int intervalY = 3;
					// write the time results in the panel
					g.drawString(String.format("%.3f", addTimeOfArrayList) + "sec", x1 + width / 2 - intervalX,
							y - h1 - intervalY);
					g.drawString(String.format("%.3f", addTimeOfLinkedList) + "sec", x2 - width - width / 2 - intervalX,
							y - h2 - intervalY);
					g.drawString(String.format("%.3f", getTimeOfArrayList) + "sec", x3 + width / 2 - intervalX,
							y - h3 - 2);
					g.drawString(String.format("%.3f", getTimeOfLinkedList) + "sec", x4 - width - width / 2 - intervalX,
							y - h4 - intervalY);
					g.drawString(String.format("%.3f", removeTimeOfArrayList) + "sec", x5 + width / 2 - intervalX,
							y - h5 - intervalY);
					g.drawString(String.format("%.3f", removeTimeOfLinkedList) + "sec",
							x6 - width - width / 2 - intervalX, y - h6 - intervalY);
					g.drawString(String.format("%.3f", sortTimeOfArrayList) + "sec", x7 + width / 2 - intervalX,
							y - h7 - intervalY);
					g.drawString(String.format("%.3f", sortTimeOfLinkedList) + "sec",
							x8 - width - width / 2 - intervalX, y - h8 - intervalY);
				}
			};

			p.setLayout(null);

			// label for title
			lab0 = new JLabel(mainTitle);
			lab0.setForeground(Color.LIGHT_GRAY);
			lab0.setBounds(W / 4, 0, W - 20, H / 6);
			lab0.setFont(new Font("Serif", Font.PLAIN, 50));

			// labels for different method
			lab1 = new JLabel(barTitle[0]);
			lab1.setForeground(Color.white);
			lab1.setBounds(x1 + (x2 - x1) / 3, y - 20, 400, 100);
			lab1.setFont(new Font("Serif", Font.PLAIN, 30));
			lab1.setMinimumSize(new Dimension(100, 100));

			lab2 = new JLabel(barTitle[1]);
			lab2.setForeground(Color.white);
			lab2.setBounds(x3 + (x4 - x3) / 3, y - 20, 400, 100);
			lab2.setFont(new Font("Serif", Font.PLAIN, 30));
			lab2.setMinimumSize(new Dimension(100, 100));

			lab3 = new JLabel(barTitle[2]);
			lab3.setForeground(Color.white);
			lab3.setBounds(x5 + (x6 - x5) / 3 - 10, y - 20, 400, 100);
			lab3.setFont(new Font("Serif", Font.PLAIN, 30));
			lab3.setMinimumSize(new Dimension(100, 100));

			lab4 = new JLabel(barTitle[3]);
			lab4.setForeground(Color.white);
			lab4.setBounds(x7 + (x8 - x7) / 3, y - 20, 400, 100);
			lab4.setFont(new Font("Serif", Font.PLAIN, 30));
			lab4.setMinimumSize(new Dimension(100, 100));

			refLab1 = new JLabel("ArrayList");
			refLab1.setForeground(Color.BLACK);
			refLab1.setBounds(4 * W / 5 + 30, 20, 100, 60);
			refLab1.setFont(new Font("Serif", Font.PLAIN, 20));

			refLab2 = new JLabel("LinkedList");
			refLab2.setForeground(Color.BLACK);
			refLab2.setBounds(4 * W / 5 + 30, 50, 100, 60);
			refLab2.setFont(new Font("Serif", Font.PLAIN, 20));

			// the bars represent the time
			barALadd = new JButton("");
			barALadd.setBounds(x1 + width / 2, y - h1, width, h1); // size of the button (bar)
			barALadd.setBackground(Color.BLUE);
			barALadd.setFont(new Font("Serif", Font.PLAIN, 30));

			barLLadd = new JButton("");
			barLLadd.setBounds(x2 - width - width / 2, y - h2, width, h2); // size of the button (bar)
			barLLadd.setBackground(Color.BLACK);
			barLLadd.setFont(new Font("Serif", Font.PLAIN, 30));

			barALget = new JButton("");
			barALget.setBounds(x3 + width / 2, y - h3, width, h3); // size of the button (bar)
			barALget.setBackground(Color.BLUE);

			barLLget = new JButton("");
			barLLget.setBounds(x4 - width - width / 2, y - h4, width, h4); // size of the button (bar)
			barLLget.setBackground(Color.BLACK);

			barALrmv = new JButton("");
			barALrmv.setBounds(x5 + width / 2, y - h5, width, h5); // size of the button (bar)
			barALrmv.setBackground(Color.BLUE);

			barLLrmv = new JButton("");
			barLLrmv.setBounds(x6 - width - width / 2, y - h6, width, h6); // size of the button (bar)
			barLLrmv.setBackground(Color.black);

			barALsort = new JButton("");
			barALsort.setBounds(x7 + width / 2, y - h7, width, h7); // size of the button (bar)
			barALsort.setBackground(Color.BLUE);

			barLLsort = new JButton("");
			barLLsort.setBounds(x8 - width - width / 2, y - h8, width, h8); // size of the button (bar)
			barLLsort.setBackground(Color.black);

			// add components into panel
			p.add(lab0);
			p.add(lab1);
			p.add(lab2);
			p.add(lab3);
			p.add(lab4);
			p.add(refLab1);
			p.add(refLab2);
			p.add(barALadd);
			p.add(barLLadd);
			p.add(barALget);
			p.add(barLLget);
			p.add(barALrmv);
			p.add(barLLrmv);
			p.add(barALsort);
			p.add(barLLsort);
			// add panel into the frame
			f.add(p);
			f.setVisible(true);
		}
	}

}
