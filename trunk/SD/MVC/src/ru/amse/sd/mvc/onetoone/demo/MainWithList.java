package ru.amse.sd.mvc.onetoone.demo;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import ru.amse.sd.mvc.onetoone.DataArray;
import ru.amse.sd.mvc.onetoone.view.TreeView;


public class MainWithList {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		JFrame frame = new JFrame("One-to-one");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		final DataArray data = new DataArray();
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
		JList list = new JList(new DefaultListModel() {
					@Override
					public Object getElementAt(int index) {
						return data.get(index);
					}
					
					@Override
					public int getSize() {
						return data.size();
					}
				});
		list.setPreferredSize(new Dimension(200, 0));
		frame.getContentPane().add(list, BorderLayout.EAST);
		frame.setVisible(true);		
	}

}
