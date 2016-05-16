package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import data.ProjectDao;
import models.Project;
import models.User;
import services.DataService;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GenericDataTablePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GenericDataTablePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel create = new CreateProjectPanel();
		create.setBackground(Color.GREEN);
		add(create, BorderLayout.SOUTH);
		
		JPanel search = new JPanel();
		search.setBackground(Color.ORANGE);
		add(search, BorderLayout.NORTH);
		
		JScrollPane databasetable = new JScrollPane();
		add(databasetable, BorderLayout.CENTER);
		
		table = this.JTableProject();
		databasetable.setViewportView(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{						
				table = JTableProject();
				databasetable.setViewportView(table);
			}
		});
		search.add(btnNewButton);
	}
	
	private JTable JTableProject()
	{
		JTable table = null;
		//when clicking on refresh, create a new table
		User temp = State.getStateInstance().getUser();
		DataService ds = new DataService();
		table = new JTable(ds.GetProjectTableData(temp.getId()), ds.GetProjectTableColumns());
		table.setBackground(Color.WHITE);		
		return table;		
	}

}
