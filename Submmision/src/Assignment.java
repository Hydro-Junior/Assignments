import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Assignment implements SubmissionHistory {

	private Set<Submission> submissions = new TreeSet<Submission>();
	
	@Override
	public Integer getBestGrade(String unikey) throws IllegalArgumentException {
		if (unikey == null) {
			throw new IllegalArgumentException();
		}
		
		Submission temp = null;
		if (submissions.size() == 0) {
			return null;
		} else {
			Iterator<Submission> iterator = submissions.iterator();
			while(iterator.hasNext()) {
				temp = iterator.next();
				if(temp.getUnikey() == unikey) {
					return temp.getGrade();
				}
			}
			return null;
		}
	}

	@Override
	public Submission getSubmissionFinal(String unikey) throws IllegalArgumentException {
		if (unikey == null) {
			throw new IllegalArgumentException();
		}
		
		Submission temp = null;
		Set<Submission> sm = new TreeSet<Submission>(new Comparator<Submission>() {
			@Override
			public int compare(Submission o1, Submission o2) {
				if (o1.getTime().after(o2.getTime())) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		Iterator<Submission> iterator = submissions.iterator();
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getUnikey().equals(unikey)) {
				sm.add(temp);
			}
		}
		if (sm.size() == 0) {
			return null;
		} else {
			Iterator<Submission> it = sm.iterator();
			if (it.hasNext()) {
				return (Submission) it.next();
			} else {
				return null;
			}
		}

	}

	@Override
	public Submission getSubmissionBefore(String unikey, Date deadline) throws IllegalArgumentException {
		
		if (unikey == null) {
			throw new IllegalArgumentException();
		}
		Submission temp = null;
		Set<Submission> sm = new TreeSet<Submission>(new Comparator<Submission>() {
			@Override
			public int compare(Submission o1, Submission o2) {
				if (o1.getTime().after(o2.getTime())) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		Iterator<Submission> iterator = submissions.iterator();
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getUnikey().equals(unikey)&& !temp.getTime().after(deadline)) {
				sm.add(temp);
			}
		}
		if (sm.size() == 0) {
			return null;
		} else {
			Iterator<Submission> it = sm.iterator();
			if (it.hasNext()) {
				return (Submission) it.next();
			} else {
				return null;
			}
		}	
	}

	@Override
	public Submission add(String unikey, Date timestamp, Integer grade) throws IllegalArgumentException {
		if (unikey == null || timestamp == null || grade == null) {
			throw new IllegalArgumentException();
		}
		Submission addedSubmission = new Submission(unikey, timestamp, grade);
		submissions.add(addedSubmission);
		return addedSubmission;
	}

	@Override
	public void remove(Submission submission) throws IllegalArgumentException {
		if (submission == null) {
			throw new IllegalArgumentException();
		}
		Iterator<Submission> iterator = submissions.iterator();
		while(iterator.hasNext()) {
			if(iterator.next() == submission) {
				iterator.remove();
			}
		}
	}

	@Override
	public List<String> listTopStudents() {
		int maxGrade = 0;
		Submission sm = null;
		Iterator<Submission> iterator = submissions.iterator();
		if(iterator.hasNext()) {
			maxGrade = iterator.next().getGrade();
		}
		List<String> topStudents = new ArrayList<String>();
		iterator = submissions.iterator();
		while(iterator.hasNext()) {
			sm = iterator.next();
			if(sm.getGrade() == maxGrade) {
				 topStudents.add(sm.getUnikey());
			}
		}
		return topStudents;
	}

	@Override
	public List<String> listRegressions() {
		Set<String> students = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		Iterator<Submission> iterator = submissions.iterator();
		while(iterator.hasNext()) {
			students.add(iterator.next().getUnikey());
		}
		Iterator<String> it = students.iterator();
		String theStudent = new String();
		int bestGrade = 0;
		while (it.hasNext()) {
			theStudent = it.next();
			bestGrade = this.getBestGrade(theStudent);
			if (this.getSubmissionFinal(theStudent).getGrade() < bestGrade) {
				result.add(theStudent);
			}
		}
		return result;
	}

}
