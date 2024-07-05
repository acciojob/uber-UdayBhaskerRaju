package com.driver.controllers;

import com.driver.model.Customer;
import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;

    @PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
		try {
			customerService.register(customer);
			return new ResponseEntity<>("Customer Registered Successfully!! ",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete")
	public void deleteCustomer(@RequestParam Integer customerId){
		customerService.deleteCustomer(customerId);
	}

	@PostMapping("/bookTrip")
	public ResponseEntity<String> bookTrip(@RequestParam Integer customerId, @RequestParam String fromLocation, @RequestParam String toLocation, @RequestParam Integer distanceInKm) throws Exception {
		try {
			TripBooking bookedTrip = customerService.bookTrip(customerId, fromLocation, toLocation, distanceInKm);
			return new ResponseEntity<>("Your Booking Id is : "+bookedTrip.getTripBookingId(), HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/complete")
	public void completeTrip(@RequestParam("id") Integer tripId){
		customerService.completeTrip(tripId);
	}
	@DeleteMapping("/cancelTrip")
	public void cancelTrip(@RequestParam("id") Integer tripId){
		customerService.cancelTrip(tripId);
	}
}
