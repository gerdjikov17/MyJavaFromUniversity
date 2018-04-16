import java.util.List;

public class AndCriteria implements Criteria{
	Criteria criteria;
	Criteria otherCriteria;
	
	
	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		List<Person> firstCriteria = criteria.meetCriteria(persons);
		return otherCriteria.meetCriteria(firstCriteria);
	}
	
	
	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		this.criteria=criteria;
		this.otherCriteria=otherCriteria;
	}

}
