package heart;

public class HeartRate {
	private String first_name;
	private String last_name;
	private int[] info_birth; 
	private int year = 0;int month = 1;int day = 2;
	
	public HeartRate(String first_name,String last_name,int[] info_birth) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.info_birth = info_birth;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int[] getInfo_birth() {
		return info_birth;
	}

	public void setInfo_birth(int[] info_birth) {
		this.info_birth = info_birth;
	}
	
	public int caculate_year() {
		return 2024 - info_birth[year];
	}
	
	public int max_heart_rate() {
		return 220 - caculate_year();
	}
	
	public String target_heart_rate() {
		return 0.5*(float)max_heart_rate() + " to " + 0.85*(float)max_heart_rate();
	}
	
	public void info_show() {
		System.out.printf("%s %s's heart rate information:\n",getFirst_name(),getLast_name());
		System.out.printf("The first name is :%s\n",getFirst_name());
		System.out.printf("The last name is :%s\n",getLast_name());
		System.out.printf("The date of birth is : %d %d %d\n",getInfo_birth()[0],getInfo_birth()[1],getInfo_birth()[2]);
		System.out.printf("The maximum heart rate is :%d\n",max_heart_rate());
		System.out.printf("The target heart rate is :%s\n",target_heart_rate());
	}
}
