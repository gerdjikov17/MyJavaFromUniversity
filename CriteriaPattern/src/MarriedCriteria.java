import java.util.ArrayList;
import java.util.List;

public class MarriedCriteria implements Criteria{
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> marriedPersons = new ArrayList<Person>();
		for(Person person : persons) {
			if(person.getMaritalStatus().equalsIgnoreCase("Married")) marriedPersons.add(person);
		}
		return marriedPersons;
	}
}
