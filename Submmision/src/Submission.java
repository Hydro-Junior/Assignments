import java.util.Date;

public class Submission implements Comparable<Submission> {
	private String unikey;
	private Date timestamp;
	private Integer grade;

	/**
	 * @return the unikey (a String of the form "abcd1234")
	 */
	public String getUnikey() {
		return unikey;
	}

	/**
	 * @return a Date object representing the time the submission was made
	 */
	public Date getTime() {
		return timestamp;
	}

	/**
	 * @return an integer grade
	 */
	public Integer getGrade() {
		return grade;
	}

	public Submission(String unikey, Date timestamp, Integer grade) {
		super();
		this.unikey = unikey;
		this.timestamp = timestamp;
		this.grade = grade;
	}

	@Override
	public int compareTo(Submission o) {	
		if (this.grade > o.grade) {
			return -1;
		}else {
			return 1;
		}
		
	}

	@Override
	public String toString() {
		return this.unikey + " " + this.timestamp.toString() +" " + this.grade;
	}
	
}
