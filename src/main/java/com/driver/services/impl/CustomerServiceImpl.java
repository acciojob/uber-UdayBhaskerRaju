package com.driver.services.impl;

import com.driver.Exceptions.CabNotFoundException;
import com.driver.Exceptions.CustomerNotFoundException;
import com.driver.Exceptions.TripNotBookedException;
import com.driver.model.*;
import com.driver.repository.CabRepository;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Autowired
	CabRepository cabRepository;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
          Optional<Customer> optionalCustomer = customerRepository2.findById(customerId);
		  if(optionalCustomer.isPresent()){
			  Customer customer = optionalCustomer.get();
			  customerRepository2.delete(customer);
		  }
		  else{
			  throw new CustomerNotFoundException("Customer with this "+customerId+ "Not Found");
		  }
		}
	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception {
        //Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
        //Avoid using SQL query
        Optional<Customer> optionalCustomer = customerRepository2.findById(customerId);
        if (optionalCustomer.isPresent()) {
          Customer customer = optionalCustomer.get();
        } else {
            throw new CustomerNotFoundException("Invalid Id");
        }
		Cab cab;
        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
        if (optionalCab.isPresent()) {
			cab = optionalCab.get();
            cab.setAvailable(false);
        } else {
            throw new CabNotFoundException("seems like drivers are busy");
        }
        //book Trip
        TripBooking booking = new TripBooking();
        booking.setTripBookingId(String.valueOf(UUID.randomUUID()));
		booking.setFromLocation(fromLocation);
		booking.setToLocation(toLocation);
		booking.setDistanceInKm(distanceInKm);
		booking.setStatus(TripStatus.CONFIRMED);
        booking.setFarePrice(distanceInKm*cab.getFarePerKm());
		booking.setCab(cab);
		return tripBookingRepository2.save(booking);
    }

	@Override
	public void cancelTrip(Integer tripId) {
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		Optional<TripBooking> optionalTrip = tripBookingRepository2.findById(tripId);
		if (optionalTrip.isPresent()) {
			TripBooking trip = optionalTrip.get();
			if(TripStatus.CONFIRMED.equals(trip.getStatus()))
			{
				trip.setStatus(TripStatus.CANCELED);
				trip.getCab().setAvailable(true);
				tripBookingRepository2.save(trip);
			}
			else{
				throw new TripNotBookedException("Trip not booked");
			}
		}
		else{
			throw new IllegalArgumentException("login into Uber before you start booking your Ride");
		}
	}
	@Override
	public void completeTrip(Integer tripId) {
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		Optional<TripBooking> optionalTrip = tripBookingRepository2.findById(tripId);
		if(optionalTrip.isPresent()){
			 TripBooking trip = optionalTrip.get();
			if(TripStatus.COMPLETED.equals(trip.getStatus())){
               throw new IllegalArgumentException("Trip already completed please refresh the page");
			}
			else {
				trip.setFarePrice(trip.getFarePrice());
				trip.setStatus(TripStatus.COMPLETED);
				trip.getCab().setAvailable(true);
				tripBookingRepository2.save(trip);
			}
		}
		else{
			throw new IllegalArgumentException("User Not found");
		}
	}
}
