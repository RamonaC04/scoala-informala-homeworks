public class Employee {

	 public String nameOfEmployee;
	 public Integer seniority;
	 public String rol;
	 public boolean hasParking;
	 
	public Employee(String nameOfEmployee,Integer seniority,String rol, boolean hasParking){
		this.nameOfEmployee=nameOfEmployee;
		this.seniority=seniority;
	    this.rol=rol;
	    this.hasParking = hasParking;
	    
	}
	public String getRol() {
		return rol;
	}

    public void setRol(String rol) {
		this.rol = rol;
	}
    public String getNameOfEmployee() {
		return nameOfEmployee;
	}
	public void setNameEmployee(String nameOfEmployee) {
		this.nameOfEmployee = nameOfEmployee;
	}
	public Integer getSeniority() {
		return seniority;
	}
	public void setSeniority(Integer seniority) {
		this.seniority= seniority;
	}
	
	public boolean getHasParking() {
		return hasParking;
	}
	public void setHasParking(boolean hasParking) {
		this.hasParking= hasParking;
	}
	
	
	public String toString(){
		 return nameOfEmployee + " " +  rol  +  " " + seniority  + " " +  hasParking;
	 }
}
