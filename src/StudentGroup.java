import java.util.Date;
import java.util.*;
import java.text.*;
/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students == null) 
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else
			return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if((student==null) || (index<0 || index>=this.students.length))
			throw new IllegalArgumentException();
		else
			this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(students == null) 
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.addFirst(student);
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(students == null) 
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.addLast(student);
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if((student==null) || (index<0 || index>=this.students.length))
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.add(index,student);
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.remove(index);
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int count=0;
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			for(Student x:l){
				if(x.equals(student)){
					l.remove(x);
					count++;
				}
			}
			if(count==0)
				throw new IllegalArgumentException("Student not exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.remove(index);
		}	
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int index=-1;
			for(int i=0;i<this.students.length;i++){
				if(this.students[i].equals(student)){
					index=i;
					break;
				}
			}
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			l.remove(index+1);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=this.students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=0;i<index;i++)
				l.remove(i);
			this.students=l.toArray(new Student[l.size()]);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int index=-1;
			for(int i=0;i<this.students.length;i++){
				if(this.students[i].equals(student)){
					index=i;
					break;
				}
			}
			LinkedList<Student> l=new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=0;i<index;i++)
				l.remove(i);
			this.students=l.toArray(new Student[l.size()]);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i = 0; i < this.students.length; i++){
	            for(int j = 0; j < this.students.length-i-1; j++){
                  	 if(this.students[j].getId() > this.students[j+1].getId()){
				Student temp = this.students[j];
				this.students[j] = this.students[j+1];
				this.students[j+1] = temp;	   
		 	 }
		  }	   
	  	}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> l = new LinkedList<Student>();
			   for(Student s :l)
			   {
			       if(s.getBirthDate().compareTo(date) == 0)
					   l.add(s);
			   }
			   return  l.toArray(new Student[l.size()]);
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate == null)
	 		throw new IllegalArgumentException();
		else{
			LinkedList<Student> l = new LinkedList<Student>();
			   for(Student s :l)
			   {
				if(s.getBirthDate().after(firstDate) && s.getBirthDate().before(lastDate))
					l.add(s);				
			   }
			return l.toArray(new Student[l.size()]);
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		Date d1=date;
		if(date == null)
	 		throw new IllegalArgumentException();
		else{
			Calendar cal =Calendar.getInstance();
		   	cal.add(Calendar.DATE, days);
           		date = cal.getTime();
			LinkedList<Student> l = new LinkedList<Student>();
			for(Student s :l){
				if(s.getBirthDate().after(d1) && s.getBirthDate().before(date))
					l.add(s);				
			}
			return l.toArray(new Student[l.size()]);
		}
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		 if(indexOfStudent == 0)
			throw new IllegalArgumentException();
		else{
			Date d=new Date();	
			SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
			String date=sd.format(d);
			date=date.substring(0,3);
			Date tempdate=this.students[indexOfStudent].getBirthDate();
			sd.format(tempdate);
			String date1=sd.format(tempdate);
			return (Integer.parseInt(date)-Integer.parseInt(date1));
		}
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		LinkedList<Student> temp = new LinkedList<>();
		  for(int i = 0; i < this.students.length; i++)
		  {
		      if(getCurrentAgeByDate(i) == age)
				  temp.add(this.students[i]);
		  }
         	 return  temp.toArray(new Student[temp.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double maxavg1 = 0;
		  for(Student s : this.students)
			  if(s.getAvgMark() > maxavg1)
				 maxavg1 = s.getAvgMark();
		  LinkedList<Student> t = new LinkedList<>();
		  for(Student s : this.students)
			  if(s.getAvgMark() == maxavg1)  
				t.add(s);
		  return  t.toArray(new Student[t.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		this.bubbleSort();
		   int i;
		   for(i = 0; i < this.students.length; i++)
			   if(this.students[i].equals(student))
				 break;
		   return this.students[i+1];
	}
}
