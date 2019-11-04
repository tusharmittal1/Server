package users;
import java.io.Serializable;
import java.util.ArrayList;
public class Customer extends User implements Serializable {
	
	public Customer(){}
	public Customer( int in_UserID , String in_username , String in_password ){
		super(in_UserID,in_username,in_password);
	}
	
	public ArrayList<Refund> getRequestedRefunds(){
		return refundRequests;
	}
	
	public void addRefundRequest( Refund in_refund ){
		refundRequests.add(in_refund);
	}
	public boolean addBooking( Booking in_Booking ){
		userBookings.add(in_Booking);
		return true;
	}
}