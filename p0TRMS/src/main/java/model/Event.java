package model;

public class Event {
private int evt_id, zipcode;
private String name, beginDate, endDate, time, address, address2, city, state, description;
private double cost;
public int getEvt_id() {
	return evt_id;
}
public void setEvt_id(int evt_id) {
	this.evt_id = evt_id;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBeginDate() {
	return beginDate;
}
public void setBeginDate(String beginDate) {
	this.beginDate = beginDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAddress2() {
	return address2;
}
public void setAddress2(String address2) {
	this.address2 = address2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public Event(int evt_id, String name, String description, double cost, String beginDate, String endDate, String time,
		String address, String address2, String city, String state, int zipcode) {
	super();
	this.evt_id = evt_id;
	this.name = name;
	this.description = description;
	this.cost = cost;
	this.beginDate = beginDate;
	this.endDate = endDate;
	this.time = time;
	this.address = address;
	this.address2 = address2;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
}
@Override
public String toString() {
	return "Event [evt_id=" + evt_id + ", name=" + name + ", description=" + description + ", cost=" + cost
			+ ", beginDate=" + beginDate + ", endDate=" + endDate + ", time=" + time + ", address=" + address
			+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
}


}
