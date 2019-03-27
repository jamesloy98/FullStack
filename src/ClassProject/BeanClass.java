package ClassProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="classproject")
public class BeanClass {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement Integer puppy_id;
	@XmlElement String first_name;
	
	
	public String toString() {
		return first_name + " " + puppy_id;
	}
	
}

