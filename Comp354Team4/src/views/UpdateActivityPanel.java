package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import models.ProjectDao;
import models.Activity;
import models.ActivityDao;
import models.Project;
import models.User;
import controllers.ConverterService;
import controllers.DataService;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UpdateActivityPanel extends JPanel {
	
	private ActivitiesTab parentPanel;
	
	private int activityID = 0 ;   
	private JTextField endDateField;
	private JTextField startDateField;
	private JTextField activityField;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField descriptionField;
	
	
	public void setDescriptionField(String description){	
		descriptionField.setText(description);
	}
	public void setEndDateField(String endDate){	
		endDateField.setText(endDate);
	}
	public void setStartDateField(String startDate){	
		startDateField.setText(startDate);
	}
	public void setProjectField(String projectFieldStr){	
		activityField.setText(projectFieldStr);
	}
	
	public void setActiveProject(int activityID)
	{
		this.activityID = activityID;
	}
	
	
	/**
	 * Create the panel.
	 */
	public UpdateActivityPanel(ActivitiesTab parentPanel) {
		this.parentPanel = parentPanel;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_2.add(panel_6, gbc_panel_6);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_1 = new JLabel("Activity Name");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel_3.add(label_1, gbc_label_1);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		activityField = new JTextField();
		activityField.setColumns(10);
		panel_4.add(activityField, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 3;
		panel_2.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 5;
		panel_2.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 0;
		panel_7.add(lblDescription, gbc_lblDescription);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 3;
		gbc_panel_12.gridy = 0;
		panel_7.add(panel_12, gbc_panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		descriptionField = new JTextField();
		descriptionField.setText("");
		descriptionField.setColumns(10);
		panel_12.add(descriptionField, BorderLayout.CENTER);

		
		JLabel lblStartDate = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 0;
		panel_10.add(lblStartDate, gbc_lblStartDate);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 3;
		gbc_panel_11.gridy = 0;
		panel_10.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		startDateField = new JTextField();
		startDateField.setColumns(10);
		panel_11.add(startDateField, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 4;
		panel_2.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblNewLabel = new JLabel("End Date");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_8.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 3;
		gbc_panel_9.gridy = 0;
		panel_8.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		endDateField = new JTextField();
		panel_9.add(endDateField, BorderLayout.CENTER);
		endDateField.setColumns(10);
		
		//what happens when update button clicked
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{						
				try 
				{
					if(activityID == 0)
					{
						JOptionPane.showMessageDialog(null, "You must select an Activity to update!");
					}
					else
					{
//						System.out.println(activeProjectID );
//			        	Project projectToUpdate = new Project();
//			        	projectToUpdate.setId(activeProjectID);	
//			        	projectToUpdate.setProjectName(projectField.getText());
//			        	projectToUpdate.setStartDate(ConverterService.StringToDate(startDateField.getText()));
//			        	projectToUpdate.setEndDate(ConverterService.StringToDate(endDateField.getText()));
			        	
						Activity activityToUpdate = new Activity(activityID, activityField.getText(), descriptionField.getText(), 
								startDateField.getText(), endDateField.getText(), 
								State.getStateInstance().getProject().getId());
						
						ActivityDao activityDao = new ActivityDao();
						activityDao.UpdateActivity(activityToUpdate);
						
						JOptionPane.showMessageDialog(null, "The Activity was updated succesfully! ");

						activityField.setText(activityToUpdate.getActivityName());
						descriptionField.setText(activityToUpdate.getActivityDescription());
						startDateField.setText(ConverterService.DateToString(activityToUpdate.getStartDate()));
						endDateField.setText(ConverterService.DateToString(activityToUpdate.getEndDate()));
						activityID = activityToUpdate.getId();
							
					}

				}

				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "An error occured while updating this activity! Try again.");
					activityField.setText("");
					descriptionField.setText("");
					startDateField.setText("");
					endDateField.setText("");
					activityID = 0;	
					}		
				finally
				{
					parentPanel.refreshTable();				
				}
			}
		});		
		

		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 6;
		panel_2.add(btnUpdate, gbc_btnCreate);

		activityField.setText("");
		descriptionField.setText("");
		startDateField.setText("yyyy-mm-dd");
		endDateField.setText("yyyy-mm-dd");
		
			
	}


}
