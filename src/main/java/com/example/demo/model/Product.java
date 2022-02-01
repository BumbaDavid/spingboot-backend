package com.example.demo.model;

import javax.persistence.Basic;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Product name is required.")
	@Basic(optional = false)
	private String name;
	private double price;
	private String brand;
	private String phoneType;
	private String operatingSystem;
	private double processorFrequency;
	private int nucleusNumber;
	private double weight;
	private double internalMemory;
	private double ram;
	private int cameraNumber;
	private String imgURL;
	
	public Product() {
		
	}

	public Product(Long id, @NotNull(message = "Name is required") String name, double price, String brand, String phoneType, String operatingSystem,
			double processorFrequency, int nucleusNumber, double weight, double internalMemory, double ram,
			int cameraNumber,String imgURL) {
		this.id =id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.phoneType = phoneType;
		this.operatingSystem = operatingSystem;
		this.processorFrequency = processorFrequency;
		this.nucleusNumber = nucleusNumber;
		this.weight = weight;
		this.internalMemory = internalMemory;
		this.ram = ram;
		this.cameraNumber = cameraNumber;
		this.imgURL = imgURL;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public double getProcessorFrequency() {
		return processorFrequency;
	}

	public void setProcessorFrequency(double processorFrequency) {
		this.processorFrequency = processorFrequency;
	}

	public int getNucleusNumber() {
		return nucleusNumber;
	}

	public void setNucleusNumber(int nucleusNumber) {
		this.nucleusNumber = nucleusNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(double internalMemory) {
		this.internalMemory = internalMemory;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public int getCameraNumber() {
		return cameraNumber;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public void setCameraNumber(int cameraNumber) {
		this.cameraNumber = cameraNumber;
	}
	
	
}
