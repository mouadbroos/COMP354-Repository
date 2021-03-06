package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.ProjectDao;
import models.Project;
import models.User;
import controllers.DataService;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSplitPane;

public class ProjectsTab extends JPanel {
	private JTable table;
	private CreateProjectPanel createPanel ; 
	private UpdateProjectPanel updatePanel ;
	private JScrollPane databasetable;

	/**
	 * Create the panel.
	 */
	public ProjectsTab() {
		setLayout(new BorderLayout(0, 0));
		
//		JPanel search = new JPanel();
//		search.setBackground(Color.ORANGE);
//		add(search, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.SOUTH);
		
		createPanel = new CreateProjectPanel(this);
		updatePanel = new UpdateProjectPanel(this);
		//updatePanel.setStartDateField("1991-10-28");
	
		splitPane.setLeftComponent(createPanel);
		splitPane.setRightComponent(updatePanel);
		
		splitPane.setResizeWeight(.5d);
		
		databasetable = new JScrollPane();
		add(databasetable, BorderLayout.CENTER);
		
		//table = this.JTableProject(createPanel,updatePanel);
		table = this.JTableProject();
		databasetable.setViewportView(table);
		
//		JButton refreshButton = new JButton("Refresh");
//		refreshButton.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{						
//				//table = JTableProject();
//				//databasetable.setViewportView(table);
//				 refreshTable();
//			}
//		});
//		search.add(refreshButton);
	}
	
	private JTable JTableProject()
	{
		//JTable table = null;
		//when clicking on refresh, create a new table
		User temp = State.getStateInstance().getUser();
		DataService ds = new DataService();
		table = new JTable(ds.GetProjectTableData(temp.getId()), ds.GetProjectTableColumns());
		table.setBackground(Color.WHITE);
		table.setGridColor(Color.GRAY);
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        
		        //column 4 is click to look at activities of a project
		        if (row >= 0 && col == 4) {
		        	System.out.println("Activities will open for project with id:" + table.getModel().getValueAt(row, 0));
		        	
		        	//get data for activities;
		        	int projectId = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		        	Project temp = new Project(projectId);        	
		        	State.getStateInstance().setProject(temp);
		        	
		        	ActivitiesTab tab = State.getStateInstance().activityTab;
		        	tab.refreshTable();
		        	State.getStateInstance().getProjectsView().tabbedPane.setSelectedIndex(1); //switches tabbed panes to the activity tab pane
		        	
		        }
		        //column 5 is update project
		        if (row >= 0 && col == 5) {
		        	System.out.println("Update project with id:" + table.getModel().getValueAt(row, 0));
		        	
		        	updatePanel.setActiveProject(Integer.parseInt(table.getModel().getValueAt(row, 0).toString()));
		        	updatePanel.setStartDateField(table.getModel().getValueAt(row, 2).toString());
		        	updatePanel.setEndDateField(table.getModel().getValueAt(row, 3).toString());
		        	updatePanel.setProjectField(table.getModel().getValueAt(row, 1).toString());
		        	
		        }
		        
		        //column 6 is delete project
		        if (row >= 0 && col == 6) {
		        	System.out.println("Delete project with id:" + table.getModel().getValueAt(row, 0));
		        	int projectId = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		        	new ProjectDao().DeleteProject(projectId);
		        	refreshTable();
		        }
		    }
		});
		
		
		return table;		
	}
	
	public void refreshTable(){
		table = JTableProject();
		databasetable.setViewportView(table);
	}
}
