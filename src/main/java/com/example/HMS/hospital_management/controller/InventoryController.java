package com.example.HMS.hospital_management.controller;

import com.example.HMS.hospital_management.entity.Inventory;
import com.example.HMS.hospital_management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/update")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    @GetMapping("/list")
    public List<Inventory> getInventoryList() {
        return inventoryService.getInventoryList();
    }
}
