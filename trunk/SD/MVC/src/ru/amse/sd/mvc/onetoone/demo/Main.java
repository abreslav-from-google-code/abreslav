package ru.amse.sd.mvc.onetoone.demo;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import ru.amse.sd.mvc.onetoone.DataArray;
import ru.amse.sd.mvc.onetoone.view.TreeView;



public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("One-to-one");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		DataArray data = new DataArray();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(6);
		data.add(7);
		data.add(8);
		data.add(9);
		TreeView view = new TreeView(data);
		frame.getContentPane().add(view, BorderLayout.CENTER);
		frame.setVisible(true);		
	}
	
}
