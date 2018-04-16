import java.util.List;

public class OrCriteria implements Criteria{
	Criteria criteria;
	Criteria otherCriteria;
	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria=criteria;
		this.otherCriteria=otherCriteria;
	}
	
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstList = criteria.meetCriteria(persons);
		List<Person> secondList = otherCriteria.meetCriteria(persons);
		for(Person person : secondList) {
			if(!firstList.contains(person)) firstList.add(person);
		}
		
		return firstList;
	}

}
