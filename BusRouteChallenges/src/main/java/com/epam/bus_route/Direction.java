package com.epam.bus_route;

import org.codehaus.jackson.annotate.JsonProperty;

public class Direction {

	private int departureSid;
	private int arrivalSid;
	private boolean directionBusRoute;

	public Direction() {
		super();
	}

	public Direction(int departureSid, int arrivalSid, boolean directionBusRoute) {
		super();
		this.departureSid = departureSid;
		this.arrivalSid = arrivalSid;
		this.directionBusRoute = directionBusRoute;
	}

	@JsonProperty("dep_sid")
	public int getDepartureSid() {
		return departureSid;
	}

	public void setDepartureSid(int departureSid) {
		this.departureSid = departureSid;
	}
	@JsonProperty("arr_sid")
	public int getArrivalSid() {
		return arrivalSid;
	}

	public void setArrivalSid(int arrivalSid) {
		this.arrivalSid = arrivalSid;
	}
	@JsonProperty("direct_bus_route")
	public boolean isDirectionBusRoute() {
		return directionBusRoute;
	}

	public void setDirectionBusRoute(boolean directionBusRoute) {
		this.directionBusRoute = directionBusRoute;
	}

}
