package com.kamesh.constants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatusResponse {

	public static Map<String, Object> getObjectStatus(Object responseObject) {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.put("status", 1);
		status.put("data", responseObject);
		return status;
	}

	public static Map<String, Object> createObjectStatus(String parameterId) {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.put("status", 1);
		status.put("message", "created");
		status.put("Generated Id", parameterId);
		return status;
	}

	public static Map<String, Object> updateObjectStatus(long parameterId) {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.put("status", 1);
		status.put("message", "Successfully Updated the record");
		status.put("Reference Id", parameterId);
		return status;
	}

	public static Map<String, Object> deleteObject() {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.clear();
		status.put("status", 0);
		status.put("message", "Record Deleted Successfully");
		return status;
	}

	public static Map<String, Object> getObjectListStatus(List<?> listOfObjects) {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.put("status", 1);
		status.put("data", listOfObjects);
		return status;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Object> noDataFound() {

		Map<String, Object> status = new LinkedHashMap<String, Object>();
		status.clear();
		status.put("status", 0);
		status.put("message", "No Data Found");
		return status;
	}

}
