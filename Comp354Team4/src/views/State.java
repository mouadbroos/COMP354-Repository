package views;

import models.*;

public class State {
	
	public User user;
	public Project project;
	public Activity activity;
	public ProjectsView projectsView;
	public ProjectsTab projectTab;
	public ActivitiesTab activityTab;
	
	public ProjectsView getProjectsView() {
		return projectsView;
	}

	public void setProjectsView(ProjectsView projectsView) {
		this.projectsView = projectsView;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	//singleton	
	private static State state;	
	
	private State(){}
	
	public static State getStateInstance()
	{
		if (State.state == null)
			State.state = new State();
		
		return State.state;		
	}

	public ProjectsTab getProjectTab() {
		return projectTab;
	}

	public void setProjectTab(ProjectsTab projectTab) {
		this.projectTab = projectTab;
	}

	public ActivitiesTab getActivityTab() {
		return activityTab;
	}

	public void setActivityTab(ActivitiesTab activityTab) {
		this.activityTab = activityTab;
	}

}
