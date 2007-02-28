package ru.amse.sd.mvc.onetomany.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import ru.amse.sd.mvc.onetomany.DataChangedListener;
import ru.amse.sd.mvc.onetomany.NotifyingDataArray;
import ru.amse.sd.mvc.onetomany.view.barchart.BarChartView;
import ru.amse.sd.mvc.onetomany.view.tree.NotifiedTreeView;

public class CopyOfMainWithListAndBar {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		JFrame frame = new JFrame("One-to-one");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		final NotifyingDataArray data = new NotifyingDataArray();
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		data.add(6);
		data.add(7);
		data.add(8);
		data.add(9);
		NotifiedTreeView view = new NotifiedTreeView(data);
		frame.getContentPane().add(view, BorderLayout.CENTER);
		final JList list = new JList();
		DefaultListModel listModel = new DefaultListModel() {
		
					{
						data.addDataChangedListener(new DataChangedListener() {
							public void dataChanged() {
								fireContentsChanged(list, 0, size() - 1);
							}
						});
					}
		
					@Override
					public Object getElementAt(int index) {
						return data.get(index);
					}
		
					@Override
					public int getSize() {
						return data.size();
					}
				};
		list.setModel(listModel);
		list.setPreferredSize(new Dimension(200, 0));
		frame.getContentPane().add(list, BorderLayout.EAST);
		BarChartView barChartView = new BarChartView(data);
		barChartView.setPreferredSize(new Dimension(0, 200));
		frame.getContentPane().add(barChartView, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}

}
