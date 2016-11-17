package Main;

import java.sql.Date;

public class Package {

	private String targetLocation;
	private Integer distanceInKmToTheTarget;
	private Double merchandiseValue;
	private Date deliveryDate;

	public Package(String targetLocation, Integer distanceInKmToTheTarget, Double merchandiseValue, Date deliveryDate) {
		super();
		this.targetLocation = targetLocation;
		this.distanceInKmToTheTarget = distanceInKmToTheTarget;
		this.merchandiseValue = merchandiseValue;
		this.deliveryDate = deliveryDate;
	}

	public String getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(String targetLocation) {
		this.targetLocation = targetLocation;
	}

	public Integer getDistanceInKmToTheTarget() {
		return distanceInKmToTheTarget;
	}

	public void setDistanceInKmToTheTarget(Integer distanceInKmToTheTarget) {
		this.distanceInKmToTheTarget = distanceInKmToTheTarget;
	}

	public Double getMerchandiseValue() {
		return merchandiseValue;
	}

	public void setMerchandiseValue(Double merchandiseValue) {
		this.merchandiseValue = merchandiseValue;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Package [targetLocation=" + targetLocation + ", distanceInKmToTheTarget=" + distanceInKmToTheTarget
				+ ", merchandiseValue=" + merchandiseValue + ", deliveryDate=" + deliveryDate + "]";
	}
}
