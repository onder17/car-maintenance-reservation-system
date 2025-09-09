package com.grkmonder.reservationsystem.entities.concretes;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false, updatable = false)
	private int id;
	
	
	private String name;
	
	
	private String plate;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "car_owner")
	private String carOwner;
	
	
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
    @Size(min = 11, max = 11, message = "Vergi numarası 11 haneli olmalıdır.")
    @Pattern(regexp = "\\d+", message = "Vergi numarası sadece rakamlardan oluşmalıdır.")
    @Column(name = "tax_num")
	private String taxNum;
	
	
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "car_reservation_times", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "reservation_time")
	private List<LocalDateTime> reservationTimes = new ArrayList<>();
	
	
	

	
}
