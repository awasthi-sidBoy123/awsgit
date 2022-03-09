package POJO;

public class GetSet {
	
	
	private String dashboard;
	private String purchaseAmount;
	private String website;
	private GetSetCourses courses;
	private String linkedIn;
	private String url;
	private String services;
	
	
	//Mark:- Getter methods
	public String getdashboard() {
		return dashboard;
	}
	
	
	public String getpurchaseAmount() {
		return purchaseAmount;
	}
	
	public String getwebsite() {
		return website;
	}
	
	
	public GetSetCourses getcourses() {
		return courses;
	}
	
	public String getlinkedIn() {
		return linkedIn;
	}
	
	
	public String geturl() {
		return url;
	}
	
	public String getservices() {
		return services;
	}
	
	
	//Mark:- Setter methods
	
	public void setdashboard(String dashboard){
		this.dashboard = dashboard;
	}
	
	
	public void setpurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	public void setwebsite(String website){
		this.website = website;
	}
	
	
	public void setcourses(GetSetCourses courses) {
		this.courses = courses;
	}
	
	public void setlinkedIn(String linkedIn){
		this.linkedIn = linkedIn;
	}
	
	
	public void seturl(String url) {
		this.url = url;
	}
	
	public void setservices(String services){
		this.services = services;
	}
		
}
