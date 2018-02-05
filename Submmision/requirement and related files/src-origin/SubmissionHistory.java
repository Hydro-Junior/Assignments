import java.util.Date;
import java.util.List;

public interface SubmissionHistory {
    /**
     * Find the highest grade of any submission by this student
     *
     * @param unikey The student to filter on
     * @return the best grade by this student, or null if they have made no submissions
     * @throws IllegalArgumentException if the argument is null
     */
    public Integer getBestGrade(String unikey);

    /**
     * The most recent submission for a given student
     *
     * @param unikey The student to filter on.
     * @return Submission made most recently by that student, or null if the student has made no submissions
     * @throws IllegalArgumentException if the argument is null
     */
    public Submission getSubmissionFinal(String unikey);

    /**
     * The most recent submission for a given student, prior to a given time
     *
     * @param unikey The student to filter on
     * @param deadline The deadline after which no submissions are considered
     * @return Submission made most recently by that student, or null if the student has made no submissions
     * @throws IllegalArgumentException if the argument is null
     */
    public Submission getSubmissionBefore(String unikey, Date deadline);

    /**
     * Add a new submission *
     *
     * For simplicity, you may assume that all submissions have unique times *
     *
     * @param unikey
     * @param timestamp
     * @param grade
     * @return the Submission object that was created
     * @throws IllegalArgumentException if any argument is null
     */
    public Submission add(String unikey, Date timestamp, Integer grade);

    /**
     * Remove a submission
     *
     * For simplicity, you may assume that all submissions have unique times
     *
     * @param submission The Submission to remove
     * @throws IllegalArgumentException if the argument is null
     */
    public void remove(Submission submission);

    /**
     * Get all the students who achieved the highest grade (in any of their
     * submissions).
     *
     * For example, if the highest grade achieved by any student was 93, then
     * this would return a list of all the students who have made a submission
     * graded at 93.
     *
     * If no submissions have been made, then return an empty list.
     *
     * @return a list of unikeys */
    public List<String> listTopStudents();

    /**
     * Get all the students whose most recent submissions have lower grades than
     * their best submissions
     *
     * @return a list of unikeys */
    public List<String> listRegressions();
}
