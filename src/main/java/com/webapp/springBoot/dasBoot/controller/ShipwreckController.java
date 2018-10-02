package com.webapp.springBoot.dasBoot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springBoot.dasBoot.entity.ShipwreckTable;
import com.webapp.springBoot.dasBoot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	ShipwreckRepository shipwreckRepository;
	
	/*@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list(){
		return ShipwreckStub.getList();
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		return ShipwreckStub.create(shipwreck);
	}

	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id){
		return ShipwreckStub.get(id);
	}

	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
		return ShipwreckStub.update(id, shipwreck);
	}

	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		return ShipwreckStub.delete(id);
	}*/
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<ShipwreckTable> list(){
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public ShipwreckTable create(@RequestBody ShipwreckTable shipwrecktable){
		return shipwreckRepository.saveAndFlush(shipwrecktable);
	}

	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public ShipwreckTable get(@PathVariable Long id){
		return shipwreckRepository.getOne(id);
	}

	/*@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public ShipwreckTable update(@PathVariable Long id, @RequestBody ShipwreckTable shipwreckTable){
		Optional<ShipwreckTable> existingShipwreck = shipwreckRepository.findById(id);
		if(existingShipwreck.isPresent()) {
			ShipwreckTable st = existingShipwreck.get();
		BeanUtils.copyProperties(shipwreckTable, st);
		return shipwreckRepository.saveAndFlush(st);
		}
		else {
			return null;
		}
	}*/
	
	/*@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public ShipwreckTable update(@PathVariable Long id, @RequestBody ShipwreckTable shipwreckTable){
		Optional<ShipwreckTable> existingValue = shipwreckRepository.findById(id);
		if(!existingValue.isPresent()) {
			throw new IllegalArgumentException();
		}
		else
		{
			ShipwreckTable st = existingValue.get();
			BeanUtils.copyProperties(shipwreckTable, st);
			return shipwreckRepository.saveAndFlush(st);
			shipwreckTable.setId(id);
			return shipwreckRepository.save(shipwreckTable);
		}
	}*/
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public ShipwreckTable update(@PathVariable Long id, @RequestBody ShipwreckTable shipwreck){
		ShipwreckTable existingShipwreck = shipwreckRepository.findById(id).orElse(null);
		//BeanUtils.copyProperties(shipwreckTable, existingShipwreck);
		//existingShipwreck.setId(existingShipwreck.getId());
		existingShipwreck.setCondition(shipwreck.getCondition());
		existingShipwreck.setDepth(shipwreck.getDepth());
		existingShipwreck.setDescription(shipwreck.getDescription());
		existingShipwreck.setLatitude(shipwreck.getLatitude());
		existingShipwreck.setLongitude(shipwreck.getLongitude());
		existingShipwreck.setName(shipwreck.getName());
		existingShipwreck.setYearDiscovered(shipwreck.getYearDiscovered());
		ShipwreckTable updatedTable = shipwreckRepository.saveAndFlush(existingShipwreck);
		return updatedTable;
		
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.DELETE)
	public ShipwreckTable delete(@PathVariable Long id){
		ShipwreckTable shipwreckTable = shipwreckRepository.findById(id).orElse(null);
		shipwreckRepository.delete(shipwreckTable);
		return shipwreckTable;
	}


}
