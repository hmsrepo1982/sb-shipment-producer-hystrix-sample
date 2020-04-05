package com.hms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.hms.model.Shipment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	@RequestMapping(value = "/shipment", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getShipmentFallBackData")
	public Shipment findMyShipment() {

		Shipment shipment = new Shipment();
		shipment.setShipmentId("ST23456");
		shipment.setShipmentName("VANTL");
		shipment.setTransportMode("TL");
		

		return shipment;
	}
/**
 * Fall back operation for Shipment.
 * @return
 */
public Shipment getShipmentFallBackData() {
		
	Shipment shipment = new Shipment();
	shipment.setShipmentId("ST23456_FB");
	shipment.setShipmentName("VANTL");
	shipment.setTransportMode("TL");

		return shipment;
		
	}

}
