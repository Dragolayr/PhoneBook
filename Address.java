package phonebook;


	public class Address {
		private String street;
		private String state;
		private String city;
		private String zipCode;
	
		public Address() {
			
		}
		public Address(String street, String city, String state, String zipCode) {
			this.street = street;
			this.state = state;
			this.city = city;
			this.zipCode = zipCode;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		
		
		
		public String toString() {
			return " "+street+", "+city+", "+state+", "+zipCode+" " ;     
		}
		
		
}
	
	
	
	
	
	
	
