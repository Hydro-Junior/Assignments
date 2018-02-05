import java.util.Date;

public interface Submission {
    /**
     * @return the unikey (a String of the form "abcd1234")
     */
    public String getUnikey();

    /**
     * @return a Date object representing the time the submission was made
     */
    public Date getTime();

    /**
     * @return an integer grade
     */
    public Integer getGrade();
}
