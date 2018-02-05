import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

public class Testor {
	@Test
	public void test1() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SubmissionHistory history = new Assignment();
		history.add("aaaa1234", df.parse("2016/09/03 09:00:00"), 66);
		history.add("aaaa1234", df.parse("2016/09/03 16:00:00"), 92);
		history.add("cccc1234", df.parse("2016/09/03 16:00:00"), 92);
		history.add("aaaa1234", df.parse("2016/09/03 18:00:00"), 40);
		
		Integer example1 = history.getBestGrade("aaaa1234");
		System.out.println(example1);
		Submission example2 = history.getSubmissionFinal("aaaa1234");
		System.out.println(example2);
		Submission example3 = history.getSubmissionBefore("aaaa1234",df.parse("2016/09/03 17:00:00"));
		System.out.println(example3);
		Submission example4 = history.getSubmissionBefore("cccc1234",df.parse("2016/09/03 15:00:00"));
		System.out.println(example4);
		List<String> str = history.listTopStudents();
		System.out.println(str.size());
		history.add("bbbb1234", df.parse("2016/09/03 16:00:00"), 98);
		history.add("bb1234", df.parse("2016/09/03 16:00:00"), 98);
		str = history.listTopStudents();
		System.out.println(str.size());
		history.add("bb1234", df.parse("2016/09/03 20:00:00"), 56);
		str = history.listRegressions();
		System.out.println(str.get(1));
		
		history.add("mmmm1234", df.parse("2016/09/03 18:00:00"), 90);
		history.add("mmmm1234", df.parse("2016/09/03 20:00:00"), 60);
		history.add("mmmm1234", df.parse("2016/09/03 21:00:00"), 91);
		str = history.listRegressions();
		System.out.println(str.size());
		System.out.println(history.getBestGrade("mmmm1234"));
		history.remove(history.getSubmissionFinal("mmmm1234"));
		System.out.println(history.getBestGrade("mmmm1234"));
 	}
}
