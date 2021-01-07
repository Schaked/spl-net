package bgu.spl.net.srv;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {
	private ConcurrentHashMap<String, User> userHashMap;
	private ConcurrentHashMap<Integer, Course> courseHashMap;
	private ConcurrentHashMap<Integer, Integer> coursesPlaceAtTheCourseFile;
	int count;



	//to prevent user from creating new Database
	private Database() {
		userHashMap=new ConcurrentHashMap<>();
		courseHashMap=new ConcurrentHashMap<>();
		coursesPlaceAtTheCourseFile=new ConcurrentHashMap<>();
		count=1;
		initialize("/home/spl211/IdeaProjects/spl-net/Courses.txt");

	}
	private static class SingletonHolder{
		private static Database instance=new Database();
	}

	/**
	 * Retrieves the single instance of this class.
	 */
	public static Database getInstance() {
		return SingletonHolder.instance;
	}
	
	/**
	 * loades the courses from the file path specified 
	 * into the Database, returns true if successful.
	 */
	boolean initialize(String coursesFilePath) {
		try{
			File file=new File(coursesFilePath);
			Scanner scanner=new Scanner(file);
			while (scanner.hasNextLine()){
				String[] data=scanner.nextLine().split("\\|");
				int []kdamCourses=new int[0];
				if(data[2].length()>=3) {// checks that the KdamCoursesList isn't empty (length 2 means [])
					kdamCourses = Stream.of(data[2].substring(1, data[2].length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
				}
				courseHashMap.put(Integer.parseInt(data[0]),new Course(Integer.parseInt(data[0]),data[1],kdamCourses,Integer.parseInt(data[3])));
				coursesPlaceAtTheCourseFile.put(Integer.parseInt(data[0]),count);
				count=count+1;
			}
			return true;
		}
		catch (FileNotFoundException ex){
			ex.printStackTrace();
		}
		return false;
	}

	public ConcurrentHashMap<String, User> getUserHashMap() {
		return userHashMap;
	}

	public ConcurrentHashMap<Integer, Course> getCourseHashMap() {
		return courseHashMap;
	}

	public ConcurrentHashMap<Integer, Integer> getCoursesPlaceAtTheCourseFile() {
		return coursesPlaceAtTheCourseFile;
	}
}
