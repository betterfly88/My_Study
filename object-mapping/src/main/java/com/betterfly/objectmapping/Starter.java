package com.betterfly.objectmapping;

import com.betterfly.objectmapping.service.MappingService;

public class Starter {
    public static void main(String[] args) {
        MappingService mappingService = new MappingService();

        mappingService.init();
        mappingService.timeCheck();
    }
}
