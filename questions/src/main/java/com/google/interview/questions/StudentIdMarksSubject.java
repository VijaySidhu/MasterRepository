package com.google.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StudentIdMarksSubject {
	public static void main(String[] args) {
		StudentIdMarksSubject studentIdMarksSubject = new StudentIdMarksSubject();
		/*
		 * Map should return Data Structures: 45 English: 81
		 */
		Map<String, StudentInformation> map = studentIdMarksSubject.processData(studentIdMarksSubject.getList());
		for (Map.Entry<String, StudentInformation> entry : map.entrySet()) {
			StudentInformation stu = (StudentInformation) entry.getValue();
			System.out.println(entry.getKey() + "/" + stu.getId() + "/" + stu.getMarks());
		}

	}

	/*
	 * You have to modify processData to compute the marks scored in each
	 * subject by the student with the lowest ID (who has actually appeared for
	 * that test). Thus, processData will returns a Map that maps each Subject
	 * to the marks scored. In other words, the map will contain each subject
	 * name as a key, and the marks scored by the student with the lowest ID as
	 * the value for that entry.
	 * 
	 * Solution :: solution is store entry in Map as <String, <Lowest Id,Marks>>
	 * For each line in the list, extract id,marks,subject name. Check the
	 * subject name(ie. key) in Map. If the value already exists, then simply
	 * compare the current Id with Id in the corresponding entry. If current Id
	 * is lower than that simply update the value pair <Lowest Id,Marks> with
	 * current ID and marks.
	 */
	public Map<String, StudentInformation> processData(List<String> studenInfo) {
		Map<String, StudentInformation> map = new TreeMap<String, StudentInformation>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		for (String currentStudent : studenInfo) {
			StudentInformation studentInformation = new StudentInformation();
			List<String> studentList = Arrays.asList(currentStudent.split("\\|"));
			studentInformation.setId(Integer.valueOf(studentList.get(0)));
			studentInformation.setSubject(studentList.get(1));
			studentInformation.setMarks(Integer.valueOf(studentList.get(2)));
			if (false == map.containsKey(studentInformation.getSubject())) {
				map.put(studentInformation.getSubject(), studentInformation);
			} else {
				StudentInformation studentExist = (StudentInformation) map.get(studentInformation.getSubject());
				if (studentInformation.getId() < studentExist.getId()) {
					map.remove(studentExist.getSubject());
					map.put(studentInformation.getSubject(), studentInformation);
				}

			}
		}
		return map;
	}

	public List<String> getList() {
		List<String> studentInfo = new ArrayList<String>();
		studentInfo.add("22|Data Structures|45");
		studentInfo.add("23|English|52");
		studentInfo.add("22|English|51");
		studentInfo.add("26|Data Structures|72");
		studentInfo.add("23|Data Structures|61");
		studentInfo.add("21|English|81");
		return studentInfo;
	}

}
