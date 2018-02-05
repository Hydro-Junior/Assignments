import java.util.Date;
import java.util.List;

public class Assignment implements SubmissionHistory {
    public Assignment() {
        // TODO initialise your data structures
    }

    @Override
    public Integer getBestGrade(String unikey) {
        // TODO Implement this, ideally in better than O(n)
        return null;
    }

    @Override
    public Submission getSubmissionFinal(String unikey) {
        // TODO Implement this, ideally in better than O(n)
        return null;
    }

    @Override
    public Submission getSubmissionBefore(String unikey, Date deadline) {
        // TODO Implement this, ideally in better than O(n)
        return null;
    }

    @Override
    public Submission add(String unikey, Date timestamp, Integer grade) {
        // TODO Implement this, ideally in better than O(n)
        return null;
    }

    @Override
    public void remove(Submission submission) {
        // TODO Implement this, ideally in better than O(n)

    }

    @Override
    public List<String> listTopStudents() {
        // TODO Implement this, ideally in better than O(n)
        // (you may ignore the length of the list in the analysis)
        return null;
    }

    @Override
    public List<String> listRegressions() {
        // TODO Implement this, ideally in better than O(n^2)
        return null;
    }
}
