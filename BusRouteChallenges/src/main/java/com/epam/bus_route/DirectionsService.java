package com.epam.bus_route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectionsService {
	private Direction currentDirection;
	private Map<Integer, List<Integer>> routesMap;
	private List<Integer> routes;
//	private static final String FILENAME = "C:\\Users\\rudzi\\Documents\\workspace-sts-3.9.4.RELEASE\\BusRoute\\src\\main\\data\\busRoutesData.txt";
	private static final String FILENAME ="data\\busRoutesData.txt";
	
	public Direction getCurrentDirection(int departureSid, int arrivalSid) {
		boolean getDiretion = getRouteExistsStatus(departureSid, arrivalSid);
		return new Direction(departureSid, arrivalSid, getDiretion);
	}

	private boolean getRouteExistsStatus(int departureSid, int arrivalSid) {
		readDataRoutesFile();
		return checkForExistsRouteInroutesMap(departureSid, arrivalSid);
	}

	private void readDataRoutesFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String sCurrentLine;
			routesMap = new HashMap<>();
			int routesNumber = Integer.parseInt(br.readLine());
			while ((sCurrentLine = br.readLine()) != null) {
				String[] tokens = sCurrentLine.split(" ");
				routes = new ArrayList<>();
				for (String s : tokens) {
					routes.add(Integer.parseInt(s));
				}
				routes.remove(0);// remove route id
				routesMap.put(Integer.parseInt(tokens[0]), routes);
//				System.out.println(routesMap);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private boolean checkForExistsRouteInroutesMap(int departureSid, int arrivalSid) {
		boolean result = false;
		for (List<Integer> route: routesMap.values()) {
			if ((route.contains(departureSid) & route.contains(arrivalSid))
					& (route.indexOf(departureSid) < route.indexOf(arrivalSid))) {
				result = true;
				break;
			}
		}

		return result;
	}

}
