package com.grkmonder.reservationsystem.business.abstracts;
import java.util.List;

import com.grkmonder.reservationsystem.business.requests.CreateReservationRequest;
import com.grkmonder.reservationsystem.business.requests.UpdateReservationRequest;
import com.grkmonder.reservationsystem.business.responses.GetAllCarResponse;
import com.grkmonder.reservationsystem.business.responses.GetByIdCarResponse;



public interface CarService {
	
	//Operations about car and reservation informations
	List<GetAllCarResponse> getAllCars();
	GetByIdCarResponse getCarById(int id);
	void add(CreateReservationRequest createReservationRequest);
	void update(UpdateReservationRequest updateReservationRequest);
	void delete(int id);
	

}
